package mira;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Parse {
	public static void main(String[] args) throws IOException {		
//       System.out.println("Working Directory = " +
//               System.getProperty("user.dir"));

		String csvFile = "../dataset/uci/drugsComTest_raw.txt";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = "\t";
		int iteration = 0;
		int c = 0;

		

		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	if (iteration == 0) {
            		iteration++;
            		continue;
            	}
                // use comma as separator
//            	String review = line.split("\"\"\"")[1].split("\"\"\"")[0];
            	String[] drugData = line.split(cvsSplitBy);
            	for (String string : drugData) {
					System.out.print(string + " | ");
				}
            	System.out.println();
            	c++;
//            	System.out.println(s.size());
//                String[] firstHalf = line.split("\"\"\"")[0].split(cvsSplitBy);
//                String[] secondHalf = line.split("\"\"\"")[2].split(cvsSplitBy);
//                String conditions = line.split("\"")[1].split("\"")[0];
//                System.out.println(c + " Lengths1: "+ firstHalf.length + "Lengths2: " + secondHalf.length);
            	if(c == 28) break;
               
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