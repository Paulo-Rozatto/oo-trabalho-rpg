/*
 * Gabriel Pires Ferreira 201935023
 * Matheus do Nascimento Pereira da Costa 201676003
 * Luiz Henrique de Oliveira Pereira 201635009
 * Paulo Victor de Magalhaes Rozatto 201935027
*/
package br.com.ufjf.estudante.janelas;

import br.com.ufjf.estudante.main.GrupoInimigo;
import br.com.ufjf.estudante.main.Main;
import javax.swing.JLabel;

/**
 *
 * @author Luiz
 */
public class Janela_GameOver extends javax.swing.JFrame {

    private boolean vitoria;
    private String mensagemVitoria;
    private String mensagemDerrota;
    
    public Janela_GameOver(boolean vitoria) {
        this.vitoria = vitoria;
        this.mensagemVitoria = "\tParabéns!!! \nVocê venceu o jogo!";
        System.out.println("Aqui");
        System.out.println(mensagemVitoria);
        this.mensagemDerrota = "\tVocê foi Derrotado...";
        
        initComponents();
        atualizaLabel();
    }
    
    private void atualizaLabel(){
        if(vitoria){
            label_mensagem.setText(mensagemVitoria);
        }else{
            label_mensagem.setText(mensagemDerrota);
        }
    }

    public String getMensagemVitoria() {
        return mensagemVitoria;
    }

    public void setMensagemVitoria(String mensagemVitoria) {
        this.mensagemVitoria = mensagemVitoria;
    }

    public String getMensagemDerrota() {
        return mensagemDerrota;
    }

    public void setMensagemDerrota(String mensagemDerrota) {
        this.mensagemDerrota = mensagemDerrota;
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label_mensagem = new javax.swing.JLabel();
        button_reiniciar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Game Over");
        setResizable(false);

        label_mensagem.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        label_mensagem.setText("Parabens!!! Você venceu o jogo!");

        button_reiniciar.setText("Reiniciar");
        button_reiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_reiniciarActionPerformed(evt);
            }
        });

        jLabel1.setText("Clique para Iniciar um novo Jogo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(127, 127, 127)
                        .addComponent(button_reiniciar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(label_mensagem))))
                .addContainerGap(65, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(label_mensagem, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(button_reiniciar)
                .addGap(55, 55, 55))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button_reiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_reiniciarActionPerformed
        for (int i = GrupoInimigo.getSize()-1; i >=0 ; i--) {
            GrupoInimigo.removeInimigo(i);
        }
        this.setVisible(false);
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_button_reiniciarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_reiniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel label_mensagem;
    // End of variables declaration//GEN-END:variables
}
