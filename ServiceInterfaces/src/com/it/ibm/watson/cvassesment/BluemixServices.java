package com.it.ibm.watson.cvassesment;

import java.util.Vector;

/*
 * prova sul branch di madonia
 */

public class BluemixServices {
// hfoidsa
	private int numberofservices;
	private int numberofservicesUsed;	
	private Vector<String> servicesNames;
	
	public BluemixServices(){}
	
	public BluemixServices(Vector<String> services){
		
		servicesNames = new Vector<String>(services);
		numberofservices = servicesNames.size();
		numberofservicesUsed = servicesNames.size();
	}
	
	public int getnumberofservices(){return numberofservices;}
	public int getnumberofservicesUsed(){return numberofservicesUsed;}
	public String getservicesNames(int i){return servicesNames.get(i);}
	
}
