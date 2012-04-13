
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


import org.krysalis.jcharts.properties.PieChart2DProperties;
import org.krysalis.jcharts.properties.LegendProperties;
import org.krysalis.jcharts.properties.ChartProperties;
import org.krysalis.jcharts.properties.util.ChartStroke;
import org.krysalis.jcharts.chartData.ChartDataException;
import org.krysalis.jcharts.chartData.PieChartDataSet;
import org.krysalis.jcharts.nonAxisChart.PieChart2D;
import org.krysalis.jcharts.types.PieLabelType;

import java.awt.*;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: PieChartsGuide.java,v 1.1 2003/05/31 19:10:28 nathaniel_auvil Exp $
 ************************************************************************************/
public class PieChartsGuide extends UserGuideBase
{

	/*****************************************************************************************
	* Tests a 'real' data set and usage.
	*
	* @throws Throwable
	******************************************************************************************/
	public void run() throws Throwable
	{
		this.basicChart();
		this.zeroDegreeOffsetChart();
		this.borderStroke();
		this.borderPaint();

		this.pieValueLabels();
		this.pieLegendLabels();
	}


	/******************************************************************************************/
	private void outputChart( PieChart2DProperties pieChart2DProperties, String name ) throws ChartDataException
	{
		double[] data= { 81d, 55d, 39d, 20.6d };
		String[] labels= { "BMW M5", "BMW M3", "Viper GTS-R", "Corvette Z06" };
		Paint[] paints= { Color.lightGray, Color.green, Color.blue, Color.red };

		PieChartDataSet pieChartDataSet= new PieChartDataSet( "Cars That Own", data, labels, paints, pieChart2DProperties );

		PieChart2D pieChart2D= new PieChart2D( pieChartDataSet, new LegendProperties(), new ChartProperties(), 400, 350 );
		super.exportImage( pieChart2D, name );
	}


	/******************************************************************************************/
	private void basicChart() throws Throwable
	{
		PieChart2DProperties pieChart2DProperties= new PieChart2DProperties();
		this.outputChart( pieChart2DProperties, "pieChartBasic" );
	}


	/******************************************************************************************/
	private void zeroDegreeOffsetChart() throws Throwable
	{
		PieChart2DProperties pieChart2DProperties= new PieChart2DProperties();
		pieChart2DProperties.setZeroDegreeOffset( 45f );
		this.outputChart( pieChart2DProperties, "pieChartZeroOffset" );
	}


	/******************************************************************************************/
	private void borderStroke() throws Throwable
	{
		PieChart2DProperties pieChart2DProperties= new PieChart2DProperties();
		pieChart2DProperties.setBorderChartStroke( new ChartStroke( new BasicStroke( 4f ), Color.black ) );
		this.outputChart( pieChart2DProperties, "pieChartBorderStroke" );
	}


	/******************************************************************************************/
	private void borderPaint() throws Throwable
	{
/*
		PieChart2DProperties pieChart2DProperties= new PieChart2DProperties();
		pieChart2DProperties.setBorderPaint( Color.gray );
		this.outputChart( pieChart2DProperties, "pieChartBorderPaint" );
*/
	}


	private void pieValueLabels() throws ChartDataException
	{
		PieChart2DProperties pieChart2DProperties= new PieChart2DProperties();
		pieChart2DProperties.setPieLabelType( PieLabelType.VALUE_LABELS );
		this.outputChart( pieChart2DProperties, "pieChartValueLabels" );
	}

	private void pieLegendLabels() throws ChartDataException
	{
		PieChart2DProperties pieChart2DProperties= new PieChart2DProperties();
		pieChart2DProperties.setPieLabelType( PieLabelType.LEGEND_LABELS );

		double[] data= { 81d, 55d, 39d, 20.6d };
		String[] labels= { "BMW M5", "BMW M3", "Viper GTS-R", "Audi S6" };
		Paint[] paints= { Color.lightGray, Color.green, Color.blue, Color.red };

		PieChartDataSet pieChartDataSet= new PieChartDataSet( "Cars That Own", data, labels, paints, pieChart2DProperties );
		PieChart2D pieChart2D= new PieChart2D( pieChartDataSet, null, new ChartProperties(), 400, 350 );
		super.exportImage( pieChart2D, "pieChartLegendLabels" );
	}
}





