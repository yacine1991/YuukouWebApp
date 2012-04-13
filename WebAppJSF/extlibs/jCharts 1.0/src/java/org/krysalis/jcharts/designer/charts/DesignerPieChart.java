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


import org.krysalis.jcharts.nonAxisChart.PieChart2D;
import org.krysalis.jcharts.properties.PieChart2DProperties;
import org.krysalis.jcharts.chartData.PieChartDataSet;
import org.krysalis.jcharts.chartData.ChartDataException;

import java.awt.*;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: DesignerPieChart.java,v 1.1 2003/08/09 17:04:07 nathaniel_auvil Exp $
 ************************************************************************************/
public class DesignerPieChart extends DesignerChart
{
	private PieChart2D pieChart2D;
   private PieChart2DProperties pieChart2DProperties;
   private PieChartDataSet pieChartDataSet;


	/**********************************************************************************
	 *
	 * @param width
	 * @param height
	 * @throws ChartDataException
	 *********************************************************************************/
	public DesignerPieChart( int width, int height ) throws ChartDataException
	{
		super( width, height );

		this.pieChart2DProperties = new PieChart2DProperties();

		super.setTitle( "Cars that Own" );
		super.setLegendLabels( new String[]{"BMW", "Audi", "Lexus"} );
		super.setPaints( new Paint[]{ Color.blue, Color.gray, Color.red } );
		super.setData( new double[][]{ {50d, 30d, 20d} } );

		this.updateChart();
	}


	/***************************************************************************************
	 * Updates the chart Object with all the latest settings.
	 *
	 * @throws ChartDataException
	 **************************************************************************************/
   public void updateChart() throws ChartDataException
	{
      this.pieChartDataSet = new PieChartDataSet( super.getTitle(),
																  super.getData()[ 0 ],
																  super.getLegendLabels(),
																  super.getPaints(),
																  this.pieChart2DProperties );

		this.pieChart2D= new PieChart2D( pieChartDataSet,
													super.getLegendProperties(),
													super.getChartProperties(),
													super.getWidth(),
													super.getHeight() );
	}


	public PieChart2D getPieChart2D()
	{
		return this.pieChart2D;
	}


	public PieChart2DProperties getPieChart2DProperties()
	{
		return pieChart2DProperties;
	}
}
