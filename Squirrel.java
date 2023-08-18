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
    public boolean checkUpDown(int direction,int otherHeadX,int otherHeadY,int otherBodyX,int otherBodyY,int terrainX,int terrainY, boolean TerrainExists,int otherLPieceX,int otherLPieceY)
    {
        // Collision between walls
        if(((this.headXPos+direction>=0)&&(this.bodyXPos+direction>=0))&&((this.headXPos+direction<4)&&(this.bodyXPos+direction<4)))
        {
            // Collision between heads
            if((this.headXPos+direction !=otherHeadX)||(this.headYPos!=otherHeadY))
            {
                // Collision between tails
                if((this.bodyXPos+direction !=otherBodyX)||(this.bodyYPos!=otherBodyY))
                {
                    // Collision between heads and tails,
                    if((this.headXPos+direction !=otherBodyX)||(this.headYPos!=otherBodyY))
                    {
                        // Collision between tails and heads
                        if((this.bodyXPos+direction !=otherHeadX)||(this.bodyYPos!=otherHeadY))
                        {
                            // Collision between head and terrain
                            if((this.headXPos+direction !=terrainX)||(this.headYPos!=terrainY)||(TerrainExists==false))
                            {
                                // Collision between body and terrain
                                if((this.bodyXPos+direction !=terrainX)||(this.bodyYPos!=terrainY)||(TerrainExists==false))
                                {
                                    // Collision between lPiece and wall
                                    if((((this.lPieceX+direction>=0)&&((this.lPieceX+direction<4))||(this.lPiece==false))))
                                    {
                                        // Collision between Head and lPiece
                                        if((this.headXPos+direction != otherLPieceX)||(this.headYPos!=otherLPieceY))
                                        {
                                            // Collision between lPiece and heads
                                            if((this.lPieceX+direction !=otherHeadX)||(this.lPieceY!=otherHeadY))
                                            {
                                                // Collision between lPiece and tails
                                                if((this.bodyXPos+direction !=otherLPieceX)||(this.bodyYPos!=otherLPieceY))
                                                {
                                                    // Collision between lPiece and Tail
                                                    if((this.lPieceX+direction !=otherBodyX)||(this.lPieceY!=otherBodyY))
                                                    {
                                                        // Collision between lPiece and Terrain
                                                        if((this.lPieceX+direction !=terrainX)||(this.lPieceY!=terrainY)||(TerrainExists==false))
                                                        {
                                                            // Collision between lPiece and lPiece 
                                                            if(((this.lPieceX+direction !=otherLPieceX)||(this.lPieceY!=otherLPieceY))||(this.lPiece==false))
                                                            {
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                }
                                            
                                            }
                                        }
                                    } 
                                }
                            }   
                        } 
                    }
                }      
            }    
        }
        return false;
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
    public boolean checkLeftRight(int direction,int otherHeadX,int otherHeadY,int otherBodyX,int otherBodyY,int terrainX,int terrainY, boolean TerrainExists,int otherLPieceX,int otherLPieceY)
    {
        // Collision between walls
        if(((this.headYPos+direction>=0)&&(this.bodyYPos+direction>=0))&&((this.headYPos+direction<4)&&(this.bodyYPos+direction<4)))
        {
            // Collision between heads
            if((this.headYPos+direction !=otherHeadY)||(this.headXPos!=otherHeadX))
            {
                // Collision between tails
                if((this.bodyYPos+direction !=otherBodyY)||(this.bodyXPos!=otherBodyX))
                {
                    // Collision between heads and tails,
                    if((this.headYPos+direction !=otherBodyY)||(this.headXPos!=otherBodyX))
                    {
                        // Collision between tails and heads
                        if((this.bodyYPos+direction !=otherHeadY)||(this.bodyXPos!=otherHeadX))
                        {
                            // Collision between head and terrain
                            if((this.headYPos+direction !=terrainY)||(this.headXPos!=terrainX)||(TerrainExists==false))
                            {
                                // Collision between body and terrain
                                if((this.bodyYPos+direction !=terrainY)||(this.bodyXPos!=terrainX)||(TerrainExists==false))
                                {
                                    // Collision between lPiece and wall
                                    if((((this.lPieceY+direction>=0)&&(this.lPieceY+direction<4))||(this.lPiece==false)))
                                    {
                                        // Collision between head and lPiece
                                        if((this.headYPos+direction != otherLPieceY)||(this.headXPos!=otherLPieceX))
                                        {
                                            // Collision between lPiece and heads
                                            if((this.lPieceY+direction !=otherHeadY)||(this.lPieceX!=otherHeadX))
                                            {
                                                // Collision between tails and lPiece
                                                if((this.bodyYPos+direction !=otherLPieceY)||(this.bodyXPos!=otherLPieceX))
                                                {
                                                    // Collision between lPiece and tails
                                                    if((this.lPieceY+direction !=otherBodyY)||(this.lPieceX!=otherBodyX))
                                                    {
                                                        // Collision between lPiece and Terrain
                                                        if((this.lPieceY+direction !=terrainY)||(this.lPieceX!=terrainX)||(TerrainExists==false))
                                                        {
                                                            // Collision between lPiece and lPiece 
                                                            if(((this.lPieceY+direction !=otherLPieceY)||(this.lPieceX!=otherLPieceX))||(this.lPiece==false))
                                                            {
                                                                return true;
                                                            }
                                                        }
                                                    }
                                                }
                                            
                                            }
                                        }
                                    }
                                    
                                }  
                            }  
                            
                        } 
                    }
                }      
            }    
 
        }
        return false;
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