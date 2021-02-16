package br.com.ufjf.estudante.main;

import br.com.ufjf.estudante.janelas.Janela_Batalha;

import java.util.Scanner;

/**
 *
 * @author paulo
 */
public class Main extends javax.swing.JFrame {

    private Jogador jogador;
    private NpcInimigo inimigo;
    private boolean isTurnoJogador;
    private int round;
    private Dado dado;

    // Temporario - variaveis para fazer a leitura pelo teclado enquanto nao tem interface
    private String nomeJogador;
    private int classeJogador;
    Scanner input;
    
    //
    Personagem [] grupoJogador;
    NpcInimigo [] grupoInimigo;

    public Main() {
        isTurnoJogador = true;
        round = 0;
        dado = new Dado();

        input = new Scanner(System.in);
        System.out.println("Nome: ");
        nomeJogador = input.nextLine();
        System.out.println("1-Guerreiro\n2-Mago\n3-Ladino\nClasse: ");
        classeJogador = input.nextInt();

        initJogador();
        initInimigo();
//        jogadorEscolheAcao();

        Personagem [] grupoJojador = new Personagem[1];
        grupoJojador[0] = jogador;
        this.grupoJogador = grupoJojador;
        
        NpcInimigo [] grupoInimigo = new NpcInimigo[1];
        grupoInimigo[0] = inimigo;
        this.grupoInimigo = grupoInimigo;


        initComponents();
    }

    /**
     * Instacia jogador - A fazer: pegar nome e classe da interface
     */
    private void initJogador() {
        // Equanto sem interface, inicializacao provisoria 

        String nome = nomeJogador;
        int forca = 10;
        int inteligencia = 10;
        int destreza = 10;
        AtackFisico ataqueFisico = new AtackFisico("ataque", 10, 10, 0);
        AtackMagico ataqueMagico = new AtackMagico("magia", 10, 10, 10, 0);
        int classe = classeJogador;

        jogador = new Jogador(nome, forca, inteligencia, destreza, ataqueFisico, ataqueMagico, classe);
    }

    /**
     * Inicia o inimigo com base no round atual, os inimigos tem quantidade
     * limitada e sao hard-coded
     */
    private void initInimigo() {
        int experiencia;
        String descricaoMorte;
        String nome;
        int forca;
        int inteligencia;
        int destreza;
        AtackFisico ataqueFisico;
        AtackMagico ataqueMagico;
        int classe;

        if (round == 0) {
            // Inicializacao provisorio do primeiro inimigo
            experiencia = 10;
            descricaoMorte = "No ceu tem pao? E morreu.";
            nome = "Monstro 1";
            forca = 5;
            inteligencia = 5;
            destreza = 5;
            ataqueFisico = new AtackFisico("ataque", 5, 5, 0);
            ataqueMagico = new AtackMagico("magia", 5, 5, 5, 0);
            classe = 1;

            // Essa linha pode ir para o final do metodo quando tiver todos IFs
            inimigo = new NpcInimigo(experiencia, descricaoMorte, nome, forca, inteligencia, destreza, ataqueFisico, ataqueMagico, classe);
        } else if (round == 1) {
            // A fazer: Inimigo do segundo round;
        } else {
            // A fazer: Inimigo do terceiro round;
        }
    }

    /* Metodo temporario enquanto nao ha interface */
    private void jogadorEscolheAcao() {
        System.out.println("\nVida jogador: " + jogador.getHitPoints());
        System.out.println("Vida inimigo: " + inimigo.getHitPoints());
        System.out.println("1-Ataque\n2-Magia\nEscolha:");
        int escolha = input.nextInt();

        if (escolha == 1) {
            jogadorAtaca();
        } else {
            jogadorUsaMagia();
        }
    }

    /**
     * A fazer: Metodo para ser chamado pelo botao de ataque da interface
     */
    private void jogadorAtaca() {
        // A fazer: codigo de ataque fisico
        System.out.println("Jogador ataca:\n0 de dano. (Nao implementado)");
        gerenciaTurno();
    }

    /**
     * A fazer: Metodo para ser chamado pelo botao de magia da interface
     */
    private void jogadorUsaMagia() {
        // A fazer: codigo de ataque magico
        System.out.println("Jogador usa magia:\n0 de dano. (Nao implementado)");
        gerenciaTurno();
    }

    private void acaoInimigo() {
        // A fazer: exibir na interface qual acao foi escolhida
        System.out.println("Inimigo ataca: ");
        int dano = inimigo.decideAcao(jogador.getDefesa());
        System.out.println( dano + " de dano");
        jogador.sofreAtack(dano);
        gerenciaTurno();
    }

    /**
     * Verifica vida dos personagens para a passagem de turno, round ou fim de
     * jogo
     */
    private void gerenciaTurno() {
        if (isTurnoJogador) {

            if (inimigo.getHitPoints() <= 0) { // Se o inimigo morreu

                // A fazer: codigo que mostra na interface descricao de morte
                if (round == 2) { // Se for o ultimo round, ganhou jogo
                    ganhou();
                } else { // se nao for ultimo round, configure proximo round
                    round++;
                    initInimigo();
                }
            } else { // se o inimigo nao morreu, passe o turno para o inimigo
                isTurnoJogador = false;
                acaoInimigo();
            }
        } else {
            if (jogador.getHitPoints() <= 0) { // Se o jogador morreu, fim de jogo
                gameOver();
            } else { // Se nao morreu, passe o turno para o jogador
                isTurnoJogador = true;
                jogadorEscolheAcao();
            }
        }
    }

    /**
     * A fazer: Metodo para alterar a interface quando jogo for ganho
     */
    private void ganhou() {
        // A fazer
    }

    /**
     * A fazer: Metodo para alterar a interface quando jogo for perdido
     */
    private void gameOver() {
        // A fazer
        System.out.println("Game over");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelOla = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelOla.setText("Ola mundo");

        jButton1.setText("Jogar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelOla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addComponent(jLabelOla)
                .addGap(107, 107, 107)
                .addComponent(jButton1)
                .addContainerGap(108, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jLabelOla.setText("Teste!");
        new Janela_Batalha(grupoJogador, grupoInimigo).setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabelOla;
    // End of variables declaration//GEN-END:variables
}
