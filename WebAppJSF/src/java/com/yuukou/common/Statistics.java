/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.common;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieItemLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Yacine
 */
public class Statistics {

    public void drawPieChart()  {
        // create a chart
        final DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("One", new Double(43.2));
        data.setValue("Two", new Double(10.0));
        data.setValue("Three", new Double(27.5));
        data.setValue("Four", new Double(17.5));
        data.setValue("Five", new Double(11.0));
        data.setValue("Six", new Double(19.4));

        JFreeChart chart = null;
        final boolean drilldown = true;

        // create the chart...
        if (drilldown) {
            final PiePlot plot = new PiePlot(data);
            //          plot.setInsets(new Insets(0, 5, 5, 5));
            plot.setToolTipGenerator(new StandardPieItemLabelGenerator());
            plot.setURLGenerator(new StandardPieURLGenerator("pie_chart_detail.jsp"));
            chart = new JFreeChart("Pie Chart Demo 1", JFreeChart.DEFAULT_TITLE_FONT, plot, true);
        } else {
            chart = ChartFactory.createPieChart(
                    "Pie Chart Demo 1", // chart title
                    data, // data
                    true, // include legend
                    true,
                    false);
        }
        chart.setBackgroundPaint(java.awt.Color.white);


        // save it to an image
        try {
            final ChartRenderingInfo info = new ChartRenderingInfo(new StandardEntityCollection());
            final File file1 = new File("piechart100.png");
            ChartUtilities.saveChartAsPNG(file1, chart, 600, 400, info);

            // write an HTML page incorporating the image with an image map
            final File file2 = new File("piechart100.html");
            final OutputStream out = new BufferedOutputStream(new FileOutputStream(file2));
            final PrintWriter writer = new PrintWriter(out);

//            ChartUtilities.writeImageMap(writer, "chart", info);
            writer.println("<IMG SRC=\"piechart100.png\" "
                    + "WIDTH=\"600\" HEIGHT=\"400\" BORDER=\"0\" USEMAP=\"#chart\">");
            writer.close();

        } catch (IOException e) {
            System.out.println(e.toString());
        }

    }

public void drawSome(){
    DefaultPieDataset data=new DefaultPieDataset();
    data.setValue("Category1",43.2);
    data.setValue("Category2",27.9);
    data.setValue("Category3",79.5);
 
    //create a chart...
    JFreeChart chart=ChartFactory.createPieChart( "SamplePieChart", data, true/*legend?*/,true/*tooltips?*/, false/*URLs?*/);
 
    //create and display a frame...
    
    chart.createBufferedImage(500, 300);
        try {
            ChartUtilities.saveChartAsJPEG(new File("chart.jpg"), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(Statistics.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    }
