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
	private int current_round;	

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
	 * represent the number of well placed pawn
	 */
	private int number_of_red_pegs = 0 ;
	
	/**
	 * represent the number of pawn with good color but with a bad placement
	 */
	private int number_of_white_pegs = 0 ;
	
	
	/**
	 * create a user code
	 * @return a code
	 */
	public Code createUserCode()
	{
		Code uCode = new Code() ;
		
		System.out.println("Saisissez les entiers correspondant aux couleurs");
		for(int i=0 ; i<Code.LENGTH_OF_CODE; i++)
		{
			System.out.print("Pion "+i+" :") ;
			uCode.codeColor[i] = Main.userentry.nextInt();
			if(uCode.codeColor[i]>=0 && uCode.codeColor[i]<9)
			{
				int j = i-1 ;
				while(j>=0 && uCode.codeColor[i]!=uCode.codeColor[j])
				{
					j-- ;
				}
				if(j!=-1)
				{
					System.out.println("Couleur deja utilisee") ;
					i-- ;
				}
			}
			else
			{
				System.out.println("Valeur invalide !");
				i-- ;
			}
			
		}
		return uCode ;
	}
	
	

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
	 *      	afficher victoire
	 *      sinon
	 *      	si (il reste des tours à jouer)
	 *      		passe au tour suivant 
	 *      	sinon 
	 *      		afficher defaite 
	 * }
	 */
	public void play()
	{
		current_round = 1;
		while(current_round<=NUMBER_OF_ROUNDS)
		{
			this.usercode = createUserCode() ;
			
			number_of_red_pegs = this.usercode.verifCode(this.secretcode)[0] ;
			number_of_white_pegs = this.usercode.verifCode(this.secretcode)[1] ;
			
			System.out.println("Your code : "+this.usercode.codeColor[0]+this.usercode.codeColor[1]+this.usercode.codeColor[2]+this.usercode.codeColor[3]);
			System.out.println("red pegs = "+this.number_of_red_pegs);
			System.out.println("white pegs = "+this.number_of_white_pegs);
			System.out.println("Round number: "+ this.current_round);
			
			if(this.number_of_red_pegs == 4)
			{
				System.out.println("VICTORY ! ! ! in "+this.current_round+" rounds") ;
				current_round = NUMBER_OF_ROUNDS ;
			}
			current_round++ ;
		}
		
		if(this.number_of_red_pegs!=4)
		{
			System.out.println("You loose ! :( ");
			System.out.println("The secret code was :" + this.secretcode.codeColor[0]+ this.secretcode.codeColor[1] + this.secretcode.codeColor[2] + this.secretcode.codeColor[3]);
		}
	}
}
