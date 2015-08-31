package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * <code>EnterKeyListener</code> is a class implements ActionListener. 
 * It plays a role as observer in Observer pattern.  
 * @author A0119391A
 *
 */
class EditIgnoredWordKeyListener implements ActionListener {
	
	private String currentWords;
	private final static String EMPTY_STRING = "";
	
	

	// once enter key is invoked, user command in the TextField will be sent
	public void actionPerformed(ActionEvent e) {
		
		JFrame frame = new JFrame("InputDialog Example #1");
		String words = JOptionPane.showInputDialog(frame, "Ignored word list (keyword seperated by space)", GuiController.getIgnoredWord());
		if(words != null) {
			GuiController.editIgnoredWord(words); 
		}
		

	}
}