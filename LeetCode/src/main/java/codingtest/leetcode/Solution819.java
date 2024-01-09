package codingtest.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("\\W+"," ");
        String[] arr = paragraph.split("\\s+");

        int n = arr.length;
        HashMap<String,Integer> hp = new HashMap<>();
        for(int i=0; i < n; i++){
            hp.put(arr[i],hp.getOrDefault(arr[i],0)+1);
        }

        for(int i=0; i < banned.length; i++){
            hp.remove(banned[i]);
        }


        int freq = 0;
        String ans = "";
        for(var a : hp.keySet()){
            if(hp.get(a) > freq){
                freq = hp.get(a);
                ans = a;
            }
        }
        return ans;
    }
}
