package mining;

/**
 * Global variables to allow us to work things between classes
 * eg. set via gui, read via instance of Mine
 */
public class Information {
	
	//array of ints for the unmined rock ids
	public static int[] ROCK_IDS;
	
	//int for the ore id, explicit default 0 (though should be 0 anyway) so we can make sure the script only functions when options selected in gui
	public static int ORE_ID = 0;
}
