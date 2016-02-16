package com.it.ibm.watson.frontendapp;

import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.event.ActionEvent;
import java.awt.*;

public class InfoPanel extends JPanel implements ActionListener {
	
	private javax.swing.JLabel servicename;
	private javax.swing.JLabel description;
	
	public InfoPanel(String service, String comment){
		
		servicename = new javax.swing.JLabel();
		servicename.setText(service);
		servicename.setPreferredSize(new Dimension(100,25));
		
		description = new javax.swing.JLabel();
		description.setText(comment);
		description.setPreferredSize(new Dimension(300,300));
		
		formatLayout();
		
	}

	public void actionPerformed(ActionEvent e) {}

	public void formatLayout() {
		
		this.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(1, 1, 1, 1);

		this.add(servicename, c);
		c.gridy = 1;
		this.add(description, c);
		
	}

}
