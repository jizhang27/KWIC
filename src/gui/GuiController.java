package gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import logic_abstractDataType.MainLogic;
import logic_abstractDataType.MasterControl;
import logic_pipeFilter.Debugger;
import logic_pipeFilter.Master;

public class GuiController {
	private static BasicGui gui;
	private static boolean isPipeFilterMode = true;
	private static MainLogic logic;
	
	// start point of the whole program 
		public static void main(String[] args) {
			reInitialize(isPipeFilterMode);
		}
		
		private static void updateGui() {
			logic.calculate();
			gui.updateResult(logic.getOutput());
		}
		
		private static void reInitialize(boolean mode) {
			
			gui = BasicGui.getInstance();
			gui.setToggleButtonLabel(mode);
			if(mode) {
				logic = new Master();
			} else {
				//System.out.println("unimplemented yet");
				logic = new MasterControl();
			}
			logic.initialize();

		}
		
		public static void AddLine(String s) {
			gui.showModalDialog();
			int key = logic.getKey();
			gui.addInputLine(s, key);
			if(isPipeFilterMode) {
				logic.run(0, gui.getAllLines(), key);
			} else {
				logic.run(1, s, key);
			}
			updateGui();
			gui.dismissModalDialog();
			
		}
		
		public static void deleteLine(InputLine l) {
			gui.showModalDialog();
			gui.removeInputLine(l);
			if(isPipeFilterMode) {
				logic.run(0, gui.getAllLines(), 0);
			} else {
				logic.run(3, l.getValue(), l.getKey());
			}
			updateGui();
			gui.dismissModalDialog();
		}
		
		public static void editIgnoredWord(String words) {
			gui.showModalDialog();
			logic.editIgnoreWord(words);
			updateGui();
			gui.dismissModalDialog();
		}
		
		public static String getIgnoredWord() {
			return logic.getIgnoreWordList();
			
		}
		public static void inputFromFile(File f) {
			 
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				 StringBuilder sb = new StringBuilder();
				    String line = br.readLine().trim();

				    gui.showModalDialog();
				    while (line != null ) {
				    	if(!line.equalsIgnoreCase("")) {
				    		sb.append(line);
					        sb.append(System.lineSeparator());
					        int key = logic.getKey();
					        gui.addInputLine(line, key);
					        if(!isPipeFilterMode) {
					        	
						    	logic.run(1, line, key);
						    	
						    }
				    	}
				        line = br.readLine();
				        
				    }
				    
				    gui.dismissModalDialog();
				    String everything = sb.toString();
				    Debugger.print(everything);
				    if(isPipeFilterMode) {
				    	gui.showModalDialog();
				    	logic.run(0, everything, 0);
				    	
				    	gui.dismissModalDialog();
				    	
				    }  
				    updateGui();
				    br.close();
				    
				    
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
			

		}
		public static void toggleMode() {
			isPipeFilterMode =  !isPipeFilterMode;
			reInitialize(isPipeFilterMode);
			gui.clearInputLine();
			gui.clearResult();
		}
		
		
}
