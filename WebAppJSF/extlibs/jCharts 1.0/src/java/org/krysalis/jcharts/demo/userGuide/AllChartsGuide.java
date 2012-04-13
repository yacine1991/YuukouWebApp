
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

package org.krysalis.jcharts.demo.userGuide;


import org.krysalis.jcharts.axisChart.AxisChart;
import org.krysalis.jcharts.chartData.ChartDataException;
import org.krysalis.jcharts.chartData.DataSeries;
import org.krysalis.jcharts.properties.AreaChartProperties;
import org.krysalis.jcharts.properties.AxisProperties;
import org.krysalis.jcharts.properties.ChartProperties;
import org.krysalis.jcharts.properties.LegendProperties;
import org.krysalis.jcharts.properties.util.ChartStroke;
import org.krysalis.jcharts.types.ChartType;

import java.awt.*;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: AllChartsGuide.java,v 1.2 2003/06/25 01:40:15 nathaniel_auvil Exp $
 ************************************************************************************/
public class AllChartsGuide extends UserGuideBase
{
	private DataSeries dataSeries;



	public AllChartsGuide() throws ChartDataException
	{
		this.dataSeries= AxisChartsGuide.createDataSeries();
		this.dataSeries.addIAxisPlotDataSet( AxisChartsGuide.createAxisChartDataSet( ChartType.AREA, new AreaChartProperties(), 200, 5000 ) );
	}


	/*****************************************************************************************
	* Tests a 'real' data set and usage.
	*
	* @throws Throwable
	******************************************************************************************/
	public void run() throws Throwable
	{
		this.chartTitle();
		this.chartNoTitle();
      this.chartTitleWrapping();

		this.backgroundPaint();
		this.chartBorder();
		this.edgePadding();
	}


	/********************************************************************************************/
	private void backgroundPaint() throws Throwable
	{
		ChartProperties chartProperties= this.getChartProperties();
		GradientPaint paint= new GradientPaint( 250, 0, Color.white,
															 250, 800, new Color( 0, 255, 255, 220 ) );
		chartProperties.setBackgroundPaint( paint );

		AxisProperties axisProperties= new AxisProperties();
		axisProperties.setXAxisLabelsAreVertical( true );
		LegendProperties legendProperties= new LegendProperties();

		AxisChart axisChart= new AxisChart( this.dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );

		super.exportImage( axisChart, "backgroundPaint" );
	}


	/*******************************************************************************************/
	private void chartBorder() throws Throwable
	{
		ChartProperties chartProperties= this.getChartProperties();

		ChartStroke borderStroke= new ChartStroke( new BasicStroke( 2.0f ), Color.red );
		chartProperties.setBorderStroke( borderStroke );

		AxisProperties axisProperties= new AxisProperties();
		axisProperties.setXAxisLabelsAreVertical( true );
		LegendProperties legendProperties= new LegendProperties();

		AxisChart axisChart= new AxisChart( this.dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );

		super.exportImage( axisChart, "chartBorder" );
	}


	/********************************************************************************************/
	private void edgePadding() throws Throwable
	{
		ChartProperties chartProperties= this.getChartProperties();
		chartProperties.setEdgePadding( 50f );
      chartProperties.setBorderStroke( ChartStroke.DEFAULT_CHART_OUTLINE );

		AxisProperties axisProperties= new AxisProperties();
      axisProperties.setXAxisLabelsAreVertical( true );
		LegendProperties legendProperties= new LegendProperties();

		AxisChart axisChart= new AxisChart( this.dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );


		super.exportImage( axisChart, "edgePadding" );
	}


	/********************************************************************************************/
	private void chartTitle() throws Throwable
	{
		String[] xAxisLabels= { "1998", "1999", "2000", "2001", "2002", "2003", "2004" };
		DataSeries dataSeries = new DataSeries( xAxisLabels, "Years", "Production", "Micro$oft Bug Production" );
		dataSeries.addIAxisPlotDataSet( AxisChartsGuide.createAxisChartDataSet( ChartType.AREA, new AreaChartProperties(), 200, 5000 ) );

		ChartProperties chartProperties= this.getChartProperties();

		AxisProperties axisProperties= new AxisProperties();
		axisProperties.setXAxisLabelsAreVertical( true );
		LegendProperties legendProperties= new LegendProperties();

		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );

		super.exportImage( axisChart, "chartTitle" );
	}

	/********************************************************************************************/
	private void chartNoTitle() throws Throwable
	{
		String[] xAxisLabels= { "1998", "1999", "2000", "2001", "2002", "2003", "2004" };
		DataSeries dataSeries = new DataSeries( xAxisLabels, "Years", "Production", null );
		dataSeries.addIAxisPlotDataSet( AxisChartsGuide.createAxisChartDataSet( ChartType.AREA, new AreaChartProperties(), 200, 5000 ) );

		ChartProperties chartProperties= this.getChartProperties();

		AxisProperties axisProperties= new AxisProperties();
		axisProperties.setXAxisLabelsAreVertical( true );
		LegendProperties legendProperties= new LegendProperties();

		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );

		super.exportImage( axisChart, "chartNoTitle" );
	}


	/********************************************************************************************/
	private void chartTitleWrapping() throws Throwable
	{
		String[] xAxisLabels= { "1998", "1999", "2000", "2001", "2002", "2003", "2004" };
		DataSeries dataSeries = new DataSeries( xAxisLabels, "Years", "Production", "The Micro$ofties have been so very, very, very, busy adding Bugs, this title is going to wrap to the next line" );

		dataSeries.addIAxisPlotDataSet( AxisChartsGuide.createAxisChartDataSet( ChartType.AREA, new AreaChartProperties(), 200, 5000 ) );

		ChartProperties chartProperties= this.getChartProperties();

		AxisProperties axisProperties= new AxisProperties();
		axisProperties.setXAxisLabelsAreVertical( true );
		LegendProperties legendProperties= new LegendProperties();

		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );

		super.exportImage( axisChart, "chartTitleWrapping" );
	}


	/*******************************************************************************************
	 *
	 * @return
	 *****************************************************************************************/
	private ChartProperties getChartProperties()
	{
		ChartProperties chartProperties= new ChartProperties();
		//chartProperties.setBorderStroke( ChartStroke.DEFAULT_CHART_OUTLINE );
		chartProperties.setEdgePadding( 20 );
		return chartProperties;
	}
}





