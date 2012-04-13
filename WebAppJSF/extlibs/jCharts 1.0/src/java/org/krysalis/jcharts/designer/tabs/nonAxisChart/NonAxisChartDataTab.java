/***************************************************************************************
 * File Info: $Id: NonAxisChartDataTab.java,v 1.1 2003/08/09 17:07:23 nathaniel_auvil Exp $
 *
 * Description:
 *
 * Last Reviewed: NEVER
 * Maintainer: Nathaniel Auvil
 * Copyright: <copyright.icore>
 ***************************************************************************************/

package org.krysalis.jcharts.designer.tabs.nonAxisChart;


import javax.swing.*;


public class NonAxisChartDataTab extends JPanel {

	private NonAxisChartTabs nonAxisChartTab;


	/*******************************************************************************
	 *
	 * @param nonAxisChartTab
	 *******************************************************************************/
	public NonAxisChartDataTab( NonAxisChartTabs nonAxisChartTab ) {
		this.nonAxisChartTab= nonAxisChartTab;

		nonAxisChartTab.addTab( "Data Set", this );

		//this.add( new FontChooser( "Title Font" ) );
	}


}
