import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class cabinLayout here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class cabinLayout extends World
{

    /**
     * Constructor for objects of class cabinLayout.
     * 
     */
    public cabinLayout()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        Shelf shelf = new Shelf();
        addObject(shelf, 440, 90);
        
        Flame flame = new Flame();
        addObject(flame,166, 234);
        
        livingRoom livingRoom = new livingRoom();
        addObject(livingRoom, 488, 323);
        
        Player player = new Player();
        addObject(player, 70, 100);
        
        
    }
}
