/***************************************************************************************
 * File Info: $Id: DesignerMenuBar.java,v 1.1 2003/08/09 17:07:22 nathaniel_auvil Exp $
 *
 * Description:
 *
 * Last Reviewed: NEVER
 * Maintainer: Nathaniel Auvil
 * Copyright: <copyright.icore>
 ***************************************************************************************/

package org.krysalis.jcharts.designer.menuBar;



import org.krysalis.jcharts.designer.Designer;

import javax.swing.*;


public class DesignerMenuBar extends JMenuBar {

	private Designer designer;


	public DesignerMenuBar( Designer designer ) {
		this.designer= designer;



/*
		this.fileMenu = this.addJMenu( "File", KeyEvent.VK_F );
		this.createJMenuItem( "Load File...", KeyEvent.VK_L, new LoadFileAction( this, auditViewer.getAuditTableModel() ), this.fileMenu );

		this.addFileMenuItem= this.createJMenuItem( "Add File...", KeyEvent.VK_A, new AddFileAction( this, auditViewer.getAuditTableModel() ), this.fileMenu );
      this.addFileMenuItem.setEnabled( false );

		this.refreshFileAction= new RefreshFileAction( this, auditViewer.getAuditTableModel() );
		this.reloadFileMenuItem= this.createJMenuItem( "Reload File", KeyEvent.VK_R, this.refreshFileAction, this.fileMenu );
      this.reloadFileMenuItem.setEnabled( false );
*/

	}


}
