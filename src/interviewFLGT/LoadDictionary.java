package interviewFLGT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Google
 */
public class LoadDictionary {

	public Map<String, Set<String>> loadDictionary(String fileName) throws IOException {

		File file = new File(fileName);
		/**
		 * handle error when we cannot open the file: throws FileNotFoundException
		 */
		BufferedReader reader = new BufferedReader(new FileReader(file));
		Map<String, Set<String>> dict = new HashMap<String, Set<String>>();

		/**
		 * handle error when we cannot readLine: throws IOException 
		 * IOException is superclass of FileNotFoundException
		 */
		String line = null;
		while ((line = reader.readLine()) != null) { // process one single line

			StringBuilder abbr = new StringBuilder(); // abbreviation as the key
			// Abbriviate the word and put into the map
			if (line.isEmpty()) {
				continue;
			} else if (line.length() > 2) { // length() >= 3
				abbr.append(line.charAt(0));
				abbr.append(line.length() - 2);
				abbr.append(line.charAt(line.length() - 1));
			} else { // length() == [1, 2]
				abbr.append(line);
			}

			if (dict.containsKey(abbr.toString())) {
				dict.get(abbr.toString()).add(line);
			} else {
				Set<String> wordSet = new HashSet<String>();
				wordSet.add(line);
				dict.put(abbr.toString(), wordSet);
			}
		}
		return dict;
	}
	
}
