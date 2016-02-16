package com.it.ibm.watson.frontendapp;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ibm.watson.developer_cloud.document_conversion.v1.DocumentConversion;
import com.ibm.watson.developer_cloud.personality_insights.v2.PersonalityInsights;
import com.ibm.watson.developer_cloud.personality_insights.v2.model.Profile;
import com.it.ibm.watson.cvassesment.DocumentConversionConfig;
import com.it.ibm.watson.cvassesment.PersonalityInsightConfig;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CVSettingsPanel extends JPanel implements ActionListener {

	public javax.swing.JTextField inputFolder;
	public javax.swing.JButton inputBrowser;
	public javax.swing.JLabel inputLabel;
	public javax.swing.JLabel logLabel;

	public javax.swing.JTextField outputFolder;
	public javax.swing.JButton outputBrowser;
	public javax.swing.JLabel outputLabel;

	public javax.swing.JButton startAnalysis;
	public javax.swing.JTextArea log;

	JFileChooser fc;

	// Watson services
	private DocumentConversion service;
	private PersonalityInsights pi;

	public CVSettingsPanel() {

		// Initialize (hardcoded)
		service = new DocumentConversion(
				DocumentConversion.VERSION_DATE_2015_12_01);
		service.setUsernameAndPassword(DocumentConversionConfig.usernameAndrea,
				DocumentConversionConfig.passwordAndrea);

		pi = new PersonalityInsights();
		pi.setUsernameAndPassword(PersonalityInsightConfig.usernameAndrea,
				PersonalityInsightConfig.passwordAndrea);

		// Setting all the variables of this class
		inputFolder = new javax.swing.JTextField();
		outputFolder = new javax.swing.JTextField();
		inputBrowser = new javax.swing.JButton("Browser");
		outputBrowser = new javax.swing.JButton("Browser");
		inputLabel = new javax.swing.JLabel("Input directory path");
		outputLabel = new javax.swing.JLabel("Output directory path");
		logLabel = new javax.swing.JLabel("Log panel");
		startAnalysis = new javax.swing.JButton("START");

		fc = new JFileChooser();

		inputBrowser.addActionListener(this);
		outputBrowser.addActionListener(this);
		startAnalysis.addActionListener(this);

		inputFolder.setPreferredSize(new Dimension(600, 25));
		outputFolder.setPreferredSize(new Dimension(600, 25));

		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);

		// Formatting this panel (TO BE EXTENED with multiple layout choices)
		formatLayout();

	}

	public void actionPerformed(ActionEvent e) {

		// Handle open button action.
		if (e.getSource() == inputBrowser) {
			// fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(CVSettingsPanel.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				inputFolder.setText(file.getAbsolutePath());
			} else {
				log.append("ERROR: the directory path is not valid.\n");
			}
		}

		if (e.getSource() == outputBrowser) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showOpenDialog(CVSettingsPanel.this);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				outputFolder.setText(file.getAbsolutePath());
			} else {
				log.append("ERROR: the directory path is not valid.\n");
			}
		}

		if (e.getSource() == startAnalysis) {
			// log.append("WARNING: Still missing the link to the backend code.\n");
			// log.append("input folder:" + inputFolder.getText() + "\n");
			// log.append("output folder:" + outputFolder.getText() + "\n");

			// Convert to txt
			String normalizedText = service.convertDocumentToText(new File(
					inputFolder.getText()));

			// Now, we send this text to personality insight service
			// log.append(normalizedText);

			Profile personalityProfile = pi.getProfile(normalizedText);

			log.append(personalityProfile.toString());

			// Print to file
			PrintWriter out = null;
			try {
				out = new PrintWriter(new BufferedWriter(new FileWriter(
						outputFolder.getText() + "\\out.txt")));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			out.println(personalityProfile);
			out.close();

		}

	}

	public void formatLayout() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JScrollPane logScrollPane = new JScrollPane(log);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 1, 1);

		this.add(inputLabel, c);
		c.gridy = 1;
		this.add(inputFolder, c);
		c.gridx = 1;
		this.add(inputBrowser, c);

		c.gridx = 0;
		c.gridy = 3;
		this.add(outputLabel, c);
		c.gridy = 4;
		this.add(outputFolder, c);
		c.gridx = 1;
		this.add(outputBrowser, c);

		c.gridx = 0;
		c.gridy = 5;
		this.add(logLabel, c);

		c.gridx = 0;
		c.gridy = 6;
		this.add(logScrollPane, c);

		c.gridx = 1;
		c.insets = new Insets(10, 1, 10, 1);
		this.add(startAnalysis, c);

	}

}
