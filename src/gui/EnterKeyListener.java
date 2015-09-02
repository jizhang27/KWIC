package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import logic_pipeFilter.Debugger;

/**
 * <code>EnterKeyListener</code> is a class implements ActionListener. 
 * It plays a role as observer in Observer pattern.  
 * @author A0119391A
 *
 */
class EnterKeyListener implements ActionListener {
	
	private JTextField input;
	private final static String EMPTY_STRING = "";
	
	// add input JTextField into list of observation
	public EnterKeyListener(JTextField input) {
		this.input = input;
	}

	// once enter key is invoked, user command in the TextField will be sent
	public void actionPerformed(ActionEvent e) {
		
		String inputCommand =input.getText().trim(); 
		if(!inputCommand.equalsIgnoreCase(EMPTY_STRING)) {
			Debugger.print("input command: " + inputCommand);
			GuiController.AddLine(inputCommand);
			input.setText(EMPTY_STRING);
		}

	}
}