import java.util.Scanner; 

/**
 * A MasterMind game
 */
public class MastermindGame { 
	

	/**
	 * the number of round in the game
	 */
	public static int NUMBER_OF_ROUND= 10 ;
	
	/**
	 * the length of the code
	 */
	public static int LENGTH_OF_CODE = 4 ;	
	
	/**
	 * collect the user entry
	 */
	Scanner userentry = new Scanner(System.in);
	
	/**
	 * the number of the current round
	 */
	private int current_round ;	
	// TODO rename field (coding conventions)
	/**
	 * the code you have to find
	 */
	private final Code secretcode;
	
	/**
	 * the code choose by the user
	 */
	private Code Usercode ;
	
	/**
	 * Creates a new Mastermind game, with random code
	 */
	public MastermindGame()
	{
		this.secretcode = new Code();
	}
	
	
	/**
	 * stock an integer table to create a code with it
	 */
	int[] couleurs ;
	
	/**
	 * create a user code
	 * @return a table
	 */
	public int[] CreateUserCode()
	{
		System.out.println("Saisissez les entiers correspondant aux couleurs");
		for(int i=0 ; i<LENGTH_OF_CODE; i++)
		{
			couleurs[i] = userentry.nextInt();
			int j = i ;
			while(couleurs[i]!=couleurs[j-1] && j>0)
			{
				j-- ;
			}
			if(j!=0)
			{
				System.out.println("Couleur deja utilisee") ;
				i-- ;
			}
		}
		return couleurs ;
	}
	
	
	/**
	 * represent the number of well placed pawn
	 */
	private int number_of_red_pegs = 0 ;
	
	/**
	 * represent the number of pawn with good color but with a bad placement
	 */
	private int number_of_white_pegs = 0 ;
	
	
	// TODO write comment (algorithm)
	/**
	 * tant que (la partie n'est pas finie){
	 * 
	 *      demander a l'utilisateur de proposer un code
	 *      	verifier a chaque fois que la couleur n'a pas été choisie
	 *      
	 *      verifier que chaque couleur correspond
	 *      		-correspond :
	 *      		-correspond pas : verifier que la couleur est présente
	 *      
	 *      afficher le code dans le tableau
	 *      afficher les indicateurs
	 *      
	 *      si (toutes les couleurs sont bonnes)
	 *      	afficher victoire, recommencerpartie?
	 *      sinon
	 *      	si (il reste des tours à jouer)
	 *      		passe au tour suivant 
	 *      	sinon 
	 *      		afficher defaite/recommencerpartie?
	 *    
	 * 			 
	 * }
	 */
	public void play()
	{
		int i = 1 ;	
		while(i<NUMBER_OF_ROUND)
		{
			
			this.Usercode = new Code(CreateUserCode()) ;
			
			for(int j=0 ; j<Code.LENGTH_OF_CODE ; j++)
			{
				if(this.Usercode.codeColor[j] == this.secretcode.codeColor[j])
				{
					number_of_red_pegs++ ;
				}
				else
				{
					for(int k=0 ; k< Code.LENGTH_OF_CODE ; k++)
					{
						if(this.Usercode.codeColor[j]== this.secretcode.codeColor[k])
						{
							number_of_white_pegs++ ;
						}
					}
					
				}
			}
			
			System.out.println("Your code : "+this.Usercode.codeColor[0]+this.Usercode.codeColor[1]+this.Usercode.codeColor[2]+this.Usercode.codeColor[3]);
			System.out.println("red pegs = "+this.number_of_red_pegs);
			System.out.println("white pegs = "+this.number_of_white_pegs);
			
			if(this.number_of_red_pegs == 4)
			{
				System.out.println("VICTORY in"+this.current_round+"rounds") ;
				i = NUMBER_OF_ROUND ;
			}
		}
		
		if(this.number_of_red_pegs!=4)
		{
			System.out.println("You loose ! :( ");
		}
	}
}
