/**
 * A MasterMind game
 */
// TODO rename class
public class MastermindGame { 
	
	// TODO rename constant
	// TODO add visibility
	/**
	 * the number of round in the game
	 */
	public static int NUMBER_OF_ROUND= 10 ;
	public static int LENGTH_OF_CODE= 4 ;
	
	// TODO write comment
	/**
	 * the code you have to find
	 */
	private final Code secretcode;
	
	
	
	
	
	
	
	/**
	 * Creates a new Mastermind game, with random code
	 */
	public MastermindGame()
	{
		this.secretcode = new Code();
	}
	
	
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
		while(i<NUMBER_OF_ROUND){
			
		
			
			
		}
	}
}