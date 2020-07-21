import java.util.concurrent.ThreadLocalRandom;  // lo uso para generar algun número aleatorio
import java.util.Arrays;
import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class prueba {
	public static void main(String[] args) {
		
		HangmanLexicon hl = new HangmanLexicon();												
		W2g wToG = new W2g(hl.getWord(ThreadLocalRandom.current().nextInt(10)));
		
		// Crea una lista con el mismo numero de nodos con "-" que letras la palabra a adivinar		
		UserWord uw = new UserWord(wToG.getWord().length());
		
		// guesses left
		int gl = 8; 
		int index;
		
		Scanner sc = new Scanner(System.in);
		String letterGuess;

		System.out.format("Welcome to Hangman! %n");
		while (gl >-1) {
			// Solo es formato para que cuando solo quede un intento, la ortografía sea correcta
			if ( gl != 1) {
				System.out.format("The word now looks like this: %s%nYou have %d guesses left%n", uw, gl);							
			}
			else {
				System.out.format("The word now looks like this: %s%nYou have only one guess left%n", uw);
			}
			do{    // Pido input al usuario y lo valido. 
			System.out.println("Your guess:");						
			letterGuess = sc.next();  //VE DONDE CERRAR ESTO
			} while (! validateInput(letterGuess) );			
							
						
			index = wToG.validateLetter(letterGuess);  //Checo que la letra este en wToG
			if (index != -1) {	                   //letra adivinada
				uw.addLetterGuessToUW( index, letterGuess); // actualizo uw
				System.out.println("That guess is correct");
				if (wToG.getCeldasNoNull() == 0) {  //Si todas las celdas son null, el usuario ya  adivino la palabra
					System.out.format("You guessed the word: %s%nYou win.", wToG.getWord());
					break;
				}
			}
			else { //letra no adivinada
				System.out.format("There are no %s's in the word.%n",letterGuess.toUpperCase());				 
				if(gl == 1) {  // Si el usuario ya no tiene vidas termina el juego.
					System.out.format("You are completely hung. %nThe word was: %s %nYou lose.", wToG.getWord());
					break;
				}
				gl -= 1;
			}				
														
		}															
	}
	
	static boolean validateInput(String l) {
	String[] abcd = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", 
				"n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
		
	if ( Arrays.binarySearch(abcd, l) < 0 ) {
		System.out.println("Invalid input. Type only one character of the alphabet.");
		return false;
		}
	return true;
	}
}




































