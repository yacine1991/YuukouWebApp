/***************************************************************************************
 * File Info: $Id: PieChartTab.java,v 1.2 2003/09/02 08:48:19 nicolaken Exp $
 *
 * Description:
 *
 * Last Reviewed: NEVER
 * Maintainer: Nathaniel Auvil
 * Copyright: <copyright.icore>
 ***************************************************************************************/

package org.krysalis.jcharts.designer.tabs.nonAxisChart;


import javax.swing.JPanel;

import org.krysalis.jcharts.designer.common.stroke.StrokeChooser;


public class PieChartTab extends JPanel {

	private NonAxisChartTabs nonAxisChartTab;

	private StrokeChooser borderStroke;

	/*******************************************************************************
	 *
	 * @param nonAxisChartTab
	 *******************************************************************************/
	public PieChartTab( NonAxisChartTabs nonAxisChartTab ) {
		this.nonAxisChartTab= nonAxisChartTab;

		nonAxisChartTab.addTab( "Pie Chart", this );

     	this.borderStroke= new StrokeChooser( "Border Stroke" );
	}


}
