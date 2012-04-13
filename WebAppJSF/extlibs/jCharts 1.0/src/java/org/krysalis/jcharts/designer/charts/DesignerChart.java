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

package org.krysalis.jcharts.designer.charts;


import org.krysalis.jcharts.properties.ChartProperties;
import org.krysalis.jcharts.properties.LegendProperties;

import java.awt.*;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: DesignerChart.java,v 1.1 2003/08/09 17:04:07 nathaniel_auvil Exp $
 ************************************************************************************/
public abstract class DesignerChart
{
	private int width;
	private int height;

	private String title;
	private String[] legendLabels;
	private Paint[] paints;
	private double[][] data;



	private ChartProperties chartProperties;
	private LegendProperties legendProperties;


	/**************************************************************************
	 *
	 * @param width
	 * @param height
	 *************************************************************************/
	public DesignerChart( int width, int height )
	{
		this.width= width;
		this.height= height;

		this.chartProperties= new ChartProperties();
		this.legendProperties= new LegendProperties();
	}


	public ChartProperties getChartProperties()
	{
		return chartProperties;
	}


	public LegendProperties getLegendProperties()
	{
		return legendProperties;
	}


	public int getWidth()
	{
		return width;
	}


	public void setWidth( int width )
	{
		this.width = width;
	}


	public int getHeight()
	{
		return height;
	}


	public void setHeight( int height )
	{
		this.height = height;
	}


	public String getTitle()
	{
		return title;
	}


	public void setTitle( String title )
	{
		this.title = title;
	}


	public String[] getLegendLabels()
	{
		return legendLabels;
	}


	public void setLegendLabels( String[] legendLabels )
	{
		this.legendLabels = legendLabels;
	}


	public Paint[] getPaints()
	{
		return paints;
	}


	public void setPaints( Paint[] paints )
	{
		this.paints = paints;
	}


	public double[][] getData()
	{
		return data;
	}


	public void setData( double[][] data )
	{
		this.data = data;
	}
}
