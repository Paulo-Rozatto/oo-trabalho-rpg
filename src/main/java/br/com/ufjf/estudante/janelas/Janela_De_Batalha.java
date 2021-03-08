/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ufjf.estudante.janelas;

//import br.com.ufjf.estudante.main.GrupoInimigo;
//import br.com.ufjf.estudante.main.GrupoJogador;
import br.com.ufjf.estudante.main.Jogador;
import br.com.ufjf.estudante.main.NpcInimigo;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author Luiz
 */
public class Janela_De_Batalha extends JFrame implements ActionListener {

    private Timer timer = new Timer(1, this); //Cronometro com 1000 ms de atraso
    private int cronometro;//contador do timer
    private int cronometroPausa;
    private Painel_Animacao painel;
    private int largJanela;
    private int altJanela;
    private int maxJogador;
    private int maxInimigo;
    private boolean isTurnoJogador;
    private int round;
    private boolean trocaTurnoJogador;
    private boolean trocaTurnoInimigo;

    private List<Jogador> jogador;
    private List<NpcInimigo> inimigo;

//    private List<Image> spriteJogador;
//    private List<Image> spriteInimigo;
    //Botoes
    private JButton botao_ataque;
    private JButton botao_magia;
    private JButton botao_item;
    //Labels
    private JLabel label_personagem;
    private JLabel label_inimigo;
    private JLabel label_HPpersonagem;
    private JLabel label_HPinimigo;
    private JLabel label_mostraHPersonagem;
    private JLabel label_mostraHPinimigo;
    private JLabel label_MPpersonagem;
    private JLabel label_MPinimigo;
    private JLabel label_mostraMPpersonagem;
    private JLabel label_mostraMPinimigo;
    private JLabel label_evento;
    //Caixa de selecao
    private JComboBox<String> cbox_personagem;
    private JComboBox<String> cbox_inimigo;
    private JComboBox<String> cbox_itens;

    public Janela_De_Batalha(List<Jogador> jogador, List<NpcInimigo> inimigos) {
        timer.start();
        this.cronometro = 0;
        this.cronometroPausa = 0;
        largJanela = 1020;
        altJanela = 720;
        this.maxJogador = 6;
        this.maxInimigo = 6;
        round = 0;
        isTurnoJogador = true;
        this.trocaTurnoJogador = false;//Verifica se o gerenciador de turnos foi executado
        this.trocaTurnoInimigo = false;

        this.jogador = jogador;
        this.inimigo = inimigos;

//        GrupoJogador.iniciaGrupo(jogador);
//        inimigo.iniciaGrupo(0);
        this.setTitle("o-o Trabalho");  //Titulo
        this.setSize(largJanela, altJanela); //Tamanho
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Clicar no x fecha
        this.setResizable(false); // Nao maximiza
        this.setLocationRelativeTo(null); //Abre no centro da tela

        alocaBotoes();//PosicionaBotoes
        alocaLabels();
        alocaSprites();
        iniciaComboBox();

        painel = new Painel_Animacao(largJanela, altJanela - (altJanela / 4), jogador, inimigos);//Inicializa painel de animacao
        this.add(painel);
        this.setVisible(true);
    }

    //ESSA FUNCAO POSICIONA OS BOTOES NA TELA
    private void alocaBotoes() { 
        botao_ataque = new JButton();
        botao_ataque.addActionListener(this);//Adiciona evento
        botao_ataque.setText("Ataque");//Texto
        botao_ataque.setSize(100, 25); //Tamanho
        botao_ataque.setLocation(10, 600);//Posicao

        botao_magia = new JButton();
        botao_magia.addActionListener(this);//Adiciona evento
        botao_magia.setText("Magia");//Texto
        botao_magia.setSize(100, 25); //Tamanho
        botao_magia.setLocation(10, 625);//Posicao
        
        botao_item = new JButton();
        botao_item.addActionListener(this);//Adiciona evento
        botao_item.setText("Item");//Texto
        botao_item.setSize(100, 25); //Tamanho
        botao_item.setLocation(10, 650);//Posicao

        //Adiciona botoes na tela
        this.add(botao_magia);
        this.add(botao_ataque);
        this.add(botao_item);

    }
    //ESSA FUNCAO POSICIONA AS LABELS(TEXTO) NA TELA
    private void alocaLabels() { //Posiciona Labels na tela
        label_personagem = new JLabel();
        label_personagem.setText("Escolha o personagem: "); //Texto
        label_personagem.setSize(200, 25); //Tamanho
        label_personagem.setLocation(10, altJanela - (altJanela / 4)); //Posicao        
        label_inimigo = new JLabel();
        label_inimigo.setText("Escolha o inimigo: ");
        label_inimigo.setSize(200, 25);
        label_inimigo.setLocation(largJanela / 2, altJanela - (altJanela / 4));

        label_HPpersonagem = new JLabel();
        label_HPpersonagem.setText("HP do Personagem:");
        label_HPpersonagem.setSize(200, 25);
        label_HPpersonagem.setLocation(150, 600);
        label_HPinimigo = new JLabel();
        label_HPinimigo.setText("HP do inimigo: ");
        label_HPinimigo.setSize(200, 25);
        label_HPinimigo.setLocation(largJanela / 2, 600);

        label_mostraHPersonagem = new JLabel();
        label_mostraHPersonagem.setSize(50, 25);
        label_mostraHPersonagem.setLocation(150 + 125, 600);
        label_mostraHPinimigo = new JLabel();
        label_mostraHPinimigo.setSize(50, 25);
        label_mostraHPinimigo.setLocation(largJanela / 2 + 90, 600);

        label_MPpersonagem = new JLabel();
        label_MPpersonagem.setText("MP do Personagem:");
        label_MPpersonagem.setSize(200, 25);
        label_MPpersonagem.setLocation(150, 625);
        label_MPinimigo = new JLabel();
        label_MPinimigo.setText("MP do inimigo: ");
        label_MPinimigo.setSize(200, 25);
        label_MPinimigo.setLocation(largJanela / 2, 625);

        label_mostraMPpersonagem = new JLabel();
        label_mostraMPpersonagem.setSize(50, 25);
        label_mostraMPpersonagem.setLocation(150 + 125, 625);
        label_mostraMPinimigo = new JLabel();
        label_mostraMPinimigo.setSize(50, 25);
        label_mostraMPinimigo.setLocation(largJanela / 2 + 90, 625);

        label_evento = new JLabel();
        label_evento.setSize(50, 25);
        label_evento.setLocation(largJanela / 2 - 50, 10);
        label_evento = new JLabel();
        label_evento.setSize(800, 25);
        label_evento.setText("Turno do jogador");

        atualizaLabeldeHP(0, 0);
        atualizaLabeldeMP(0, 0);
        //Adiciona Labels na tela
        this.add(label_personagem);
        this.add(label_inimigo);
        this.add(label_HPpersonagem);
        this.add(label_HPinimigo);
        this.add(label_mostraHPersonagem);
        this.add(label_mostraHPinimigo);
        this.add(label_MPpersonagem);
        this.add(label_MPinimigo);
        this.add(label_mostraMPpersonagem);
        this.add(label_mostraMPinimigo);
        this.add(label_evento);
//        System.out.println("Alocou botoes");
    }

    //CADA TELA DE BATALHA TEM UM NUMERO MAXIMO DE PERSONAGANS, PARA NAO OCUPAR MUITO ESPACO NA TELA
    private void atualizaMaximoPersonagens() {
        //Atualizando o numero maximo de jogadores
        int i = maxJogador - 1;
        while (jogador.size() > maxJogador) {
//            System.out.println("Aqui removeu jogador");
            jogador.remove(i);
        }
        if (jogador.size() <= maxJogador) {
            maxJogador = jogador.size();
//            System.out.println("Max jogador: " + maxJogador);
        }

        i = maxInimigo - 1;
        while (inimigo.size() > maxInimigo) {
//            System.out.println("aqui removeu inimigo");
            inimigo.remove(i);
        }
        if (inimigo.size() <= maxInimigo) {
            maxInimigo = inimigo.size();
//            System.out.println("Max inimigo: " + maxInimigo);
        }
//        if(GrupoJogador.getSize()<maxJogador){
//            spriteJogador = new ArrayList<Image>(GrupoJogador.getSize());
//            maxJogador = GrupoJogador.getSize();
//        }
//        else{
//            spriteJogador = new ArrayList<Image>(maxJogador);
//        }
//        if(GrupoInimigo.getSize()<maxInimigo){
//            spriteInimigo = new ArrayList<Image>(GrupoInimigo.getSize());
//            maxInimigo = GrupoInimigo.getSize();
//        }
//        else{
//            spriteInimigo = new ArrayList<Image>(maxInimigo);
//        }
//        System.out.println("Atualizou personagens");
//        for (int i = 0; i < jogador.size(); i++) {
//            System.out.println(jogador.get(i).getNomePersonagem());
//        }
    }

    //ADICIONA VALORES NAS COMBO BOX
    private void iniciaComboBox() {//Caixa de selecao de personagem
        //FALTA IMPLEMENTAR OS VALORES ADICIONADOS NO COMBOBOX DOS ITENS
        //Inicializando posicao e tamanho:
        cbox_personagem = new JComboBox<String>();
        cbox_personagem.setSize(200, 25); //Tamanho
        cbox_personagem.setLocation(160, altJanela - (altJanela / 4)); //Posicao

        cbox_inimigo = new JComboBox<String>();
        cbox_inimigo.setSize(200, 25);
        cbox_inimigo.setLocation(largJanela / 2 + 110, altJanela - (altJanela / 4));
        
        cbox_itens = new JComboBox<String>();
        cbox_itens.setSize(100, 25);
        cbox_itens.setLocation(110, 650);

        atualizaMaximoPersonagens();

        for (int i = 0; i < maxJogador; i++) {//Adiciona personagens na caixa de selecao
            cbox_personagem.addItem(jogador.get(i).getNomePersonagem());
        }
        for (int i = 0; i < maxInimigo; i++) {//Adiciona personagens na caixa de selecao
            cbox_inimigo.addItem(inimigo.get(i).getNomePersonagem());
        }

        cbox_inimigo.removeItem("Vazio");
        cbox_personagem.removeItem("Vazio");
        this.add(cbox_personagem);
        this.add(cbox_inimigo);
        this.add(cbox_itens);
        cbox_inimigo.setVisible(true); //Deixa caixa de selecao de inimigos, visivel
        cbox_personagem.setVisible(true); //Deixa caixa de selecao de personages, visivel
//        System.out.println("Iniciou cBox");
    }

    //EDITA A POSICAO EM QUE VAO APARECER OS PERSONAGENS NA TELA
    private void alocaSprites() {//Caixa de selecao de personagem

        atualizaMaximoPersonagens();

        //"Desenhando" imagem na tela
        int distanciax = 1;
        int distanciay = 1;

        for (int i = 0; i < jogador.size() && i < maxJogador; i++) {

            jogador.get(i).setPosX((distanciax * 64) + 100);//posicao
            jogador.get(i).setPosY(distanciay * 64);
            distanciay++;

            if (i % 4 == 0) {
                distanciax++;
                distanciay = 1;
            }
        }
        distanciax = 1;
        distanciay = 1;
        for (int i = 0; i < inimigo.size() && i < maxInimigo; i++) {
            inimigo.get(i).setPosX((distanciax * 64) + 500);//posicao
            inimigo.get(i).setPosY(distanciay * 64);
            distanciay++;
            if (i % 4 == 0) {
                distanciax++;
                distanciay = 1;
            }
        }
//        System.out.println("Alocou Sprites");
    }

    private boolean confereSe_InimigoMorreu(int indice) {
        if (indice < maxInimigo && indice>=0) {
//            System.out.println("Conferiu se inimigo morreu");
            if (inimigo.get(indice).getHitPoints() <= 0) {
//                spriteInimigo.get(indice).setVisible(false);//deixa o sprite invisivel
//                this.remove(spriteInimigo.get(indice));//remove o sprite do painel
//                spriteInimigo.remove(indice);
//                inimigo.remove(indice);
                if (inimigo.size() != 1) {
//                    System.out.println("tentando remover indice: "+indice);
                    System.out.println("cbox nome: "+inimigo.get(indice).getNomePersonagem());
                    cbox_inimigo.removeItem(inimigo.get(indice).getNomePersonagem());
//                    System.out.println("removendo indice: "+indice);
                } else {
                    cbox_inimigo.addItem("Vazio");
                    cbox_inimigo.removeItem(inimigo.get(0).getNomePersonagem());
                    cbox_inimigo.setVisible(false);
                }
                inimigo.remove(indice);//remove inimigo morto do vetor de inimigos
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean confereSe_JogadorMorreu(int indice) {
        if (indice < maxJogador) {
            if (jogador.get(indice).getHitPoints() <= 0) {
//                System.out.println("Conferiu se jogador morreu");
//                spriteJogador.get(indice).setVisible(false);//deixa o sprite invisivel
//                this.remove(spriteJogador.get(indice));//remove o sprite do painel
//                spriteJogador.remove(indice);
//                jogador.remove(indice);
                if (jogador.size() != 1) {
                    cbox_personagem.removeItem(jogador.get(indice).getNomePersonagem());
                } else {
                    cbox_personagem.addItem("Vazio");
                    cbox_personagem.removeItem(jogador.get(0).getNomePersonagem());
                    cbox_personagem.setVisible(false);
                }
                jogador.remove(indice);//remove jogador morto do vetor de jogador
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean confereSe_ExistemJogadores() {
        for (int i = 0; i < jogador.size(); i++) {
            if (confereSe_JogadorMorreu(i)) {
                return false;
            }
        }
        return true;
    }

    //FUNCOES DE TURNO:
    private void turnoJogador(int tipoAtaque) {
        if (!painel.isAnimacao()) {//Se nao estiver acontecendo nenhuma animacao
//            System.out.println("Jogador: ");
            switch (tipoAtaque) {
                case 1:
                    inimigo.get(cbox_inimigo.getSelectedIndex()).sofreAtack(jogador.get(cbox_personagem.getSelectedIndex()).ataqueFisico(inimigo.get(cbox_inimigo.getSelectedIndex()).getDefesa()));
                    
                    //animacao de ataque
                    painel.ataqueJogador(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
                    break;
                case 2:
                    inimigo.get(cbox_inimigo.getSelectedIndex()).sofreAtack(jogador.get(cbox_personagem.getSelectedIndex()).ataqueMagico(inimigo.get(cbox_inimigo.getSelectedIndex()).getDefesa()));
                    
                    //animacao de magia
                    painel.magiaJogador(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
                    break;
            }
            trocaTurnoJogador = true;
//            gerenciaTurno();
        }
    }

    private void turnoInimigo() {
        if (!painel.isAnimacao()) {//Se nao estiver acontecendo nenhuma animacao
//            System.out.println("Inimigo: ");
            jogador.get(cbox_personagem.getSelectedIndex()).sofreAtack(inimigo.get(cbox_inimigo.getSelectedIndex()).decideAcao(jogador.get(cbox_personagem.getSelectedIndex()).getDefesa()));
            //Animacao de ataque do inimigo
            painel.ataqueInimigo(cbox_inimigo.getSelectedIndex(), cbox_personagem.getSelectedIndex());
//            gerenciaTurno();
            trocaTurnoInimigo = true;
        }

    }

    private boolean gerenciaTurno() {
        if (!painel.isAnimacao()) {//Se nao estiver ocorrendo nenhuma animacao
            atualizaLabeldeHP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
            atualizaLabeldeMP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
            if (isTurnoJogador) {
                for (int i = 0; i < inimigo.size() && i < maxInimigo; i++) {//removendo inimigos mortos
                    if (confereSe_InimigoMorreu(i)) {
                        --i;
                    }
                }
                if (inimigo.size() == 0) {//se não há mais inimigos vivos
                    // A fazer: codigo que mostra na interface descricao de morte
                    if (round == 2) { // Se for o ultimo round, ganhou jogo
                        vitoria();
                    } else { // se nao for ultimo round, configure proximo round
                        round++;
                        System.out.println("Round: " + round);
                    }
                    isTurnoJogador = false;
                } else { // se há inimigos vivos, passe o turno para o próximo inimigo
                    if (cbox_inimigo.getSelectedIndex() >= inimigo.size())//se o inimigo selecionado está morto, encontre o próximo inimigo vivo
                    {
                        cbox_inimigo.setSelectedIndex(0);
                    }
                    isTurnoJogador = false;
                    label_evento.setText("Turno do Inimigo");
                    turnoInimigo();
                }
            } else {
                for (int i = 0; i < jogador.size() && i < maxJogador; i++)//removendo jogadores mortos
                {
                    if (confereSe_JogadorMorreu(i)) {
                        --i;
                    }
                }
                if (confereSe_ExistemJogadores() == false) { // Se todos os personagesn do jogador morreram, fim de jogo
                    gameOver();
                } else {// Se nao morreram, passe o turno para o primeiro jogador vivo
                    if (cbox_personagem.getSelectedIndex() >= jogador.size()) {
                        cbox_personagem.setSelectedIndex(0);
                    }
                    isTurnoJogador = true;
                    label_evento.setText("Turno do Jogador");
                }
            }

            return true;
        }
        return false;
    }

    void gameOver() {
        System.out.println("Game Over");
    }

    void vitoria() {
        System.out.println("Vitória");
    }

    private void atualizaLabeldeMP(int i, int j) {
        if (jogador.size() > i && jogador.get(i).getManaPoints() > 0) {
            label_mostraMPpersonagem.setText("" + jogador.get(i).getManaPoints());
        } else {
            label_mostraMPpersonagem.setText("0");
        }
        if (inimigo.size() > j && inimigo.get(j).getManaPoints() > 0) {
            label_mostraMPinimigo.setText("" + inimigo.get(j).getManaPoints());
        } else {
            label_mostraMPinimigo.setText("0");
        }
    }

    private void atualizaLabeldeHP(int i, int j) {
        if (jogador.size() > i && jogador.get(i).getHitPoints() > 0) {
            label_mostraHPersonagem.setText("" + jogador.get(i).getHitPoints());
        } else {
            label_mostraHPersonagem.setText("0");
        }
        if (inimigo.size() > j && inimigo.get(j).getHitPoints() > 0) {
            label_mostraHPinimigo.setText("" + inimigo.get(j).getHitPoints());
        } else {
            label_mostraHPinimigo.setText("0");
        }
    }

    @Override
    //ESSA FUNCAO RODA EM LOOP DE ACORDO COM O "timer" DECLARADO NO CONSTRUTOR
    public void actionPerformed(ActionEvent e) {
        //AQUI ADICIONA EVENTOS AO APERTAR OS BOTOES
        if (e.getSource() == botao_ataque) {//Se o botao ataque for pressionado
            if (isTurnoJogador && inimigo.size() > 0 && trocaTurnoJogador ==false) {//Se o jogador nao fez a jogada ainda
                turnoJogador(1);
            }
        }
        if (e.getSource() == botao_magia) {//Se o botao magia for pressionado
            if (isTurnoJogador && inimigo.size() > 0) {
                turnoJogador(2);
            }
        }

        //AQUI CHAMA O GERENCIADOR DE TURNO
        if (!painel.isAnimacao() && trocaTurnoJogador == true) {//Se o jogador fez a sua jogada e acabou a animacao
            cronometroPausa++;
            //AQUI VC PODE COLOCAR UMA MENSAGEM NA LABEL ANTES DE INICIRA O PROXIMO TURNO
            label_evento.setText("MENSAGEM COM TEMPO AQUI ..."+(100-cronometroPausa));
            if(cronometroPausa%100==0){//Tempo de espera de 1000ms = 1 segundos
                label_evento.setText("Turno do Inimigo");
                gerenciaTurno();
                trocaTurnoJogador = false;
                cronometroPausa = 0;
            }
            
        }
        if (!painel.isAnimacao() && trocaTurnoInimigo == true) {//Se o inimigo fez a jogada e acabou a animacao
            cronometroPausa++;
            //AQUI VC PODE COLOCAR UMA MENSAGEM NA LABEL ANTES DE INICIRA O PROXIMO TURNO
            label_evento.setText("MENSAGEM COM TEMPO AQUI ..."+(100-cronometroPausa));
            if(cronometroPausa%100==0){//Tempo de espera de 1000ms = 1 segundos
                label_evento.setText("Turno do Jogador");
                gerenciaTurno();
                trocaTurnoInimigo = false;
                cronometroPausa = 0;
            }
        }
//        //AQUI ATUALIZA AS LABELS EM TEMPO REAL(oPCIONAL)
        atualizaLabeldeHP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
        atualizaLabeldeMP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());

        //AQUI REPINTA A TELA A CADA 20 ms
        cronometro++;
        if (cronometro % 20 == 0) {
            repaint();//chama a fucao paint() da classe Painel_Animacao
        }

    }

}
