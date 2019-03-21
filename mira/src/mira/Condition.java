package mira;

import java.util.ArrayList;

public class Condition implements Comparable<Condition>{
	private final String name;
	private final ArrayList<Comparable> drugs;
//	private final ArrayList<Comparable> drugs = new ArrayList<Comparable>();
	
	public Condition(String name) {
		this.name = name;	
		this.drugs = new ArrayList<Comparable>();
	}
	
	public String getName() {
		return this.name;
	}
	public ArrayList<Comparable> getDrugs(){
		return this.drugs;
	}
	public void add(Drug drug) {
		this.drugs.add(drug);
//		sort.Quick.sortBasicQuick(this.drugs);
	}

	@Override
	public int compareTo(Condition arg0) {
		// TODO Auto-generated method stub
		return this.getName().compareTo(arg0.getName());
	}
	
}
