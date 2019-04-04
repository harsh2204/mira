package mira;

import java.util.ArrayList;





public class Drug implements Comparable<Drug>{

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
	
	private void updateScore() {
		float s = 0;
		for(Comparable r : this.reviews) {
			Review rev = (Review) r;
			s += rev.getSrating();
		}
		this.score = s/this.reviews.size();
	}
	public void add(Review review) {
		this.reviews.add(review);
		sort.Quick.sortBasicQuick(this.reviews);
		this.updateScore();
	}	
	@Override
	public String toString() {
		return "Drug [name: " + this.name + " condition: " + this.condition + " score: " + this.score +" # of reviews: "+this.reviews.size()+"]";
	}
	@Override
	public int compareTo(Drug j)
	{
		//TODO
		if (this.score < j.score ) {
			return -1;
		}
		else if (this.score  > j.score ) {
			return 1;
		}
		return 0;		
	}
}