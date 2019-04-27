package ihm;

import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public final class Chart {

    private JFreeChart jFreeChart;
    private XYSeriesCollection dataset = new XYSeriesCollection();
    XYSeries xyBestAllTime = new XYSeries("Solução");
    XYSeries xyBestOfGen = new XYSeries("Melhor da Geração");
    XYSeries xyWorseOfGen = new XYSeries("Pior da Geração");
    XYSeries xyAVG = new XYSeries("Média");
    private ChartPanel img;
    private int height, width;

    public Chart(int width, int height) {
        this.height = height;
        this.width = width;
        draw();
    }

    public void update(int actualGeneration, double melhor, double media, double pior) {
        xyBestAllTime.add(actualGeneration, 0);
        xyBestOfGen.add(actualGeneration, melhor);
        xyWorseOfGen.add(actualGeneration, pior);
        xyAVG.add(actualGeneration, media);
        jFreeChart.fireChartChanged();
    }

    public void clear() {
        xyBestAllTime.clear();
        xyBestOfGen.clear();
        xyWorseOfGen.clear();
        xyAVG.clear();
    }

    public JPanel getImage() {
        return img;
    }

    private void draw() {
        jFreeChart = ChartFactory.createXYLineChart("n-Rainhas", "Gerações", "Colisões", dataset, PlotOrientation.VERTICAL, true, true, true);
        final XYPlot plot = (XYPlot) jFreeChart.getPlot();
        img = new ChartPanel(jFreeChart);
        img.setPreferredSize(new java.awt.Dimension(width - 20, height - 20));
        img.setMinimumSize(new java.awt.Dimension(width - 20, height - 20));
        img.setMaximumSize(new java.awt.Dimension(width - 20, height - 20));
        img.setMouseZoomable(true);
        img.updateUI();
        dataset.addSeries(xyWorseOfGen);
        dataset.addSeries(xyBestAllTime);
        dataset.addSeries(xyBestOfGen);
        dataset.addSeries(xyAVG);
    }
}