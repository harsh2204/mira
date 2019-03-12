package mira;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parse {
	
	public static void main(String[] args) throws IOException {		
//       System.out.println("Working Directory = " +
//               System.getProperty("user.dir"));
		String csvFile = "./dataset/uci/drugsComTest_raw.csv";
		BufferedReader br = null;
		String line = "";
		String cvsSplitBy = ",";
		int iteration = 0;
		Pattern p = Pattern.compile(".*\\\"(.*)\\\".*");
		
		
		try {

            br = new BufferedReader(new FileReader(csvFile));
            while ((line = br.readLine()) != null) {
            	if (iteration == 0) {
            		iteration++;
            		continue;
            	}
                // use comma as separator
//            	Matcher m = p.matcher(line);
//            	m.find();
            	
            	String review = line.split("\"\"\"")[1].split("\"\"\"")[0];
//            	System.out.println(line);
            	System.out.println("Review " + review);
                String[] firstHalf = line.split("\"\"\"")[0].split(cvsSplitBy);
                String[] secondHalf = line.split("\"\"\"")[1].split("\"\"\"")[1].split(cvsSplitBy)
                String dummy = drugData[2];
//                System.out.println(drugData[2]);
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