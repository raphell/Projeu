import java.util.Scanner; 

// TODO write comment
/**
 * the application on which the game will run
 */
public class Main {
	
		
	/**
	 * create a new Mastermind game
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner userentry = new Scanner(System.in);
		
		int answer =1;
		
		while(answer==1){
			MastermindGame blblbl = new MastermindGame() ;
			blblbl.play() ;
			System.out.println("Jouer une nouvelle partie ? OUI-->1     NON-->0");
			answer = userentry.nextInt();
		}

	}
	
}
 
