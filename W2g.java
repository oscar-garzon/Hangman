import java.util.Arrays;
import java.util.List;
import java.util.InvalidPropertiesFormatException;

public class W2g {

	private String w2g;
	private List<String> lW2g;
	int celdasNoNull;
	
	public W2g(String word) {
		w2g = word;
		lW2g = Arrays.asList(w2g.split(""));
		celdasNoNull = lW2g.size();
	}
	
	public String getWord() {
		return w2g;
	}
	
	public int getCeldasNoNull() {
		return celdasNoNull;
	}	
	
	/*validates the letter l is in w2g and returns the index in lW2g (returns -1 if the 
	*letter is not in w2g.
	*/
	public int validateLetter(String l) {		
		int i = lW2g.indexOf(l.toUpperCase());  		
		if ( i == -1 && w2g.contains(l.toUpperCase())) {  // la letra ya fue adivinada y se removio de lista			
			return w2g.indexOf(l.toUpperCase());
		}
		makeNodeNull(i);
		return i;
	}
	
	public void makeNodeNull(int i) {
		if(i != -1) {
			lW2g.set(i, null);
			celdasNoNull -= 1;
		}		
	}
	
	public String toString() {
		return lW2g.toString();
	}		
	
}












