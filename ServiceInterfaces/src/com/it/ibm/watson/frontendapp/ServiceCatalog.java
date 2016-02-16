package com.it.ibm.watson.frontendapp;

import java.awt.event.*;

import javax.swing.*;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.it.ibm.watson.cvassesment.DocumentConversionConfig;
import com.it.ibm.watson.cvassesment.PersonalityInsightConfig;

import java.awt.*;

public class ServiceCatalog extends JPanel implements ActionListener {

	private JButton CVassessment;
	private JButton FaceRecognition;
	private JButton WatsonSesdr;
	private JButton IoTexperiment;

	private GlobalPanel CVservice;
	private GlobalPanel FaceRecon;
	private GlobalPanel Watson;
	private GlobalPanel IoTexp;


	public ServiceCatalog() {


		CVassessment = new JButton();
		CVassessment.setText("CV assessment service");
		CVassessment.addActionListener(this);
		CVassessment.setPreferredSize(new Dimension(500, 50));

		FaceRecognition = new JButton();
		FaceRecognition.setText("Face Recognition service");
		FaceRecognition.addActionListener(this);
		FaceRecognition.setPreferredSize(new Dimension(500, 50));

		WatsonSesdr = new JButton();
		WatsonSesdr.setText("Watson SESDR service");
		WatsonSesdr.addActionListener(this);
		WatsonSesdr.setPreferredSize(new Dimension(500, 50));

		IoTexperiment = new JButton();
		IoTexperiment.setText("IoT for everyone service");
		IoTexperiment.addActionListener(this);
		IoTexperiment.setPreferredSize(new Dimension(500, 50));

		formatLayout();
	}

	public void formatLayout() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 1, 1);

		this.add(CVassessment, c);
		c.gridx = 1;
		this.add(FaceRecognition, c);
		c.gridx = 0;
		c.gridy = 1;
		this.add(WatsonSesdr, c);
		c.gridx = 1;
		this.add(IoTexperiment, c);

	}

	// Determine action of panel buttons
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == CVassessment) {
			GlobalPanel CVservice = new GlobalPanel(0);
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					CVservice.createAndShowGUI(0);
				}
			});
		}

		if (e.getSource() == FaceRecognition) {
			GlobalPanel FaceRecon = new GlobalPanel(1);
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					FaceRecon.createAndShowGUI(1);
				}
			});
		}

		if (e.getSource() == WatsonSesdr) {
			GlobalPanel Watson = new GlobalPanel(2);
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					Watson.createAndShowGUI(2);
				}
			});
		}

		if (e.getSource() == IoTexperiment) {
			GlobalPanel IoTexp = new GlobalPanel(3);
			javax.swing.SwingUtilities.invokeLater(new Runnable() {
				public void run() {
					IoTexp.createAndShowGUI(3);
				}
			});
		}

	}

	/**
	 * Create the GUI and show it. For thread safety, this method should be
	 * invoked from the event-dispatching thread.
	 */
	public void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Service Catalogue for Bluemix Services");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		ServiceCatalog newContentPane = new ServiceCatalog();
		newContentPane.setOpaque(true); // content panes must be opaque
		frame.setContentPane(newContentPane);

		// Display the window.
		frame.pack();
		frame.setVisible(true);
	}
}
