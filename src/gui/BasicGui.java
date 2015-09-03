package gui;


import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**re:Enter your command here:
 * class BasicGUI: contains the all visual composition and structure of GUI
 * 
 * <p>
 * GUI is mainly constructs by 3 main container: MeunuArea(for butns),
 * MainArea(for main) and ControlArea(for input) And inside each container,
 * there exist a hierarchy of container and field. All components contribute to
 * the appearance and layout of GUI. In particular, components inside mainPanel
 * are substitutable, which allows the customization to some extent.
 * 
 * <p>
 * <strong>Note</strong>: singleton pattern is applied in this class.
 * 
 */
public class BasicGui extends JFrame {

	/*
	 * ====================================================================
	 * ===================== START OF PRIVATE FIELD =======================
	 * ====================================================================
	 */

	private static final long serialVersionUID = 1L;
	// instance of BasicGui
	private static BasicGui instance;

	// all relevant components
	private JPanel menuArea;
	private JPanel titlePanel;
	private JTextField titleWindow;
	private JButton editIngoredWordBtn;
	private JButton toggleModeBtn;
	private JButton fileImportBtn;

	private JPanel mainArea;
	private JPanel mainPanel;
	private JPanel contentPanel;
	private JPanel inputPanel;
	
	private JScrollPane scrollPane;
	private JTextArea resultWindow;

	private JFrame modalDialog;
	
	private JTextField inputWindow;

	// constants for component size (unit in pixel)
	private final static int TOP_LEFT_X_VALUE = 100;
	private final static int TOP_LEFT_Y_VALUE = 100;
	private final static int FRAME_WIDTH = 1000;
	private final static int FRAME_HEIGHT = 640;
	private final static int MINIMUM_FRAME_WIDTH = 1000;
	private final static int MINIMUM_FRAME_HEIGHT = 640;

	private final static int MENU_AREA_WIDTH = FRAME_WIDTH;
	private final static int MENU_AREA_HEIGHT = 50;
	
	private final static int INPUT_AREA_WIDTH = FRAME_WIDTH/2;
	private final static int INPUT_AREA_HEIGHT = 30;

	String switchBtn_pipeFilter = "Switch to Pipe & Filter Architecture";
	String switchBtn_ImplicitInvocation = "Switch to Implicit Invocation Architecture";
	String inputWindowHelperText = "Add a new line here & hit enter key";
	// color info
	private final static Color COLOR_TITLE_WINDOW_BACK = Color.WHITE;
	private final static Color COLOR_TITLE_WINDOW_FORE = new Color(66, 161,
			223, 220);
	private final static Color COLOR_TITLE_WINDOW_BORDER = new Color(66, 161,
			223, 255);
	// font info
	private final static Font FONT_MAIN_WINDOW = new Font("Calibri",
			Font.PLAIN, 29);
	
	
	//all available keyboard shortcut
	private String[] keyboardShortcut = {"F1", "F2","F3","F4","F5", "F6"};

	/*
	 * ====================================================================
	 * ===================== END OF PRIVATE FIELD =========================
	 * ====================================================================
	 */

	/*
	 * ====================================================================
	 * ===================== START OF PUBLIC METHOD =======================
	 * ====================================================================
	 */
	

	public static BasicGui getInstance() {
		if (instance == null) {
			instance = new BasicGui();
		}
		return instance;
	}

	public void setTitleText(String text) {
		titleWindow.setText(text);
	}




	public void refreshMainPanel() {
		mainPanel.validate();
	}

	/*
	 * ====================================================================
	 * ===================== END OF PUBLIC METHOD =========================
	 * ====================================================================
	 */

	/*
	 * ====================================================================
	 * ===================== START OF Private METHOD =======================
	 * ====================================================================
	 */

	/**
	 * method BasicGUI: constructor of GUI. It is private as the singleton
	 * pattern is applied.
	 */
	private BasicGui() {
		constructFrame();
		constructContentPanel();

		constructMenuArea();
		constructTitlePanel();
		constructTitleWindow();

		constructMainArea();
		constructMainPanel();
		
		
		constructResultWindow();

		constructscrollPanel();
		constructInputPanel();
		constructInputWindow();
		constructModalDialog();
		
		validate();
	}

	
	private void constructFrame() {

		setRootPaneCheckingEnabled(false);
		//setType(Type.UTILITY);
		setModalExclusionType(ModalExclusionType.TOOLKIT_EXCLUDE);
		getContentPane().setFocusTraversalPolicyProvider(true);
		setVisible(true);
	}

	private void constructContentPanel() {
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setMinimumSize(new Dimension(MINIMUM_FRAME_WIDTH,
				MINIMUM_FRAME_HEIGHT));
		setBounds(TOP_LEFT_X_VALUE, TOP_LEFT_Y_VALUE, FRAME_WIDTH, FRAME_HEIGHT);
	}

	private void constructMenuArea() {
		menuArea = new JPanel();
		menuArea.setOpaque(true);
		menuArea.setPreferredSize(new Dimension(MENU_AREA_WIDTH,
				MENU_AREA_HEIGHT));
		menuArea.setLayout(new BorderLayout(0, 0));

		getContentPane().add(menuArea, BorderLayout.NORTH);
	}

	private void constructTitlePanel() {
		titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.setOpaque(true);

		menuArea.add(titlePanel, BorderLayout.CENTER);
	}

	private void constructTitleWindow() {
		editIngoredWordBtn = new JButton("Edit Igored Words");
		toggleModeBtn = new JButton(switchBtn_pipeFilter);
		
		editIngoredWordBtn.addActionListener(new EditIgnoredWordKeyListener());
		toggleModeBtn.addActionListener(new ToggleModeButtonListener());

		titlePanel.add(toggleModeBtn);
		titlePanel.add(editIngoredWordBtn);
	}

	private void constructMainArea() {
		mainArea = new JPanel();
		mainArea.setOpaque(true);
		mainArea.setLayout(new BorderLayout(0, 0));
		Dimension d = new Dimension(FRAME_WIDTH, FRAME_HEIGHT - MENU_AREA_HEIGHT);
		//mainArea.setBorder(BorderFactory.createLineBorder(Color.red, 1));
		mainArea.setSize(d);
		mainArea.setMinimumSize(d);
		mainArea.setMaximumSize(d);

		getContentPane().add(mainArea, BorderLayout.CENTER);

	}

	private void constructMainPanel() {
		mainPanel = new JPanel();
		mainPanel.setRequestFocusEnabled(false);
		mainPanel.setOpaque(false);
		
		
		mainPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		mainPanel.setBorder(null);
		mainPanel.setLayout(new BorderLayout(0, 0));

		mainArea.add(mainPanel, BorderLayout.WEST);
		
		
		
	}

	

	private void constructResultWindow() {
		resultWindow = new JTextArea();
		resultWindow.setEnabled(false);
//		resultWindow.setLineWrap(true);
		//resultWindow.setWrapStyleWord(true);
		resultWindow.setBorder(BorderFactory.createLineBorder(Color.blue, 1));
		resultWindow.setText("Result:");
//		Dimension d = new Dimension(mainArea.getSize().width/2,mainArea.getSize().height);
//		resultWindow.setMinimumSize(d);
//		resultWindow.setMaximumSize(d);
//		resultWindow.setPreferredSize(d);
//		resultWindow.setOpaque(false);
		//resultWindow.setBorder(null);
		
		
		JScrollPane sp = new JScrollPane(resultWindow);
		sp.setVisible(true);
		Dimension d = new Dimension(mainArea.getSize().width/2,mainArea.getSize().height);
		sp.setMinimumSize(d);
		sp.setMaximumSize(d);
		sp.setPreferredSize(d);
		sp.setAutoscrolls(true);
		sp.validate();
		// Add the scroll pane into the content pane
		mainArea.add(sp, BorderLayout.EAST);
		
		
	}
	
	private void constructscrollPanel() {
		
		contentPanel = new JPanel();
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.PAGE_AXIS));
		
		scrollPane = new JScrollPane(contentPanel);
		scrollPane.setBorder(BorderFactory.createLineBorder(Color.green, 1));
		Dimension d = new Dimension(FRAME_WIDTH/2, FRAME_HEIGHT - MENU_AREA_HEIGHT);
		
		scrollPane.setSize(d);
		scrollPane.setMinimumSize(d);
		scrollPane.setMaximumSize(d);
		scrollPane.setPreferredSize(d);
		scrollPane.setAlignmentX(LEFT_ALIGNMENT);
		scrollPane.setAutoscrolls(true);
		
		mainPanel.add(scrollPane, BorderLayout.CENTER);
	}



	private void constructInputPanel() {
		Dimension d = new Dimension(INPUT_AREA_WIDTH, INPUT_AREA_HEIGHT);
		
		inputPanel = new JPanel();
		inputPanel.setMinimumSize(d);
		inputPanel.setMaximumSize(d);
		inputPanel.setSize(d);
		inputPanel.setPreferredSize(d);
		inputPanel.setLayout(new BorderLayout());
		mainPanel.add(inputPanel, BorderLayout.SOUTH);
	}

	private void constructInputWindow() {
		
		
		
		fileImportBtn = new JButton("import");
		fileImportBtn.addActionListener(new ImportFileButtonListener(this));
		inputPanel.add(fileImportBtn,  BorderLayout.WEST);

		inputWindow = new JTextField();
		inputWindow.setOpaque(true);
//		inputWindow.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		inputWindow.setText(inputWindowHelperText);
		inputWindow.selectAll();
		inputWindow.addActionListener(new EnterKeyListener(inputWindow));
			
		inputPanel.add(inputWindow, BorderLayout.CENTER);
		inputWindow.requestFocus();
		
		
		
		
		
	}



	/*
	 * ====================================================================
	 * ===================== END OF PRIVATE FIELD =========================
	 * ====================================================================
	 */
	
	public void clearResult() {
		resultWindow.setText("");
	}
	public void updateResult(String res) {
		resultWindow.setText(res);
	}
	public void addInputLine(String text, int key) {
		InputLine line = new InputLine(text, key, contentPanel.getWidth(), 30);
		contentPanel.add(line);
		contentPanel.updateUI();
		
		
	}
	public void removeInputLine(InputLine line) {
		contentPanel.remove(line);
		contentPanel.updateUI();
		
	}
	
	public void clearInputLine() {
		contentPanel.removeAll();
		contentPanel.updateUI();
		
	}
	
	public void setToggleButtonLabel(boolean isPipeFilter) {
		if(isPipeFilter) {
			toggleModeBtn.setText(switchBtn_ImplicitInvocation);
		} else  {
			toggleModeBtn.setText(switchBtn_pipeFilter);
		}
	}
	private void constructModalDialog() {
		modalDialog = new JFrame("In Progress");
		modalDialog.setBounds(100, 200, 800, 400);
		modalDialog.setLayout(new BorderLayout());
		JLabel l = new JLabel("Calculation in progress, please wait! Calculation in progress, please wait!Calculation in progress, please wait! Calculation in progress, please wait!Calculation in progress, please wait! Calculation in progress, please wait!");
		modalDialog.add(l, BorderLayout.CENTER);

	}
	public void showModalDialog() {
				modalDialog.setVisible(true);
		modalDialog.requestFocus();
	}
	
	public void dismissModalDialog() {
		modalDialog.setVisible(false);
	}
	 

	public String getAllLines() {
		String output="";
		int count = contentPanel.getComponentCount();
		for(int i=0; i<count; i++) {
			Component comp  = contentPanel.getComponent(i);
			if (comp instanceof  InputLine)  {
				output += ((InputLine)comp).getValue() + "\n";
			}
			
		}
		
		return output;
	}
}
