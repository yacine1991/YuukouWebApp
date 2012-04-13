/***************************************************************************************
 * File Info: $Id: NonAxisChartTabs.java,v 1.1 2003/08/09 17:07:23 nathaniel_auvil Exp $
 *
 * Description:
 *
 * Last Reviewed: NEVER
 * Maintainer: Nathaniel Auvil
 * Copyright: <copyright.icore>
 ***************************************************************************************/

package org.krysalis.jcharts.designer.tabs.nonAxisChart;


import org.krysalis.jcharts.designer.tabs.TopLevelTabs;

import javax.swing.*;


public class NonAxisChartTabs extends JTabbedPane {

	private TopLevelTabs topLevelTabs;

	private NonAxisChartDataTab nonAxisChartDataTab;
	private PieChartTab pieChartTab;


	/*******************************************************************************
	 *
	 * @param topLevelTabs
	 *******************************************************************************/
	public NonAxisChartTabs( TopLevelTabs topLevelTabs ) {
		this.topLevelTabs= topLevelTabs;
		this.topLevelTabs.addTab( "Non Axis Charts", this );

		this.nonAxisChartDataTab= new NonAxisChartDataTab( this );
		this.pieChartTab= new PieChartTab( this );
	}


}
