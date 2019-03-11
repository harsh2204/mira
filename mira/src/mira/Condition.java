package mira;

import java.util.ArrayList;

public class Condition {
	private final String name;
	private final ArrayList<Drug> drugs;
	
	public Condition(String name, ArrayList<Drug> drugs) {
		this.name = name;
		this.drugs = drugs;
	}

}
