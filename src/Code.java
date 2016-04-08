import java.util.Scanner; 

// TODO fix comment
/**
 * Represent a code, generated randomly or choose by the user
 * @author lucianor
 *
 */
public class Code {
	
	public static int LENGTH_OF_CODE = 4 ;	
	// TODO declare constants
	public static int YELLOW = 1 ;
	public static int RED = 2 ;
	public static int GREEN = 3 ;
	public static int BLUE = 4 ;
	public static int ORANGE = 5 ;
	public static int WHITE = 6 ;
	public static int PURPLE = 7 ;
	public static int PINK = 8 ;
	 
	Scanner userentry = new Scanner(System.in);

	
	// TODO write comment
	/**
	 * these integer compose the code
	 */
	int[] couleurs ;
	

	/**
	 * create a code
	 */
	public Code(int x)
	{
		if (x==0){
			//CREATE A RANDOM CODE
			for(int i=0 ; i<LENGTH_OF_CODE; i++){
				couleurs[i] = (int)(Math.random()*8) + 1 ;
			}
		}
		else{
			//CREATE A USER CODE
			System.out.println("Saisissez les entiers correspondant aux couleurs");
			for(int i=0 ; i<LENGTH_OF_CODE; i++){
				couleurs[i] = userentry.nextInt();
				int j = i ;
				while(couleurs[i]!=couleurs[j-1] && j>0){
					j-- ;
				}
				if(j!=0){
					System.out.println("Couleur deja utilisee") ;
					i-- ;
				}
			}
		}
	}
	
	
	
}
