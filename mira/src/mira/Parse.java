package mira;

import search.BinarySearch;
import java.io.BufferedReader;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.text.StringEscapeUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parse {
	public static List<Condition> loadData() throws IOException {
//       System.out.println("Working Directory = " +
//               System.getProperty("user.dir"));
//		String anim = "|/-\\";
		System.out.println("Started Data Preprocessing");
		String csvFile = "../dataset/uci/drugsComTest_raw.csv";		
		List<Condition> conditions = new ArrayList<Condition>();
		Reader in = new FileReader(csvFile);
		Iterable<CSVRecord> records = CSVFormat.EXCEL.parse(in);
		int a = 0;
		for (CSVRecord record : records) {
//			System.out.flush();
//			String data = "\r" + anim.charAt(a % anim.length()) + " " + a;
//			System.out.write(data.getBytes());
			if(a == 0) {
				a++;
				continue;
			}
//			System.out.print("Current record: "+ a);
			String review = record.get(3);
			review = review.replace("\"", "");
			review = StringEscapeUtils.unescapeHtml4(review);//    	
			String[] conds = record.get(2).split(", ");
			String medication = record.get(1);
			int useful = Integer.parseInt(record.get(6));
			int rating = Integer.parseInt(record.get(4));
			for (String condition : conds) {
//				System.out.println("Condition:\t" + condition + "\t|\tTotal:\t"+conditions.size());
				int cond_index = BinarySearch.linSearch_C(conditions, condition);
				if (cond_index != -1) {
//    			System.out.println("Condition found");
//    			The conditions list has the drug entry
//    			Check for drug in condition
					Condition cond = conditions.get(cond_index);
					int drug_index = BinarySearch.binarySearch_D(cond.getDrugs(), medication);
					if (drug_index != -1) {
//    				Drug found. Add review to the drug
						Drug drug = (Drug) cond.getDrugs().get(drug_index);
						drug.add(new Review(review, condition, rating, useful));
					} else {
//    				Drug not found. Add drug to condition
						Drug new_drug = new Drug(medication, condition);
						new_drug.add(new Review(review, condition, rating, useful));
						cond.add(new_drug);
					}
				} else {
//    			Condition not found. Make a new condition and add the drug to it.
//    			System.out.println("Condition not found");
					Drug new_drug = new Drug(medication, condition);
					Condition cond = new Condition(condition);
					new_drug.add(new Review(review, condition, rating, useful));
					cond.add(new_drug);
					conditions.add(cond);
				}
			}
			
			if(a == 50) {
				break;				
			}
			a++;
//			System.out.print("\b\r");
		}		
		System.out.println("Loading done.");
		return conditions;
	}

	public static void main(String[] args) throws IOException {
		List<Condition> l = loadData();		
		for (int i = 0; i < l.size(); i++) {
			Condition condition = l.get(i);
			System.out.println("["+i+"] "+condition.getName() +" : "+ condition.getDrugs().size());			
		}
				
		
//		Condition first = l.get(5);
//		System.out.println(first.getName() + " | number of drugs : " + first.getDrugs().size());
//		ArrayList<Comparable> weight = first.getDrugs();
//		for (Comparable drug : weight) {
//			System.out.println(((Drug) drug).getName());
//			ArrayList<Comparable> reviews = (((Drug) drug).getReviews());
//			for (Comparable review : reviews) {
//				System.out.println(((Review) review));				
//			}
//			System.out.println("========================================");
//		}
		
		
	}

}