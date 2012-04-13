

package org.krysalis.jcharts.designer.common.font;


import org.krysalis.jcharts.designer.common.LabelledCombo;
import org.krysalis.jcharts.designer.common.LabelledTextfield;
import org.krysalis.jcharts.designer.exceptions.DesignerException;
import org.krysalis.jcharts.properties.util.ChartFont;

import javax.swing.*;
import java.awt.*;


public class FontChooser extends JPanel
{
	private static String[] ALL_FONT_NAMES;
	static
	{
		Font[] allFonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
		ALL_FONT_NAMES = new String[ allFonts.length ];

		for( int i = 0; i < allFonts.length; i++ )
		{
			ALL_FONT_NAMES[ i ] = allFonts[ i ].getName();
		}
	}


	private String title;
	private LabelledCombo fontCombo;
	private LabelledTextfield size;
	private LabelledCombo styleCombo;


	/***********************************************************************************
	 *
	 * @param title
	 **********************************************************************************/
	public FontChooser( String title )
	{
		super();
      this.title= title;

		super.setBorder( BorderFactory.createCompoundBorder( BorderFactory.createTitledBorder( this.title ),
																			  BorderFactory.createEmptyBorder( 5, 5, 5, 5 ) ) );

		this.setLayout( new FlowLayout() );

		this.fontCombo = new LabelledCombo( "Name:", ALL_FONT_NAMES );
		this.add( this.fontCombo );

		this.size= new LabelledTextfield( "Size:", 3 );
		this.size.setText( "12" );
		this.add( this.size );

		this.styleCombo= new StylesCombo();
		this.add( this.styleCombo );
	}


 	/*********************************************************************************
	 *
	 * @return ChartFont
	 ********************************************************************************/
	public ChartFont getChartFont() throws DesignerException
	{
		if( this.size.getText().trim().equals( "" ) )
		{
			throw new DesignerException( "Title Font size can not be NULL." );
		}


		Font font= new Font( this.fontCombo.getSelected(), this.styleCombo.getSelectedIndex(), Integer.parseInt( this.size.getText() ) );
//todo Paint implementation?
      ChartFont chartFont= new ChartFont( font, Color.black );
		return chartFont;
	}
}
