package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import logic_pipeFilter.Debugger;

public class InputLine extends JPanel {
	private String value;
	private JLabel content; 
	private JButton deleteBtn;
	private int key;
	
	public InputLine( String s, int k, int width, int height) {
		Debugger.print("is input constructor called");
		this.value = s;
		Dimension d = new Dimension(width,height);
//		this.setMaximumSize(d);
//		this.setMinimumSize(d);
//		this.setPreferredSize(d);
		//content.setEditable(false);
		this.setLayout(new FlowLayout(FlowLayout.LEFT));
		this.content = new JLabel(value);
		this.deleteBtn = new JButton("del");
		content.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		this.key = k;
		this.setOpaque(false);
		this.setBorder(BorderFactory.createLineBorder(Color.green, 1));
		
		deleteBtn.addActionListener(new DeleteLineKeyListener(this) );
		
		this.add(this.deleteBtn);
		this.add(this.content);
		
		this.setVisible(true);
		
		
	}
	public String getValue() {
		return value;
	}
	public int getKey() {
		return key;
	}
}
