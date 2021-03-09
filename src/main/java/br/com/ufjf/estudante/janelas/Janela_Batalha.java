/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
 */
package br.com.ufjf.estudante.janelas;

import br.com.ufjf.estudante.main.NpcInimigo;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import br.com.ufjf.estudante.main.GrupoInimigo;
import br.com.ufjf.estudante.main.GrupoJogador;
import br.com.ufjf.estudante.main.Jogador;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author Luiz
 */
public class Janela_Batalha extends javax.swing.JFrame implements ActionListener {

    //OS EVENTOS DOS BOTOES ESTAO NA FUNCAO actionPerformed() AGORA
    private boolean isTurnoJogador;
    private int round;

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

    public Janela_Batalha(List<Jogador> jogador, List<NpcInimigo> inimigos) {
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
        GrupoInimigo.iniciaGrupo(0);

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
        botao_ataque.setSize(100, 25); //Tamanho
        botao_ataque.setLocation(10, 425);//Posicao

        botao_magia = new JButton();
        botao_magia.addActionListener(this);//Adiciona evento
        botao_magia.setText("Magia");//Texto
        botao_magia.setSize(100, 25); //Tamanho
        botao_magia.setLocation(10, 460);//Posicao

        botao_item = new JButton();
        botao_item.addActionListener(this);//Adiciona evento
        botao_item.setText("Item");//Texto
        botao_item.setSize(100, 25); //Tamanho
        botao_item.setLocation(10, 495);//Posicao

        //Adiciona botoes na tela
        this.add(botao_magia);
        this.add(botao_ataque);
        this.add(botao_item);
    }

    private void atualizaMaximoPersonagens() {
        //Atualizando o numero maximo de jogadores
        if (GrupoJogador.getSize() < maxJogador) {
            spriteJogador = new ArrayList<>(GrupoJogador.getSize());
            maxJogador = GrupoJogador.getSize();
        } else {
            spriteJogador = new ArrayList<>(maxJogador);
        }
        if (GrupoInimigo.getSize() < maxInimigo) {
            spriteInimigo = new ArrayList<>(GrupoInimigo.getSize());
            maxInimigo = GrupoInimigo.getSize();
        } else {
            spriteInimigo = new ArrayList<>(maxInimigo);
        }
    }

    private void iniciaComboBox() {//Caixa de selecao de personagem

        atualizaMaximoPersonagens();

//        add(cbox_personagem);//Adiciona caixa de selecao de personagens
//        add(cbox_inimigo);
        for (int i = 0; i < maxJogador; i++) {//Adiciona personagens na caixa de selecao
            cbox_personagem.addItem(GrupoJogador.getJogador(i).getNomePersonagem());
        }
        for (int i = 0; i < maxInimigo; i++) {//Adiciona personagens na caixa de selecao
            cbox_inimigo.addItem(GrupoInimigo.getInimigo(i).getNomePersonagem());
        }
        cbox_inimigo.removeItem("Vazio");
        cbox_personagem.removeItem("Vazio");
        cbox_inimigo.setVisible(true); //Deixa caixa de selecao de inimigos, visivel
        cbox_personagem.setVisible(true); //Deixa caixa de selecao de personages, visivel
    }

    private boolean confereSe_InimigoMorreu(int indice) {
        if (indice < maxInimigo) {
            if (GrupoInimigo.getInimigo(indice).getVidaAtual() <= 0) {
                spriteInimigo.get(indice).setVisible(false);//deixa o sprite invisivel
                this.remove(spriteInimigo.get(indice));//remove o sprite do painel
                spriteInimigo.remove(indice);
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
        int distanciay = 1;

        for (int i = 0; i < GrupoJogador.getSize() && i < maxJogador; i++) {
            spriteJogador.add(new JLabel(GrupoJogador.getJogador(i).getSprite()));
            spriteJogador.get(i).setSize(64, 64);//tamanho do sprite
            spriteJogador.get(i).setLocation(distanciax + 64, 64 * distanciay);//posicao
            painel.add(spriteJogador.get(i));//adiciona no painel
            spriteJogador.get(i).setVisible(true);//torna o sprite visivel
            if (i % 4 == 0) {
                distanciax++;
                distanciay = 0;
            }
        }
        distanciax = 1;
        distanciay = 1;
        for (int i = 0; i < GrupoInimigo.getSize() && i < maxInimigo; i++) {
            spriteInimigo.add(new JLabel(GrupoInimigo.getInimigo(i).getSprite()));
            spriteInimigo.get(i).setSize(64, 64);//tamanho do sprite
            spriteInimigo.get(i).setLocation((distanciax * 64) + 450, 64);//posicao
            painel.add(spriteInimigo.get(i));//adiciona no painel
            spriteInimigo.get(i).setVisible(true);//torna o sprite visivel
            if (i % 4 == 0) {
                distanciax++;
                distanciay = 0;
            }
        }
    }

    private void atualizaLabeldeHP(int i, int j) {
        if (GrupoJogador.getSize() > i && GrupoJogador.getJogador(i).getVidaAtual() > 0) {
            hitPointsJogador.setText("" + GrupoJogador.getJogador(i).getVidaAtual());
        } else {
            hitPointsJogador.setText("0");
        }
        if (GrupoInimigo.getSize() > j && GrupoInimigo.getInimigo(j).getVidaAtual() > 0) {
            hitPointsInimigo.setText("" + GrupoInimigo.getInimigo(j).getVidaAtual());
        } else {
            hitPointsInimigo.setText("0");
        }
    }

    private void atualizaLabeldeMP(int i, int j) {
        if (GrupoJogador.getSize() > i && GrupoJogador.getJogador(i).getManaPoints() > 0) {
            mpPointsJogador.setText("" + GrupoJogador.getJogador(i).getManaPoints());
        } else {
            mpPointsJogador.setText("0");
        }
        if (GrupoInimigo.getSize() > j && GrupoInimigo.getInimigo(j).getManaPoints() > 0) {
            mpPointsInimigo.setText("" + GrupoInimigo.getInimigo(j).getManaPoints());
        } else {
            mpPointsInimigo.setText("0");
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
        System.out.println("Inimigo: ");
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).sofreAtack(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).decideAcao(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getDefesa()));
        acaoInimigo = true;
        gerenciaTurno();
    }

    private void turnoJogador(int tipoAtaque) {
        System.out.println("Jogador: ");
        switch (tipoAtaque) {
            case 1:
                GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).sofreAtack(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).ataqueFisico(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getDefesa()));
                break;
            case 2:
                //GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).sofreAtack(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).ataqueMagico(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getDefesa()));
                break;
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
                    if (round == 2) { // Se for o ultimo round, ganhou jogo
                        vitoria();
                    } else { // se nao for ultimo round, configure proximo round
                        round++;
                        System.out.println("Round: " + round);
                    }
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

        alocaBotoes();
        atualizaLabeldeHP(0, 0);
        atualizaLabeldeMP(0, 0);
        iniciaComboBox();
        alocaSprites();


    }                                 

    private void cbox_personagemActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        if (GrupoJogador.getSize() > cbox_personagem.getSelectedIndex()) {
            if (GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getVidaAtual() > 0) {
                hitPointsJogador.setText("" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getVidaAtual());
            } else {
                hitPointsJogador.setText("0");
            }
            if (GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaPoints() > 0) {
                mpPointsJogador.setText("" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaPoints());
            } else {
                mpPointsJogador.setText("0");
            }
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
                hitPointsInimigo.setText("" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getVidaAtual());
            } else {
                hitPointsInimigo.setText("0");
            }
            if (GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaPoints() > 0) {
                mpPointsInimigo.setText("" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaPoints());
            } else {
                mpPointsInimigo.setText("0");
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

        if (poseJogador == 1) {
            animacao = true;
            animacaoJogadorAtaque();
            cronometroJogador++;
            System.out.println("cronometro: " + cronometroJogador);
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
            System.out.println("cronometro: " + cronometroJogador);
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
            System.out.println("cronometro: " + cronometroJogador);
            if (cronometroJogador % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroJogador = 0;
                poseJogador = -1;
                //Falta implementar
//                turnoJogador(2);
            }
        }

        
        if (poseInimigo == 1) {
            animacao = true;
            animacaoInimigoAtaque();
            cronometroInimigo++;
            System.out.println("cronometro: " + cronometroInimigo);
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
            System.out.println("cronometro: " + cronometroInimigo);
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
            System.out.println("cronometro: " + cronometroInimigo);
            if (cronometroInimigo % 200 == 0) {//Depois que passar 200milesegundos
                animacaoJogadorPadrao();
                animacaoInimigoPadrao();
                animacao = false;
                cronometroInimigo = 0;
                poseInimigo = -1;
                auxturnoInimigo();
            }
        }
//        cronometro++;
//        if(cronometro%1000==0){
//            System.out.println("CRONOMETRO: "+cronometro+" s");
//        }
    }
}
