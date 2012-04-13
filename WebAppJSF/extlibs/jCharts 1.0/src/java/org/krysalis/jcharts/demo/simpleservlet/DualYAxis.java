
/***********************************************************************************************
 * File Info: $Id: DualYAxis.java,v 1.2 2003/08/28 01:18:02 nathaniel_auvil Exp $
 * Copyright (C) 2002
 * Author: Nathaniel G. Auvil
 * Contributor(s):
 *
 * Copyright 2002 (C) Nathaniel G. Auvil. All Rights Reserved.
 *
 * Redistribution and use of this software and associated documentation ("Software"), with or
 * without modification, are permitted provided that the following conditions are met:
 *
 * 1. Redistributions of source code must retain copyright statements and notices.
 * 	Redistributions must also contain a copy of this document.
 *
 * 2. Redistributions in binary form must reproduce the above copyright notice, this list of
 * 	conditions and the following disclaimer in the documentation and/or other materials
 * 	provided with the distribution.
 *
 * 3. The name "jCharts" or "Nathaniel G. Auvil" must not be used to endorse or promote
 * 	products derived from this Software without prior written permission of Nathaniel G.
 * 	Auvil.  For written permission, please contact nathaniel_auvil@users.sourceforge.net
 *
 * 4. Products derived from this Software may not be called "jCharts" nor may "jCharts" appear
 * 	in their names without prior written permission of Nathaniel G. Auvil. jCharts is a
 * 	registered trademark of Nathaniel G. Auvil.
 *
 * 5. Due credit should be given to the jCharts Project (http://jcharts.sourceforge.net/).
 *
 * THIS SOFTWARE IS PROVIDED BY Nathaniel G. Auvil AND CONTRIBUTORS ``AS IS'' AND ANY
 * EXPRESSED OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.  IN NO EVENT SHALL
 * jCharts OR ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 * EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION)
 * HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT,STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN
 * IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE
 ************************************************************************************************/

package org.krysalis.jcharts.demo.simpleservlet;


import org.krysalis.jcharts.axisChart.AxisChart;
import org.krysalis.jcharts.chartData.AxisChartDataSet;
import org.krysalis.jcharts.chartData.DataSeries;
import org.krysalis.jcharts.chartData.interfaces.IAxisDataSeries;
import org.krysalis.jcharts.encoders.ServletEncoderHelper;
import org.krysalis.jcharts.properties.AxisProperties;
import org.krysalis.jcharts.properties.ChartProperties;
import org.krysalis.jcharts.properties.ClusteredBarChartProperties;
import org.krysalis.jcharts.properties.DataAxisProperties;
import org.krysalis.jcharts.properties.LegendProperties;
import org.krysalis.jcharts.properties.LineChartProperties;
import org.krysalis.jcharts.properties.PointChartProperties;
import org.krysalis.jcharts.properties.util.ChartFont;
import org.krysalis.jcharts.types.ChartType;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;

// Dual Y axis changes courtesy of St�phane NGUYEN integrated by CMC 25Aug03
// French translation courtesy of my good wife Jacki ...
public class DualYAxis extends ChartServlet {


    //---all of the charts will have some properties.
    private LineChartProperties lineChartProperties;
    private ClusteredBarChartProperties clusteredBarChartProperties;

    protected LegendProperties legendProperties;
    protected ChartProperties chartProperties;
    protected AxisProperties axisProperties;

    //---all of the charts have the same size
    protected int width = 750;
    protected int height = 430;


  public void init() {


    //---------------------Font & Police----------------------------------------

    legendProperties = new LegendProperties();
    chartProperties = new ChartProperties();
    axisProperties = new AxisProperties(false);

    ChartFont axisScaleFont = new ChartFont(new Font("Arial Narrow", Font.PLAIN, 10), Color.black);
    axisProperties.getXAxisProperties().setScaleChartFont(axisScaleFont);
    axisProperties.getYAxisProperties().setScaleChartFont(axisScaleFont);

    ChartFont axisTitleFont = new ChartFont(new Font("Arial Narrow", Font.PLAIN, 13), Color.black);
    axisProperties.getXAxisProperties().setTitleChartFont(axisTitleFont);
    axisProperties.getYAxisProperties().setTitleChartFont(axisTitleFont);

    ChartFont titleFont = new ChartFont(new Font("Georgia Negreta cursiva", Font.PLAIN, 15), Color.black);
    chartProperties.setTitleFont(titleFont);

    //On fixe la marge avec le cadre
    // Set the margin within the frame
    chartProperties.setEdgePadding(2f);

    //On met le graphe sur un fond gris clair
    // Set the chart against a plain grey background
    axisProperties.setBackgroundPaint(new Color (245, 245, 245)); 

    //Param�trage de la bo�te de l�gende
    //Parameters for the legend box
    //legendProperties.setPlacement(LegendAreaProperties.RIGHT);
    //legendProperties.setNumColumns(1);
    //legendProperties.setFont( new Font("Arial Narrow", Font.PLAIN, 13) );
    //legendProperties.setFontPaint(Color.black);
    ChartFont legendFont = new ChartFont(new Font("Arial Narrow", Font.PLAIN, 13), Color.black);
    legendProperties.setChartFont(legendFont);
    legendProperties.setChartPadding(10);

    //Arrondi � la puissance 10
    //Round up to the power of 10
    DataAxisProperties dataAxisProperties= (DataAxisProperties) axisProperties.getYAxisProperties();
    dataAxisProperties.setRoundToNearest(1);

    //Parametrage du nombre de graduation sur l'axe des ordonn�es
    //Set the number of ticks(?) for the ordinal axis
    dataAxisProperties.setNumItems(6);

    //utilisation de la virgule s'il y a lieu (normalement non)
    // Set the use of the comma if there are any (usually not)
    dataAxisProperties.setUseCommas(false);

    //Ne pas afficher les bordures sup�rieur et droite du chart
    // Don't attach upper borders and the right of the chart
    axisProperties.getYAxisProperties().setShowEndBorder(false);
    axisProperties.getXAxisProperties().setShowEndBorder(false);


    Stroke[] strokes = {LineChartProperties.DEFAULT_LINE_STROKE};
    //Shape[] shapes = {null};
    Shape[] shapes= { PointChartProperties.SHAPE_TRIANGLE };
    lineChartProperties = new LineChartProperties(strokes, shapes);

    clusteredBarChartProperties = new ClusteredBarChartProperties();

    //Param�trage de la largeur des barres de l'histogramme et non affichage des contours
    //Set the width of the bars and don't show the outline
    clusteredBarChartProperties.setWidthPercentage( 0.70f );
    clusteredBarChartProperties.setShowOutlinesFlag( false );
  }

	/**********************************************************************************************
	 *
	 **********************************************************************************************/
  public void service( HttpServletRequest req, HttpServletResponse httpServletResponse ) throws ServletException, IOException
  {
    //---Some charts will need a second scale to render some values and then will
    //---need to render an axis at the right of the charts with it
    long secondScale=1;

    //---specific variable use to render negative value in all case
    double maxDataClustAbs = 0;
    double maxDataLineAbs = 0;
    int numberOfNegativ=0;
    int numberOfZero=0;

    try {

      String[] xAxisLabels = {"MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC", "JAN", "FEB"};
      

      double[][] dataClust = new double[][]{
        {3533, 101265, 76076, 86664, 135567, 87729, 85309, 143423, 18732, 111842, 39534, 11980}
      , {0, 103400, 65000, 88500, 143000, 80000, 88500, 143500, 99000, 118500, 38500, 18000}
                                    };
      double[][] dataLine = new double[][]{
        {21, 4, 1, 2, 3, 2, 3, 2, 93, 18, 54, 0}
                                      };          

      String title = "Chart Title";
      String legendLabel1 = "Legend Label 1";
      String legendLabel2 = "Legend Label 2";
      String legendLabel3 = "Legend Label 3";

      //IAxisDataSeries dataSeries = new DataSeries( xAxisLabels, null, null, title );
      IAxisDataSeries dataSeries = new DataSeries( xAxisLabels, "X Axis title", "Left Y Axis title", title );

      String[] legendLabelsClust = {legendLabel1, legendLabel2};
      Paint[] clustPaints = new Paint[]{Color.pink, Color.blue};

      String[] legendLabelsLine = {legendLabel3};
      Paint[] linePaints = new Paint[]{Color.green};

      //------------On r�cup�re une 2�me �chelle "secondScale"------------------
      //------------et on fait un traitement pour les nombres n�gatifs----------
      //------------We get back the 2nd scale "secondScale"---------------------
      //-------------and we handle the negative numbers---------------------
     //On identifie la valeur maximum absolue des data Clustered Bar
      //et on compte le nombre de z�ro et le nombre de chiffres n�gatifs
      // We identify the absolute maximum value of the data in the Clustered Bar
      // and we count the number of zero and negative digits
      for (int k=0; k<2; k++) {

        for (int j=0; j<xAxisLabels.length; j++) {
          if (maxDataClustAbs < (Math.abs(dataClust[k][j])) && (dataClust[k][j]!=0) ) {
            maxDataClustAbs=(Math.abs(dataClust[k][j]));
          }
          if (dataClust[k][j]<0) {
            numberOfNegativ+=1;
          }
          if (dataClust[k][j]==0) {
            numberOfZero+=1;  
          }
        }
      }

      //On identifie la valeur maximum absolue des data Line
      //et on compte le nombre de z�ro et le nombre de chiffres n�gatifs
      // We identify the absolute maximum value of the data lines
      // and we count the number of zero and negative digits
      for (int j=0; j<xAxisLabels.length; j++) {
        if (maxDataLineAbs < (Math.abs(dataLine[0][j])) && (dataLine[0][j]!=0) ) {
          maxDataLineAbs=(Math.abs(dataLine[0][j]));
        }
        if (dataLine[0][j]<0) {
            numberOfNegativ+=1;
        }
        if (dataLine[0][j]==0) {
            numberOfZero+=1;  
        }
      }

      //On d�finit la valeur de la seconde �chelle si les ordres de grandeurs
      //sont tr�s diff�rent (de l'ordre de 10).
      //We define the value of the second scale if the increment is an order of
      //magnitude greater
      if (maxDataClustAbs>10*maxDataLineAbs) {    
        axisProperties.getYAxisProperties().setShowRightAxis(true);
        secondScale=Math.round(maxDataClustAbs/(maxDataLineAbs));
        axisProperties.getYAxisProperties().setSecondScaleRight((float) (secondScale) );
        ChartFont axisScaleFontRight = new ChartFont( new Font("Arial Narrow", Font.PLAIN, 10), Color.green.darker() );
        axisProperties.getYAxisProperties().setScaleChartFontRight( axisScaleFontRight );
      }

      //On v�rifie s'il y a des valeurs n�gatives
      // Check if there are negative numbers
      if (numberOfNegativ>0) {
        if ((maxDataLineAbs*secondScale)>maxDataClustAbs) {
          axisProperties.getYAxisProperties().setMinRightAxis((double) (-maxDataLineAbs*secondScale));
          //Si les valeurs ne sont pas toutes n�gatives on affiche l'axe des ordonn�es
          //de mani�re a ce que le z�ro soit centr�
          // If the numbers are not all negative we center the ordinal axis around zero
          if (numberOfNegativ!=(3*xAxisLabels.length-numberOfZero)) {
            axisProperties.getYAxisProperties().setMaxRightAxis((double) (maxDataLineAbs*secondScale));
          }
        } else {
          axisProperties.getYAxisProperties().setMinRightAxis((double) (-maxDataClustAbs));
            if (numberOfNegativ!=(3*xAxisLabels.length-numberOfZero)) {
              axisProperties.getYAxisProperties().setMaxRightAxis((double) (maxDataClustAbs));
            }
        }
      }

      dataSeries.addIAxisPlotDataSet( new AxisChartDataSet( dataClust, legendLabelsClust, clustPaints, ChartType.BAR_CLUSTERED, clusteredBarChartProperties ) );
      dataSeries.addIAxisPlotDataSet( new AxisChartDataSet( dataLine, legendLabelsLine, linePaints, ChartType.LINE, lineChartProperties ) );
      AxisChart axisChart = new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, width, height );
 
      ServletEncoderHelper.encodeJPEG13( axisChart, 1.0f, httpServletResponse );
    }
    catch( Throwable throwable ) {
      //HACK do your error handling here...
      throwable.printStackTrace();
    }
  }

}