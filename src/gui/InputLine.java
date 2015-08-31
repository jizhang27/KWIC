package gui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class InputLine extends JPanel {
	private JTextField content; 
	private JButton deleteBtn;
	private int key;
	private BasicGui gui;
	
	public InputLine(BasicGui gui, String s, int k) {
		this.gui = gui;
		this.setLayout(new FlowLayout());
		this.content = new JTextField(s);
		this.deleteBtn = new JButton("del");
		this.key = k;
		this.setBorder(BorderFactory.createLineBorder(Color.green, 1));
		
		deleteBtn.addActionListener(new DeleteLineKeyListener(this) );
		
		this.add(this.content);
		this.add(this.deleteBtn);
		
		
	}
}
