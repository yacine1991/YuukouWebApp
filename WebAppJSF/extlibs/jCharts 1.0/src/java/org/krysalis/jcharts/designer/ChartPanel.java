/***************************************************************************************
 * File Info: $Id: ChartPanel.java,v 1.1 2003/08/09 16:57:29 nathaniel_auvil Exp $
 *
 * Description:
 *
 * Last Reviewed: NEVER
 * Maintainer: Nathaniel Auvil
 * Copyright: <copyright.icore>
 ***************************************************************************************/


package org.krysalis.jcharts.designer;



import org.krysalis.jcharts.Chart;
import org.krysalis.jcharts.properties.PropertyException;
import org.krysalis.jcharts.chartData.ChartDataException;

import javax.swing.*;
import java.awt.*;


public class ChartPanel extends JPanel {

	private Designer designer;
	private Chart chart;


	/***********************************************************************************
	 *
	 * @param designer
	 **********************************************************************************/
	public ChartPanel( Designer designer ) {
		super();

		super.setMinimumSize( new Dimension( 400, 400 ) );
		super.setVisible( true );

		this.designer = designer;
	}


	/**********************************************************************************
	 *
	 * @param chart
	 * @param width
	 * @param height
	 **********************************************************************************/
	public void setChart( Chart chart, int width, int height ) {
		this.chart = chart;
		super.setSize( width, height );
//todo this does not set the size correctly
	}


	/***********************************************************************************
	 *
	 * @param graphics
	 **********************************************************************************/
	public void paint( Graphics graphics ) {
		super.paint( graphics );

		if( this.chart != null ) {
			try {
				this.chart.setGraphics2D( (Graphics2D) graphics );
				this.chart.render();
			}
			catch( ChartDataException chartDataException ) {
				chartDataException.printStackTrace();
			}
			catch( PropertyException propertyException ) {
				propertyException.printStackTrace();
			}
		}
	}


}
