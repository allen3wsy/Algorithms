package leetcode;

import java.util.ArrayList;
import java.util.HashMap;

/*
 * Title: Anagrams
 *
 * Description:
 * Given an array of strings, return all groups of strings that are anagrams.
 *
 * Note: All inputs will be in lower-case.
 *
 * Solution:
 * Anagram is the kind of words that every character appears for the same times.
 * So we can construct a countMap char->count to identify a group
 *
 * Also, we can consider sort the string first
 */
public class Anagram {
    // dict c -> count
    // represent a anagram group
	
	/* In this way: every string corresponds to a HashMap */
    private HashMap<Character, Integer> getCharCount(String s){
        HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (countMap.containsKey(c)){
                countMap.put(c, countMap.get(c) + 1);	// rewrite the old value
                										// and plus 1
            }
            else
                countMap.put(c, 1);
        }
        return countMap;
    }

    public ArrayList<String> anagrams(String[] strs) {
        // groupid -> the String[id] of the first occurence (used to print the old one)
        // if appear 2nd time, add the first, !! output the first and itself 
    	// and set the whole thing to -1
    	
        HashMap<HashMap<Character, Integer>, Integer> group = 
            new HashMap<HashMap<Character, Integer>, Integer>();
        ArrayList<String> result = new ArrayList<String>();
        
        for (int i = 0; i < strs.length; i++)	{
            String str = strs[i];
            HashMap<Character, Integer> countMap = getCharCount(str);
            if (group.containsKey(countMap))	{
                int firstIdx = group.get(countMap);
                if (firstIdx != -1)	{
                    result.add(strs[firstIdx]);	// add the previous one to result
                    group.put(countMap, -1);
                }
                result.add(str);
            }
            else{
                group.put(countMap, i);
            }
        }
        return result;
    }

    public static void main(String[] args){
        String[] strs = {"cat","rye","aye","dog", "god","cud","cat","old","fop","bra"};
        Anagram a = new Anagram();
        ArrayList<String> anagramList = a.anagrams(strs);
        for (String str: anagramList){
            System.out.println(str);
        }
    }
}