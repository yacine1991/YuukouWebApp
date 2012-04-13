/***************************************************************************************
 * File Info: $Id: AxisChartTabs.java,v 1.1 2003/08/09 17:07:23 nathaniel_auvil Exp $
 *
 * Description:
 *
 * Last Reviewed: NEVER
 * Maintainer: Nathaniel Auvil
 * Copyright: <copyright.icore>
 ***************************************************************************************/

package org.krysalis.jcharts.designer.tabs.axisChart;


import org.krysalis.jcharts.designer.tabs.TopLevelTabs;

import javax.swing.*;


public class AxisChartTabs extends JTabbedPane {

	private TopLevelTabs topLevelTabs;



	/*******************************************************************************
	 *
	 * @param topLevelTabs
	 ******************************************************************************/
	public AxisChartTabs( TopLevelTabs topLevelTabs ) {
		this.topLevelTabs= topLevelTabs;
      this.topLevelTabs.addTab( "Axis Charts", this );
	}

}
