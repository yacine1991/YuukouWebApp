package com.yuukou.stats;

import com.yuukou.data.RoomList;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author Yacine
 */
public class ChartStatistics {

    public CategoryDataset createDataset(RoomList rl) {

        ArrayList listCampus = rl.getCampus();
        ArrayList listCampusShort = rl.getCampusShort();

        DefaultCategoryDataset result = new DefaultCategoryDataset();

        for (int j = 0; j < listCampus.size(); j++) {

            result.addValue(rl.getNumberComputerAvailablePerCampus(listCampus.get(j).toString()), "PC (Available)", listCampusShort.get(j).toString());
            result.addValue(rl.getNumberComputerDownPerCampus(listCampus.get(j).toString()), "PC (Down)", listCampusShort.get(j).toString());
            result.addValue(rl.getNumberComputerBusyPerCampus(listCampus.get(j).toString()), "PC (Busy)", listCampusShort.get(j).toString());

        }
        return result;
    }

    public JFreeChart createChart(final CategoryDataset dataset) {

        final JFreeChart chart =
                ChartFactory.createStackedBarChart(
                "Computer per Campus", "Category", "Value", dataset,
                PlotOrientation.VERTICAL, true, true, false);

        chart.setBackgroundPaint(new Color(249, 231, 236));

        GroupedStackedBarRenderer renderer =
                new GroupedStackedBarRenderer();



        renderer.setItemMargin(0.0);
        Paint p1 = new GradientPaint(
                0.0f, 0.0f, new Color(16, 89, 172), 0.0f, 0.0f, new Color(201, 201, 244));
        renderer.setSeriesPaint(0, p1);
        renderer.setSeriesPaint(3, p1);
        renderer.setSeriesPaint(6, p1);

        Paint p2 = new GradientPaint(
                0.0f, 0.0f, new Color(10, 144, 40), 0.0f, 0.0f, new Color(160, 240, 180));
        renderer.setSeriesPaint(1, p2);
        renderer.setSeriesPaint(4, p2);
        renderer.setSeriesPaint(7, p2);

        Paint p3 = new GradientPaint(
                0.0f, 0.0f, new Color(255, 35, 35), 0.0f, 0.0f, new Color(255, 180, 180));
        renderer.setSeriesPaint(2, p3);
        renderer.setSeriesPaint(5, p3);
        renderer.setSeriesPaint(8, p3);


        renderer.setGradientPaintTransformer(
                new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));

        SubCategoryAxis domainAxis =
                new SubCategoryAxis("Diagramme Des PCs");
        domainAxis.setCategoryMargin(0.05);


        CategoryPlot plot = (CategoryPlot) chart.getPlot();
        plot.setDomainAxis(domainAxis);
        plot.setRenderer(renderer);
        plot.setFixedLegendItems(createLegendItems());
        chart.createBufferedImage(500, 300);

        try {
            ChartUtilities.saveChartAsJPEG(new File("RoomsChartPiefor.jpg"), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(PieStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return chart;
    }

    public LegendItemCollection createLegendItems() {
        LegendItemCollection result = new LegendItemCollection();
        LegendItem item1 = new LegendItem("Available", "Available", "Available", "Available",
                new Rectangle(10, 10), new GradientPaint(0.0f, 0.0f,
                new Color(16, 89, 172), 0.0f, 0.0f,
                new Color(201, 201, 244)));
        LegendItem item2 =
                new LegendItem("Busy", "Busy", "Busy", "Busy",
                new Rectangle(10, 10), new GradientPaint(0.0f, 0.0f,
                new Color(10, 144, 40), 0.0f, 0.0f,
                new Color(160, 240, 180)));
        LegendItem item3 =
                new LegendItem("Down", "Down", "Down", "Down",
                new Rectangle(10, 10), new GradientPaint(0.0f, 0.0f,
                new Color(255, 35, 35), 0.0f, 0.0f,
                new Color(255, 180, 180)));

        result.add(item1);
        result.add(item2);
        result.add(item3);

        return result;
    }
}
