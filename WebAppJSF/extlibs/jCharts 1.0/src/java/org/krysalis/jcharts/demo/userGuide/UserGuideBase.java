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


import java.io.FileOutputStream;

import org.krysalis.jcharts.Chart;
import org.krysalis.jcharts.encoders.PNGEncoder;


/*************************************************************************************
 *
 * @author Nathaniel Auvil
 * @version $Id: UserGuideBase.java,v 1.5 2003/09/03 02:40:13 nathaniel_auvil Exp $
 ************************************************************************************/
public class UserGuideBase
{
   private static String path= "./src/documentation/resources/images/userGuide/";
	private static String subdir;


	/*******************************************************************************************
	 *
	 *
	 ******************************************************************************************/
	public static void main( String[] args ) throws Throwable
	{
		if( args.length > 2 )
		{
			System.out.println( "Usage - java UserGuideBase <whatToRun>" );
			return;
		}
		else
		{
			if( args.length == 1 )
			{
				String whatToRun = args[0];
            System.out.println( "running user guide charts for section: " + whatToRun );

				if( whatToRun.equals( "all" ) )
				{
					UserGuideBase.subdir= "allCharts/";
					AllChartsGuide allCharts = new AllChartsGuide();
					allCharts.run();
				}

				if( whatToRun.equals( "legend" ) )
				{
					UserGuideBase.subdir= "legends/";
					LegendsGuide legends = new LegendsGuide();
					legends.run();
				}

				if( whatToRun.equals( "stock" ) )
				{
					UserGuideBase.subdir= "allCharts/";
					StockChartsGuide stockCharts = new StockChartsGuide();
					stockCharts.run();
				}

				if( whatToRun.equals( "pie" ) )
				{
					UserGuideBase.subdir= "pieCharts/";
					PieChartsGuide pieChart = new PieChartsGuide();
					pieChart.run();
				}

				if( whatToRun.equals( "pie3d" ) )
				{
					UserGuideBase.subdir= "pieChart3d/";
					PieChart3DGuide pieChart3D = new PieChart3DGuide();
					pieChart3D.run();
				}

				if( whatToRun.equals( "axis" ) )
				{
					UserGuideBase.subdir= "axisCharts/";
					AxisChartsGuide axisCharts = new AxisChartsGuide();
					axisCharts.run();
				}

				if( whatToRun.equals( "area" ) )
				{
					UserGuideBase.subdir= "areaCharts/";
					AreaChartsGuide areaCharts = new AreaChartsGuide();
					areaCharts.run();
				}

				if( whatToRun.equals( "bar" ) )
				{
					UserGuideBase.subdir= "barCharts/";
					BarChartsGuide barCharts = new BarChartsGuide();
					barCharts.run();
				}

				if( whatToRun.equals( "line" ) )
				{
					UserGuideBase.subdir= "lineCharts/";
					LineChartsGuide lineCharts = new LineChartsGuide();
					lineCharts.run();
				}

				if( whatToRun.equals( "point" ) )
				{
					UserGuideBase.subdir= "pointCharts/";
					PointChartsGuide pointCharts = new PointChartsGuide();
					pointCharts.run();
				}

				if( whatToRun.equals( "combo" ) )
				{
					UserGuideBase.subdir= "comboCharts/";
					ComboChartsGuide comboCharts = new ComboChartsGuide();
					comboCharts.run();
				}
			}
			else
			{
				AllChartsGuide allCharts = new AllChartsGuide();
				allCharts.run();

				LegendsGuide legends = new LegendsGuide();
				legends.run();

				StockChartsGuide stockCharts = new StockChartsGuide();
				stockCharts.run();

				PieChartsGuide pieChart = new PieChartsGuide();
				pieChart.run();

				PieChart3DGuide pieChart3d = new PieChart3DGuide();
				pieChart3d.run();

				AxisChartsGuide axisCharts = new AxisChartsGuide();
				axisCharts.run();

				AreaChartsGuide areaCharts = new AreaChartsGuide();
				areaCharts.run();

				BarChartsGuide barCharts = new BarChartsGuide();
				barCharts.run();

				LineChartsGuide lineCharts = new LineChartsGuide();
				lineCharts.run();

				PointChartsGuide pointCharts = new PointChartsGuide();
				pointCharts.run();

				ComboChartsGuide comboCharts = new ComboChartsGuide();
				comboCharts.run();
			}
		}
	}


	/******************************************************************************************
	 * Utility method to write the image to file so I do not have to deal with file i/o
	 *  every time I write a demo.
	 *
	 * @param chart everything that is renderable extends this class.
	 * @param fileName what to name the file
	 ******************************************************************************************/
	void exportImage( Chart chart, String fileName )
	{
		String extension = ".png";
		FileOutputStream fileOutputStream;

		try
		{
			fileOutputStream = new FileOutputStream( UserGuideBase.path + UserGuideBase.subdir + fileName + extension );
			PNGEncoder.encode( chart, fileOutputStream );
			//JPEGEncoder13.encode( chart, 1.0f, fileOutputStream );
			fileOutputStream.flush();
			fileOutputStream.close();
		}
		catch( Throwable throwable )
		{
			throwable.printStackTrace();
		}
	}
}