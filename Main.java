import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Class;
import java.lang.reflect.*;
/**
 * The main class is used in launching the menu for the level screen to run on.
 */
public class Main 
{   
    /**
    * The main method stats the code and initilises the frame size to be used for the program.
    * @param args The command line arguments.
    **/
    public static void main(String[] args)
    {
        int arenaWidth = 670;
        int arenaHeight = 670;


        Menu LevelSelect = new Menu(arenaWidth, arenaHeight); // Creates and instance of the Menu Class called LevelSelect 
        LevelSelect.menuBoard();
    }
}
