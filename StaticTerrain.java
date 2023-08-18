/**
 * This class simply creates StaticTerrain objects and allows for simple retrieval and update of object attributes,
 *  allowing for the GameBoard to use it to load icons on the static terrain possitions.
 */
public class StaticTerrain
{

    private int terrainX;
    private int terrainY;
    private boolean exists;

    /** The constructor of the StaticTerrain Class.
    * @param TerrainX Int of the terrain Instance X coordinate.
    * @param TerrainY Int of the terrain Instance Y coordinate.
    */
    public StaticTerrain(int terrainX, int terrainY)
	{
		this.init(terrainX, terrainY,true);

	}

    /**
	* Internal initialisation method - called by constructor methods.
    * @param Exists boolean value stating the the terrain should be displayed on the board and used in collisions.
    */
    private void init(int TerrainX, int TerrainY, Boolean Exists)
	{
        this.terrainX = TerrainX;
        this.terrainY = TerrainY;
        this.exists = Exists;
    }
    /**
	* Method to retrieve the Static Terrain X coordinate.
    * @param return int value returned of the Static Terrain X coordinate.
    */
    public int getStaticTerrainX()
    {
        return this.terrainX;
    }
    /**
	* Method to retrieve the Static Terrain Y coordinate.
    * @param return int value returned of the Static Terrain Y coordinate.
    */
    public int getStaticTerrainY()
    {
        return this.terrainY;
    }
    /**
	* Method to check if the terrain should be visable and used for the current level.
    * @param return boolean value returned to the program so static terrain is considered.
    */
    public boolean checkExists()
    {
        return this.exists;
    }
    /**
	* Method to set terrain to (false) to not be used when drawn or collsision checked.
    */
    public void existsFalse()
    {
        this.exists=false;
    }



}