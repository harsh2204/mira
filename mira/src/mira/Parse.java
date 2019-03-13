package mira;

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
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws IOException {		
//       System.out.println("Working Directory = " +
//               System.getProperty("user.dir"));

		String csvFile = "../dataset/uci/drugsComTest_raw.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\t";

		int c = 0;
		
		

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
            	String[] conds = drugData[2].split(",");
            	String medication = drugData[1];
            	int useful = Integer.parseInt(drugData[6]);
            	int rating = Integer.parseInt(drugData[4]);
            	Review rev = new Review(review, conds[0], rating, useful);            	
//            	Review rev;
//            	if (conds.length == 0) {            		
//            		rev = new Review(review, conds[0], rating, useful);
//            	}else {
//            		for (String cond : conds) {
//            			rev = new Review(review, cond, rating, useful);
//					}
//            	}
            	System.out.println(rev);
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

    }
	
}	