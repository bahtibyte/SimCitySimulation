package panels;

import org.knowm.xchart.*;
import org.knowm.xchart.style.Styler.LegendPosition;

import utils.Settings;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GraphPanel extends JPanel {

    private static final String TITLE = "Real Time Preference Rating";

    private XYChart chart;
    private XChartPanel panel;

    private List<Double> currentDay;
    private List<Double> comp_X_yPoints;

    private List<Double> comp_Y_yPoints;

    private List<Double> middle;

    private int width;
    private int height;

    public GraphPanel() {
        super();
        currentDay = new ArrayList<>();
        comp_X_yPoints = new ArrayList<>();

        comp_Y_yPoints = new ArrayList<>();
        middle = new ArrayList<>();
    }

    public void insert(double x, double y) {
        currentDay.add(x);
        comp_X_yPoints.add(y);
        comp_Y_yPoints.add(1.0-y);

        middle.add(0.5);
        chart.updateXYSeries("Company Blue", currentDay, comp_X_yPoints, null);
        chart.updateXYSeries("Company Red", currentDay, comp_Y_yPoints, null);
        panel.repaint();
    }

    public void createDefaultChart(int w, int h){
        this.width = w;
        this.height = h;
        chart = defaultChart(width, height);
        panel = new XChartPanel(chart);
        add(panel);
    }

    public void reset() {
        currentDay = new ArrayList<>();
        comp_X_yPoints = new ArrayList<>();
        comp_Y_yPoints = new ArrayList<>();
        middle = new ArrayList<>();
        chart.getStyler().setXAxisMax(Settings.NUM_OF_DAYS*1.0);
        chart.updateXYSeries("Company Blue", currentDay, comp_X_yPoints, null);
        chart.updateXYSeries("Company Red", currentDay, comp_Y_yPoints, null);
        panel.repaint();
    }

    private XYChart defaultChart(int w, int h) {

        XYChart chart = new XYChartBuilder().xAxisTitle("Current Day")
        									.yAxisTitle("Company Rating")
        									.width(w)
        									.height(h)
        									.title(TITLE)
        									.build();
        
        chart.getStyler().setLegendPosition(LegendPosition.InsideNW);
        chart.getStyler().setLegendVisible(true);
        chart.getStyler().setAxisTitlesVisible(true);
        chart.getStyler().setYAxisMin(0.0);
        chart.getStyler().setYAxisMax(1.0);
        chart.getStyler().setXAxisMin(0.0);
        chart.getStyler().setXAxisMax(Settings.NUM_OF_DAYS*1.0);
        chart.getStyler().setMarkerSize(4);
        chart.getStyler().setSeriesColors(new Color[]{Color.BLUE, Color.RED});
        chart.getStyler().setChartBackgroundColor(new Color(244, 242, 232));
        chart.addSeries("Company Blue", new double[] {0}, new double[] {0.5});
        chart.addSeries("Company Red", new double[] {0}, new double[] {0.5});

        return chart;
    }


    public void refresh() {
        double event = (Settings.EVENT_COUNTER * 1.0) / (Settings.TICKS_PER_HOUR * 12);
        double pref = Settings.PREFERENCE;
        this.insert(event, pref);
    }
}
