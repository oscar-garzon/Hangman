import java.util.ArrayList;
import java.util.List;

public class UserWord {
	
	private List<String> word = null;
	private int n = 0;
	
	// capacity is the number of elements on the list 
	public UserWord(int n) {
		word = new ArrayList<String>();
		this.n = n;
		fillListDashes(); // IS THIS A GOOD PROGRAMMING PRACTICE??
	}
	
	private void fillListDashes() {						
		for(int i = 0; i < n; i++) {
			word.add("-");			
		}		
	}
	
	public String toString() {		
		String s = "";
		for(String c: word) {
			s += c;			
		}				
		return s;
	}	
	
	public void addLetterGuessToUW(int index, String letter) {				
		word.set(index, letter);
		
	}
	

}













