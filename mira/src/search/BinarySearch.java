package search;

import java.util.ArrayList;
import java.util.List;

import mira.Condition;
import mira.Drug;

public class BinarySearch {
    public static int binarySearch_C(List<Condition> arr, String x) 
    { 
        int l = 0, r = arr.size() - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int res = x.compareTo(((mira.Condition) arr.get(m)).getName()); 
  
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
    public static int binarySearch_D(ArrayList<Comparable> arrayList, String x) 
    { 
        int l = 0, r = arrayList.size() - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            int res = x.compareTo(((mira.Drug) arrayList.get(m)).getName()); 
  
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
