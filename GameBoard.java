import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Class;
import java.lang.reflect.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * This class GameBoard creates a window for where the levels will be played,
 * and be used to update the board with the correct icons. 
 */
public class GameBoard 
{
    private int[][] standardBoard = { {0,0,1,0},{1,0,0,0},{0,1,0,0},{0,0,0,1} };
    private JButton[][] objectBoard = new JButton[4][4];
    private JFrame frame;

    // Loading standard pictures to use
    private Picture emptyGround = new Picture("Empty.png", 0);
    private Picture holeGround = new Picture("Hole.png", 0);
    private Picture holeNut = new Picture("HoleNut.png", 0);
    
    private JButton north = new JButton();
    private JButton south = new JButton();
    private JButton east = new JButton();
    private JButton west = new JButton();


    private Squirrel squirrels[]=new Squirrel[5]; // Arrays to hold the objects loaded from the levels
    private StaticTerrain staticTerrain[] = new StaticTerrain[2];

    private int squirrelAmount;

    /**
	 * Create a view of a Menu.
	 * @param boardW The width of the playing area, in pixels.
	 * @param boardH The height of the playing area, in pixels.
	 */
	public GameBoard(int boardW, int boardH)
	{
		this.init(boardW, boardH);
        
	}
    /**
	 * Internal initialisation method - called by constructor methods.
	 */
    private void init(int boardW, int boardH)
	{

        this.frame = new JFrame("Cache Noisettes");
        frame.setSize(boardW, boardH);
		frame.setResizable(false);
		frame.setBackground(Color.BLACK);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);

   
        

    }
    /**
	 * Create a empty board of the game by creating buttons and setting icons.
	 */
    public void createBoard(){

        JPanel ui = new JPanel(new BorderLayout());
        ActionListener listener = new MyListener();
        for(int i=0;squirrels[i]!=null;i++) // Checks how many squirrels have been initialised
        {
            squirrelAmount++;
        }


        north.setBackground(Color.BLACK); // The 4 move directions possible via buttons 
        north.setIcon(new Picture("BigArrow.png", 0));
        ui.add(north, BorderLayout.NORTH);
        north.addActionListener(listener);

        south.setBackground(Color.BLACK);
        south.setIcon(new Picture("BigArrow.png", 180));
        ui.add(south, BorderLayout.SOUTH);
        south.addActionListener(listener);
        
        east.setIcon(new Picture("Arrow.png", 90));
        east.setBackground(Color.BLACK);
        ui.add(east, BorderLayout.EAST);
        east.addActionListener(listener);
        
        west.setIcon(new Picture("Arrow.png", 270));
        west.setBackground(Color.BLACK);
        ui.add(west, BorderLayout.WEST);
        west.addActionListener(listener);


        JPanel buttonPanel = new JPanel(new GridLayout(4,4)); 
        JButton btn;  
        for (int i=0; i<4; i++) 
        {
            for (int j=0; j<4; j++) 
            {
                btn = new JButton();
                objectBoard[i][j] = btn;
                btn.addActionListener(listener);               
                buttonPanel.add(btn);
            }
        }  

        
        
        ui.add(buttonPanel, BorderLayout.CENTER);
        frame.setContentPane(ui);
        frame.setVisible(true);

        drawboard();
    }
    /**
	 * Method that is called upon when the game state changes that will redraw the board with the squirrels and flowers and update if holes have nuts in or not.
	 */
    public void drawboard()
    {
        int count=0; // Temp Variable to incrament if a squirrel doesnt have a nut.
        for (int i=0; i<4; i++) // Checks the current state of the board it the board buttons need to have icons changed after squirrel has moved/ deposited a nut. 
        {
            for (int j=0; j<4; j++)  
            {
                JButton btn;
                btn = objectBoard[i][j];
                switch(standardBoard[i][j]) 
                {
                    case 0:
                        btn.setIcon(emptyGround);
                        break;
                    case 1:
                        btn.setIcon(holeGround);
                        break;
                    case 2:
                        btn.setIcon(holeNut);
                    default:
                }
            }
        }
        for(int i=0;squirrels[i]!=null;i++) // Sets the icon for the buttons depending on Squirrels.
        {
            if((standardBoard[squirrels[i].getHeadXPos()][squirrels[i].getHeadYPos()]==1)&&(squirrels[i].getNut()==true)) // Checks if the squirrel has a nut or not.
            {
                standardBoard[squirrels[i].getHeadXPos()][squirrels[i].getHeadYPos()]=2;
                squirrels[i].setNut();
            }
            objectBoard[squirrels[i].getHeadXPos()][squirrels[i].getHeadYPos()].setIcon(new Picture(squirrels[i].getColour()+squirrels[i].GetHead(), squirrels[i].getRotation()));
            objectBoard[squirrels[i].getBodyXPos()][squirrels[i].getBodyYPos()].setIcon(new Picture(squirrels[i].getColour()+"Squirrel2.png",squirrels[i].getRotation()));
            if(squirrels[i].getLPiece()== true)
            {
                objectBoard[squirrels[i].getLPieceX()][squirrels[i].getLPieceY()].setIcon(new Picture("SquirrelFlower.png",squirrels[i].getRotation()));
            }
            if(squirrels[i].getNut()==false) // If all squirrels have lost their nut declares the game to be won
            {
                count++;
                if(count == squirrelAmount){
                    winGame();
                }
            }
        }
        for(int i=0;staticTerrain[i]!=null;i++) // Sets the icon for the buttons depending on flowers.
        {                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
            if (staticTerrain[i].getStaticTerrainX()>=0){
                objectBoard[staticTerrain[i].getStaticTerrainX()][staticTerrain[i].getStaticTerrainY()].setIcon(new Picture("Flower.png", 0));
            }
        }
        count = 0;
    }
    /**
    * Closes the game window and procceds to WinMsg.
    */
    private void winGame(){
        frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
        Menu Win = new Menu(400, 100);
        Win.winMsg();
    }
    /**
	 * An action listener class to check which button has been pressed
	 */
    private class MyListener implements ActionListener 
    {   
        /**
	    * An action listener class to check which button has been pressed
        * @param e the action performed
	    */
        public void actionPerformed(ActionEvent e) 
        {
            Object btn =e.getSource();
            int direction=0; // Either (+/-) 1 depending of if the squirrel is moving (+/-) in the array. 

            for(int i=0;squirrels[i]!=null;i++) // For loop to see for which squirrel has been selected and allowing for movement for that squirrel.
            {               
                if(btn==objectBoard[squirrels[i].getHeadXPos()][squirrels[i].getHeadYPos()])
                {                   
                    for(int j=0;squirrels[j]!=null;j++)
                    { 
                        squirrels[j].setMoving(false);  
                    }
                    squirrels[i].setMoving(true);
                }
                
                int count = 1; // Int used to keep track of how many squirrels the movement check has looked through before allowing them to move, so one isnt checked twice and a illegal move is permited.
                for(int j=0;squirrels[j]!=null;j++)
                {
                    if((btn==north)||(btn==south))
                    {
                        if(btn==north){
                            direction=-1;
                        }
                        else{
                            direction=1;
                        }
                        if ((squirrels[i].getMoving() == true )&&(squirrels[i] !=squirrels[j])) // Checks squirrels against eachother
                        {   
                            // Checks to see if the movement is legal                     
                            if(true==(squirrels[i].checkUpDown(direction,squirrels[j].getHeadXPos(),squirrels[j].getHeadYPos(),squirrels[j].getBodyXPos(),squirrels[j].getBodyYPos(),staticTerrain[0].getStaticTerrainX(),staticTerrain[0].getStaticTerrainY(), staticTerrain[0].checkExists(),squirrels[j].getLPieceX(),squirrels[j].getLPieceY())))
                            {
                                count++;
                                if (count==squirrelAmount) // If the count matches to SquirrelAmount it means that the current squirrels move is legal.
                                {
                                    squirrels[i].moveUpDown(direction);
                                }

                            }
                            else
                            {
                                count = 1; // If the movements isnt legal count is reset and nothing is moved.
                            }                 

                        }
                    }     
                    else if((btn==east)||(btn==west))
                    {
                        if(btn==east){
                            direction=1;
                        }
                        else{
                            direction=-1;
                        }
                        if ((squirrels[i].getMoving() == true )&&(squirrels[i] !=squirrels[j]))
                        {                           
                            if(true==(squirrels[i].checkLeftRight(direction,squirrels[j].getHeadXPos(),squirrels[j].getHeadYPos(),squirrels[j].getBodyXPos(),squirrels[j].getBodyYPos(),staticTerrain[0].getStaticTerrainX(),staticTerrain[0].getStaticTerrainY(), staticTerrain[0].checkExists(),squirrels[j].getLPieceX(),squirrels[j].getLPieceY())))
                            {
                                count++;
                                if (count==squirrelAmount)
                                {
                                    squirrels[i].moveLeftRight(direction);
                                }

                            }
                            else
                            {
                                count = 1;
                            }  
                        }
                    }   
                }
                           
            }
            drawboard();
        }
    }  
    
    /**
     *  All hard coded levels are bellow they create instances of the objects and load them int arrays
     */
    public void level1()
    {     
        squirrels[0] = new Squirrel("Red",1,1,1,2,false,270);
        squirrels[1] = new Squirrel("Grey",2,2,3,2,false,0);

        staticTerrain[0] = new StaticTerrain(2,1);     
    }
    
    public void level2()
    {
        squirrels[0] = new Squirrel("Brown",2,2,2,3,true,270);
        squirrels[0].addTerrain(1,2);
        squirrels[1] = new Squirrel("Grey",0,1,1,1,false,0);

        staticTerrain[0] = new StaticTerrain(1,0);     
    }

    public void level3()
    {
        squirrels[0] = new Squirrel("Black",0,1,0,0,true,90);
        squirrels[0].addTerrain(1, 0);
        squirrels[1] = new Squirrel("Red",3,0,3,1,false,270);

        staticTerrain[0] = new StaticTerrain(0,2);     
    }

    public void level4()
    {
        squirrels[0] = new Squirrel("Black",3,2,3,3,true,270);
        squirrels[0].addTerrain(2, 3);
        squirrels[1]= new Squirrel("Brown",1,3,0,3,true,180);
        squirrels[1].addTerrain(1, 2);

        staticTerrain[0] = new StaticTerrain(1,0);   
   
    }

    public void level5()
    {
        squirrels[0] = new Squirrel("Black",3,1,2,1,true,180);
        squirrels[0].addTerrain(2, 0);
        squirrels[1] = new Squirrel("Brown",2,2,2,3,true,270);
        squirrels[1].addTerrain(1, 2);

        staticTerrain[0] =new StaticTerrain(0,2);   
    }

    public void level6()
    {
        squirrels[0] = new Squirrel("Black",3,1,3,2,true,270);
        squirrels[0].addTerrain(2, 2);
        squirrels[1]= new Squirrel("Red",2,0,2,1,false,270);

        staticTerrain[0] = new StaticTerrain(1,0);   
    }

    public void level7()
    {
        squirrels[0] = new Squirrel("Brown",0,1,0,0,true,90);
        squirrels[0].addTerrain(1,1);
        squirrels[1] = new Squirrel("Red",0,3,1,3,false,0);

        staticTerrain[0] = new StaticTerrain(0,2);   
    }

    public void level8()
    {
        squirrels[0] = new Squirrel("Black",2,3,1,3,true,180);
        squirrels[0].addTerrain(1,2);
        squirrels[1] = new Squirrel("Red",3,2,3,1,false,90);
                

        staticTerrain[0] = new StaticTerrain(3,3);   
    
    }

    public void level9()
    {
        squirrels[0] = new Squirrel("Brown",0,1,0,0,true,90);
        squirrels[0].addTerrain(1,1);
        squirrels[1] = new Squirrel("Black",1,2,2,2,true,0);
        squirrels[1].addTerrain(2,3);

        staticTerrain[0] = new StaticTerrain(0,2);   

    }

    public void level10()
    {
        squirrels[0] = new Squirrel("Brown",2,0,3,0,true,0);
        squirrels[0].addTerrain(2, 1);
        squirrels[1] = new Squirrel("Black",2,3,1,3,true,180);
        squirrels[1].addTerrain(1, 2);

        staticTerrain[0] = new StaticTerrain(3,3);   
    }

    public void level11()
    {
        squirrels[0] = new Squirrel("Brown",2,3,1,3,true,180);
        squirrels[0].addTerrain(2,2);
        squirrels[1] = new Squirrel("Black",1,2,0,2,true,180);
        squirrels[1].addTerrain(0,1);

        staticTerrain[0] = new StaticTerrain(1,0);   
    }

    public void level12()
    {
        squirrels[0] = new Squirrel("Grey",2,2,1,2,false,180);
        squirrels[1] = new Squirrel("Black",3,2,3,3,true,270);
        squirrels[1].addTerrain(2,3);

        staticTerrain[0] = new StaticTerrain(2,1);   
    }

    public void level13()
    {
        squirrels[0] = new Squirrel("Brown",3,1,2,1,true,180);
        squirrels[0].addTerrain(3,0);
        squirrels[1] = new Squirrel("Grey",2,2,3,2,false,0);

        staticTerrain[0] = new StaticTerrain(0,2);    
    }
  
    public void level14()
    {
        squirrels[0] = new Squirrel("Brown",1,1,0,1,true,180);
        squirrels[0].addTerrain(1,0);
        squirrels[1] = new Squirrel("Black",2,0,3,0,true,0);
        squirrels[1].addTerrain(3,1);

        staticTerrain[0] = new StaticTerrain(3,3);   
    }

    public void level15()
    {
        squirrels[0] = new Squirrel("Black",3,1,3,2,true,270);
        squirrels[0].addTerrain(2,2);
        squirrels[1] = new Squirrel("Red",3,0,2,0,false,180);
        
        staticTerrain[0] = new StaticTerrain(2,1);   
    }

    public void level16()
    {
        squirrels[0] = new Squirrel("Brown",1,3,1,2,true,90);
        squirrels[0].addTerrain(2,3);
        squirrels[1] = new Squirrel("Black",2,2,2,1,true,90);
        squirrels[1].addTerrain(3,1);
        squirrels[2] = new Squirrel("Grey",0,3,0,2,false,90);
        
        staticTerrain[0] = new StaticTerrain(-4,-4);  
        staticTerrain[0].existsFalse(); 

    }

    public void level17()
    {
        squirrels[0] = new Squirrel("Red",3,2,3,1,false,90);
        squirrels[1] = new Squirrel("Grey",2,3,1,3,false,180);
        squirrels[2] = new Squirrel("Brown",2,0,3,0,true,0);
        squirrels[2].addTerrain(2, 1);
        
        staticTerrain[0] = new StaticTerrain(1,0);   
    }

    public void level18()
    {
        squirrels[0] = new Squirrel("Black",3,1,3,2,true,270);
        squirrels[0].addTerrain(2, 2);
        squirrels[1] = new Squirrel("Red",2,0,2,1,false,270);
        squirrels[2] = new Squirrel("Brown",0,0,1,0,true,0);
        squirrels[2].addTerrain(0, 1);

        staticTerrain[0] = new StaticTerrain(3,3);    
    }

    public void level19()
    {
        squirrels[0] = new Squirrel("Red",3,1,3,0,false,90);
        squirrels[1] = new Squirrel("Black",2,0,2,1,true,270);
        squirrels[1].addTerrain(1, 1);
        squirrels[2] = new Squirrel("Brown",0,0,1,0,true,0);
        squirrels[2].addTerrain(0, 1);
        
        staticTerrain[0] = new StaticTerrain(3,3);   
    }

    public void level20()
    {
        squirrels[0] = new Squirrel("Red",1,1,2,1,true,0);
        squirrels[1] = new Squirrel("Black",3,1,3,2,true,270);
        squirrels[1].addTerrain(2, 2);
        squirrels[2] = new Squirrel("Brown",1,3,0,3,false,180);
        squirrels[2].addTerrain(1, 2);

        staticTerrain[0]= new StaticTerrain(3,3);      
    }

    public void level21()
    {
        squirrels[0] = new Squirrel("Red",3,2,3,3,false,270);
        squirrels[1] = new Squirrel("Black",1,1,0,1,true,180);
        squirrels[1].addTerrain(0, 0);
        squirrels[2] = new Squirrel("Grey",2,2,1,2,false,180);
        
        staticTerrain[0]= new StaticTerrain(1,0);   
    }

    public void level22()
    {
        squirrels[0] = new Squirrel("Red",1,1,1,0,false,90);
        squirrels[1] = new Squirrel("Black",1,2,0,2,true,180);
        squirrels[1].addTerrain(0, 1);
        squirrels[2] = new Squirrel("Brown",2,3,1,3,true,180);
        squirrels[2].addTerrain(2, 2);

        staticTerrain[0]= new StaticTerrain(-4,-4);   
        staticTerrain[0].existsFalse();
   
    }

    public void level23()
    {
        squirrels[0] = new Squirrel("Red",3,1,3,0,false,90);
        squirrels[1] = new Squirrel("Black",2,2,3,2,true,0);
        squirrels[1].addTerrain(3, 3);
        squirrels[2] = new Squirrel("Brown",1,1,1,2,true,270);
        squirrels[2].addTerrain(0, 1);
        
        staticTerrain[0]= new StaticTerrain(0,2);    
    }

    public void level24()
    {
        squirrels[0] = new Squirrel("Red",1,3,2,3,false,0);
        squirrels[1] = new Squirrel("Black",2,2,3,2,true,0);
        squirrels[1].addTerrain(3, 3);
        squirrels[2] = new Squirrel("Grey",1,1,0,1,false,180);
        squirrels[2].addTerrain(2, 2);
        
        staticTerrain[0] = new StaticTerrain(0,2);     
    }

    public void level25()
    {
        squirrels[0] = new Squirrel("Red",1,1,1,2,false,270);
        squirrels[1] = new Squirrel("Grey",0,0,1,0,false,0);
        squirrels[2] = new Squirrel("Black",1,3,0,3,true,180);
        squirrels[2].addTerrain(0,2);
        squirrels[3] = new Squirrel("Brown",2,2,3,2,true,0);
        squirrels[3].addTerrain(2, 3);

        staticTerrain[0] = new StaticTerrain(-4,-4); 
        staticTerrain[0].existsFalse(); 
   
    }

    public void level26()
    {
        squirrels[0] = new Squirrel("Red",1,2,1,3,false,270);
        squirrels[1] = new Squirrel("Grey",0,1,0,0,false,90);
        squirrels[2] = new Squirrel("Black",2,0,2,1,true,270);
        squirrels[2].addTerrain(1,1);
        squirrels[3] = new Squirrel("Brown",3,2,3,3,true,270);
        squirrels[3].addTerrain(2, 2);

        staticTerrain[0] = new StaticTerrain(-4,-4); 
        staticTerrain[0].existsFalse();
   
    }
    
    public void level27()
    {
        squirrels[0] = new Squirrel("Red",1,1,0,1,false,180);
        squirrels[1] = new Squirrel("Grey",0,0,1,0,false,0);
        squirrels[2] = new Squirrel("Black",3,2,3,3,true,270);
        squirrels[2].addTerrain(2,3);
        squirrels[3] = new Squirrel("Brown",1,2,1,3,true,270);
        squirrels[3].addTerrain(0, 2);

        staticTerrain[0]= new StaticTerrain(-4,-4); 
        staticTerrain[0].existsFalse();
    }

    public void level28()
    {
        squirrels[0] = new Squirrel("Grey",1,3,0,3,false,180);
        squirrels[1] = new Squirrel("Black",3,1,2,1,true,180);
        squirrels[1].addTerrain(2,0);
        squirrels[2] = new Squirrel("Brown",1,2,1,1,true,90);
        squirrels[2].addTerrain(2, 2);

        staticTerrain[0]= new StaticTerrain(3,3); 
    }

    public void level29()
    {
        squirrels[0] = new Squirrel("Red",2,0,1,0,false,180);
        squirrels[1] = new Squirrel("Grey",0,0,0,1,false,270);
        squirrels[2] = new Squirrel("Brown",2,2,2,3,true,270);
        squirrels[2].addTerrain(1, 2);

        staticTerrain[0]= new StaticTerrain(0,2); 
    }
    
    public void level30()
    {
        squirrels[0] = new Squirrel("Red",2,0,2,1,false,270);
        squirrels[1] = new Squirrel("Black",1,2,2,2,true,0);
        squirrels[1].addTerrain(2,3);
        squirrels[2]= new Squirrel("Brown",1,1,0,1,true,180);
        squirrels[2].addTerrain(1, 0);

        staticTerrain[0] = new StaticTerrain(3,3);  
    }
}
