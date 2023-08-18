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
 * This class Menu creates a window for where the levels will be displayed,
 * and will allow the use to select the desired level to move on. 
 */

public class Menu 
{
    private JFrame frame;
    private JButton[][] levelButtons = new JButton[5][6]; // A JButton array to hold the level buttons

    /**
	 * Create a view of a Menu.
	 * @param boardW The width of the playing area, in pixels.
	 * @param boardH The height of the playing area, in pixels.
	 */
	public Menu(int boardW, int boardH)
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
	 * Create a the Menu/Level Select for the menu using java swing objects.
	 */
    public void menuBoard()
    {

        JPanel ui = new JPanel(new BorderLayout());
        ActionListener listener = new MyListener();
        
        JLabel welcomeMsg = new JLabel("Welcome to the Cache Noisettes, select a Level."); // Simple JLabel with text to Welcome the user 
        welcomeMsg.setBackground(Color.BLACK);
        welcomeMsg.setFont(new Font("Verdana",1,20));
        ui.add(welcomeMsg, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(5,6)); 
        int count=0;
        JButton btn;  
        for (int i=0; i<5; i++) // The two For loops allow to create a 5x6 grid for the buttons
        {
            for (int j=0; j<6; j++)
            {
                count++;
                btn = new JButton("Level"+(count));
                if (count<13){ // Sets the colours of the levels based on difficulty
                    btn.setBackground(Color.GREEN); 
                }
                else if (count<25)
                {
                    btn.setBackground(Color.YELLOW);
                }
                else{
                    btn.setBackground(Color.RED);
                }
                btn.addActionListener(listener);
                levelButtons[i][j]= btn;
                
                buttonPanel.add(btn);
            }
        }  
        
        ui.add(buttonPanel, BorderLayout.CENTER);
        frame.setContentPane(ui);
        frame.setVisible(true);

    }
    /**
	 * Create a window with a win Messege upon the completion of the Level.
	 */
    public void winMsg(){
        JLabel WelcomeMsg = new JLabel("You Beat the Level, Play Another!"); // Simple JLabel with text to congradulate the user on finishing the level.
        WelcomeMsg.setFont(new Font("Verdana",1,20));
        frame.add(WelcomeMsg);
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
            Object btn =e.getSource(); // Gets the button that has been pressed.
            GameBoard levelBoard = new GameBoard(670,670); // Creates an instance of the game board class.
            
            if(btn==levelButtons[0][0]) // Depending of the button pressed loads different levels.
            {                 
                levelBoard.level1(); 
            } 
            if(btn==levelButtons[0][1])
            {                 
                levelBoard.level2();
            }
            if(btn==levelButtons[0][2])
            {                 
                levelBoard.level3();
            } 
            if(btn==levelButtons[0][3])
            {                 
                levelBoard.level4();
            }
            if(btn==levelButtons[0][4])
            {                 
                levelBoard.level5();
            }
            if(btn==levelButtons[0][5])
            {                 
                levelBoard.level6();
            }
            if(btn==levelButtons[1][0])
            {                 
                levelBoard.level7();
            }
            if(btn==levelButtons[1][1])
            {                 
                levelBoard.level8();
            }
            if(btn==levelButtons[1][2])
            {                 
                levelBoard.level9();
            }
            if(btn==levelButtons[1][3])
            {                 
                levelBoard.level10();
            }
            if(btn==levelButtons[1][4])
            {                 
                levelBoard.level11();
            }
            if(btn==levelButtons[1][5])
            {                 
                levelBoard.level12();
            }
            if(btn==levelButtons[2][0])
            {                 
                levelBoard.level13();
            }
            if(btn==levelButtons[2][1])
            {                 
                levelBoard.level14();
            }
            if(btn==levelButtons[2][2])
            {                 
                levelBoard.level15();
            }
            if(btn==levelButtons[2][3])
            {                 
                levelBoard.level16();
            }
            if(btn==levelButtons[2][4])
            {                 
                levelBoard.level17();
            } 
            if(btn==levelButtons[2][5])
            {                 
                levelBoard.level18();
            } 
            if(btn==levelButtons[3][0])
            {                 
                levelBoard.level19();
            } 
            if(btn==levelButtons[3][1])
            {                 
                levelBoard.level20();
            } 
            if(btn==levelButtons[3][2])
            {                 
                levelBoard.level21();
            }
            if(btn==levelButtons[3][3])
            {                 
                levelBoard.level22();
            } 
            if(btn==levelButtons[3][4])
            {                 
                levelBoard.level23();
            }
            if(btn==levelButtons[3][5])
            {                 
                levelBoard.level24();
            } 
            if(btn==levelButtons[4][0])
            {                 
                levelBoard.level25();
            }  
            if(btn==levelButtons[4][1])
            {                 
                levelBoard.level26();
            }
            if(btn==levelButtons[4][2])
            {                 
                levelBoard.level27();
            }
            if(btn==levelButtons[4][3])
            {                 
                levelBoard.level28();
            }
            if(btn==levelButtons[4][4])
            {                 
                levelBoard.level29();
            }
            if(btn==levelButtons[4][5])
            {                 
                levelBoard.level30();
            }
            levelBoard.createBoard();        
        }
    }
}