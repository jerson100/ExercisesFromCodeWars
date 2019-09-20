package CincoKyu;

import algoritmos.DistanceLevenshtein;
import utils.FPrint;

public class Dictionary {

	private final String[] words;

	public Dictionary(String[] words) {

		this.words = words;
	}
	
	public static void main(String[] args) {
		Dictionary fruits = new Dictionary(new String[]{"cherry", "pineapple", "melon", "strawberry", "raspberry"});

		FPrint.println(fruits.findMostSimilar("strawbery")); // must return "strawberry"
		FPrint.println(fruits.findMostSimilar("berry")); // must return "cherry"

		Dictionary things = new Dictionary(new String[]{"stars", "mars", "wars", "codec", "codewars"});
		FPrint.println(things.findMostSimilar("coddwars")); // must return "codewars"

		Dictionary languages = new Dictionary(new String[]{"javascript", "java", "ruby", "php", "python", "coffeescript"});
		FPrint.println(languages.findMostSimilar("heaven")); // must return "java"
		FPrint.println(languages.findMostSimilar("javascript")); // must return "javascript" (same words are obviously the most similar ones)
	}

	public String findMostSimilar(String to) {
		int m = 999999999;
		String wordR = "";
		int aux;
		for(String word:words) {
			if(m>(aux=DistanceLevenshtein.computeLevenshteinDistance(word, to))) {
				m = aux;
				wordR = word;
			}
		}
		return wordR;
	}
	
	


}
