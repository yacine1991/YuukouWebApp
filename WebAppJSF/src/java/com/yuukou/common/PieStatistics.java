/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yuukou.common;

import java.io.*;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.labels.StandardPieItemLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.urls.StandardPieURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.general.DatasetGroup;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author Yacine
 */
public class PieStatistics {

    private int nbHarrow;
    private int nbCavendish;
    private int nbMarylbone;
    private int nbRegent;
    private int nbLittle;
    private int nbECS;
    private int nbBusy;
    private int nbDown;
    private int nbAvailable;
    private int nbRoomBusy;
    private int nbRoomAvailable;
    private int nbRoomBusyPerCampus;
    private int nbRoomAvailablePerCampus;

    public void drawPieChart() {
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

    public void drawPieMacPc(RoomList rl) {


        int nbMac = rl.getNumberMac();
        int nbPc = rl.getNumberPc();

        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Macintosh", nbMac);
        data.setValue("Windows", nbPc);


        //create a chart...
        JFreeChart chart = ChartFactory.createPieChart("Mac - PC", data, true/*
                 * legend?
                 */, true/*
                 * tooltips?
                 */, false/*
                 * URLs?
                 */);

        //create and display a frame...

        chart.createBufferedImage(500, 300);
        try {
            ChartUtilities.saveChartAsJPEG(new File("macPC.jpg"), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(PieStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }


    }

    public void drawPieComputerPerCampus(RoomList rl) {
        nbCavendish = rl.getNbComputerRoomsCavendish();
        nbMarylbone = rl.getNbComputerRoomsMarylebone();
        nbRegent = rl.getNbComputerRoomsRegent();
        nbLittle = rl.getNbComputerRoomsLittleTich();
        nbHarrow = rl.getNbComputerRoomsHarrow();
        nbECS = rl.getNbComputerRoomsECS();


        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Regent", nbRegent);
        data.setValue("Marylbone", nbMarylbone);
        data.setValue("LittleTich", nbLittle);
        data.setValue("Harrow", nbHarrow);
        data.setValue("Cavendish", nbCavendish);
        data.setValue("ECS", nbECS);



        //create a chart...
        JFreeChart chart = ChartFactory.createPieChart("Computer Rooms per Campus", data, true/*
                 * legend?
                 */, true/*
                 * tooltips?
                 */, false/*
                 * URLs?
                 */);

        //create and display a frame...

        chart.createBufferedImage(500, 300);
        try {
            ChartUtilities.saveChartAsJPEG(new File("RoomsperCampus.jpg"), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(PieStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void drawPieComputerBusyAvailableDown(RoomList rl) {
        nbBusy = rl.getNumberComputerBusyForAllCampus();
        nbDown = rl.getNumberComputerDownForAllCampus();
        nbAvailable = rl.getNumberComputerAvailableForAllCampus();



        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Busy", nbBusy);
        data.setValue("Down", nbBusy);
        data.setValue("Available", nbAvailable);




        //create a chart...
        JFreeChart chart = ChartFactory.createPieChart("Busy - Available - Down", data, true/*
                 * legend?
                 */, true/*
                 * tooltips?
                 */, false/*
                 * URLs?
                 */);

        //create and display a frame...

        chart.createBufferedImage(500, 300);
        try {
            ChartUtilities.saveChartAsJPEG(new File("RessourcesPies.jpg"), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(PieStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void drawPieRoomsBusyAvailable(RoomList rl) {
        nbRoomBusy = rl.getNumberRoomBusyForAllCampus();

        nbRoomAvailable = rl.getNumberRoomAvailableForAllCampus();



        DefaultPieDataset data = new DefaultPieDataset();
        data.setValue("Room Busy", nbRoomBusy);

        data.setValue("Room Available", nbRoomAvailable);




        //create a chart...
        JFreeChart chart = ChartFactory.createPieChart("Rooms Busy - Available", data, true/*
                 * legend?
                 */, true/*
                 * tooltips?
                 */, false/*
                 * URLs?
                 */);

        //create and display a frame...

        chart.createBufferedImage(500, 300);
        try {
            ChartUtilities.saveChartAsJPEG(new File("RoomsBAPie.jpg"), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(PieStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void drawPieRoomsBusyAvailablePerCampus(RoomList rl, String campus) {
        nbRoomBusyPerCampus = rl.getNumberRoomBusyPerCampus(campus);

        nbRoomAvailablePerCampus = rl.getNumberRoomAvailablePerCampus(campus);



        DefaultPieDataset data = new DefaultPieDataset();

        data.setValue("Room Busy", nbRoomBusyPerCampus);

        data.setValue("Room Available", nbRoomAvailablePerCampus);




        //create a chart...
        JFreeChart chart = ChartFactory.createPieChart("Rooms Busy - Available for " + campus + "", data, true/*
                 * legend?
                 */, true/*
                 * tooltips?
                 */, false/*
                 * URLs?
                 */);

        //create and display a frame...

        chart.createBufferedImage(500, 300);
        try {
            ChartUtilities.saveChartAsJPEG(new File("RoomsBAPiefor" + campus + ".jpg"), chart, 500, 300);
        } catch (IOException ex) {
            Logger.getLogger(PieStatistics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
