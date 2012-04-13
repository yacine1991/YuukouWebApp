
package org.krysalis.jcharts.designer;


import org.krysalis.jcharts.chartData.ChartDataException;
import org.krysalis.jcharts.designer.charts.DesignerPieChart;
import org.krysalis.jcharts.designer.exceptions.DesignerException;
import org.krysalis.jcharts.designer.menuBar.DesignerMenuBar;
import org.krysalis.jcharts.designer.tabs.LowerHalfPanel;

import javax.swing.*;


/*******************************************************************************
 * 
 * @author Nathaniel Auvil
 * @version $Id: Designer.java,v 1.2 2004/05/29 13:50:13 nathaniel_auvil Exp $
 ******************************************************************************/
public class Designer extends JFrame
{

	public static final String TITLE = "jCharts Designer - 1.0.0";

	private ChartPanel chartPanel;
	private LowerHalfPanel lowerHalfPanel;

	private DesignerPieChart designerPieChart;
	private org.krysalis.jcharts.axisChart.AxisChart axisChart;


	/****************************************************************************
	 * 
	 * @throws org.krysalis.jcharts.chartData.ChartDataException
	 ***************************************************************************/
	public Designer() throws ChartDataException
	{
		super( TITLE );

		this.designerPieChart = new DesignerPieChart( 450, 450 );

		super.setJMenuBar( new DesignerMenuBar( this ) );
		super.getContentPane().setLayout( new BoxLayout( super.getContentPane(), BoxLayout.Y_AXIS ) );

		this.chartPanel = new ChartPanel( this );
		this.chartPanel.setChart( this.designerPieChart.getPieChart2D(), 500, 500 );

		this.lowerHalfPanel = new LowerHalfPanel( this );

		JScrollPane scrollPane = new JScrollPane( this.chartPanel );
		JSplitPane jSplitPane = new JSplitPane( JSplitPane.VERTICAL_SPLIT, scrollPane, this.lowerHalfPanel );
		jSplitPane.setOneTouchExpandable( true );

		//this.getContentPane().add( jSplitPane, BorderLayout.CENTER );
		this.getContentPane().add( jSplitPane );

		//---so when they click on the 'x' in the upper right corner, the
		// program exits
		super.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		this.pack();
		this.setVisible( true );

		super.setBounds( 30, 30, 600, 600 );
	}


	/****************************************************************************
	 *  
	 ***************************************************************************/
	public void refreshChart()
	{
		try
		{
			this.lowerHalfPanel.getTopLevelTabs().updateChartProperties( this.designerPieChart.getChartProperties() );

			this.designerPieChart.updateChart();
			this.chartPanel.repaint();
		}
		catch( DesignerException designerException )
		{
			designerException.display( this );
		}
		catch( ChartDataException chartDataException )
		{
			JOptionPane.showMessageDialog(	this,
														chartDataException.getMessage(),
														"Chart Data Exception",
														JOptionPane.ERROR_MESSAGE );
		}
	}


	/****************************************************************************
	 *  
	 ***************************************************************************/
	public static void main( String[] args ) throws ChartDataException
	{
		Designer designer = new Designer();

		/*
		 * int width= 450; int height= 450;
		 * 
		 * try { String[] labels = {"BMW", "Audi", "Lexus"}; String title = "Cars
		 * that Own"; Paint[] paints = {Color.blue, Color.gray, Color.red};
		 * double[] data = {50d, 30d, 20d};
		 * 
		 * PieChart2DProperties pieChart2DProperties = new PieChart2DProperties();
		 * PieChartDataSet pieChartDataSet = new PieChartDataSet( title, data,
		 * labels, paints, pieChart2DProperties );
		 * 
		 * PieChart2D pieChart2D = new PieChart2D( pieChartDataSet, new
		 * LegendProperties(), new ChartProperties(), width, height );
		 * 
		 * designer.chartPanel.setChart( pieChart2D, width, height ); } catch(
		 * ChartDataException chartDataException ) {
		 * chartDataException.printStackTrace(); }
		 */
	}
}