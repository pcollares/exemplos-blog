package ihm;

import operacao.Algoritimo;
import dominio.Funcoes;
import dominio.Individuo;
import dominio.Populacao;
import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * Classe que representa a aplicação principal, a inteface e a execução do AG
 *
 * @author pcollares
 */
public class Frame extends javax.swing.JFrame {

    private GraficoConvergencia graficoConvergencia;
    private GraficoFuncao graficoFuncao;
    private int tamPop;

    public Frame() {
        super("AG - Funções");
        initComponents();

        jTabbedPane.setTitleAt(0, "Gráfico da Função");
        jTabbedPane.setTitleAt(1, "Grafico de Convergência");

        //Adiciona as funções no menu
        funcaoComboBox.addItem(new Funcoes(1, -100, 100, 1500));
        funcaoComboBox.addItem(new Funcoes(2, -10, 10, 2000));
        funcaoComboBox.addItem(new Funcoes(3, -100, 100, 5000));
        funcaoComboBox.addItem(new Funcoes(4, -100, 100, 5000));
        funcaoComboBox.addItem(new Funcoes(5, -30, 30, 20000));
        funcaoComboBox.addItem(new Funcoes(6, -100, 100, 1500));
        funcaoComboBox.addItem(new Funcoes(7, -1.28, 1.28, 3000));
        funcaoComboBox.addItem(new Funcoes(8, -500, 500, 9000));
        funcaoComboBox.addItem(new Funcoes(9, -5.12, 5.12, 5000));
        funcaoComboBox.addItem(new Funcoes(10, -32, 32, 1500));
        funcaoComboBox.addItem(new Funcoes(11, -600, 600, 2000));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSplitPane1 = new javax.swing.JSplitPane();
        jTabbedPane = new javax.swing.JTabbedPane();
        painelGraficoFuncao = new javax.swing.JPanel();
        painelGrafico = new javax.swing.JPanel();
        painelControles = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        funcaoComboBox = new javax.swing.JComboBox();
        iniciar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        valorCrossover = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        valorMutacao = new javax.swing.JTextField();
        valorPopulacao = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        valorGeracoes = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        logArea = new javax.swing.JTextArea();
        elitismoCheckBox = new javax.swing.JCheckBox();
        labelFuncao = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setExtendedState(6);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });

        jSplitPane1.setDividerLocation(380);

        painelGraficoFuncao.setLayout(null);
        jTabbedPane.addTab("tab2", painelGraficoFuncao);

        javax.swing.GroupLayout painelGraficoLayout = new javax.swing.GroupLayout(painelGrafico);
        painelGrafico.setLayout(painelGraficoLayout);
        painelGraficoLayout.setHorizontalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 879, Short.MAX_VALUE)
        );
        painelGraficoLayout.setVerticalGroup(
            painelGraficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 588, Short.MAX_VALUE)
        );

        jTabbedPane.addTab("tab1", painelGrafico);

        jSplitPane1.setRightComponent(jTabbedPane);

        jLabel1.setText("Função:");

        funcaoComboBox.setModel(new javax.swing.DefaultComboBoxModel());
        funcaoComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                funcaoComboBoxActionPerformed(evt);
            }
        });

        iniciar.setText("INICIAR");
        iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iniciarActionPerformed(evt);
            }
        });

        jLabel4.setText("Taxa de Crossover:");

        valorCrossover.setText("0.9");

        jLabel5.setText("Taxa de Mutação:");

        valorMutacao.setText("0.03");

        valorPopulacao.setText("500");

        jLabel6.setText("População:");

        jLabel7.setText("Gerações:");

        valorGeracoes.setText("1000");

        logArea.setEditable(false);
        logArea.setColumns(20);
        logArea.setRows(5);
        jScrollPane1.setViewportView(logArea);

        elitismoCheckBox.setSelected(true);
        elitismoCheckBox.setText("Elitismo");

        labelFuncao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/F1(x).jpg"))); // NOI18N

        javax.swing.GroupLayout painelControlesLayout = new javax.swing.GroupLayout(painelControles);
        painelControles.setLayout(painelControlesLayout);
        painelControlesLayout.setHorizontalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelFuncao, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(iniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(painelControlesLayout.createSequentialGroup()
                        .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelControlesLayout.createSequentialGroup()
                                .addComponent(valorMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7))
                            .addGroup(painelControlesLayout.createSequentialGroup()
                                .addComponent(valorCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(4, 4, 4)
                        .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorPopulacao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(valorGeracoes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelControlesLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(funcaoComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelControlesLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(elitismoCheckBox)))
                .addContainerGap())
        );
        painelControlesLayout.setVerticalGroup(
            painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelControlesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(funcaoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFuncao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(valorPopulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(valorCrossover, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelControlesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(valorGeracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(valorMutacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(elitismoCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iniciar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 375, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(painelControles);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSplitPane1)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void iniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iniciarActionPerformed
        logArea.setText(null);
        configuraValores();
        montaGraficoConvergencia();
        jTabbedPane.setSelectedIndex(1);
        new Thread(new RodaAlgoritimo()).start();
    }//GEN-LAST:event_iniciarActionPerformed

    private void funcaoComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_funcaoComboBoxActionPerformed
        if (funcaoComboBox.getSelectedItem() != null) {
            Algoritimo.setFuncao((Funcoes) funcaoComboBox.getSelectedItem());
            valorGeracoes.setText(String.valueOf(Algoritimo.getFuncao().getMaximoGeracoes()));
            jTabbedPane.setSelectedIndex(0);

            String imageName = "/imagens/F" + Algoritimo.getFuncao().getNumFuncao() + "(x).jpg";
            
            Icon icon = new ImageIcon(getClass().getResource(imageName));
            labelFuncao.setIcon(icon);

            if (graficoFuncao != null) {
                montaGraficoFuncao();
            }
        }
    }//GEN-LAST:event_funcaoComboBoxActionPerformed

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        montaGraficoFuncao();
        montaGraficoConvergencia();
    }//GEN-LAST:event_formComponentResized

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox elitismoCheckBox;
    private javax.swing.JComboBox funcaoComboBox;
    private javax.swing.JButton iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTabbedPane jTabbedPane;
    private javax.swing.JLabel labelFuncao;
    private javax.swing.JTextArea logArea;
    private javax.swing.JPanel painelControles;
    private javax.swing.JPanel painelGrafico;
    private javax.swing.JPanel painelGraficoFuncao;
    private javax.swing.JTextField valorCrossover;
    private javax.swing.JTextField valorGeracoes;
    private javax.swing.JTextField valorMutacao;
    private javax.swing.JTextField valorPopulacao;
    // End of variables declaration//GEN-END:variables

    public void montaGraficoConvergencia() {
        graficoConvergencia = new GraficoConvergencia(painelGrafico.getWidth(), painelGrafico.getHeight());
        JPanel img = graficoConvergencia.getImage();
        painelGrafico.removeAll();
        GroupLayout mainPanelLayout = new GroupLayout(painelGrafico);
        painelGrafico.setLayout(mainPanelLayout);
        GroupLayout.SequentialGroup hGroup = mainPanelLayout.createSequentialGroup();
        hGroup.addGap(5, 5, 5);
        hGroup.addComponent(img);
        mainPanelLayout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = mainPanelLayout.createSequentialGroup();
        vGroup.addGap(5, 5, 5);
        vGroup.addComponent(img);
        mainPanelLayout.setVerticalGroup(vGroup);
        img.setVisible(true);
    }

    public void montaGraficoFuncao() {
        graficoFuncao = new GraficoFuncao(painelGraficoFuncao.getWidth(), painelGraficoFuncao.getHeight());
        JPanel img = graficoFuncao.getImage();
        painelGraficoFuncao.removeAll();
        GroupLayout mainPanelLayout = new GroupLayout(painelGraficoFuncao);
        painelGraficoFuncao.setLayout(mainPanelLayout);
        GroupLayout.SequentialGroup hGroup = mainPanelLayout.createSequentialGroup();
        hGroup.addGap(5, 5, 5);
        hGroup.addComponent(img);
        mainPanelLayout.setHorizontalGroup(hGroup);
        GroupLayout.SequentialGroup vGroup = mainPanelLayout.createSequentialGroup();
        vGroup.addGap(5, 5, 5);
        vGroup.addComponent(img);
        mainPanelLayout.setVerticalGroup(vGroup);
        img.setVisible(true);

        for (double x = Algoritimo.getFuncao().getMin(); x < Algoritimo.getFuncao().getMax(); x = x + Algoritimo.getFuncao().getIncrementoGrafico()) {
            double[] x2 = {x};
            graficoFuncao.updateFuncao(x, Algoritimo.getFuncao().resolve(x2));
        }
    }

    private void configuraValores() {
        Algoritimo.setTaxaDeCrossover(Double.parseDouble(valorCrossover.getText()));
        Algoritimo.setTaxaDeMutacao(Double.parseDouble(valorMutacao.getText()));
        Algoritimo.getFuncao().setMaximoGeracoes(Integer.parseInt(valorGeracoes.getText()));

        tamPop = Integer.parseInt(valorPopulacao.getText());
    }

    private void setLog(String texto) {
        logArea.append(texto + "\n");
        logArea.setCaretPosition(logArea.getText().length() - 1);
    }

    class RodaAlgoritimo implements Runnable {

        @Override
        public void run() {
            iniciar.setEnabled(false);

            Populacao populacao = new Populacao(tamPop, true);
            populacao.ordenaPopulacao();
            Individuo melhorIndividuo = populacao.getIndivduo(0);

            int geracao = 0;
            while (geracao < Algoritimo.getFuncao().getMaximoGeracoes()) {
                geracao++;

                if (geracao % Algoritimo.getFuncao().getIncremento() == 0) {
                    graficoConvergencia.update(geracao, populacao, populacao.getIndivduo(populacao.getNumIndividuos() - 1), populacao.getIndivduo(0), Algoritimo.getFuncao().getMinimoDaFuncao());
                }

                populacao = Algoritimo.novaGeracao(populacao, geracao, elitismoCheckBox.isSelected());
                Algoritimo.setPopulacaoAtual(populacao);

                setLog("Geração " + geracao + "\nMelhor: " + populacao.getIndivduo(0).getAptidao() + "\nMédia: " + populacao.getMediaAptidao() + "\nPior: " + populacao.getIndivduo(populacao.getTamPopulacao() - 1).getAptidao() + "\n");

                if (populacao.getIndivduo(0).getAptidao() < melhorIndividuo.getAptidao()) {
                    melhorIndividuo = populacao.getIndivduo(0);
                }
            }

            setLog("--------------------\nFIM DO AG:\nMelhor indivíduo na geração: " + melhorIndividuo.getGeracao() + "\nx: " + melhorIndividuo.toString() + "\nf(x)=" + melhorIndividuo.getAptidao() + "\n");
            iniciar.setEnabled(true);
        }
    }
}