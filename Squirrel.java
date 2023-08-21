/**
 * This class creates Squirrels Objects and allows for simple retrieval and update of object attributes 
 * and is also responisble for all movement occuring with the Squirrel pieces on the board.
 */
public class Squirrel
{
    private String colour;
    private int headXPos;
    private int headYPos;
    private int bodyXPos;
    private int bodyYPos;
    private int rotation;
    private boolean moving;
    private boolean nutEquip;

    private String nutAttached;

    private boolean lPiece;
    private int lPieceX=-4;
    private int lPieceY=-4;

    /** The constructor of the Squirrel Class.
    * @param colour String of the Squirrel colour .
    * @param headXPos Int for the Squirrel head X position.
    * @param headYPos Int for the Squirrel head Y position.
    * @param bodyXPos Int for the Squirrel body X position.
    * @param bodyYPos Int for the Squirrel body Y position.
    * @param lPiece Boolean for if the squirrel head has an attached flower.
    * @param rotation Int for the rotation of the squirrel picture icons.
    */
    public Squirrel(String colour,int headXPos, int headYPos, int bodyXPos, int bodyYPos, boolean lPiece, int rotation)
	{
		this.init(colour,headXPos, headYPos, bodyXPos, bodyYPos, lPiece, rotation , true, false);

	}
    
    /**
	* Internal initialisation method - called by constructor methods.
    * @param nutEquip Boolean for if the squirrel head has a nut.
    * @param moving Boolean for if the squirrel is currently selected.
    */
    private void init(String colour, int headXPos, int headYPos, int bodyXPos, int bodyYPos,boolean lPiece, int rotation, boolean nutEquip, boolean moving )
	{
        this.colour = colour;
        this.headXPos = headXPos;
        this.headYPos = headYPos;
        this.bodyXPos = bodyXPos;
        this.bodyYPos = bodyYPos;
        this.rotation = rotation;
        this.nutEquip = nutEquip;
        this.moving = moving;
        this.lPiece = lPiece;

    }

    /** Checks the Squirrel for if it still has its nut.
    * @param nutEquip Boolean for if the squirrel head has a nut.
    * @param NutAttached Temp Storage for string that helps pick the correct picture for the icon.
    */
    public String GetHead()
    {
        if(this.nutEquip == true)
        {
            nutAttached =("Squirrel1Nut.png");
            return nutAttached;
        }
        else
        {
            nutAttached =("Squirrel1.png");
            return nutAttached;
        }
    }
    /** Gets the Squirrel's colour.
    * @return A string representing the 's cSquirrelolour
    */
    public String getColour()
    {
        return this.colour;
    }
    /** Gets the Squirrel's Head X Position.
    * @return A int representing the Squirrel's Head X coordinate.
    */
    public int getHeadXPos()
    {
        return this.headXPos;
    }
    /** Gets the Squirrel's Head Y Position.
    * @return A int representing the Squirrel's Head Y coordinate.
    */
    public int getHeadYPos()
    {
        return this.headYPos;
    }
    /** Gets the Squirrel's body X Position.
    * @return A int representing the Squirrel's body X coordinate.
    */
    public int getBodyXPos()
    {
        return this.bodyXPos;
    }
    /** Gets the Squirrel's body Y Position.
    * @return A int representing the Squirrel's body Y coordinate.
    */
    public int getBodyYPos()
    {
        return this.bodyYPos;
    }
    /** Gets the Squirrel's orientation.
    * @return A int representing the Squirrel's orientation.
    */
    public int getRotation()
    {
        return this.rotation;
    }
    /** Gets the Squirrel's lPiece Flower X Position.
    * @return A int representing the lPiece Flower X coordinate.
    */
    public int getLPieceX()
    {
        return this.lPieceX;
    }
    /** Gets the Squirrel's lPiece Flower Y Position.
    * @return A int representing the lPiece Flowerd Y coordinate.
    */
    public int getLPieceY()
    {
        return this.lPieceY;
    }
    /** Checks if Squirrel is currently allowed to move.
    * @return A boolean representing if the Squirrel is selected.
    */
    public boolean getMoving()
    {
        return this.moving;
    }
    /** Gets if the Squirrel has a nut.
    * @return A boolean representing if the Squirrel has its nut still.
    */
    public boolean getNut()
    {
        return this.nutEquip;
    }
    /** Gets if the Squirrel has a lPiece Flower.
    * @return A boolean representing if the Squirrel has a lPiece Flower.
    */
    public boolean getLPiece()
    {
        return this.lPiece;
    }

    /** Sets the Squirrel's lPiece Flower coordinates.
    * @param xPos A int containing lPiece Flower's X Position.
    * @param yPos A int containing lPiece Flower's Y Position.
    */
    public void addTerrain(int xPos, int yPos)
    {
        this.lPieceX = xPos;
        this.lPieceY = yPos;
    }
    /** Sets the Squirrel's Head X coordinates.
    * @param xPos A int containing Squirrel's Head X Position.
    */
    public void setHeadXPos(int xPos)
    {
        this.headXPos = xPos;
    }
    /** Sets the Squirrel's Head Y coordinates.
    * @param yPos A int containing Squirrel's Head Y Position.
    */
    public void setHeadYPos(int yPos)
    {
        this.headYPos = yPos;
    }
    /** Sets the Squirrel's Body X coordinates.
    * @param xPos A int containing Squirrel's Body X Position.
    */
    public void setBodyXPos(int xPos)
    {
        this.bodyXPos = xPos;
    }
    /** Sets the Squirrel's Body Y coordinates.
    * @param yPos A int containing Squirrel's Body Y Position.
    */
    public void setBodyYPos(int yPos)
    {
        this.bodyYPos = yPos;
    }
    /** Sets the Squirrel's to have been selected.
    * @param Selected A boolean containing if the Squirrel has been selected.
    */
    public void setMoving(boolean Selected)
    {
        this.moving = Selected;
    }
    /** Sets the Squirrel's to not have a nut.
    */
    public void setNut()
    {
        this.nutEquip=false;
    }

    
    /** Checks if the Squirrel has collided with anything moving north/south.
    * @param direction A int containing (1/-1) to determine which direction the Squirrel is currently being moved in.
    * @param otherHeadX A int containing the others Squirrels' Head X coordinate.
    * @param otherHeadY A int containing the others Squirrels' Head Y coordinate.
    * @param otherBodyX A int containing the others Squirrels' Body X coordinate.
    * @param otherBodyY A int containing the others Squirrels' Body Y coordinate.
    * @param terrainX A int containing the static terrain's X coordinate.
    * @param terrainY A int containing the static terrain's Y coordinate.
    * @param TerrainExists A boolean containing if the static terrain is used on the current level.
    * @param otherLPieceX A int containing the others Squirrels' lPiece X coordinate.
    * @param otherLPieceY A int containing the others Squirrels' lPiece Y coordinate.
    * @param return Returns a boolean value stating that the current Squirrel move didnt conflict with the one being checked against.
    */
    public boolean checkCollisionWithWallsVertical(int direction) {
        return (this.headXPos + direction >= 0) && (this.bodyXPos + direction >= 0) &&
               (this.headXPos + direction < 4) && (this.bodyXPos + direction < 4);
    }
    
    public boolean checkCollisionBetweenHeadsVertical(int direction, int otherHeadX, int otherHeadY) {
        return (this.headXPos + direction != otherHeadX) || (this.headYPos != otherHeadY);
    }
    
    public boolean checkCollisionBetweenTailsVertical(int direction, int otherBodyX, int otherBodyY) {
        return (this.bodyXPos + direction != otherBodyX) || (this.bodyYPos != otherBodyY);
    }
    
    public boolean checkCollisionBetweenHeadsAndTailsVertical(int direction, int otherBodyX, int otherBodyY) {
        return (this.headXPos + direction != otherBodyX) || (this.headYPos != otherBodyY);
    }
    
    public boolean checkCollisionBetweenTailsAndHeadsVertical(int direction, int otherHeadX, int otherHeadY) {
        return (this.bodyXPos + direction != otherHeadX) || (this.bodyYPos != otherHeadY);
    }
    
    public boolean checkCollisionWithTerrainVertical(int direction, int terrainX, int terrainY, boolean terrainExists) {
        return (this.headXPos + direction != terrainX) || (this.headYPos != terrainY) || !terrainExists;
    }
    
    public boolean checkCollisionBetweenBodyAndTerrainVertical(int direction, int terrainX, int terrainY, boolean terrainExists) {
        return (this.bodyXPos + direction != terrainX) || (this.bodyYPos != terrainY) || !terrainExists;
    }
    
    public boolean checkCollisionBetweenLPieceAndWallVertical(int direction) {
        return (this.lPieceX + direction >= 0) && (this.lPieceX + direction < 4) || !this.lPiece;
    }
    
    public boolean checkCollisionBetweenHeadAndLPieceVertical(int direction, int otherLPieceX, int otherLPieceY) {
        return (this.headXPos + direction != otherLPieceX) || (this.headYPos != otherLPieceY);
    }
    
    public boolean checkCollisionBetweenLPieceAndHeadsVertical(int direction, int otherHeadX, int otherHeadY) {
        return (this.lPieceX + direction != otherHeadX) || (this.lPieceY != otherHeadY);
    }
    
    public boolean checkCollisionBetweenTailsAndLPieceVertical(int direction, int otherLPieceX, int otherLPieceY) {
        return (this.bodyXPos + direction != otherLPieceX) || (this.bodyYPos != otherLPieceY);
    }
    
    public boolean checkCollisionBetweenLPieceAndTailsVertical(int direction, int otherBodyX, int otherBodyY) {
        return (this.lPieceX + direction != otherBodyX) || (this.lPieceY != otherBodyY);
    }
    
    public boolean checkCollisionBetweenLPieceAndTerrainVertical(int direction, int terrainX, int terrainY, boolean terrainExists) {
        return (this.lPieceX + direction != terrainX) || (this.lPieceY != terrainY) || !terrainExists;
    }
    
    public boolean checkCollisionBetweenLPieceAndLPieceVertical(int direction, int otherLPieceX, int otherLPieceY) {
        return (this.lPieceX + direction != otherLPieceX) || (this.lPieceY != otherLPieceY) || !this.lPiece;
    }
    
    public boolean checkUpDown(int direction, int otherHeadX, int otherHeadY, int otherBodyX, int otherBodyY, int terrainX, int terrainY, boolean terrainExists, int otherLPieceX, int otherLPieceY) {
        return checkCollisionWithWallsVertical(direction) &&
               checkCollisionBetweenHeadsVertical(direction, otherHeadX, otherHeadY) &&
               checkCollisionBetweenTailsVertical(direction, otherBodyX, otherBodyY) &&
               checkCollisionBetweenHeadsAndTailsVertical(direction, otherBodyX, otherBodyY) &&
               checkCollisionBetweenTailsAndHeadsVertical(direction, otherHeadX, otherHeadY) &&
               checkCollisionWithTerrainVertical(direction, terrainX, terrainY, terrainExists) &&
               checkCollisionBetweenBodyAndTerrainVertical(direction, terrainX, terrainY, terrainExists) &&
               checkCollisionBetweenLPieceAndWallVertical(direction) &&
               checkCollisionBetweenHeadAndLPieceVertical(direction, otherLPieceX, otherLPieceY) &&
               checkCollisionBetweenLPieceAndHeadsVertical(direction, otherHeadX, otherHeadY) &&
               checkCollisionBetweenTailsAndLPieceVertical(direction, otherLPieceX, otherLPieceY) &&
               checkCollisionBetweenLPieceAndTailsVertical(direction, otherBodyX, otherBodyY) &&
               checkCollisionBetweenLPieceAndTerrainVertical(direction, terrainX, terrainY, terrainExists) &&
               checkCollisionBetweenLPieceAndLPieceVertical(direction, otherLPieceX, otherLPieceY);
    }

    /** Moves the Squirrel's X coordinates in either direction north/south.
    * @param direction A int containing (1/-1) to determine which direction the Squirrel is currently being moved in.
    */
    public void moveUpDown(int direction)
    {
        this.headXPos=this.headXPos+direction;
        this.bodyXPos=this.bodyXPos+direction;  
        this.lPieceX = this.lPieceX+direction;    
    }
    
    /** Checks if the Squirrel has collided with anything moving east/west.
    */
    public boolean checkCollisionWithWallsHorizontal(int direction) {
        return (this.headYPos + direction >= 0) && (this.bodyYPos + direction >= 0) &&
               (this.headYPos + direction < 4) && (this.bodyYPos + direction < 4);
    }
    
    public boolean checkCollisionBetweenHeadsHorizontal(int direction, int otherHeadX, int otherHeadY) {
        return (this.headYPos + direction != otherHeadY) || (this.headXPos != otherHeadX);
    }
    
    public boolean checkCollisionBetweenTailsHorizontal(int direction, int otherBodyX, int otherBodyY) {
        return (this.bodyYPos + direction != otherBodyY) || (this.bodyXPos != otherBodyX);
    }
    
    public boolean checkCollisionBetweenHeadsAndTailsHorizontal(int direction, int otherBodyX, int otherBodyY) {
        return (this.headYPos + direction != otherBodyY) || (this.headXPos != otherBodyX);
    }
    
    public boolean checkCollisionBetweenTailsAndHeadsHorizontal(int direction, int otherHeadX, int otherHeadY) {
        return (this.bodyYPos + direction != otherHeadY) || (this.bodyXPos != otherHeadX);
    }
    
    public boolean checkCollisionWithTerrainHorizontal(int direction, int terrainX, int terrainY, boolean terrainExists) {
        return (this.headYPos + direction != terrainY) || (this.headXPos != terrainX) || !terrainExists;
    }
    
    public boolean checkCollisionBetweenBodyAndTerrainHorizontal(int direction, int terrainX, int terrainY, boolean terrainExists) {
        return (this.bodyYPos + direction != terrainY) || (this.bodyXPos != terrainX) || !terrainExists;
    }
    
    public boolean checkCollisionBetweenLPieceAndWallHorizontal(int direction) {
        return (this.lPieceY + direction >= 0) && (this.lPieceY + direction < 4) || !this.lPiece;
    }
    
    public boolean checkCollisionBetweenHeadAndLPieceHorizontal(int direction, int otherLPieceX, int otherLPieceY) {
        return (this.headYPos + direction != otherLPieceY) || (this.headXPos != otherLPieceX);
    }
    
    public boolean checkCollisionBetweenLPieceAndHeadsHorizontal(int direction, int otherHeadX, int otherHeadY) {
        return (this.lPieceY + direction != otherHeadY) || (this.lPieceX != otherHeadX);
    }
    
    public boolean checkCollisionBetweenTailsAndLPieceHorizontal(int direction, int otherLPieceX, int otherLPieceY) {
        return (this.bodyYPos + direction != otherLPieceY) || (this.bodyXPos != otherLPieceX);
    }
    
    public boolean checkCollisionBetweenLPieceAndTailsHorizontal(int direction, int otherBodyX, int otherBodyY) {
        return (this.lPieceY + direction != otherBodyY) || (this.lPieceX != otherBodyX);
    }
    
    public boolean checkCollisionBetweenLPieceAndTerrainHorizontal(int direction, int terrainX, int terrainY, boolean terrainExists) {
        return (this.lPieceY + direction != terrainY) || (this.lPieceX != terrainX) || !terrainExists;
    }
    
    public boolean checkCollisionBetweenLPieceAndLPieceHorizontal(int direction, int otherLPieceX, int otherLPieceY) {
        return (this.lPieceY + direction != otherLPieceY) || (this.lPieceX != otherLPieceX) || !this.lPiece;
    }
    
    public boolean checkLeftRight(int direction, int otherHeadX, int otherHeadY, int otherBodyX, int otherBodyY, int terrainX, int terrainY, boolean terrainExists, int otherLPieceX, int otherLPieceY) {
        
        return checkCollisionWithWallsHorizontal(direction) &&
               checkCollisionBetweenHeadsHorizontal(direction, otherHeadX, otherHeadY) &&
               checkCollisionBetweenTailsHorizontal(direction, otherBodyX, otherBodyY) &&
               checkCollisionBetweenHeadsAndTailsHorizontal(direction, otherBodyX, otherBodyY) &&
               checkCollisionBetweenTailsAndHeadsHorizontal(direction, otherHeadX, otherHeadY) &&
               checkCollisionWithTerrainHorizontal(direction, terrainX, terrainY, terrainExists) &&
               checkCollisionBetweenBodyAndTerrainHorizontal(direction, terrainX, terrainY, terrainExists) &&
               checkCollisionBetweenLPieceAndWallHorizontal(direction) &&
               checkCollisionBetweenHeadAndLPieceHorizontal(direction, otherLPieceX, otherLPieceY) &&
               checkCollisionBetweenLPieceAndHeadsHorizontal(direction, otherHeadX, otherHeadY) &&
               checkCollisionBetweenTailsAndLPieceHorizontal(direction, otherLPieceX, otherLPieceY) &&
               checkCollisionBetweenLPieceAndTailsHorizontal(direction, otherBodyX, otherBodyY) &&
               checkCollisionBetweenLPieceAndTerrainHorizontal(direction, terrainX, terrainY, terrainExists) &&
               checkCollisionBetweenLPieceAndLPieceHorizontal(direction, otherLPieceX, otherLPieceY);
    }

    /** Moves the Squirrel's Y coordinates in either direction east/west.
    */
    public void moveLeftRight(int direction)
    {
        this.headYPos=this.headYPos+direction;
        this.bodyYPos=this.bodyYPos+direction;  
        this.lPieceY = this.lPieceY+direction; 
    }
    

}