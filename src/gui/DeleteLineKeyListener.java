package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 * <code>EnterKeyListener</code> is a class implements ActionListener. 
 * It plays a role as observer in Observer pattern.  
 * @author A0119391A
 *
 */
class DeleteLineKeyListener implements ActionListener {
	
	private InputLine l;
	private final static String EMPTY_STRING = "";
	
	// add input JTextField into list of observation
	public DeleteLineKeyListener(InputLine l) {
		this.l = l;
	}

	// once enter key is invoked, user command in the TextField will be sent
	public void actionPerformed(ActionEvent e) {
		
		GuiController.deleteLine(l);

	}
}