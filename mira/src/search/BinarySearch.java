package search;

import java.util.ArrayList;

public class BinarySearch {
    static int binarySearch(ArrayList<Comparable> arr, String x) 
    { 
        int l = 0, r = arr.size() - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int res = x.compareTo(((mira.Conditions) arr.get(m)).getName()); 
  
            // Check if x is present at mid 
            if (res == 0) 
                return m; 
  
            // If x greater, ignore left half 
            if (res > 0) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        return -1; 
    }
}
