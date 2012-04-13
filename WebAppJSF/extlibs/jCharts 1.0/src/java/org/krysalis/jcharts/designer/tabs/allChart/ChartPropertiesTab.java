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


package org.krysalis.jcharts.designer.tabs.allChart;


import javax.swing.JPanel;

import org.krysalis.jcharts.designer.common.font.FontChooser;
import org.krysalis.jcharts.designer.common.stroke.StrokeChooser;
import org.krysalis.jcharts.designer.exceptions.DesignerException;
import org.krysalis.jcharts.designer.tabs.allChart.items.EdgePadding;
import org.krysalis.jcharts.properties.ChartProperties;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: ChartPropertiesTab.java,v 1.3 2004/05/25 01:03:04 nathaniel_auvil Exp $
 ************************************************************************************/
public class ChartPropertiesTab extends JPanel
{
	private AllChartTabs allChartTabs;

	private FontChooser titleFont;
	private StrokeChooser borderStroke;
	private EdgePadding edgePadding;


	/************************************************************************************
	 *
	 * @param allChartTabs
	 ***********************************************************************************/
	public ChartPropertiesTab( AllChartTabs allChartTabs )
	{
		super();
		this.allChartTabs = allChartTabs;

		allChartTabs.addTab( "Chart Properties", this );

		this.titleFont= new FontChooser( "Title Font" );
		this.add( this.titleFont );

		this.borderStroke= new StrokeChooser( "Border Stroke" );
		this.add( this.borderStroke );
		
		this.edgePadding= new EdgePadding( "Edge Padding" );
		this.add( this.edgePadding );
	}


	/******************************************************************
	 * 
	 * @param chartProperties
	 * @throws DesignerException
	 *****************************************************************/
	public void updateChartProperties( ChartProperties chartProperties ) throws DesignerException
	{
		chartProperties.setTitleFont( this.titleFont.getChartFont() );
		chartProperties.setBorderStroke( this.borderStroke.getChartStroke() );
		chartProperties.setEdgePadding( this.edgePadding.getEdgePadding() );
		
		//TODO add more stuff
	}
}
