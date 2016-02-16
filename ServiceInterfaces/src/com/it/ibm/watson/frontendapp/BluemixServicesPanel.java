package com.it.ibm.watson.frontendapp;

import java.util.Vector;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/*
 * STEP 3
 * 
 * Continuando sul master
 * 
 * 
 * prima prova, continuiamo sulla strada BR1
 * 
 * 
 * Proviamo invece quest'altra strada, step 3 ma BR2
 * 
 * in ogni caso sul master si può andare avanti a fare modifiche non trovate?
 * 
 * Quindi dicevamo con queste modifiche da master!
 */

/*
 * BluemiServicesPanel manages the layout of the panel where each account and password 
 * data are collected from the user.
 * From this panel it is possible to:
 * 1. See which services are needed by the solution
 * 2. Check the availability of the bluemix servers
 * 3. Update and personalize the bluemix servers used
 * 
 */



public class BluemixServicesPanel extends JPanel implements ActionListener {
	
	
	// Variables linked to utilities of this panel
	private JButton checkServers;
	private JButton updateServers;
	private javax.swing.JTextArea log;
	private Border lowerdetched;
	// Variables linked with the bluemix class
	private Vector<javax.swing.JLabel> servicenames;
	private Vector<javax.swing.JTextField> servicepwd;
	private Vector<javax.swing.JTextField> serviceaccount;

	// Fixed variables of this pane
	private javax.swing.JLabel list;
	private javax.swing.JLabel account;
	private javax.swing.JLabel pwd;

	public BluemixServicesPanel() {

		// Kind of borders used
		lowerdetched = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

		// TO DO -----------------------------
		// Class bluemix services will be external, I put this class here for
		// the sake of simplicity
		Vector<String> services = new Vector<String>();
		services.add("Personal Insight");
		services.add("Document Conversion");
		services.add("IoT integration");
		BluemixServices BluemixSvc = new BluemixServices(services);
		// ------------------------------------

		// Setting all the variables of this class
		checkServers = new JButton();
		checkServers.setText("Check servers");
		checkServers.addActionListener(this);
		updateServers = new JButton();
		updateServers.setText("Update servers");
		updateServers.addActionListener(this);
		log = new JTextArea(5, 20);
		log.setMargin(new Insets(5, 5, 5, 5));
		log.setEditable(false);

		servicenames = new Vector<javax.swing.JLabel>();
		servicepwd = new Vector<javax.swing.JTextField>();
		serviceaccount = new Vector<javax.swing.JTextField>();

		list = new javax.swing.JLabel("List of services");
		list.setHorizontalAlignment(JLabel.CENTER);
		list.setBorder(lowerdetched);
		list.setPreferredSize(new Dimension(100, 25));

		account = new javax.swing.JLabel("Account");
		account.setHorizontalAlignment(JLabel.CENTER);
		account.setBorder(lowerdetched);
		account.setPreferredSize(new Dimension(100, 25));

		pwd = new javax.swing.JLabel("Password");
		pwd.setHorizontalAlignment(JLabel.CENTER);
		pwd.setBorder(lowerdetched);
		pwd.setPreferredSize(new Dimension(100, 25));

		// Import data from bluemix class
		importAccountData(BluemixSvc);

		// Formatting this panel (TO BE EXTENED with multiple layout choices)
		formatLayout();

	}

	// Determine action of panel buttons
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == checkServers) {
			for (int i = 0; i < servicenames.size(); i++) {
				if (checkserver(serviceaccount.get(i), servicepwd.get(i))) {
					log.append("DONE:" + servicenames.get(i).getText() + ".\n");
				} else {
					log.append("FAILED:" + servicenames.get(i).getText() + ".\n");
				}
			}
		}

		// TO DO - we need to see BluemixServices class
		if (e.getSource() == updateServers) {
			log.append("WARNING: update servers is not implemented yet.\n");
		}
	}

	// Import data from bluemix class
	public void importAccountData(BluemixServices bluesvc) {

		for (int i = 0; i < bluesvc.getnumberofservicesUsed(); i++) {

			servicenames.add(new JLabel());
			servicenames.get(i).setPreferredSize(new Dimension(200, 25));
			servicenames.get(i).setMaximumSize(new Dimension(200, 25));
			servicenames.get(i).setHorizontalAlignment(JLabel.CENTER);
			servicenames.get(i).setBorder(lowerdetched);
			servicenames.get(i).setText(bluesvc.getservicesNames(i));

			serviceaccount.add(new JTextField());
			serviceaccount.get(i).setPreferredSize(new Dimension(300, 25));
			serviceaccount.get(i).setMaximumSize(new Dimension(300, 25));
			serviceaccount.get(i).setText("Default account...");
			;

			servicepwd.add(new JTextField());
			servicepwd.get(i).setPreferredSize(new Dimension(300, 25));
			servicepwd.get(i).setMaximumSize(new Dimension(300, 25));
			servicepwd.get(i).setText("***************");
			;
		}
	}
	
	
	// Choose the format do you wish for this panel (TO BE EXTENDED with other choices)
	public void formatLayout() {

		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		JScrollPane logScrollPane = new JScrollPane(log);

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 1, 1);

		this.add(list, c);
		c.gridx = 1;
		this.add(account, c);
		c.gridx = 2;
		this.add(pwd, c);

		for (int i = 0; i < servicenames.size(); i++) {
			c.gridy = 1 + i;
			c.gridx = 0;
			this.add(servicenames.get(i), c);
			c.gridx = 1;
			this.add(serviceaccount.get(i), c);
			c.gridx = 2;
			this.add(servicepwd.get(i), c);
		}

		c.gridy = servicenames.size() + 1;
		c.gridx = 1;
		c.insets = new Insets(10, 1, 10, 1);
		this.add(checkServers, c);

		c.gridy = servicenames.size() + 2;
		c.insets = new Insets(5, 1, 5, 1);
		this.add(logScrollPane, c);

		c.gridy = servicenames.size() + 1;
		c.gridx = 2;
		c.insets = new Insets(10, 1, 10, 1);
		this.add(updateServers, c);

	}

	// TO BE IMPLEMENTED - check if severs are active
	public boolean checkserver(JTextField account, JTextField pwd) {
		return false;
	}
}
