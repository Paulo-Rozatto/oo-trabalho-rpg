/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
 */
package br.com.ufjf.estudante.janelas;

import br.com.ufjf.estudante.main.Dado;
import br.com.ufjf.estudante.main.AuxiliarGeraTexto;
import br.com.ufjf.estudante.main.NpcInimigo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import br.com.ufjf.estudante.main.GrupoInimigo;
import br.com.ufjf.estudante.main.GrupoJogador;
import br.com.ufjf.estudante.main.Item;
import br.com.ufjf.estudante.main.ItemArma;
import br.com.ufjf.estudante.main.ItemArmadura;
import br.com.ufjf.estudante.main.ItemConsumivel;
import br.com.ufjf.estudante.main.Jogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author Luiz
 */
public class Janela_Batalha extends javax.swing.JFrame implements ActionListener {

    //OS EVENTOS DOS BOTOES ESTAO NA FUNCAO actionPerformed() AGORA
    private boolean isTurnoJogador;
    private static int round;
    private Dado dado;
    
    //TIMER EH A VELOCIDADE QUE actionPerformed() VAI FUNCIONAR EM LOOP, 1 VALE 1MILISEGUNDO
    Timer timer = new Timer(1, this);
//    int cronometro = 0;
    //CRONOMETRO EH UM CONTADOR PAA MEDIR O TEMPO NA FUNCAO actionPerformed)(
    int cronometroJogador;
    int cronometroInimigo;
    int poseJogador;
    int poseInimigo;
    boolean acaoJogador;
    boolean acaoInimigo;
    boolean animacao;

    private int maxJogador;
    private int maxInimigo;
    private List<JLabel> spriteJogador;
    private List<JLabel> spriteInimigo;

    private JButton botao_ataque;
    private JButton botao_magia;
    private JButton botao_item;
    private JButton botao_mochila;
     
    private JComboBox<String> cbox_magia;
    
    private Janela_Mochila janelamMochila ;
    
    public Janela_Batalha(List<Jogador> jogador, List<NpcInimigo> inimigos) {
        dado = new Dado();
        timer.start();
        
        cronometroJogador = 0;
        cronometroInimigo = 0;
        poseJogador = -1;
        poseInimigo = -1;
        acaoJogador = false;
        acaoInimigo = false;
        animacao = false;
        //Declare variaveis aqui e chame metodos em formWindowOpened()
        GrupoJogador.iniciaGrupo(jogador);
        GrupoInimigo.iniciaGrupo();
        
        janelamMochila = new Janela_Mochila(this);

        this.maxJogador = 6;
        this.maxInimigo = 6;

        isTurnoJogador = true;
        round = 0;

        initComponents();//Inicia a janela
    }

    private void alocaBotoes() {
        botao_ataque = new JButton();
        botao_ataque.addActionListener(this);//Adiciona evento
        botao_ataque.setText("Ataque");//Texto
        botao_ataque.setSize(100, 35); //Tamanho
        botao_ataque.setLocation(10, 515);//Posicao

        botao_magia = new JButton();
        botao_magia.addActionListener(this);//Adiciona evento
        botao_magia.setText("Magia");//Texto
        botao_magia.setSize(100, 35); //Tamanho
        botao_magia.setLocation(10, 550);//Posicao

        botao_item = new JButton();
        botao_item.addActionListener(this);//Adiciona evento
        botao_item.setText("Item");//Texto
        botao_item.setSize(100, 35); //Tamanho
        botao_item.setLocation(10, 585);//Posicao
        
        botao_mochila = new JButton();
        botao_mochila.addActionListener(this);//Adiciona evento
        botao_mochila.setText("Mochila");//Texto
        botao_mochila.setSize(100, 35); //Tamanho
        botao_mochila.setLocation(10, 620);//Posicao

        //Adiciona botoes na tela
        this.add(botao_magia);
        this.add(botao_ataque);
        this.add(botao_item);
        this.add(botao_mochila);
    }
    
    private void realocaPosicaoItens(){
        this.remove(painel);
        painel.setSize(1020, 350);
        this.add(painel);
        
        this.remove(cbox_itens);
        cbox_itens.setLocation(110, 585);
        cbox_itens.setSize(200, 35);
        this.add(cbox_itens);
        
        cbox_magia = new JComboBox<String>();
        cbox_magia.setLocation(110, 550);
        cbox_magia.setSize(200, 35);
        this.add(cbox_magia);
        
        this.remove(jLabel1);
        this.remove(cbox_personagem);
        jLabel1.setLocation(10,420);
        cbox_personagem.setLocation(150, 415);
        cbox_personagem.setEditable(false);//Copiando mudança feita por Luiz
        this.add(cbox_personagem);
        this.add(jLabel1);
        
        this.remove(label_HP_Jogador);
        this.remove(label_MP_Jogador);
        label_HP_Jogador.setLocation(10, 450);
        label_MP_Jogador.setLocation(10, 485);
        this.add(label_HP_Jogador);
        this.add(label_MP_Jogador);
        
        this.remove(hitPointsJogador);
        this.remove(mpPointsJogador);
        hitPointsJogador.setLocation(150, 445);
        mpPointsJogador.setLocation(150, 480);
        this.add(hitPointsJogador);
        this.add(mpPointsJogador);
        
        
        this.remove(jLabel2);
        this.remove(cbox_inimigo);
        jLabel2.setLocation(450,420);
        cbox_inimigo.setLocation(590, 415);        
        this.add(cbox_inimigo);
        this.add(jLabel2);
        
        this.remove(label_HP_Inimigo);
        this.remove(label_MP_Inimigo);
        label_HP_Inimigo.setLocation(450, 450);
        label_MP_Inimigo.setLocation(450, 485);
        this.add(label_HP_Inimigo);
        this.add(label_MP_Inimigo);
        
        this.remove(hitPointsInimigo);
        this.remove(mpPointsInimigo);
        hitPointsInimigo.setLocation(590, 445);
        mpPointsInimigo.setLocation(590, 480);
        this.add(hitPointsInimigo);
        this.add(mpPointsInimigo);
//        
//        this.add(jLabel1);
//        jLabel1.setVisible(true);
//        cbox_personagem.setLocation(400, 400);
    }

    private void atualizaMaximoPersonagens() {
        //Atualizando o numero maximo de jogadores
        if (GrupoJogador.getSize() < maxJogador && round == 0) {
            spriteJogador = new ArrayList<>(GrupoJogador.getSize());
            maxJogador = GrupoJogador.getSize();
        } else if(round == 0){
            spriteJogador = new ArrayList<>(maxJogador);
        }
        if (GrupoInimigo.getSize() < maxInimigo && GrupoInimigo.getSize()>=0) {
            spriteInimigo = new ArrayList<>(GrupoInimigo.getSize());
            maxInimigo = GrupoInimigo.getSize();
        } else {
            spriteInimigo = new ArrayList<>(maxInimigo);
        }
    }
    
    private void limpa_cboxItens(){
        for(int i = cbox_itens.getItemCount()-1; i >= 0 ; i--){//Removendo lixo inicial da cboxItens
            cbox_itens.removeItemAt(i);
        }
    }
    
    private void atualiza_cboxItens(){
        limpa_cboxItens();
        
//        int tamanho = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getClasse();
        if(GrupoJogador.getSize() == cbox_personagem.getItemCount()){
            int tamanho = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getMochilaConsumivelSize();
            Item item; 
            System.out.println("Tamanho: " + tamanho);
            for (int i = 0; i < tamanho; i++) {
               item = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getMochilaItemConsumivel(i);
               if(item.getModelo() == 0){//Se for um item consumivel
                   int j;
                   for(j = 0; j < cbox_itens.getItemCount(); j++){
                       if(cbox_itens.getItemAt(j).contains(item.getNome())){
                           if(cbox_itens.getItemAt(j).length() == item.getNome().length()){
                               cbox_itens.addItem(item.getNome() + "(x2)");
                               cbox_itens.removeItemAt(j);
                               break;
                           }
                           else if(cbox_itens.getItemAt(j).length() == (item.getNome().length() + 4)){
                               char quantidade = (cbox_itens.getItemAt(j).charAt(cbox_itens.getItemAt(j).length() - 2));
                               System.out.println(quantidade);
                               if(quantidade != '9')
                                    cbox_itens.addItem(item.getNome() + "(x" + (quantidade - '0' + 1) + ")");
                               else
                                   cbox_itens.addItem(item.getNome() + "(x10)"); 
                               cbox_itens.removeItemAt(j);
                               break;
                           }
                           else if(cbox_itens.getItemAt(j).length() == (item.getNome().length() + 5)){
                               char quantidade = (cbox_itens.getItemAt(j).charAt(cbox_itens.getItemAt(j).length() - 2));
                               System.out.println(quantidade);
                               if(quantidade != '9')
                                    cbox_itens.addItem(item.getNome() + "(x" + cbox_itens.getItemAt(j).charAt(cbox_itens.getItemAt(j).length() - 3) + (quantidade - '0' + 1) + ")");
                               else
                                    cbox_itens.addItem(item.getNome() + "(x" + (cbox_itens.getItemAt(j).charAt(cbox_itens.getItemAt(j).length() - 3) - '0' + 1) + "0)");
                               cbox_itens.removeItemAt(j);
                               break;
                           }
                       }
                   }
                   if(j == cbox_itens.getItemCount())
                        cbox_itens.addItem(item.getNome());//Ela funciona com itens repetidos
               }
            }
        }
        if(cbox_itens.getItemCount() == 0)
            cbox_itens.setVisible(false);
        else
            cbox_itens.setVisible(true);
    }

    private void iniciaComboBox() {//Caixa de selecao de personagem
        if(round == 0){
            cbox_personagem.addActionListener(this);//USADO PARA ADICIONA EVENTO NO FUNCAO ACTIONPERFORMED
            atualizaMaximoPersonagens();
                limpa_cboxItens();



    //        add(cbox_personagem);//Adiciona caixa de selecao de personagens
    //        add(cbox_inimigo);
            for (int i = 0; i < maxJogador; i++) {//Adiciona personagens na caixa de selecao
                cbox_personagem.addItem(GrupoJogador.getJogador(i).getNomePersonagem());
            }
        cbox_personagem.removeItem("Vazio");
        cbox_personagem.setVisible(true); //Deixa caixa de selecao de personages, visivel
        }
        for (int i = 0; i < maxInimigo && i<GrupoInimigo.getSize(); i++) {//Adiciona personagens na caixa de selecao
            cbox_inimigo.addItem(GrupoInimigo.getInimigo(i).getNomePersonagem());
        }
        cbox_inimigo.removeItem("Vazio");
        cbox_inimigo.setVisible(true); //Deixa caixa de selecao de inimigos, visivel
        
        atualiza_cboxItens();
        
    }
    private void atualizaCboxMagia(int id){
        cbox_magia.removeAllItems();
        for(int i = 0; i < GrupoJogador.getJogador(id).getSizeListaMagias(); i++)
            cbox_magia.addItem(GrupoJogador.getJogador(id).getAtackMagico(i).getNomeMagia());
        if(GrupoJogador.getJogador(id).getSizeListMagias() == 0)//Se o Jogador não possuir nenhuma magia
            cbox_magia.setVisible(false);
        else
            cbox_magia.setVisible(true);
    }
    private void iniciaCboxMagia(){   
        cbox_magia.addActionListener(this);
        atualizaCboxMagia(0);
    }

    private boolean confereSe_InimigoMorreu(int indice) {
        if (indice < maxInimigo) {
            if (GrupoInimigo.getInimigo(indice).getVidaAtual() <= 0) {
                for (int i = 0; i < GrupoJogador.getSize(); i++) {
                    GrupoJogador.getJogador(i).adquireExp(GrupoInimigo.getInimigo(indice).getExperiencia());
                     //0 = consumivel, 1=arma, 2=armadura
                    if (GrupoInimigo.getInimigo(indice).getDrop().getModelo()==0){
                        GrupoJogador.getJogador(i).addMochilaConsumivel((ItemConsumivel) GrupoInimigo.getInimigo(indice).getDrop());
                    }
                    else{
                        if (GrupoInimigo.getInimigo(indice).getDrop().getModelo()==1) {
                            GrupoJogador.getJogador(i).addMochilaArma((ItemArma) GrupoInimigo.getInimigo(indice).getDrop());
                        }
                        else if(GrupoInimigo.getInimigo(indice).getDrop().getModelo()==2){
                            GrupoJogador.getJogador(i).addMochilaArmaduras((ItemArmadura) GrupoInimigo.getInimigo(indice).getDrop());
                        }
                    }
                               
                }
                spriteInimigo.get(indice).setVisible(false);//deixa o sprite invisivel
                this.remove(spriteInimigo.get(indice));//remove o sprite do painel
                spriteInimigo.remove(indice);
                transicao(indice, 0);
                if (GrupoInimigo.getSize() != 1) {
                    cbox_inimigo.removeItem(GrupoInimigo.getInimigo(indice).getNomePersonagem());
                } else {
                    cbox_inimigo.addItem("Vazio");
                    cbox_inimigo.removeItem(GrupoInimigo.getInimigo(0).getNomePersonagem());
                    cbox_inimigo.setVisible(false);
                }
                GrupoInimigo.removeInimigo(indice);//remove inimigo morto do vetor de inimigos
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean confereSe_JogadorMorreu(int indice) {
        if (indice < maxJogador) {
            if (GrupoJogador.getJogador(indice).getVidaAtual() <= 0) {
                spriteJogador.get(indice).setVisible(false);//deixa o sprite invisivel
                this.remove(spriteJogador.get(indice));//remove o sprite do painel
                spriteJogador.remove(indice);
                transicao(indice, 3);
                if (GrupoJogador.getSize() != 1) {
                    cbox_personagem.removeItem(GrupoJogador.getJogador(indice).getNomePersonagem());
                } else {
                    cbox_personagem.addItem("Vazio");
                    cbox_personagem.removeItem(GrupoJogador.getJogador(0).getNomePersonagem());
                    cbox_personagem.setVisible(false);
                }
                GrupoJogador.removeJogador(indice);//remove jogador morto do vetor de jogador
                return true;
            }
            return false;
        }
        return false;
    }

    private boolean confereSe_ExistemJogadores() {
        for (int i = 0; i < GrupoJogador.getSize(); i++) {
            if (GrupoJogador.getJogador(i).getVidaAtual() > 0) {
                return true;
            }
        }
        return false;
    }

    private boolean confereSe_ExistemInimigos() {
        for (int i = 0; i < GrupoInimigo.getSize(); i++) {
            if (GrupoInimigo.getInimigo(i).getVidaAtual() > 0) {
                return true;
            }
        }
        return false;
    }

    private void alocaSprites() {//Caixa de selecao de personagem

        atualizaMaximoPersonagens();

        //"Desenhando" imagem na tela
        int distanciax = 1;
        double distanciay = 0.5d;

        for (int i = 0; i < GrupoJogador.getSize() && i < maxJogador && round == 0; i++) {
            spriteJogador.add(new JLabel(GrupoJogador.getJogador(i).getSprite()));
            spriteJogador.get(i).setSize(64, 64);//tamanho do sprite
            spriteJogador.get(i).setLocation(distanciax * 64, (int)(64 * distanciay));//posicao
            distanciay++;
            painel.add(spriteJogador.get(i));//adiciona no painel
            spriteJogador.get(i).setVisible(true);//torna o sprite visivel
            if (i % 4 == 0 && i!=0) {
                distanciax++;
                distanciay = 0.5d;
            }
        }
        distanciax = 1;
        distanciay = 0.5d;
        for (int i = 0; i < GrupoInimigo.getSize() && i < maxInimigo; i++) {
            spriteInimigo.add(new JLabel(GrupoInimigo.getInimigo(i).getSprite()));
            spriteInimigo.get(i).setSize(64, 64);//tamanho do sprite
            spriteInimigo.get(i).setLocation((distanciax * 6) * 64 , (int)(64*distanciay));//posicao
            distanciay++;
            painel.add(spriteInimigo.get(i));//adiciona no painel
            spriteInimigo.get(i).setVisible(true);//torna o sprite visivel
            if (i % 4 == 0 && i!=0) {
                distanciax++;
                distanciay = 0.5d;
            }
        }
    }

    private void atualizaLabeldeHP(int i, int j) {
        if (GrupoJogador.getSize() > i && GrupoJogador.getJogador(i).getVidaAtual() > 0) {
            hitPointsJogador.setText(GrupoJogador.getJogador(i).getVidaAtual() + "/" + GrupoJogador.getJogador(i).getHitPoints());
        } else {
            hitPointsJogador.setText("0/" + GrupoJogador.getJogador(i).getHitPoints());
        }
        if (GrupoInimigo.getSize() > j && GrupoInimigo.getInimigo(j).getVidaAtual() > 0) {
            hitPointsInimigo.setText(GrupoInimigo.getInimigo(j).getVidaAtual() + "/" + GrupoInimigo.getInimigo(j).getHitPoints());
        } else {
            hitPointsInimigo.setText("0/" + GrupoInimigo.getInimigo(j).getHitPoints());
        }
    }

    private void atualizaLabeldeMP(int i, int j) {
        if (GrupoJogador.getSize() > i && GrupoJogador.getJogador(i).getManaAtual() > 0) {
            mpPointsJogador.setText(GrupoJogador.getJogador(i).getManaAtual() + "/" + GrupoJogador.getJogador(i).getManaPoints());
        } else {
            mpPointsJogador.setText("0/" + GrupoJogador.getJogador(i).getManaPoints());
        }
        if (GrupoInimigo.getSize() > j && GrupoInimigo.getInimigo(j).getManaAtual() > 0) {
            mpPointsInimigo.setText(GrupoInimigo.getInimigo(j).getManaAtual() + "/" + GrupoInimigo.getInimigo(j).getManaPoints());
        } else {
            mpPointsInimigo.setText("0/" + GrupoInimigo.getInimigo(j).getManaPoints());
        }
    }

    void vitoria() {
        System.out.println("Vitória");
    }

    private void turnoInimigo() {
        System.out.println("Inimigo: ");
        poseInimigo = 1;//Pose de ataqu
    }
    private void auxturnoInimigo() {
        int tipoAtaque = dado.rodaDado(2);
        int idMagia;
        System.out.println("Inimigo: ");
        switch(tipoAtaque){
            case 1:
                GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).sofreAtack(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).ataqueFisico(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getDefesa()));
                transicao(cbox_inimigo.getSelectedIndex(), 1);
                break;
            case 2:
                if(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getSizeListMagias() > 0){//Caso o personagem possua alguma magia
                    idMagia = dado.rodaDado(GrupoInimigo.getInimigo(cbox_personagem.getSelectedIndex()).getSizeListMagias()) - 1;
                    GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).sofreAtack(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).ataqueMagico(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getDefesa(), GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getAtackMagico(idMagia)));
                    transicao(cbox_inimigo.getSelectedIndex(), 2, idMagia);
                }
                else{
                    GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).sofreAtack(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).ataqueFisico(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getDefesa()));
                    transicao(cbox_inimigo.getSelectedIndex(), 1);
                }
                break;
        }
        acaoInimigo = true;
        gerenciaTurno();
    }

    private void turnoJogador(int tipoAtaque) {
        System.out.println("Jogador: ");
        switch (tipoAtaque) {
            case 1:
                GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).sofreAtack(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).ataqueFisico(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getDefesa()));
                transicao(cbox_personagem.getSelectedIndex(), 4);
                break;
            case 2:
                if(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getSizeListMagias() == cbox_magia.getItemCount() && cbox_magia.getItemCount()!= 0){
                    GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).sofreAtack(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).ataqueMagico(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getDefesa(), GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getAtackMagico(cbox_magia.getSelectedIndex())));
                    transicao(cbox_personagem.getSelectedIndex(), 5, cbox_magia.getSelectedIndex());
                }
                else{
                    transicao(cbox_personagem.getSelectedIndex(), 8);
                    return;
                }
                break;
            case 3:
                if(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getMochilaConsumivelSize() > cbox_itens.getSelectedIndex()){
                    int id = -1;
                    for(int i = 0; i < GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getMochilaConsumivelSize(); i++){
                        String Item = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getMochilaItemConsumivel(i).getNome();
                        System.out.println("Item: " + Item);
                        if((cbox_itens.getItemAt(cbox_itens.getSelectedIndex()).length() == (Item.length() + 4) || cbox_itens.getItemAt(cbox_itens.getSelectedIndex()).length() == (Item.length() + 5) || cbox_itens.getItemAt(cbox_itens.getSelectedIndex()).length() == Item.length()) && cbox_itens.getItemAt(cbox_itens.getSelectedIndex()).contains(Item)){
                            id = i;
                            break;
                        }
                    }
                    transicao(cbox_personagem.getSelectedIndex(), 9, id);
                    GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).usarConsumivel(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getMochilaItemConsumivel(id), id);
                    atualizaLabeldeHP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
                    atualizaLabeldeMP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
                    atualiza_cboxItens();
                }
                return;
        }
        acaoJogador = true;
        gerenciaTurno();
    }

    void gameOver() {
        System.out.println("Game Over");
    }

    private void gerenciaTurno() {
        if (animacao == false) {
            atualizaLabeldeHP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
            atualizaLabeldeMP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
            if (isTurnoJogador) {
                for (int i = 0; i < GrupoInimigo.getSize() && i < maxInimigo; i++) {//removendo inimigos mortos
                    if (confereSe_InimigoMorreu(i)) {
                        --i;
                    }
                }
                if (GrupoInimigo.getSize() == 0) {//se não há mais inimigos vivos
                    // A fazer: codigo que mostra na interface descricao de morte
                    /*
                    if (round == 2) { // Se for o ultimo round, ganhou jogo
                        vitoria();
                    } else { // se nao for ultimo round, configure proximo round
                    */
                        round++;
                        maxInimigo = 6;
                        GrupoInimigo.iniciaGrupo();
                        atualizaLabeldeHP(cbox_personagem.getSelectedIndex(), 0);
                        atualizaLabeldeMP(cbox_personagem.getSelectedIndex(), 0);
                        iniciaComboBox();
                        alocaSprites();
                        transicao(6);
                        System.out.println("Round: " + round);
                        cbox_inimigo.setSelectedIndex(0);
                        isTurnoJogador = false;
                        turnoInimigo();
                        
                    //}
                    //GrupoInimigo.iniciaGrupo(0);
                    //atualizaLabeldeHP(0, 0);
                    //atualizaLabeldeMP(0, 0);
                    //iniciaComboBox();
                    //alocaSprites();
                } else { // se há inimigos vivos, passe o turno para o próximo inimigo
                    if (cbox_inimigo.getSelectedIndex() >= GrupoInimigo.getSize())//se o inimigo selecionado está morto, encontre o próximo inimigo vivo
                    {
                        cbox_inimigo.setSelectedIndex(0);
                    }
                    isTurnoJogador = false;
                    turnoInimigo();
                }
            } else {
                for (int i = 0; i < GrupoJogador.getSize() && i < maxJogador; i++)//removendo jogadores mortos
                {
                    if (confereSe_JogadorMorreu(i)) {
                        --i;
                    }
                }
                if (confereSe_ExistemJogadores() == false) { // Se todos os personagesn do jogador morreram, fim de jogo
                    gameOver();
                    new Janela_GameOver(false).setVisible(true);
                    this.setVisible(false);
                    this.dispose();
                } else {// Se nao morreram, passe o turno para o primeiro jogador vivo
                    if (cbox_personagem.getSelectedIndex() >= GrupoJogador.getSize()) {
                        cbox_personagem.setSelectedIndex(0);
                    }
                    isTurnoJogador = true;
                }
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbox_personagem = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        cbox_inimigo = new javax.swing.JComboBox<>();
        label_HP_Jogador = new javax.swing.JLabel();
        label_HP_Inimigo = new javax.swing.JLabel();
        hitPointsJogador = new javax.swing.JTextField();
        hitPointsInimigo = new javax.swing.JTextField();
        label_MP_Jogador = new javax.swing.JLabel();
        label_MP_Inimigo = new javax.swing.JLabel();
        mpPointsJogador = new javax.swing.JTextField();
        mpPointsInimigo = new javax.swing.JTextField();
        painel = new javax.swing.JPanel();
        cbox_itens = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Escolha o personagem:");

        cbox_personagem.setEditable(true);
        cbox_personagem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_personagemActionPerformed(evt);
            }
        });

        jLabel2.setText("Escolha o inimigo:");

        cbox_inimigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbox_inimigoActionPerformed(evt);
            }
        });

        label_HP_Jogador.setText("HP do Jogador");

        label_HP_Inimigo.setText("HP do Inimigo");

        hitPointsJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitPointsJogadorActionPerformed(evt);
            }
        });

        hitPointsInimigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitPointsInimigoActionPerformed(evt);
            }
        });

        label_MP_Jogador.setText("MP do Jogador");

        label_MP_Inimigo.setText("MP do Inimigo");

        mpPointsJogador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpPointsJogadorActionPerformed(evt);
            }
        });

        mpPointsInimigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mpPointsInimigoActionPerformed(evt);
            }
        });

        painel.setBackground(new java.awt.Color(51, 255, 255));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 329, Short.MAX_VALUE)
        );

        cbox_itens.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbox_itens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbox_personagem, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_HP_Jogador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(hitPointsJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(label_MP_Jogador, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(mpPointsJogador, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 253, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cbox_inimigo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(label_HP_Inimigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(label_MP_Inimigo, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mpPointsInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(hitPointsInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(47, 47, 47))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbox_personagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbox_inimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_HP_Inimigo)
                            .addComponent(hitPointsInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_MP_Inimigo)
                            .addComponent(mpPointsInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_HP_Jogador)
                            .addComponent(hitPointsJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_MP_Jogador)
                            .addComponent(mpPointsJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox_itens, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4))
        );

        pack();
    }// </editor-fold>                        

    //QUANDO A JANELA ABRIR
    private void formWindowOpened(java.awt.event.WindowEvent evt) {                                  

        this.setResizable(false);// true: Habilita/false: Desabilita maximizar
        this.setTitle("Trabalho o-o");//titulo
        this.setSize(880, 720);
        this.setLocationRelativeTo (null);
        realocaPosicaoItens();

        alocaBotoes();
        atualizaLabeldeHP(0, 0);
        atualizaLabeldeMP(0, 0);
        iniciaComboBox();
        iniciaCboxMagia();
        alocaSprites();


    }                                 

    private void cbox_personagemActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        if (GrupoJogador.getSize() > cbox_personagem.getSelectedIndex()) {
            if (GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getVidaAtual() > 0) {
                hitPointsJogador.setText(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getVidaAtual() + "/" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getHitPoints());
            } else {
                hitPointsJogador.setText("0/" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getHitPoints());
            }
            if (GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaAtual() > 0) {
                mpPointsJogador.setText(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaAtual() + "/" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaPoints());
            } else {
                mpPointsJogador.setText("0/" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaPoints());
            }
            atualizaCboxMagia(cbox_personagem.getSelectedIndex());
        }
    }                                               

    private void hitPointsJogadorActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:

    }                                                

    private void mpPointsJogadorActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void hitPointsInimigoActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
    }                                                

    private void mpPointsInimigoActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
    }                                               

    private void cbox_inimigoActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        if (GrupoInimigo.getSize() > cbox_inimigo.getSelectedIndex()) {
            if (GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getVidaAtual() > 0) {
                hitPointsInimigo.setText(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getVidaAtual() + "/" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getHitPoints());
            } else {
                hitPointsInimigo.setText("0/" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getHitPoints());
            }
            if (GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaAtual() > 0) {
                mpPointsInimigo.setText(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaAtual() + "/" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaPoints());
            } else {
                mpPointsInimigo.setText("0/" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaPoints());
            }
        }
    }                                            

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(Janela_Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Janela_Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Janela_Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Janela_Batalha.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Janela_Batalha().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify                     
    private javax.swing.JComboBox<String> cbox_inimigo;
    private javax.swing.JComboBox<String> cbox_itens;
    private javax.swing.JComboBox<String> cbox_personagem;
    private javax.swing.JTextField hitPointsInimigo;
    private javax.swing.JTextField hitPointsJogador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_HP_Inimigo;
    private javax.swing.JLabel label_HP_Jogador;
    private javax.swing.JLabel label_MP_Inimigo;
    private javax.swing.JLabel label_MP_Jogador;
    private javax.swing.JTextField mpPointsInimigo;
    private javax.swing.JTextField mpPointsJogador;
    private javax.swing.JPanel painel;
    // End of variables declaration                   

    //FUNCOES DE ANIMACAO:
    //Animacoes de ataque
    public void animacaoJogadorAtaque() {
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).trocaAnimacaoJogador(1);
        GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).trocaAnimacaoInimigo(3);

        ImageIcon referencia;
        referencia = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getSprite();
        spriteJogador.get(cbox_personagem.getSelectedIndex()).setIcon(referencia);

        referencia = GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getSprite();
        spriteInimigo.get(cbox_inimigo.getSelectedIndex()).setIcon(referencia);

    }

    public void animacaoInimigoAtaque() {
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).trocaAnimacaoJogador(3);
        GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).trocaAnimacaoInimigo(1);

        ImageIcon referencia;
        referencia = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getSprite();
        spriteJogador.get(cbox_personagem.getSelectedIndex()).setIcon(referencia);

        referencia = GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getSprite();
        spriteInimigo.get(cbox_inimigo.getSelectedIndex()).setIcon(referencia);
    }

    //animacao imagem padrao
    public void animacaoJogadorPadrao() {
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).trocaAnimacaoJogador(0);

        ImageIcon referencia;
        referencia = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getSprite();
        spriteJogador.get(cbox_personagem.getSelectedIndex()).setIcon(referencia);
    }

    public void animacaoInimigoPadrao() {
        GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).trocaAnimacaoInimigo(0);

        ImageIcon referencia;
        referencia = GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getSprite();
        spriteInimigo.get(cbox_inimigo.getSelectedIndex()).setIcon(referencia);
    }

    //animacao itens
    public void animacaoJogadorItem() {
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).trocaAnimacaoJogador(2);

        ImageIcon referencia;
        referencia = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getSprite();
        spriteJogador.get(cbox_personagem.getSelectedIndex()).setIcon(referencia);
    }

    public void animacaoInimigoItem() {
        GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).trocaAnimacaoInimigo(2);

        ImageIcon referencia;
        referencia = GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getSprite();
        spriteInimigo.get(cbox_inimigo.getSelectedIndex()).setIcon(referencia);
    }

    //animacao magia
    public void animacaoJogadorMagia() {
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).trocaAnimacaoJogador(2);
        GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).trocaAnimacaoInimigo(3);

        ImageIcon referencia;
        referencia = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getSprite();
        spriteJogador.get(cbox_personagem.getSelectedIndex()).setIcon(referencia);

        referencia = GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getSprite();
        spriteInimigo.get(cbox_inimigo.getSelectedIndex()).setIcon(referencia);
    }

    public void animacaoInimigoMagia() {
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).trocaAnimacaoJogador(3);
        GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).trocaAnimacaoInimigo(3);

        ImageIcon referencia;
        referencia = GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getSprite();
        spriteJogador.get(cbox_personagem.getSelectedIndex()).setIcon(referencia);

        referencia = GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getSprite();
        spriteInimigo.get(cbox_inimigo.getSelectedIndex()).setIcon(referencia);
    }

    @Override
    //ESSA FUNCAO VAI RODAR EM LOOP CONFORME O timer DECLARADO
    public void actionPerformed(ActionEvent e) {
        //IMPLEMENTACAO DE EVENTO AO SELECIONA COMBOBOX
        //Funciona porque foi adicionado um evento na funcai iniciaCombobox()
        if(e.getSource() == cbox_personagem){//Sempre que o usuario selecionar um personagem na cbox...
//            System.out.println("Texte evento cbox");
            limpa_cboxItens();
            atualiza_cboxItens();
        }
        //IMPLEMENTACAO DOS BOTOES
        if (e.getSource() == botao_ataque) {
            if (isTurnoJogador && GrupoInimigo.getSize() > 0 && animacao == false) {
                poseJogador = 1;
            }
        }
        if (e.getSource() == botao_magia) {
            if (isTurnoJogador && GrupoInimigo.getSize() > 0 && animacao == false) {
                poseJogador = 2;
            }
        }
        if (e.getSource() == botao_item) {
            if (isTurnoJogador && GrupoInimigo.getSize() > 0 && animacao == false) {
                poseJogador = 3;
            }
        }
        if (e.getSource() == botao_mochila) {
            if (isTurnoJogador && GrupoInimigo.getSize() > 0 && animacao == false) {
                Janela_Mochila janelamMochila = new Janela_Mochila(this);
                janelamMochila.setVisible(true);
                this.setVisible(false);

                
            }
        }

        if (poseJogador == 1) {
            animacao = true;
            animacaoJogadorAtaque();
            cronometroJogador++;
            if (cronometroJogador % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroJogador = 0;
                poseJogador = -1;
                turnoJogador(1);
            }
        }
        if (poseJogador == 2) {
            animacao = true;
            animacaoJogadorMagia();
            cronometroJogador++;
            if (cronometroJogador % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroJogador = 0;
                poseJogador = -1;
                turnoJogador(2);
            }
        }
        if (poseJogador == 3) {
            animacao = true;
            animacaoJogadorItem();
            cronometroJogador++;
            if (cronometroJogador % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroJogador = 0;
                poseJogador = -1;
                //Falta implementar
//                turnoJogador(2);
                  turnoJogador(3);
            }
        }

        
        if (poseInimigo == 1) {
            animacao = true;
            animacaoInimigoAtaque();
            cronometroInimigo++;
            if (cronometroInimigo % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroInimigo = 0;
                poseInimigo = -1;
                auxturnoInimigo();
            }
        }
        if (poseInimigo == 2) {
            animacao = true;
            animacaoInimigoMagia();
            cronometroInimigo++;
            if (cronometroInimigo % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroInimigo = 0;
                poseInimigo = -1;
                auxturnoInimigo();
            }
        }
        if (poseInimigo == 1) {
            animacao = true;
            animacaoInimigoItem();
            cronometroInimigo++;
            if (cronometroInimigo % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroInimigo = 0;
                poseInimigo = -1;
                auxturnoInimigo();
            }
        }
    }
    public static void transicao(int exibicao) {
        switch (exibicao){
            case 6://Descrição de transição de Round
                JOptionPane.showConfirmDialog(null, "Avançando para o próximo round...", "Round " + (round + 1), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            }
    }

    public static void transicao(int auxiliar, int exibicao){
        switch (exibicao){
            case 0://Descrição de morte do Inimigo
                JOptionPane.showConfirmDialog(null, GrupoInimigo.getInimigo(auxiliar).getDescricaoMorte(), GrupoInimigo.getInimigo(auxiliar).getNomePersonagem() + " morreu", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 1://Descrição de ataque físico do Inimigo
                JOptionPane.showConfirmDialog(null, (GrupoInimigo.getInimigo(auxiliar).getNomePersonagem() + " usou " + GrupoInimigo.getInimigo(auxiliar).getArma().getTipoDano() + AuxiliarGeraTexto.getTextoAtaqueFisico()), "Ação de " + GrupoInimigo.getInimigo(auxiliar).getNomePersonagem(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 3://Descrição de morte do Jogador
                JOptionPane.showConfirmDialog(null, (GrupoJogador.getJogador(auxiliar).getNomePersonagem() + " morreu"), "Morte", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 4://Decrição de ataque do Jogador
                JOptionPane.showConfirmDialog(null, (GrupoJogador.getJogador(auxiliar).getNomePersonagem() + " usou " + GrupoJogador.getJogador(auxiliar).getArma().getTipoDano() + AuxiliarGeraTexto.getTextoAtaqueFisico()), "Ação de " + GrupoJogador.getJogador(auxiliar).getNomePersonagem(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);    
                break;
            case 7://Descrição de aumento de nível
                JOptionPane.showConfirmDialog(null, GrupoJogador.getJogador(auxiliar).getNomePersonagem() + " subiu para o nível " + GrupoJogador.getJogador(auxiliar).getLevel(), "Aumento de Nível", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 8://Caso o jogador use ataque mágico, mas não possua magia
                JOptionPane.showConfirmDialog(null, "Você não possui Magia", "Ação de " + GrupoJogador.getJogador(auxiliar).getNomePersonagem(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
        }
        //JOptionPane.showConfirmDialog(null, "Mensagem", "Transicao", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
    }
    public static void transicao(int auxiliar, int exibicao, int id){
        switch(exibicao){
            case 2://Descrição de ataque mágico do Inimigo
                JOptionPane.showConfirmDialog(null, (GrupoInimigo.getInimigo(auxiliar).getNomePersonagem() + " usou " + GrupoInimigo.getInimigo(auxiliar).getAtackMagico(id).getNomeMagia()) + AuxiliarGeraTexto.getTextoAtaqueMagico(), "Ação de " + GrupoInimigo.getInimigo(auxiliar).getNomePersonagem(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 5://Descrição de ataque mágico do Jogador
                JOptionPane.showConfirmDialog(null, (GrupoJogador.getJogador(auxiliar).getNomePersonagem() + " usou " + GrupoJogador.getJogador(auxiliar).getAtackMagico(id).getNomeMagia()) + AuxiliarGeraTexto.getTextoAtaqueMagico(), "Ação de " + GrupoJogador.getJogador(auxiliar).getNomePersonagem(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
                break;
            case 9://Caso o jogador utiliza algum item
                JOptionPane.showConfirmDialog(null, (GrupoJogador.getJogador(auxiliar).getNomePersonagem() + " usou " + GrupoJogador.getJogador(auxiliar).getMochilaItemConsumivel(id).getNome()), "Ação de " + GrupoJogador.getJogador(auxiliar).getNomePersonagem(), JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
        }
    }
}
