import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/** Converter utility class that will be used in test. Calls methods from CodeTree class
 * @author Kevin Gomes
 */
public class MorseCodeConverter {
	
	static MorseCodeTree morseCodeTree = new MorseCodeTree();
	
	/** Fetches file, reads said file, and returns the decoded english from the morse code within the file
	 * @param file file to be read
	 * @return The english text of the morse code
	 * @throws FileNotFoundException If the file does not exist
	 */
	public static String convertToEnglish(File file) throws FileNotFoundException {
		if (!file.exists())
			throw new FileNotFoundException("File not found");
		
		Scanner fileReader = new Scanner(file);
		StringBuilder fileRead = new StringBuilder();
		
		while(fileReader.hasNextLine()) {
			fileRead.append(fileReader.nextLine()).append(" ");
		}
		
		fileReader.close();
		
		return convertToEnglish(fileRead.toString());
	}
	
	/** Converts from morse code to english text
	 * @param morc morse code string to be converted to english
	 * @return decodedENG decoded morse code message in english
	 */
	public static String convertToEnglish(String code) {
		StringBuilder decodedENG = new StringBuilder();
		String[] letters = code.split(" ");
		
		for (String letter : letters) {
			if (letter.equals("/")) {
				decodedENG.append(" ");
				continue;
			}
			
			decodedENG.append(morseCodeTree.fetch(letter));
		}
		
		return decodedENG.toString();
	}
	
	/** Prints the tree by converting it to an ArrayList and printing every node from there
	 * @return A string with the tree's data in-order.
	 */
	public static String printTree() {
		StringBuilder toReturn = new StringBuilder();
		for (String item : morseCodeTree.toArrayList())
			toReturn.append(item).append(" ");
		
		return toReturn.toString();
	}
}
