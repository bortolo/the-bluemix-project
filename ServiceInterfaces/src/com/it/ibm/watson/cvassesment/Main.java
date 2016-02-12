package com.it.ibm.watson.cvassesment;

public class Main {

	public static void main(String[] args) {
	    //Schedule a job for the event-dispatching thread:
	    //creating and showing this application's GUI.
		
		ServiceCatalog catalog = new ServiceCatalog();
		
		/*GlobalPanel mainpanel = new GlobalPanel();*/
		
	    javax.swing.SwingUtilities.invokeLater(new Runnable() {
	        public void run() {
	             catalog.createAndShowGUI();
	        }
	    });
	}

}
