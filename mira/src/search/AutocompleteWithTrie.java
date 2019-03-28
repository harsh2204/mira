package search;
import java.io.IOException;
import java.util.List;

import mira.Condition;
import mira.Parse;

public class AutocompleteWithTrie {
	
	 public static void main(String[] args) throws IOException {            
            Trie t = new Trie();  
            List<Condition> l = Parse.loadData();		
    		for (int i = 0; i < l.size(); i++) {
    			Condition condition = l.get(i);
//    			System.out.println("["+i+"] "+condition.getName() +" : "+ condition.getDrugs().size());
    			t.insert(condition.getName());
    		}
//            t.insert("amazon"); 
//            t.insert("amazon prime"); 
//			t.insert("amazing"); 			 
//            t.insert("amazing spider man"); 
//            t.insert("amazed");
//            t.insert("alibaba");
//            t.insert("ali express");
//            t.insert("ebay");
//            t.insert("walmart");          
			List<String> a= t.autocomplete("B");
			for (int i = 0; i < a.size(); i++) {
				System.out.println(a.get(i));
			}
	  }
}