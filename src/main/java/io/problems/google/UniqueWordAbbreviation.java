package io.problems.google;
// An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:

import java.util.HashMap;

public class UniqueWordAbbreviation {
  HashMap<String, String> map;

  public ValidWordAbbr(String[] dictionary) {
        this.map = new HashMap<String, String>();
        
        for(String word : dictionary) {
            String key = getKey(word);
            
            if(map.containsKey(key)) {
                if(!map.get(key).equals(word)) {
                    map.put(key, "");
                }
            } else {
                map.put(key, word);
            }
        }
    }

  public boolean isUnique(String word) {
    return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
  }

  public String getKey(String word) {
    if (word.length() <= 2) {
      return word;
    }

    return word.charAt(0) + Integer.toString(word.length() - 2)
        + word.charAt(word.length() - 1);
  }
}

// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");
