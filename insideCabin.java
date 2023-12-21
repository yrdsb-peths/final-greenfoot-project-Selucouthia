import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class insideCabin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class insideCabin extends World
{
    Label talk = new Label("This place is pretty clean, 
    /**
     * Constructor for objects of class insideCabin.
     * 
     */
    public insideCabin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        messageBack messageBack = new messageBack();
        addObject(messageBack, 300, 335);
    }
}
