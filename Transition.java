import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transition here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transition extends Actor
{
    /**
     * Act - do whatever the Transition wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int transparency = 255;
    private int fadeSpeed = 20;
    public void act()
    {
        
        if(transparency > 0)
        {
            transparency -= fadeSpeed;
            getImage().setTransparency(transparency);
        }
        if(transparency <= 0)
        {
            getWorld().removeObject(this);
        }
    }
}
