
// TODO fix comment
/**
 * Represent a code, generated randomly or choose by the user
 * @author lucianor
 *
 */
public class Code {
	
	/**
	 * the length of the code
	 */
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
	 

	/**
	 * these integer compose the code
	 */
	int[] codeColor ;
	
	
	
	/**
	 * create a random code
	 */
	public Code()
	{
		for(int i=0 ; i<LENGTH_OF_CODE; i++)
		{
			codeColor[i] = (int)(Math.random()*8) + 1 ;
			int j = i-1 ;
			while(codeColor[i]!=codeColor[j] && j>=0)
			{
				j-- ;
			}
			if(j!=-1)
			{
				i-- ;
			}
		}
	}
}
