package mira;

import java.util.ArrayList;

public class Drug{

	private final String name;
	//private int star;
	private final String condition;
	private ArrayList<Review> reviews;
	
	public Drug(String name /*int star*/, String condition, ArrayList<Review> reviews) {
		this.name = name;
		//this.star = star;
		this.condition = condition;
		this.reviews = reviews;
	}
	
	public String getName() { return this.name; }
	
	/*public int setStar() {
		
	}*/
	
	public String getCond() {return this.condition; }
	
	public ArrayList<Review> getReviews() {return this.reviews; }
	
	public void add(Review review) {
		this.reviews.add(review);
	}	
}