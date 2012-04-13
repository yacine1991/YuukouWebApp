

package org.krysalis.jcharts.designer.tabs.allChart.items;


import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.krysalis.jcharts.designer.common.LabelledTextfield;
import org.krysalis.jcharts.designer.exceptions.DesignerException;


public class EdgePadding extends JPanel
{
	private String title;
	private LabelledTextfield padding;


	/***********************************************************************************
	 *
	 * @param title
	 **********************************************************************************/
	public EdgePadding( String title )
	{
		super();
      this.title= title;

		super.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( this.title ),
																			  BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) ) );

		this.setLayout( new FlowLayout() );

		this.padding = new LabelledTextfield( "Pixels:", 4 );
		this.padding.setText( Float.toString( 5 ) );
		this.add( this.padding );
	}


 	/*********************************************************************************
	 *
	 * @return float
	 ********************************************************************************/
	public float getEdgePadding() throws DesignerException
	{
		if( this.padding.getText().trim().equals( "" ) )
		{
			throw new DesignerException( "Edge Padding can not be NULL." );
		}
		
		return Float.parseFloat( this.padding.getText() );
	}
}
