import java.util.Scanner; 

/**
 * A MasterMind game
 */
public class MastermindGame { 
	

	/**
	 * the number of round in the game
	 */
	public static int NUMBER_OF_ROUNDS= 10 ;
	
	
	
	
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
	private Code usercode ;
	
	/**
	 * Creates a new Mastermind game, with random code
	 */
	public MastermindGame()
	{
		this.secretcode = new Code();
	}
	
	
	/**
	 * create a user code
	 * @return a code
	 */
	public Code createUserCode()
	{
		/**
		 * collect the user entry
		 */
		final Scanner userentry = new Scanner(System.in);	
		
		Code uCode = null ;
		
		System.out.println("Saisissez les entiers correspondant aux couleurs");
		for(int i=0 ; i<Code.LENGTH_OF_CODE; i++)
		{
			uCode.codeColor[i] = userentry.nextInt();
			int j = i ;
			while(uCode.codeColor[i]!=uCode.codeColor[j-1] && j>0)
			{
				j-- ;
			}
			if(j!=0)
			{
				System.out.println("Couleur deja utilisee") ;
				i-- ;
			}
		}
		return uCode ;
	}
	
	
	/**
	 * represent the number of well placed pawn
	 */
	private int number_of_red_pegs = 0 ;
	
	/**
	 * represent the number of pawn with good color but with a bad placement
	 */
	private int number_of_white_pegs = 0 ;
	
	
	/**
	 * compare the usercode to the secretcode to change the number_of_red_pegs and number_of_white_pegs
	 */
	public void verifCode()
	{
		for(int j=0 ; j<Code.LENGTH_OF_CODE ; j++)
		{
			if(this.usercode.codeColor[j] == this.secretcode.codeColor[j])
			{
				number_of_red_pegs++ ;
			}
			else
			{
				for(int k=0 ; k< Code.LENGTH_OF_CODE ; k++)
				{
					if(this.usercode.codeColor[j]== this.secretcode.codeColor[k])
					{
						number_of_white_pegs++ ;
					}
				}
				
			}
		}
	}
	
	
	
	
	// TODO write comment (algorithm)
	/**
	 * tant que (la partie n'est pas finie){
	 * 
	 *      demander a l'utilisateur de proposer un code
	 *      	verifier a chaque fois que la couleur n'a pas �t� choisie
	 *      
	 *      verifier que chaque couleur correspond
	 *      		-correspond :
	 *      		-correspond pas : verifier que la couleur est pr�sente
	 *      
	 *      afficher le code dans le tableau
	 *      afficher les indicateurs
	 *      
	 *      si (toutes les couleurs sont bonnes)
	 *      	afficher victoire
	 *      sinon
	 *      	si (il reste des tours � jouer)
	 *      		passe au tour suivant 
	 *      	sinon 
	 *      		afficher defaite
	 *    
	 * 			 
	 * }
	 */
	public void play()
	{
		int i = 1 ;	
		while(i<NUMBER_OF_ROUNDS)
		{
			this.usercode = createUserCode() ;
			
			verifCode() ;
			
			System.out.println("Your code : "+this.usercode.codeColor[0]+this.usercode.codeColor[1]+this.usercode.codeColor[2]+this.usercode.codeColor[3]);
			System.out.println("red pegs = "+this.number_of_red_pegs);
			System.out.println("white pegs = "+this.number_of_white_pegs);
			
			if(this.number_of_red_pegs == 4)
			{
				System.out.println("VICTORY in"+this.current_round+"rounds") ;
				i = NUMBER_OF_ROUNDS ;
			}
		}
		
		if(this.number_of_red_pegs!=4)
		{
			System.out.println("You loose ! :( ");
			System.out.println("The secret code was :" + this.secretcode.codeColor[0]+ this.secretcode.codeColor[1] + this.secretcode.codeColor[
			                                                                                                                                    2] + this.secretcode.codeColor[3]);
		}
	}
}
