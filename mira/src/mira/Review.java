package mira;

public class Review implements Comparable<Review> {
	//private final String drugName;
	private final String review;
	private final float rating;
	private final String condition;
	private final int useful;
	
	public Review(String review, String condition, float rating, int useful) {
		this.review = review;
		this.condition = condition;
		this.rating = rating;
		this.useful = useful;
		
	}

	
	public String getReview() { return this.review; }
	
	public float getRating() { return this.rating; }
	
	public String getCond() { return this.condition; }
	
	public int getUseful() { return this.useful; }
	
	
	@Override
	public int compareTo(Review j)
	{
		//TODO
		if (this.useful < j.useful ) {
			return -1;
		}
		else if (this.useful  > j.useful ) {
			return 1;
		}
		return 0;		
	}
	
	@Override
	public String toString() {
		return "Review [condition: "+ this.condition + "\trating: "+this.rating+"\tuseful: "+this.useful+"\n\ttext: "+this.review+"\n]";
	}
	
	
}
