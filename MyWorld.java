import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @ 
 * @2023/12/12
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
               
        Door door = new Door();
        addObject(door, 553, 264);
        
        Sign sign = new Sign();
        addObject(sign, 22, 337);
        
        Player player = new Player();
        addObject(player, 150, 302);
    }
}
