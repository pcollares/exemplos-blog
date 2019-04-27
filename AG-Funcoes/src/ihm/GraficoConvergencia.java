package ihm;

import dominio.Individuo;
import dominio.Populacao;
import javax.swing.JPanel;
import operacao.Algoritimo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 * Classe que define um gráfico de linha
 * @author pcollares
 */
public final class GraficoConvergencia {

    private JFreeChart jFreeChart;
    private XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries xySolucao;
    XYSeries xyMelhorDaGeracao;
    XYSeries xyPiorDaGeracao;
    XYSeries xyMediaDaGeracao;
    private ChartPanel img;
    private int height, width;

    public GraficoConvergencia(int width, int height) {
        xySolucao = new XYSeries("Melhor Solução");
        xyMelhorDaGeracao = new XYSeries("Melhor da Geração");
        xyPiorDaGeracao = new XYSeries("Pior da Geração");
        xyMediaDaGeracao = new XYSeries("Média da Geração");
        this.height = height-15;
        this.width = width;
        draw();
    }

    public void update(int actualGeneration, Populacao populacao, Individuo piorIndividuo, Individuo melhorIndividuo, double minimoDaFuncao) {
        xySolucao.add(actualGeneration, minimoDaFuncao);
        xyMelhorDaGeracao.add(actualGeneration, melhorIndividuo.getAptidao());
        xyPiorDaGeracao.add(actualGeneration, piorIndividuo.getAptidao());
        xyMediaDaGeracao.add(actualGeneration, populacao.getMediaAptidao());
        jFreeChart.fireChartChanged();
    }

    public void clear() {
        xySolucao.clear();
        xyMelhorDaGeracao.clear();
        xyPiorDaGeracao.clear();
        xyMediaDaGeracao.clear();
    }

    public JPanel getImage() {
        return img;
    }

    private void draw() {
        jFreeChart = ChartFactory.createXYLineChart("Gráfico de Convergência", "Gerações", Algoritimo.getFuncao().toString(), dataset, PlotOrientation.VERTICAL, true, true, false);
        img = new ChartPanel(jFreeChart);
        img.setPreferredSize(new java.awt.Dimension(width, height));
        img.setMinimumSize(new java.awt.Dimension(width, height));
        img.setMaximumSize(new java.awt.Dimension(width, height));
        img.setMouseZoomable(true);
        img.updateUI();
        dataset.addSeries(xyPiorDaGeracao);
        dataset.addSeries(xyMediaDaGeracao);
        dataset.addSeries(xyMelhorDaGeracao);
        dataset.addSeries(xySolucao);
    }
}