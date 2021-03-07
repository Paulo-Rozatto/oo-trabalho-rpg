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
import java.util.List;
import java.util.ArrayList;


/**
 *
 * @author Luiz
 */
public class Janela_Batalha extends javax.swing.JFrame {

    
    private boolean isTurnoJogador;
    private int round;
    
//    private int tamanhoJanelaX;
//    private int tamanhoJanelaY;
    
    private int maxJogador; 
    private int maxInimigo; 
    private List<JLabel> spriteJogador;
    private List<JLabel> spriteInimigo;

    

    
    
    public Janela_Batalha(List<Jogador> jogador, List<NpcInimigo> inimigos) {
        //Declare variaveis aqui e chame metodos em formWindowOpened()
        GrupoJogador.iniciaGrupo(jogador);
        GrupoInimigo.iniciaGrupo(0);
        
//        this.tamanhoJanelaX = this.getWidth();
//        this.tamanhoJanelaY = this.getHeight();
        this.maxJogador = 6;
        this.maxInimigo = 6;
        
        isTurnoJogador = true;
        round = 0;
        
        initComponents();//Inicia a janela
    }
    
    private void atualizaMaximoPersonagens(){
        //Atualizando o numero maximo de jogadores
        if(GrupoJogador.getSize()<maxJogador){
            spriteJogador = new ArrayList<>(GrupoJogador.getSize());
            maxJogador = GrupoJogador.getSize();
        }
        else{
            spriteJogador = new ArrayList<>(maxJogador);
        }
        if(GrupoInimigo.getSize()<maxInimigo){
            spriteInimigo = new ArrayList<>(GrupoInimigo.getSize());
            maxInimigo = GrupoInimigo.getSize();
        }
        else{
            spriteInimigo = new ArrayList<>(maxInimigo);
        }
    }
    
    private void iniciaComboBox(){//Caixa de selecao de personagem
        
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
    
    private boolean confereSe_InimigoMorreu(int indice){
        if(indice<maxInimigo){
            if (GrupoInimigo.getInimigo(indice).getHitPoints() <= 0) {
                spriteInimigo.get(indice).setVisible(false);//deixa o sprite invisivel
                this.remove(spriteInimigo.get(indice));//remove o sprite do painel
                spriteInimigo.remove(indice);
                if(GrupoInimigo.getSize() != 1)
                    cbox_inimigo.removeItem(GrupoInimigo.getInimigo(indice).getNomePersonagem());
                else{
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
    
    private boolean confereSe_JogadorMorreu(int indice){
        if(indice<maxJogador){
            if (GrupoJogador.getJogador(indice).getHitPoints() <= 0) {
                spriteJogador.get(indice).setVisible(false);//deixa o sprite invisivel
                this.remove(spriteJogador.get(indice));//remove o sprite do painel
                spriteJogador.remove(indice);
                if(GrupoJogador.getSize() != 1)
                    cbox_personagem.removeItem(GrupoJogador.getJogador(indice).getNomePersonagem());
                else{
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
    
    private boolean confereSe_ExistemJogadores(){
        for (int i = 0; i < GrupoJogador.getSize(); i++) {
            if(GrupoJogador.getJogador(i).getHitPoints()>0)
                return true;
        }
        return false;
    }
    
    private boolean confereSe_ExistemInimigos(){
        for (int i = 0; i < GrupoInimigo.getSize(); i++) {
            if(GrupoInimigo.getInimigo(i).getHitPoints()>0)
                return true;
        }
        return false;
    }
    
    private void alocaSprites(){//Caixa de selecao de personagem
        
        atualizaMaximoPersonagens();
        
        //"Desenhando" imagem na tela
        int distanciax = 1;
        int distanciay = 1;
        
        for (int i = 0; i < GrupoJogador.getSize() && i<maxJogador; i++) {
            spriteJogador.add(new JLabel(GrupoJogador.getJogador(i).getSprite()));
            spriteJogador.get(i).setSize(64, 64);//tamanho do sprite
            spriteJogador.get(i).setLocation(distanciax + 64 , 64*distanciay);//posicao
            this.add(spriteJogador.get(i));//adiciona no painel
            spriteJogador.get(i).setVisible(true);//torna o sprite visivel
            if(i%4==0){
                distanciax ++; 
                distanciay=0;
            }
        }
        distanciax =1;
        distanciay=1;
        for (int i = 0; i < GrupoInimigo.getSize() && i<maxInimigo; i++) {
            spriteInimigo.add(new JLabel(GrupoInimigo.getInimigo(i).getSprite()));
            spriteInimigo.get(i).setSize(64, 64);//tamanho do sprite
            spriteInimigo.get(i).setLocation((distanciax*64)+450 , 64);//posicao
            this.add(spriteInimigo.get(i));//adiciona no painel
            spriteInimigo.get(i).setVisible(true);//torna o sprite visivel
            if(i%4==0){
                distanciax ++; 
                distanciay=0;
            }
        }
    }
    
    private void atualizaLabeldeHP(int i, int j){
        if(GrupoJogador.getSize() > i && GrupoJogador.getJogador(i).getHitPoints() > 0)
            hitPointsJogador.setText("" + GrupoJogador.getJogador(i).getHitPoints());
        else
            hitPointsJogador.setText("0");
        if(GrupoInimigo.getSize() > j && GrupoInimigo.getInimigo(j).getHitPoints() > 0)
            hitPointsInimigo.setText("" + GrupoInimigo.getInimigo(j).getHitPoints());
        else
            hitPointsInimigo.setText("0");
    }
    
     private void atualizaLabeldeMP(int i, int j){
        if(GrupoJogador.getSize() > i && GrupoJogador.getJogador(i).getManaPoints() > 0)
            mpPointsJogador.setText("" + GrupoJogador.getJogador(i).getManaPoints());
        else
            mpPointsJogador.setText("0");
        if(GrupoInimigo.getSize() > j && GrupoInimigo.getInimigo(j).getManaPoints() > 0)
            mpPointsInimigo.setText("" + GrupoInimigo.getInimigo(j).getManaPoints());
        else
            mpPointsInimigo.setText("0");
    }
    
    void vitoria(){
        System.out.println("Vitória");
    }
    
    private void turnoInimigo(){
        System.out.println("Inimigo: ");
        GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).sofreAtack(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).decideAcao(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getDefesa()));
        gerenciaTurno();
    }
    
    private void turnoJogador(int tipoAtaque){
        System.out.println("Jogador: ");
        switch(tipoAtaque){    
            case 1:
                GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).sofreAtack(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).ataqueFisico(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getDefesa()));
                break;
            case 2:
                //GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).sofreAtack(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).ataqueMagico(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getDefesa()));
                break;
        }
        gerenciaTurno();
    }
    
    void gameOver(){
        System.out.println("Game Over");
    }
    
    private void gerenciaTurno(){
        atualizaLabeldeHP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
        atualizaLabeldeMP(cbox_personagem.getSelectedIndex(), cbox_inimigo.getSelectedIndex());
        if(isTurnoJogador){
            for(int i = 0; i < GrupoInimigo.getSize()&& i < maxInimigo; i++){//removendo inimigos mortos
                    if(confereSe_InimigoMorreu(i))
                        --i;
            }
            if(GrupoInimigo.getSize() == 0){//se não há mais inimigos vivos
                // A fazer: codigo que mostra na interface descricao de morte
                if (round == 2){ // Se for o ultimo round, ganhou jogo
                    vitoria();
                } 
                else{ // se nao for ultimo round, configure proximo round
                    round++;
                    System.out.println("Round: " + round);
                }
                //GrupoInimigo.iniciaGrupo(0);
                    //atualizaLabeldeHP(0, 0);
                    //atualizaLabeldeMP(0, 0);
                    //iniciaComboBox();
                    //alocaSprites();
            } 
            else{ // se há inimigos vivos, passe o turno para o próximo inimigo
                if(cbox_inimigo.getSelectedIndex() >= GrupoInimigo.getSize())//se o inimigo selecionado está morto, encontre o próximo inimigo vivo
                    cbox_inimigo.setSelectedIndex(0);
                isTurnoJogador = false;
                turnoInimigo();
            }
        } 
        else{
            for(int i = 0; i < GrupoJogador.getSize() && i < maxJogador; i++)//removendo jogadores mortos
                    if(confereSe_JogadorMorreu(i))
                        --i;
            if(confereSe_ExistemJogadores() == false){ // Se todos os personagesn do jogador morreram, fim de jogo
                gameOver();
            }
            else{// Se nao morreram, passe o turno para o primeiro jogador vivo
                if(cbox_personagem.getSelectedIndex() >= GrupoJogador.getSize())
                    cbox_personagem.setSelectedIndex(0);
                isTurnoJogador = true;
            }
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        cbox_personagem = new javax.swing.JComboBox<>();
        button_ataque = new javax.swing.JButton();
        button_magia = new javax.swing.JButton();
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

        jList1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(jList1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(button_magia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_ataque, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 190, Short.MAX_VALUE)
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
                .addGap(47, 47, 47))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_HP_Jogador)
                            .addComponent(hitPointsJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(label_MP_Jogador)
                            .addComponent(mpPointsJogador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(370, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(cbox_personagem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)
                            .addComponent(cbox_inimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(button_ataque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_magia))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_HP_Inimigo)
                                    .addComponent(hitPointsInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(label_MP_Inimigo)
                                    .addComponent(mpPointsInimigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //QUANDO A JANELA ABRIR
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

        this.setResizable(false);// true: Habilita/false: Desabilita maximizar
        this.setTitle("Trabalho o-o");//titulo
        

        
        atualizaLabeldeHP(0, 0);
        atualizaLabeldeMP(0, 0);
        iniciaComboBox();
        alocaSprites();

        
    }//GEN-LAST:event_formWindowOpened

    private void cbox_personagemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_personagemActionPerformed
        // TODO add your handling code here:
        if(GrupoJogador.getSize() > cbox_personagem.getSelectedIndex()){
            if(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getHitPoints() > 0)
                hitPointsJogador.setText("" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getHitPoints());
            else
                hitPointsJogador.setText("0");
            if(GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaPoints() > 0)
                mpPointsJogador.setText("" + GrupoJogador.getJogador(cbox_personagem.getSelectedIndex()).getManaPoints());
            else
                mpPointsJogador.setText("0");
        }
    }//GEN-LAST:event_cbox_personagemActionPerformed

    private void button_ataqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ataqueActionPerformed
        // TODO add your handling code here:
        if(isTurnoJogador && GrupoInimigo.getSize() > 0)
            turnoJogador(1);
    }//GEN-LAST:event_button_ataqueActionPerformed

    private void hitPointsJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitPointsJogadorActionPerformed
        // TODO add your handling code here:
 
    }//GEN-LAST:event_hitPointsJogadorActionPerformed

    private void button_magiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_magiaActionPerformed
        // TODO add your handling code here:
        if(isTurnoJogador  && GrupoInimigo.getSize() > 0)
            turnoJogador(2);
    }//GEN-LAST:event_button_magiaActionPerformed

    private void mpPointsJogadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpPointsJogadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpPointsJogadorActionPerformed

    private void hitPointsInimigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hitPointsInimigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hitPointsInimigoActionPerformed

    private void mpPointsInimigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mpPointsInimigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mpPointsInimigoActionPerformed

    private void cbox_inimigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbox_inimigoActionPerformed
        // TODO add your handling code here:
        if(GrupoInimigo.getSize() > cbox_inimigo.getSelectedIndex()){
            if(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getHitPoints() > 0)
                hitPointsInimigo.setText("" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getHitPoints());
            else
                hitPointsInimigo.setText("0");
            if(GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaPoints() > 0)
                mpPointsInimigo.setText("" + GrupoInimigo.getInimigo(cbox_inimigo.getSelectedIndex()).getManaPoints());
            else
                mpPointsInimigo.setText("0");
        }
    }//GEN-LAST:event_cbox_inimigoActionPerformed

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
    private javax.swing.JTextField hitPointsInimigo;
    private javax.swing.JTextField hitPointsJogador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList<String> jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_HP_Inimigo;
    private javax.swing.JLabel label_HP_Jogador;
    private javax.swing.JLabel label_MP_Inimigo;
    private javax.swing.JLabel label_MP_Jogador;
    private javax.swing.JTextField mpPointsInimigo;
    private javax.swing.JTextField mpPointsJogador;
    // End of variables declaration//GEN-END:variables
}
