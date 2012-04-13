
/***********************************************************************************************
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


package org.krysalis.jcharts.demo.samples;


import org.krysalis.jcharts.axisChart.AxisChart;
import org.krysalis.jcharts.chartData.AxisChartDataSet;
import org.krysalis.jcharts.chartData.ChartDataException;
import org.krysalis.jcharts.chartData.DataSeries;
import org.krysalis.jcharts.properties.AreaChartProperties;
import org.krysalis.jcharts.properties.AxisProperties;
import org.krysalis.jcharts.properties.AxisTypeProperties;
import org.krysalis.jcharts.properties.ChartProperties;
import org.krysalis.jcharts.properties.LegendProperties;
import org.krysalis.jcharts.properties.StackedAreaChartProperties;
import org.krysalis.jcharts.properties.util.ChartFont;
import org.krysalis.jcharts.test.TestDataGenerator;
import org.krysalis.jcharts.types.ChartType;

import java.awt.*;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: AreaChartSamples.java,v 1.1 2003/08/09 19:01:20 nathaniel_auvil Exp $
 ************************************************************************************/
public class AreaChartSamples extends Sample
{

	protected String getSubdir()
	{
		return "area/";
	}


	private AxisChart getAreaChartVerticalLabels() throws ChartDataException
	{
		double[][] data= TestDataGenerator.getRandomNumbers( 3, 10, 0, 5000 );
		Paint[] paints= TestDataGenerator.getRandomPaints( 3 );
		String[] legendLabels= { "Bugs", "Security Holes", "Backdoors" };
		AreaChartProperties areaChartProperties= new AreaChartProperties();
		AxisChartDataSet axisChartDataSet = new AxisChartDataSet( data, legendLabels, paints, ChartType.AREA, areaChartProperties );

		String[] xAxisLabels= { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004" };
		DataSeries dataSeries = new DataSeries( xAxisLabels, "Years", "Incidence", "Micro$oft At Work"  );
		dataSeries.addIAxisPlotDataSet( axisChartDataSet );

		ChartProperties chartProperties= new ChartProperties();
		chartProperties.setEdgePadding( 20 );
		chartProperties.setTitleFont( new ChartFont( new Font( "Georgia Negreta cursiva", Font.PLAIN, 14 ), Color.black ) );

		AxisProperties axisProperties= new AxisProperties( false );
		axisProperties.setXAxisLabelsAreVertical( true );
		axisProperties.getYAxisProperties().setShowGridLines( AxisTypeProperties.GRID_LINES_ALL );

		ChartFont scaleFont= new ChartFont( new Font( "Georgia Negreta cursiva", Font.PLAIN, 13 ), Color.black );
		axisProperties.getXAxisProperties().setScaleChartFont( scaleFont );
		axisProperties.getYAxisProperties().setScaleChartFont( scaleFont );

		ChartFont axisTitleFont= new ChartFont( new Font( "Arial Narrow", Font.PLAIN, 12 ), Color.black );
		axisProperties.getXAxisProperties().setAxisTitleChartFont( axisTitleFont );
		axisProperties.getYAxisProperties().setAxisTitleChartFont( axisTitleFont );

		LegendProperties legendProperties= new LegendProperties();
		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, 500, 400 );

      return axisChart;
	}


	private AxisChart getStackedAreaChart() throws ChartDataException
	{
		double[][] data= TestDataGenerator.getRandomNumbers( 3, 10, 0, 5000 );
		Paint[] paints= TestDataGenerator.getRandomPaints( 3 );
		String[] legendLabels= { "Bugs", "Security Holes", "Backdoors" };
		StackedAreaChartProperties stackedAreaChartProperties= new StackedAreaChartProperties();
		AxisChartDataSet axisChartDataSet = new AxisChartDataSet( data, legendLabels, paints, ChartType.AREA_STACKED, stackedAreaChartProperties );

		String[] xAxisLabels= { "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004" };
		DataSeries dataSeries = new DataSeries( xAxisLabels, "Years", "Incidence", "Micro$oft At Work"  );
		dataSeries.addIAxisPlotDataSet( axisChartDataSet );

		ChartProperties chartProperties= new ChartProperties();
		chartProperties.setEdgePadding( 20 );
		chartProperties.setTitleFont( new ChartFont( new Font( "Georgia Negreta cursiva", Font.PLAIN, 14 ), Color.black ) );

		AxisProperties axisProperties= new AxisProperties( false );
		axisProperties.setXAxisLabelsAreVertical( true );
		axisProperties.getYAxisProperties().setShowGridLines( AxisTypeProperties.GRID_LINES_ALL );

		ChartFont scaleFont= new ChartFont( new Font( "Georgia Negreta cursiva", Font.PLAIN, 13 ), Color.black );
		axisProperties.getXAxisProperties().setScaleChartFont( scaleFont );
		axisProperties.getYAxisProperties().setScaleChartFont( scaleFont );

		ChartFont axisTitleFont= new ChartFont( new Font( "Arial Narrow", Font.PLAIN, 12 ), Color.black );
		axisProperties.getXAxisProperties().setAxisTitleChartFont( axisTitleFont );
		axisProperties.getYAxisProperties().setAxisTitleChartFont( axisTitleFont );

		LegendProperties legendProperties= new LegendProperties();
		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, 500, 400 );

      return axisChart;
	}


	protected void render() throws ChartDataException
	{
      super.encode( this.getAreaChartVerticalLabels(), "areaChartVertical" );
      super.encode( this.getStackedAreaChart(), "stackedAreaChart" );
	}
}
