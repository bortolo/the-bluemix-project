package com.it.ibm.watson.cvassesment;

import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;
import java.io.File;

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
	
	public CVSettingsPanel(){
		
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
	
		log = new JTextArea(5,20);
        log.setMargin(new Insets(5,5,5,5));
        log.setEditable(false);
        
		// Formatting this panel (TO BE EXTENED with multiple layout choices)
		formatLayout();
		
		
	}
		
	public void actionPerformed(ActionEvent e) {
		
		// Handle open button action.
		if (e.getSource() == inputBrowser) {
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
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
			log.append("WARNING: Still missing the link to the backend code.\n");
			log.append("input folder:" + inputFolder.getText() + "\n");
			log.append("output folder:" + outputFolder.getText() + "\n");
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
