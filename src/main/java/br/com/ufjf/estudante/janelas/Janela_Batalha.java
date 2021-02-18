/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
*/
package br.com.ufjf.estudante.janelas;
import br.com.ufjf.estudante.main.NpcInimigo;
import br.com.ufjf.estudante.main.Personagem;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import br.com.ufjf.estudante.main.Dado;
import br.com.ufjf.estudante.main.Jogador;

/**
 *
 * @author Luiz
 */
public class Janela_Batalha extends javax.swing.JFrame {

    private Jogador [] jogador;
    private NpcInimigo [] inimigos;
    
    private boolean isTurnoJogador = true;
    private int round = 0;
    private Dado dado = new Dado();
    
//    private int tamanhoJanelaX;
//    private int tamanhoJanelaY;
    
    private int maxJogador; 
    private int maxInimigo; 
    private JLabel [] spriteJogador;
    private JLabel [] spriteInimigo;

    

    
    
    public Janela_Batalha(Jogador [] jogador, NpcInimigo [] inimigos) {
        //Declare variaveis aqui e chame metodos em formWindowOpened()
        this.jogador = jogador;
        this.inimigos = inimigos;
        
//        this.tamanhoJanelaX = this.getWidth();
//        this.tamanhoJanelaY = this.getHeight();
        this.maxJogador = 6;
        this.maxInimigo = 6;
        

        
        initComponents();//Inicia a janela
    }
    
    private void atualizaMaximoPersonagens(){
        //Atualizando o numero maximo de jogadores
        if(jogador.length<maxJogador){
            spriteJogador = new JLabel[jogador.length];
            maxJogador = jogador.length;
        }
        else{
            spriteJogador = new JLabel[maxJogador];
        }
        if(inimigos.length<maxInimigo){
            spriteInimigo = new JLabel[inimigos.length];
            maxInimigo = inimigos.length;
        }
        else{
            spriteInimigo = new JLabel[maxInimigo];
        }
    }
    
    private void iniciaComboBox(){//Caixa de selecao de personagem
        
        atualizaMaximoPersonagens();
        
//        add(cbox_personagem);//Adiciona caixa de selecao de personagens
//        add(cbox_inimigo);
        for (int i = 0; i < maxJogador; i++) {//Adiciona personagens na caixa de selecao
            cbox_personagem.addItem(jogador[i].getNomePersonagem());
        }
        for (int i = 0; i < maxInimigo; i++) {//Adiciona personagens na caixa de selecao
            cbox_inimigo.addItem(inimigos[i].getNomePersonagem());
        }
        cbox_inimigo.setVisible(true); //Deixa caixa de selecao de inimigos, visivel
        cbox_personagem.setVisible(true); //Deixa caixa de selecao de personages, visivel
    }
    
    private boolean confereSe_InimigoMorreu(int indice){
        if(indice<maxInimigo){
            if (inimigos[indice].getHitPoints() < 0) {
                spriteInimigo[indice].setVisible(false);//deixa o sprite invisivel
                this.remove(spriteInimigo[indice]);//remove o sprite do painel
                cbox_inimigo.removeItem(inimigos[indice].getNomePersonagem());//removendo da caixa de selecao
                return true;
            }
            return false;
        }
        return false;
    }
    
    private boolean confereSe_JogadorMorreu(int indice){
        if(indice<maxJogador){
            if (jogador[indice].getHitPoints() < 0) {
                spriteJogador[indice].setVisible(false);//deixa o sprite invisivel
                this.remove(spriteJogador[indice]);//remove o sprite do painel
                cbox_inimigo.removeItem(jogador[indice].getNomePersonagem());//removendo da caixa de selecao
                return true;
            }
            return false;
        }
        return false;
        
    }
    
    private boolean confereSe_ExistemJogadores(){
        for (int i = 0; i < maxJogador; i++) {
            if(jogador[i].getHitPoints()>0)
                return true;
        }
        return false;
    }
    
    private boolean confereSe_ExistemInimigos(){
        for (int i = 0; i < maxInimigo; i++) {
            if(inimigos[i].getHitPoints()>0)
                return true;
        }
        return false;
    }
    
    private void alocaSprites(){//Caixa de selecao de personagem
        
        atualizaMaximoPersonagens();
        
        //"Desenhando" imagem na tela
        int distanciax = 1;
        int distanciay = 1;
        
        for (int i = 0; i < jogador.length && i<maxJogador; i++) {
            spriteJogador[i] = new JLabel(jogador[i].getSprite());
            spriteJogador[i].setSize(64, 64);//tamanho do sprite
            spriteJogador[i].setLocation(distanciax + 64 , 64*distanciay);//posicao
            this.add(spriteJogador[i]);//adiciona no painel
            spriteJogador[i].setVisible(true);//torna o sprite visivel
            if(i%4==0){
                distanciax ++; 
                distanciay=0;
            }
        }
        distanciax =1;
        distanciay=1;
        for (int i = 0; i < inimigos.length && i<maxInimigo; i++) {
            spriteInimigo[i] = new JLabel(inimigos[i].getSprite());
            spriteInimigo[i].setSize(64, 64);//tamanho do sprite
            spriteInimigo[i].setLocation((distanciax*64)+450 , 64);//posicao
            this.add(spriteInimigo[i]);//adiciona no painel
            spriteInimigo[i].setVisible(true);//torna o sprite visivel
            if(i%4==0){
                distanciax ++; 
                distanciay=0;
            }
        }
    }
    
    private void atualizaLabeldeHP(int i, int j){
        if((jogador[i].getHitPoints()>=0))
            hitPoints.setText("" + (jogador[i].getHitPoints()));
        else
             hitPoints.setText("0");
        if(inimigos[j].getHitPoints()>=0)
            hitPointsInimigo.setText("" + inimigos[j].getHitPoints());
        else
             hitPointsInimigo.setText("0");
    }
    
    void vitoria(){
        System.out.println("Vitória");
    }
    
    private void turnoInimigo(int i, int j){
        if(confereSe_ExistemInimigos()){
            if(inimigos[j].getHitPoints() <= 0)
                for(j = 0; j < inimigos.length && j < maxInimigo; j++)
                    if(!confereSe_InimigoMorreu(j)){
                        cbox_inimigo.setSelectedIndex(j);
                        break;
                    }
            int tipoAtaque = dado.rodaDado(2);
            System.out.println("Inimigo: ");
            if(tipoAtaque == 1)
                jogador[i].sofreAtack(inimigos[j].ataqueFisico(jogador[0].getDefesa()));
            else
                jogador[i].sofreAtack(inimigos[j].ataqueMagico(jogador[0].getDefesa()));
            atualizaLabeldeHP(i, j);
            isTurnoJogador = true;
            round = round + 1;
        }
        else
            vitoria();
    }
    
    void gameOver(){
        System.out.println("Game Over");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        cbox_personagem = new javax.swing.JComboBox<>();
        button_ataque = new javax.swing.JButton();
        button_magia = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbox_inimigo = new javax.swing.JComboBox<>();
        label_HP_personagem = new javax.swing.JLabel();
        label_HP_inimigo = new javax.swing.JLabel();
        hitPoints = new javax.swing.JTextField();
        hitPointsInimigo = new javax.swing.JTextField();

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

        button_ataque.setText("Ataque");
        button_ataque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ataqueActionPerformed(evt);
            }
        });

        button_magia.setText("Magia");
        button_magia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_magiaActionPerformed(evt);
            }
        });

        jLabel2.setText("Escolha o inimigo:");

        label_HP_personagem.setText("Pontos de vida do seu personagem:");

        label_HP_inimigo.setText("Pontos de vida do seu inimigo:");

        hitPoints.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hitPointsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbox_personagem, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(cbox_inimigo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(button_magia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(button_ataque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(189, 189, 189)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(label_HP_personagem, javax.swing.GroupLayout.DEFAULT_SIZE, 271, Short.MAX_VALUE)
                    .addComponent(label_HP_inimigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hitPoints, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(hitPointsInimigo))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(370, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbox_personagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(cbox_inimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(button_ataque)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_magia))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_HP_personagem)
                            .addComponent(hitPoints, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_HP_inimigo)
                            .addComponent(hitPointsInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //QUANDO A JANELA ABRIR
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        this.setResizable(false);// true: Habilita/false: Desabilita maximizar
        this.setTitle("Trabalho o-o");//titulo
        

        
        atualizaLabeldeHP(0, 0);
        iniciaComboBox();
        alocaSprites();

        
    }//GEN-LAST:event_formWindowOpened

    private void cbox_personagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_personagemActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbox_personagemActionPerformed

    private void button_ataqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ataqueActionPerformed
        // TODO add your handling code here:
        if(confereSe_ExistemJogadores()){
            if(isTurnoJogador == true && jogador[cbox_personagem.getSelectedIndex()].getHitPoints() > 0){
                System.out.println("Jogador: ");
                int i = cbox_personagem.getSelectedIndex();
                int j = cbox_inimigo.getSelectedIndex();
                inimigos[j].sofreAtack(jogador[i].ataqueFisico(inimigos[j].getDefesa()));
                atualizaLabeldeHP(i, j);
                isTurnoJogador = false;
                round = round + 1;
                turnoInimigo(i, j);
            }
        }
        else
            gameOver();
    }//GEN-LAST:event_button_ataqueActionPerformed

    private void hitPointsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitPointsActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_hitPointsActionPerformed

    private void button_magiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_magiaActionPerformed
        // TODO add your handling code here:
        if(confereSe_ExistemJogadores()){
            if(isTurnoJogador == true && jogador[cbox_personagem.getSelectedIndex()].getHitPoints() > 0){
                System.out.println("Jogador: ");
                int i = cbox_personagem.getSelectedIndex();
                int j = cbox_inimigo.getSelectedIndex();
                inimigos[j].sofreAtack(jogador[i].ataqueMagico(inimigos[j].getDefesa()));
                atualizaLabeldeHP(i, j);
                isTurnoJogador = false;
                round = round + 1;
                turnoInimigo(i, j);
            }
        }
        else
            gameOver();
    }//GEN-LAST:event_button_magiaActionPerformed

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_ataque;
    private javax.swing.JButton button_magia;
    private javax.swing.JComboBox<String> cbox_inimigo;
    private javax.swing.JComboBox<String> cbox_personagem;
    private javax.swing.JTextField hitPoints;
    private javax.swing.JTextField hitPointsInimigo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel label_HP_inimigo;
    private javax.swing.JLabel label_HP_personagem;
    // End of variables declaration//GEN-END:variables
}
