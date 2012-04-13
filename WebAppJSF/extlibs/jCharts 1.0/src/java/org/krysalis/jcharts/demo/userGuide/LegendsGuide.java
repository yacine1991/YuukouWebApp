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

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Shape;
import java.awt.Stroke;

import org.krysalis.jcharts.axisChart.AxisChart;
import org.krysalis.jcharts.chartData.DataSeries;
import org.krysalis.jcharts.properties.AxisProperties;
import org.krysalis.jcharts.properties.ChartProperties;
import org.krysalis.jcharts.properties.ClusteredBarChartProperties;
import org.krysalis.jcharts.properties.LegendAreaProperties;
import org.krysalis.jcharts.properties.LegendProperties;
import org.krysalis.jcharts.properties.LineChartProperties;
import org.krysalis.jcharts.properties.PointChartProperties;
import org.krysalis.jcharts.properties.util.ChartFont;
import org.krysalis.jcharts.properties.util.ChartStroke;
import org.krysalis.jcharts.types.ChartType;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: LegendsGuide.java,v 1.6 2003/08/08 08:51:27 nicolaken Exp $
 ************************************************************************************/
public class LegendsGuide extends UserGuideBase
{

	/*****************************************************************************************
	* Tests a 'real' data set and usage.
	*
	* @throws Throwable
	******************************************************************************************/
	public void run() throws Throwable
	{
		this.basicLegend();
		this.noLegend();
		this.rightSide();
		this.layout();

		this.fonts();
		this.backgroundPaint();
		this.iconBorderPaint();
		this.borderColor();
		this.chartPadding();
	}


	/*****************************************************************************************
	*
	*
	******************************************************************************************/
	private AxisChart getChart( LegendProperties legendProperties ) throws Throwable
	{
		String[] xAxisLabels= { "1998", "1999", "2000", "2001", "2002", "2003", "2004" };
		String xAxisTitle= "Years";
		String yAxisTitle= "Problems";
		String title= "Micro$oft at Work";
		DataSeries dataSeries = new DataSeries( xAxisLabels, xAxisTitle, yAxisTitle, title );

		Stroke[] strokes = new Stroke[]{ LineChartProperties.DEFAULT_LINE_STROKE, LineChartProperties.DEFAULT_LINE_STROKE, LineChartProperties.DEFAULT_LINE_STROKE };
		Shape[] shapes = new Shape[]{ PointChartProperties.SHAPE_DIAMOND, PointChartProperties.SHAPE_TRIANGLE, PointChartProperties.SHAPE_CIRCLE };
		LineChartProperties lineChartProperties= new LineChartProperties( strokes, shapes );

		String[] legendLabels= new String[]{ "Bugs", "Security Holes", "Backdoors" };
		dataSeries.addIAxisPlotDataSet( AxisChartsGuide.createAxisChartDataSet( ChartType.LINE, lineChartProperties, 3, legendLabels, 200, 5000 ) );

		ChartProperties chartProperties= new ChartProperties();
		AxisProperties axisProperties= new AxisProperties();

		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );

		return axisChart;
	}


	/*************************************************************************************************/
	private void basicLegend() throws Throwable
	{
		LegendProperties legendProperties= new LegendProperties();

		super.exportImage( this.getChart( legendProperties ), "legendBasic" );
	}


	/*************************************************************************************************/
	private void noLegend() throws Throwable
	{
		LegendProperties legendProperties= null;

		super.exportImage( this.getChart( legendProperties ), "noLegend" );
	}


	/*************************************************************************************************/
	private void rightSide() throws Throwable
	{
		LegendProperties legendProperties= new LegendProperties();
		legendProperties.setPlacement( LegendAreaProperties.RIGHT );

		super.exportImage( this.getChart( legendProperties ), "legendOnRight" );
	}


	/*************************************************************************************************/
	private void layout() throws Throwable
	{
		LegendProperties legendProperties= new LegendProperties();
		legendProperties.setPlacement( LegendAreaProperties.LEFT );
		legendProperties.setNumColumns( 1 );

		super.exportImage( this.getChart( legendProperties ), "oneColumn" );
	}



	/*************************************************************************************************/
	private void fonts() throws Throwable
	{
		LegendProperties legendProperties= new LegendProperties();
		legendProperties.setChartFont( new ChartFont( new Font( "Georgia Negreta cursiva", Font.PLAIN, 13 ), Color.red ) );

		super.exportImage( this.getChart( legendProperties ), "legendFonts" );
	}


	/*************************************************************************************************/
	private void backgroundPaint() throws Throwable
	{
		LegendProperties legendProperties= new LegendProperties();
		legendProperties.setBackgroundPaint( Color.lightGray );

		super.exportImage( this.getChart( legendProperties ), "legendBackgroundPaint" );
	}



	/*************************************************************************************************/
	private void iconBorderPaint() throws Throwable
	{
		String[] xAxisLabels= { "1998", "1999", "2000", "2001", "2002", "2003", "2004" };
		String xAxisTitle= "Years";
		String yAxisTitle= "Problems";
		String title= "Micro$oft at Work";
		DataSeries dataSeries = new DataSeries( xAxisLabels, xAxisTitle, yAxisTitle, title );

		ClusteredBarChartProperties clusteredBarChartProperties= new ClusteredBarChartProperties();

		String[] legendLabels= new String[]{ "Bugs", "Security Holes", "Backdoors" };
		dataSeries.addIAxisPlotDataSet( AxisChartsGuide.createAxisChartDataSet( ChartType.BAR_CLUSTERED, clusteredBarChartProperties, 3, legendLabels, 200, 5000 ) );

		ChartProperties chartProperties= new ChartProperties();
		AxisProperties axisProperties= new AxisProperties();

		LegendProperties legendProperties= new LegendProperties();
		legendProperties.setIconBorderPaint( Color.red );

		AxisChart axisChart= new AxisChart( dataSeries, chartProperties, axisProperties, legendProperties, AxisChartsGuide.width, AxisChartsGuide.height );

		super.exportImage( axisChart, "iconBorderPaint" );
	}


	/*************************************************************************************************/
	private void borderColor() throws Throwable
	{
		LegendProperties legendProperties= new LegendProperties();

		ChartStroke borderStroke= new ChartStroke( new BasicStroke( 2.0f ), Color.blue );
		legendProperties.setBorderStroke( borderStroke );

		super.exportImage( this.getChart( legendProperties ), "borderColor" );
	}


	/*************************************************************************************************/
	private void chartPadding() throws Throwable
	{
		LegendProperties legendProperties= new LegendProperties();
		legendProperties.setChartPadding( 30 );

		super.exportImage( this.getChart( legendProperties ), "chartPadding" );
	}

}





