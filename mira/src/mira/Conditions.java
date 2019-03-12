package mira;

import java.util.ArrayList;

public class Conditions {
	private final String name;
	private final ArrayList<Drug> drugs;
	
	public Conditions(String name, ArrayList<Drug> drugs) {
		this.name = name;
		this.drugs = drugs;
	}
	
	public String getName() {
		return this.name;
	}

}
