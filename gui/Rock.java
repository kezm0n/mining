package mining.gui;

/**
 * 
 * enums for each rock and it's ore (ids) to be utilised by the gui
 * 
 */
public enum Rock {
	COPPER(new int[] { 11768, 11769, 11770, 14969 }, 436), 
	TIN(new int[] { 11765, 11766, 11767, 14973 }, 438),
	IRON(new int[] {14971, 14970}, 440),
	COAL(new int[] {14966, 14976, 11762, 11763, 11764}, 453);
	
	private final int[] rockId;
	private final int oreId;
	
	
	/**
	 * @param rockId
	 *            int[] containing all possible rock ids for this specific rock
	 * @param oreId
	 *            int for ore id for this specific rock
	 */
	private Rock(int[] rockId, int oreId) {
		this.rockId = rockId;
		this.oreId = oreId;
	}	
	
	/**
	 * @return array of rock ids
	 */
	public int[] getRockId() {
		return this.rockId;
	}

	/**
	 * @return int of ore id
	 */
	public int getOreId() {
		return this.oreId;
	}

}