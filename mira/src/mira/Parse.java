package mira;

import search.BinarySearch;
import java.io.BufferedReader;
import org.apache.commons.text.StringEscapeUtils;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parse {
	public static List<Condition> loadData() throws IOException {		
//       System.out.println("Working Directory = " +
//               System.getProperty("user.dir"));

		String csvFile = "../dataset/uci/drugsComTest_raw.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\t";

		int c = 0;
		
		List<Condition> conditions = new ArrayList<Condition>();

		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	if (c == 0) {
            		c++;
            		continue;
            	}
            	String[] drugData = line.split(cvsSplitBy);
            	String review = drugData[3];
            	review = review.replace("\"\"\"", "");
            	review = StringEscapeUtils.unescapeHtml4(review);
//            	String cond = drugData[2];
            	String[] conds = drugData[2].replace("\"", "").split(",");
            	String medication = drugData[1];
            	int useful = Integer.parseInt(drugData[6]);
            	int rating = Integer.parseInt(drugData[4]);
            	
            	for (String condition : conds) {
            		System.out.println("Condition:\t" + condition + "\t|\tTotal:\t"+conditions.size());
            		int cond_index = BinarySearch.linSearch_C(conditions, condition);
            		if(cond_index != -1) {
//            			The conditions list has the drug entry
//            			Check for drug in condition
            			Condition cond = conditions.get(cond_index);
            			int drug_index = BinarySearch.binarySearch_D(cond.getDrugs(), medication);
            			if(drug_index != -1) {
//            				Drug found. Add review to the drug
            				Drug drug = (Drug) cond.getDrugs().get(drug_index);            				
            				drug.add(new Review(review, condition, rating, useful));
            			}else {
//            				Drug not found. Add drug to condition
            				Drug new_drug = new Drug(medication, condition);
            				new_drug.add(new Review(review, condition, rating, useful));            				
            				cond.add(new_drug);            				
            			}
            		}else {
//            			Condition not found. Make a new condition and add the drug to it.
            			Drug new_drug = new Drug(medication, condition);
            			Condition cond = new Condition(condition);
            			new_drug.add(new Review(review, condition, rating, useful));
            			cond.add(new_drug);
            			conditions.add(cond);
            		}
            	}            	
//            	System.out.println(review);
            	if(c == 28) break;             
            	c++;
            }            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return conditions;

    }
	public static void main(String[] args) throws IOException {
		List<Condition> l = loadData();
		
	}
	
}	