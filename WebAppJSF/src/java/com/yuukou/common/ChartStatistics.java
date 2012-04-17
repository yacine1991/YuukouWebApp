package com.yuukou.common;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Rectangle;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
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

    public ChartStatistics() {
    }

    public CategoryDataset createDataset(RoomList rl) {

        Set listCampus = rl.getCampus();

        /*int nbComputerAvailableinECS = rl.getNumberComputerAvailablePerCampus("Electronics and Computer Science");
        int nbComputerBusyinECS = rl.getNumberComputerBusyPerCampus("Electronics and Computer Science");
        int nbComputerDowninECS = rl.getNumberComputerDownPerCampus("Electronics and Computer Science");

        int nbComputerAvailableinRegent = rl.getNumberComputerAvailablePerCampus("Regent");
        int nbComputerBusyinRegent = rl.getNumberComputerBusyPerCampus("Regent");
        int nbComputerDowninRegent = rl.getNumberComputerDownPerCampus("Regent");

        int nbComputerAvailableinMarylebone = rl.getNumberComputerAvailablePerCampus("Marylebone");
        int nbComputerBusyinMarylebone = rl.getNumberComputerBusyPerCampus("Marylebone");
        int nbComputerDowninMarylebone = rl.getNumberComputerDownPerCampus("Marylebone");*/



        DefaultCategoryDataset result = new DefaultCategoryDataset();
        Iterator i = listCampus.iterator();
        
        while (i.hasNext()) {
            result.addValue(rl.getNumberComputerAvailablePerCampus(i.toString()), "PC (Available)", i.toString());
            result.addValue(rl.getNumberComputerDownPerCampus(i.toString()), "PC (Down)", i.toString());
            result.addValue(rl.getNumberComputerBusyPerCampus(i.toString()), "PC (Busy)", i.toString());
            System.out.println(i.toString());
            i.next();
            
        }
        i.remove();
        /*result.addValue(nbComputerAvailableinECS, "PC (Available)", "ECS");
        result.addValue(nbComputerDowninECS, "PC (Down)", "ECS");
        result.addValue(nbComputerBusyinECS, "PC (Busy)", "ECS");

        result.addValue(nbComputerAvailableinMarylebone, "PC (Available)", "Marylebone");
        result.addValue(nbComputerDowninMarylebone, "PC (Down)", "Marylebone");
        result.addValue(nbComputerBusyinMarylebone, "PC (Busy)", "Marylebone");


*/

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
        KeyToGroupMap map = new KeyToGroupMap("G1");

        map.mapKeyToGroup("ECS (US)", "G1");


        renderer.setSeriesToGroupMap(map);


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
        domainAxis.addSubCategory("Product 1");


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
