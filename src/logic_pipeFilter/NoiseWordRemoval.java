package logic_pipeFilter;

import java.util.Arrays;

/**
 * 
 * @author Zhang Ji
 * 
 */
public class NoiseWordRemoval extends Filter {

	/**
	 * The giant list of noise words to not include.
	 * 
	 * @see http://drupal.org/node/1202
	 */
	public static final String noise[] = { "the", "and", "a", "to", "of", "in",
			"i", "is", "that", "it", "on", "you", "this", "for", "but", "with",
			"are", "have", "be", "at", "or", "as", "was", "so", "if", "out",
			"not", };

	public void run() {
		while (true) {

				String s = read();
				String tokens[] = s.split("\\s");

				// Don't write it if it does contain the noise word
				if (Arrays.asList(noise).contains(tokens[0].toLowerCase()))
					continue;

				write(s);

			
		}
	}

}
