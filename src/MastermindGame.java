/**
 * A MasterMind game
 */
public class MastermindGame { 
	

	/**
	 * the number of round in the game
	 */
	public static int NUMBER_OF_ROUND= 10 ;
	
	/**
	 * 
	 */
	private int Current_round ;	
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
		this.secretcode = new Code(0);

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
	 *      	afficher victoire, recommencerpartie?
	 *      sinon
	 *      	si (il reste des tours � jouer)
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
		while(i<NUMBER_OF_ROUND){
			this.Usercode = new Code(1) ;
			
			for(int j=0 ; j<Code.LENGTH_OF_CODE ; j++){
				if(this.Usercode.couleurs[j] == this.secretcode.couleurs[j]){
					number_of_red_pegs++ ;
				}
				else{
					for(int k=0 ; k< Code.LENGTH_OF_CODE ; k++){
						if(this.Usercode.couleurs[j]== this.secretcode.couleurs[k]){
							number_of_white_pegs++ ;
						}
					}
					
				}
			}
			
			
			System.out.println("red pegs = "+this.number_of_red_pegs);
			System.out.println("white pegs = "+this.number_of_white_pegs);
			
			if(this.number_of_red_pegs == 4){
				System.out.println("VICTORY in"+this.Current_round+"rounds") ;
			}
		}
	}
}
