package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * <code>EnterKeyListener</code> is a class implements ActionListener. 
 * It plays a role as observer in Observer pattern.  
 * @author A0119391A
 *
 */
class ImportFileButtonListener implements ActionListener {
	
	private Component parent;
	
	
	public ImportFileButtonListener(Component parent) {
		this.parent = parent;
	}

	// once enter key is invoked, user command in the TextField will be sent
	public void actionPerformed(ActionEvent e) {
		JFileChooser chooser = new JFileChooser();
	    FileNameExtensionFilter filter = new FileNameExtensionFilter(
	        "Text Documents", "txt");
	    chooser.setFileFilter(filter);
	    int returnVal = chooser.showOpenDialog(parent);
	    if(returnVal == JFileChooser.APPROVE_OPTION) {
	    	
	    	GuiController.inputFromFile(chooser.getSelectedFile());
	       System.out.println("You chose to open this file: " +
	            chooser.getSelectedFile().getName());
	    }
	   
	}
}