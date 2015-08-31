package gui;

import logic_pipeFilter.Master;



public class GuiController {
	private static BasicGui gui;
	private static boolean isPipeFilterMode = true;
//	private Master pipeFilterMaster;
	
	// start point of the whole program 
		public static void main(String[] args) {
			run(isPipeFilterMode);
		}
		
		private static void run(boolean mode) {
			
			gui = BasicGui.getInstance();
			gui.setToggleButtonLabel(isPipeFilterMode);
		}
		
		public static void AddLine(String s) {
			
		}
		
		public static void deleteLine(InputLine l) {
			gui.removeInputLine(l);
			
		}
		
		public static void editIgnoredWord(String words) {
			
		}
		
		public static String getIgnoredWord() {
			return "fake";
			
		}
		
		public static void toggleMode() {
			isPipeFilterMode =  !isPipeFilterMode;
			run(isPipeFilterMode);
		}
}
