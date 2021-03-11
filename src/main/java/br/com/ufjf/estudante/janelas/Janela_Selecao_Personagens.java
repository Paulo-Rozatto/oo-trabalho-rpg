package br.com.ufjf.estudante.janelas;

import br.com.ufjf.estudante.main.ArquivoHandler;
import br.com.ufjf.estudante.main.AtackFisico;
import br.com.ufjf.estudante.main.AtackMagico;
import br.com.ufjf.estudante.main.ItemArma;
import br.com.ufjf.estudante.main.ItemArmadura;
import br.com.ufjf.estudante.main.Jogador;
import br.com.ufjf.estudante.main.NpcInimigo;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author paulo
 */
public class Janela_Selecao_Personagens extends javax.swing.JFrame {

    List<Jogador> grupoJogador = new ArrayList<>();
    List<NpcInimigo> grupoInimigo = new ArrayList<>();
    private final DefaultListModel elementosLista = new DefaultListModel();

    private int pontos;
    private int forca;
    private int inteligencia;
    private int destreza;

    /**
     * Creates new form Janela_Selecao_Personagem
     */
    public Janela_Selecao_Personagens() {
        initComponents();

        jlistPersonagens.setModel(elementosLista);

        this.pontos = 2;
        this.forca = 1;
        this.inteligencia = 1;
        this.destreza = 1;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpInfo = new javax.swing.JPanel();
        lbNome = new javax.swing.JLabel();
        lbNome1 = new javax.swing.JLabel();
        cbClasse = new javax.swing.JComboBox<>();
        tfNome = new javax.swing.JTextField();
        labelPontosDisponiveis = new javax.swing.JLabel();
        tfForca = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tfPontos = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        tfInteligencia = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        tfDestreza = new javax.swing.JTextField();
        btnMaisForca = new javax.swing.JButton();
        btnMenosForca = new javax.swing.JButton();
        btnMaisInteligencia = new javax.swing.JButton();
        btnMenosInteligencia = new javax.swing.JButton();
        btnMaisDestreza = new javax.swing.JButton();
        btnMenosDestreza = new javax.swing.JButton();
        btnNovo = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnExistente = new javax.swing.JButton();
        jpList = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlistPersonagens = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jpButtons = new javax.swing.JPanel();
        btnIniciar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(600, 480));

        lbNome.setLabelFor(tfNome);
        lbNome.setText("Nome:");

        lbNome1.setLabelFor(cbClasse);
        lbNome1.setText("Classe:");

        cbClasse.setMaximumRowCount(3);
        cbClasse.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Guerreiro", "Mago", "Ladino" }));
        cbClasse.setEnabled(false);

        tfNome.setEnabled(false);

        labelPontosDisponiveis.setLabelFor(tfPontos);
        labelPontosDisponiveis.setText("Pontos disponiveis:");

        tfForca.setEditable(false);
        tfForca.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfForca.setText("1");
        tfForca.setEnabled(false);

        jLabel2.setLabelFor(tfForca);
        jLabel2.setText("Força");

        tfPontos.setEditable(false);
        tfPontos.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfPontos.setText("2");
        tfPontos.setEnabled(false);

        jLabel3.setLabelFor(tfInteligencia);
        jLabel3.setText("Inteligencia");

        tfInteligencia.setEditable(false);
        tfInteligencia.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfInteligencia.setText("1");
        tfInteligencia.setEnabled(false);

        jLabel4.setLabelFor(tfDestreza);
        jLabel4.setText("Destreza");

        tfDestreza.setEditable(false);
        tfDestreza.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        tfDestreza.setText("1");
        tfDestreza.setEnabled(false);

        btnMaisForca.setText("+");
        btnMaisForca.setEnabled(false);
        btnMaisForca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisForcaActionPerformed(evt);
            }
        });

        btnMenosForca.setText("-");
        btnMenosForca.setEnabled(false);
        btnMenosForca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosForcaActionPerformed(evt);
            }
        });

        btnMaisInteligencia.setText("+");
        btnMaisInteligencia.setEnabled(false);
        btnMaisInteligencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisInteligenciaActionPerformed(evt);
            }
        });

        btnMenosInteligencia.setText("-");
        btnMenosInteligencia.setEnabled(false);
        btnMenosInteligencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosInteligenciaActionPerformed(evt);
            }
        });

        btnMaisDestreza.setText("+");
        btnMaisDestreza.setEnabled(false);
        btnMaisDestreza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaisDestrezaActionPerformed(evt);
            }
        });

        btnMenosDestreza.setText("-");
        btnMenosDestreza.setEnabled(false);
        btnMenosDestreza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenosDestrezaActionPerformed(evt);
            }
        });

        btnNovo.setText("Novo Jogador");
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnSalvar.setText("Salvar");
        btnSalvar.setEnabled(false);
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnExistente.setText("Adcionar Personagem existente...");
        btnExistente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExistenteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpInfoLayout = new javax.swing.GroupLayout(jpInfo);
        jpInfo.setLayout(jpInfoLayout);
        jpInfoLayout.setHorizontalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpInfoLayout.createSequentialGroup()
                        .addComponent(lbNome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNome))
                    .addGroup(jpInfoLayout.createSequentialGroup()
                        .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jpInfoLayout.createSequentialGroup()
                                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelPontosDisponiveis, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(tfPontos, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(tfForca, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(tfInteligencia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(tfDestreza, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jpInfoLayout.createSequentialGroup()
                                        .addComponent(btnMaisDestreza, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMenosDestreza, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpInfoLayout.createSequentialGroup()
                                        .addComponent(btnMaisInteligencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMenosInteligencia, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jpInfoLayout.createSequentialGroup()
                                        .addComponent(btnMaisForca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMenosForca, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jpInfoLayout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jpInfoLayout.createSequentialGroup()
                                        .addComponent(btnNovo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btnExistente))))
                        .addGap(0, 47, Short.MAX_VALUE))
                    .addGroup(jpInfoLayout.createSequentialGroup()
                        .addComponent(lbNome1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbClasse, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jpInfoLayout.setVerticalGroup(
            jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpInfoLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbClasse, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNome1))
                .addGap(40, 40, 40)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPontosDisponiveis)
                    .addComponent(tfPontos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(tfForca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMaisForca)
                    .addComponent(btnMenosForca))
                .addGap(4, 4, 4)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfInteligencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(btnMaisInteligencia)
                    .addComponent(btnMenosInteligencia))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfDestreza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnMenosDestreza)
                    .addComponent(btnMaisDestreza))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jpInfoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovo)
                    .addComponent(btnSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnExistente)
                .addContainerGap())
        );

        jlistPersonagens.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jlistPersonagens.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlistPersonagensMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jlistPersonagens);

        jLabel1.setFont(new java.awt.Font("Ubuntu", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Personagens adcionados");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("(Máximo de 4 personagens)");

        javax.swing.GroupLayout jpListLayout = new javax.swing.GroupLayout(jpList);
        jpList.setLayout(jpListLayout);
        jpListLayout.setHorizontalGroup(
            jpListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
            .addGroup(jpListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jpListLayout.setVerticalGroup(
            jpListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpListLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnIniciar.setText("Iniciar Jogo...");
        btnIniciar.setEnabled(false);
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpButtonsLayout = new javax.swing.GroupLayout(jpButtons);
        jpButtons.setLayout(jpButtonsLayout);
        jpButtonsLayout.setHorizontalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpButtonsLayout.createSequentialGroup()
                .addGap(208, 208, 208)
                .addComponent(btnIniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jpButtonsLayout.setVerticalGroup(
            jpButtonsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpButtonsLayout.createSequentialGroup()
                .addContainerGap(40, Short.MAX_VALUE)
                .addComponent(btnIniciar)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jpInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jpButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jpList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpButtons, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnMaisForcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisForcaActionPerformed
        adcionarPontos(0);
    }//GEN-LAST:event_btnMaisForcaActionPerformed

    private void btnMenosForcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosForcaActionPerformed
        removerPontos(0);
    }//GEN-LAST:event_btnMenosForcaActionPerformed

    private void btnMaisInteligenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisInteligenciaActionPerformed
        adcionarPontos(1);
    }//GEN-LAST:event_btnMaisInteligenciaActionPerformed

    private void btnMenosInteligenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosInteligenciaActionPerformed
        removerPontos(1);
    }//GEN-LAST:event_btnMenosInteligenciaActionPerformed

    private void btnMaisDestrezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaisDestrezaActionPerformed
        adcionarPontos(2);
    }//GEN-LAST:event_btnMaisDestrezaActionPerformed

    private void btnMenosDestrezaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenosDestrezaActionPerformed
        removerPontos(2);
    }//GEN-LAST:event_btnMenosDestrezaActionPerformed

    private void btnExistenteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExistenteActionPerformed
        String[] possibilities = ArquivoHandler.listarJogadores();

        if (possibilities.length == 0) {
            JOptionPane.showMessageDialog(this, "Nao foram encontrados personagens salvos.");
        } else {
            String nomePersonagem = (String) JOptionPane.showInputDialog(
                    this,
                    "Escolha o personagem:",
                    "Selecionar Personagem",
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    possibilities,
                    "");

            if (nomePersonagem != null && nomePersonagem.length() > 0) {
                if (this.grupoJogador.stream().anyMatch(j -> j.getNomePersonagem().equals(nomePersonagem))) {
                    JOptionPane.showMessageDialog(this, "Personagem já adcionado!");
                } else {
                    Jogador j = ArquivoHandler.lerJogador(nomePersonagem);
                    this.grupoJogador.add(j);
                    elementosLista.addElement(nomePersonagem);

                    btnIniciar.setEnabled(true);

                    if (this.grupoJogador.size() == 4) {
                        btnNovo.setEnabled(false);
                        btnExistente.setEnabled(false);
                    }
                }
            }
        }
    }//GEN-LAST:event_btnExistenteActionPerformed

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        trocarEnabled(true);
        resetarCampos();
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (this.grupoJogador.stream().anyMatch(j -> j.getNomePersonagem().equals(tfNome.getText().trim()))) {
            JOptionPane.showMessageDialog(this, "Personagem com esse nome já adcionado!");
        } else {
            trocarEnabled(false);
            btnIniciar.setEnabled(true);

            String nome = tfNome.getText();
            if (nome.trim().length() == 0) {
                nome = "Personagem " + (this.grupoJogador.size() + 1);
            }
            int classe = cbClasse.getSelectedIndex() + 1;

            Jogador jogador;
            AtackFisico ataqueFisico;
            AtackMagico ataqueMagico;
            ItemArma arma = null;
            ItemArmadura armadura = null;

            if (classe == 1) {
                ataqueFisico = new AtackFisico("soco", 10, 10, 1);
                ataqueMagico = new AtackMagico("magia", 5, 5, 5, 0);
                arma = new ItemArma(ataqueFisico, 0, "Mãos", 1);
                armadura = new ItemArmadura("Leve", 4, "tecido");
            } else if (classe == 2) {
                ataqueFisico = new AtackFisico("soco", 10, 10, 1);
                ataqueMagico = new AtackMagico("magia", 5, 5, 5, 0);
                arma = new ItemArma(ataqueFisico, 0, "Mãos", 1);
                armadura = new ItemArmadura("Leve", 4, "tecido");
            } else if (classe == 3) {
                ataqueFisico = new AtackFisico("soco", 10, 10, 1);
                ataqueMagico = new AtackMagico("magia", 5, 5, 5, 0);
                arma = new ItemArma(ataqueFisico, 0, "Mãos", 1);
                armadura = new ItemArmadura("Leve", 4, "tecido");
            }

            jogador = new Jogador(nome.trim(), forca, inteligencia, destreza, classe, arma, armadura);
            grupoJogador.add(jogador);
            elementosLista.addElement(jogador.getNomePersonagem());
            ArquivoHandler.criarJogador(jogador);

            trocarEnabled(false);
            btnSalvar.setEnabled(false);
            resetarCampos();
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void jlistPersonagensMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlistPersonagensMouseClicked
        if (jlistPersonagens.isEnabled() && elementosLista.size() > 0) {
            int i = jlistPersonagens.getSelectedIndex();
            Jogador j = this.grupoJogador.get(i);
            int somaPontos = 0;

            tfNome.setText(j.getNomePersonagem());
            cbClasse.setSelectedIndex(j.getClasse() - 1);
            tfForca.setText(String.valueOf(j.getModForça()));
            somaPontos += j.getModForça();
            tfInteligencia.setText(String.valueOf(j.getModInteligencia()));
            somaPontos += j.getModInteligencia();
            tfDestreza.setText(String.valueOf(j.getModDestreza()));
            somaPontos += j.getModDestreza();

            somaPontos = somaPontos >= 5 ? 0 : 5 - somaPontos; // calcula quantidade de pontos disponiveis
            tfPontos.setText(String.valueOf(somaPontos));
        }
    }//GEN-LAST:event_jlistPersonagensMouseClicked

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        this.setVisible(false);
        new Janela_Batalha(grupoJogador, grupoInimigo).setVisible(true);
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void resetarCampos() {
        tfNome.setText("");
        cbClasse.setSelectedIndex(0);

        pontos = 2;
        forca = 1;
        inteligencia = 1;
        destreza = 1;

        tfPontos.setText("2");
        tfForca.setText("1");
        tfInteligencia.setText("1");
        tfDestreza.setText("1");
    }

    private void adcionarPontos(int idCaracteristica) {
        if (this.pontos > 0) {
            this.pontos--;

            switch (idCaracteristica) {
                case 0:
                    this.forca++;
                    tfForca.setText(String.valueOf(this.forca));
                    break;
                case 1:
                    this.inteligencia++;
                    tfInteligencia.setText(String.valueOf(this.inteligencia));
                    break;
                case 2:
                    this.destreza++;
                    tfDestreza.setText(String.valueOf(this.destreza));
                    break;
            }

            tfPontos.setText(String.valueOf(this.pontos));
            if(this.pontos == 0) {
                btnSalvar.setEnabled(true);
            }
        }
    }

    private void removerPontos(int idCaracteristica) {
        switch (idCaracteristica) {
            case 0:
                if (this.forca > 1) {
                    this.forca--;
                    this.pontos++;
                    tfForca.setText(String.valueOf(this.forca));
                }
                break;
            case 1:
                if (this.inteligencia > 1) {
                    this.inteligencia--;
                    this.pontos++;
                    tfInteligencia.setText(String.valueOf(this.inteligencia));
                }
                break;
            case 2:
                if (this.destreza > 1) {
                    this.destreza--;
                    this.pontos++;
                    tfDestreza.setText(String.valueOf(this.destreza));
                }
                break;
        }

        tfPontos.setText(String.valueOf(this.pontos));
        if(this.pontos > 0) {
            btnSalvar.setEnabled(false);
        }
    }

    private void trocarEnabled(boolean enabled) {
        tfNome.setEnabled(enabled);
        cbClasse.setEnabled(enabled);
        btnMaisForca.setEnabled(enabled);
        btnMaisInteligencia.setEnabled(enabled);
        btnMaisDestreza.setEnabled(enabled);
        btnMenosForca.setEnabled(enabled);
        btnMenosInteligencia.setEnabled(enabled);
        btnMenosDestreza.setEnabled(enabled);
        
        tfPontos.setEnabled(enabled);
        tfForca.setEnabled(enabled);
        tfInteligencia.setEnabled(enabled);
        tfDestreza.setEnabled(enabled);

        jlistPersonagens.setEnabled(!enabled);
        boolean isMaximoJogadores = this.grupoJogador.size() == 4;
        btnNovo.setEnabled(!enabled && !isMaximoJogadores);
        btnExistente.setEnabled(!enabled && !isMaximoJogadores);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExistente;
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnMaisDestreza;
    private javax.swing.JButton btnMaisForca;
    private javax.swing.JButton btnMaisInteligencia;
    private javax.swing.JButton btnMenosDestreza;
    private javax.swing.JButton btnMenosForca;
    private javax.swing.JButton btnMenosInteligencia;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox<String> cbClasse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlistPersonagens;
    private javax.swing.JPanel jpButtons;
    private javax.swing.JPanel jpInfo;
    private javax.swing.JPanel jpList;
    private javax.swing.JLabel labelPontosDisponiveis;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbNome1;
    private javax.swing.JTextField tfDestreza;
    private javax.swing.JTextField tfForca;
    private javax.swing.JTextField tfInteligencia;
    private javax.swing.JTextField tfNome;
    private javax.swing.JTextField tfPontos;
    // End of variables declaration//GEN-END:variables
}
