import java.util.Scanner; 

// TODO write comment
/**
 * the application on which the game will run
 */
public class Main {
	
	/**
	 * collect the user entry
	 */
	public static Scanner userentry = new Scanner(System.in);
	
	/**
	 * create a new Mastermind game
	 * @param args
	 */
	public static void main(String[] args) {

		
		
		int answer =1;
		
		while(answer==1){
			MastermindGame blblbl = new MastermindGame() ;
			blblbl.play() ;
			System.out.println("Jouer une nouvelle partie ? OUI-->1     NON-->0");
			answer = userentry.nextInt();
			System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		}

	}
	
}
 
