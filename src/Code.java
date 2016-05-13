
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

	// TODO declare constants -->replace by enum
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
	int[] codeColor = new int[4];
	
	
	
	/**
	 * create a random code
	 */
	public Code()
	{
		for(int i=0 ; i<LENGTH_OF_CODE-1; i++)
		{
			codeColor[i] = (int)(Math.random()*8) + 1 ;
			if(i>0)
			{
				int j = i-1 ;
				while( j>=0 && codeColor[i]!=codeColor[j])
				{
					j-- ;
				}
				if(j != -1)
				{
					i-- ;
				}
			}
		}
	}
	
	
	
	
	/**
	 * compare the usercode to the secretcode to change the number_of_red_pegs and number_of_white_pegs
	 */
	public int[] verifCode(Code code)
	{
		int[] number_for_pegs = new int[2];
		
		for(int j=0 ; j<Code.LENGTH_OF_CODE ; j++)
		{
			if(this.codeColor[j] == code.codeColor[j])
			{
				number_for_pegs[0] = number_for_pegs[0]+1 ; //red pegs
			}
			else
			{
				for(int k=0 ; k< Code.LENGTH_OF_CODE ; k++)
				{
					if(this.codeColor[j]== code.codeColor[k])
					{
						number_for_pegs[0] = number_for_pegs[0]+1 ; //white pegs
					}
				}
			}
		}
		return number_for_pegs[] ;
	}
	
	
	
}
