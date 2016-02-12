package com.it.ibm.watson.cvassesment;

import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

/*
 * GlobalPanel put together all the panels related to a service
 */
public class GlobalPanel extends JPanel {

	public GlobalPanel(int service) {

		super(new GridLayout(1, 0));

		if(service==0)
		{
		// First pane: Analysis settings
		InfoPanel infoFace = new InfoPanel("CV assessment Service","Automazione, velocità...i CV non saranno mai più un problema!");
		CVSettingsPanel setAnalysis = new CVSettingsPanel();
		BluemixServicesPanel setServers = new BluemixServicesPanel();
		// Build all together the panes
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("CV Info panel", null, infoFace, null);
		tabbedPane.addTab("CV analysis settings", null, setAnalysis, null);
		tabbedPane.addTab("Bluemix server settings", null, setServers, null);
		tabbedPane.setSelectedIndex(0);
		add(tabbedPane);
		}
		
		if(service==1)
		{
		// First pane: Analysis settings
		InfoPanel infoFace = new InfoPanel("Face recognition Service","Le nuove frontiere dell'indovina chi...by Watson");
		BluemixServicesPanel setServers = new BluemixServicesPanel();
		// Build all together the panes
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Face recogniton Info panel", null, infoFace, null);
		tabbedPane.addTab("Bluemix server settings", null, setServers, null);
		tabbedPane.setSelectedIndex(0);
		add(tabbedPane);
		}
		
		if(service==2)
		{
		// First pane: Analysis settings
		InfoPanel infoFace = new InfoPanel("Watson service","Ci proponiamo di automatizzare l'analisi del SESDR utilizzando Watson Analytics");
		BluemixServicesPanel setServers = new BluemixServicesPanel();
		// Build all together the panes
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("Watson service info panel", null, infoFace, null);
		tabbedPane.addTab("Bluemix server settings", null, setServers, null);
		tabbedPane.setSelectedIndex(0);
		add(tabbedPane);
		}
		
		if(service==3)
		{
		// First pane: Analysis settings
		InfoPanel infoFace = new InfoPanel("IoT Service","Tanti bellissimi esperimenti con IoT");
		BluemixServicesPanel setServers = new BluemixServicesPanel();
		// Build all together the panes
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.addTab("IoT service Info panel", null, infoFace, null);
		tabbedPane.addTab("Bluemix server settings", null, setServers, null);
		tabbedPane.setSelectedIndex(0);
		add(tabbedPane);
		}
	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public void createAndShowGUI(int service) {
		// Create and set up the window.
		JFrame frame = new JFrame("General Interface for Bluemix Services");
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		GlobalPanel newContentPane = new GlobalPanel(service);
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}

}
