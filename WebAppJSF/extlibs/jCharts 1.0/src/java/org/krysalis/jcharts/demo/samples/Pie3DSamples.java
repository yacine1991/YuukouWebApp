package org.krysalis.jcharts.demo.samples;


import java.awt.Color;
import java.awt.Paint;

import org.krysalis.jcharts.chartData.ChartDataException;
import org.krysalis.jcharts.chartData.PieChartDataSet;
import org.krysalis.jcharts.nonAxisChart.PieChart3D;
import org.krysalis.jcharts.properties.ChartProperties;
import org.krysalis.jcharts.properties.LegendProperties;
import org.krysalis.jcharts.properties.PieChart3DProperties;
import org.krysalis.jcharts.properties.util.ChartStroke;
import org.krysalis.jcharts.types.PieLabelType;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: Pie3DSamples.java,v 1.2 2003/09/02 08:48:19 nicolaken Exp $
 ************************************************************************************/
public class Pie3DSamples extends Sample
{

	protected String getSubdir()
	{
		return "pie3d/";
	}


	public void render() throws ChartDataException
	{
		double[] data = {45.00d, 90.00d, 45.00d, 180d};
		String[] labels = {"Equities", "Bonds", "Money Market", "Alternative Investments"};

      Paint[] paints = { new Color( 200, 0, 0, 20 ),
								 new Color( 0, 200, 0, 20 ),
								 new Color( 0, 0, 200, 20 ),
								 new Color( 200, 200, 0, 20 ) };


		PieChart3DProperties pieChart3DProperties = new PieChart3DProperties();
		pieChart3DProperties.setPieLabelType( PieLabelType.LEGEND_LABELS );
		pieChart3DProperties.setTickLength( 5 );

		pieChart3DProperties.setZeroDegreeOffset( 60 );

		pieChart3DProperties.setDepth( 15 );


		LegendProperties legendProperties = null;
/*
		LegendProperties legendProperties = new LegendProperties();
		legendProperties.setPlacement( LegendAreaProperties.RIGHT );
		legendProperties.setNumColumns( 1 );
*/

		PieChartDataSet pieChartDataSet = new PieChartDataSet( "Investment Categories", data, labels, paints, pieChart3DProperties );

		ChartProperties chartProperties = new ChartProperties();
		chartProperties.setBorderStroke( ChartStroke.DEFAULT_CHART_OUTLINE );

		PieChart3D pieChart = new PieChart3D( pieChartDataSet, legendProperties, chartProperties, 500, 400 );


		super.encode( pieChart, "pie3d" );
	}
}
