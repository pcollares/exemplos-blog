package ihm;

import java.awt.Color;
import javax.swing.JPanel;
import operacao.Algoritimo;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class GraficoFuncao {

    private JFreeChart jFreeChart;
    private XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries xyFuncao;
    private ChartPanel img;
    private int height, width;

    public GraficoFuncao(int width, int height) {
        this.height = height-15;
        this.width = width;
        xyFuncao = new XYSeries("f(x)");
        draw();
    }

    public void updateFuncao(double vx, double vf) {
        xyFuncao.add(vx, vf);
        jFreeChart.fireChartChanged();
    }

    public void clear() {
        xyFuncao.clear();
    }

    public JPanel getImage() {
        return img;
    }

    private void draw() {
        jFreeChart = ChartFactory.createXYLineChart("Gráfico da Função", "x", Algoritimo.getFuncao().toString(), dataset, PlotOrientation.VERTICAL, true, true, false);

        XYItemRenderer renderer = jFreeChart.getXYPlot().getRenderer();
        renderer.setSeriesPaint(0, Color.BLUE);

        img = new ChartPanel(jFreeChart);
        img.setPreferredSize(new java.awt.Dimension(width, height));
        img.setMinimumSize(new java.awt.Dimension(width, height));
        img.setMaximumSize(new java.awt.Dimension(width, height));
        img.setMouseZoomable(true);
        img.updateUI();

        dataset.addSeries(xyFuncao);
    }
}