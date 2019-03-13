package mira;

import java.util.ArrayList;

public class Drug{

	private final String name;
	private final String condition;
	private ArrayList<Comparable> reviews = new ArrayList<Comparable>(); 
	private float score = 0;

	public Drug(String name, String condition) {
		this.name = name;
		this.condition = condition;
	}
	
	public String getName() { return this.name; }
	
	public String getCond() {return this.condition; }
	
	public ArrayList<Comparable> getReviews() {return this.reviews; }
	
	public float getScore() { return this.score; }
	
	public void add(Review review) {
		this.reviews.add(review);
		sort.Quick.sortBasicQuick(this.reviews);
	}	
	@Override
	public String toString() {
		return "Drug [name: " + this.name + " condition: " + this.condition + " score: " + this.score ;
	}
}