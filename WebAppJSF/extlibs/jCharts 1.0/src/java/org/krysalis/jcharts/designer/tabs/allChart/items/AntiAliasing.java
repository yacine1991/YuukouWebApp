

package org.krysalis.jcharts.designer.tabs.allChart.items;


import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import org.krysalis.jcharts.designer.common.LabelledCheckbox;


public class AntiAliasing extends JPanel
{
	private LabelledCheckbox checkbox;


	/***********************************************************************************
	 *
	 **********************************************************************************/
	public AntiAliasing()
	{
		super();

		super.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( "Anti Aliasing" ),
																			  BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) ) );

		this.setLayout( new FlowLayout() );

		this.checkbox = new LabelledCheckbox( "Use:" );
		this.checkbox.setSelected( true );
		this.add( this.checkbox );
	}


 	/*********************************************************************************
	 *
	 * @return boolean
	 ********************************************************************************/
	public boolean useAntiAliasing()
	{		
		return this.checkbox.isSelected();
	}
}
