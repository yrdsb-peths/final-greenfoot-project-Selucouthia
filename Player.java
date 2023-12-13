import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    GreenfootImage[] walkRight = new GreenfootImage[3];
    GreenfootImage[] walkLeft = new GreenfootImage[3];
    String facing = "right";
    
    int imageIndex = 0;
    SimpleTimer animationTimer = new SimpleTimer();
    public void player()
    {
        for(int i = 0; i < walkRight.length; i++)
        {
             walkRight[i] = new GreenfootImage("walking_left/walk" + i + ".png");
             walkRight[i].scale(90, 80);
        }
        setImage(walkRight[0]);
        
        for(int i = 0; i < walkRight.length; i++)
        {
             walkLeft[i] = new GreenfootImage("walking_left/walk" + i + ".png");
             walkLeft[i].mirrorHorizontally();
             walkLeft[i].scale(90, 80);
        }
    }
    
    public void animatePlayer()
    {
        if(animationTimer.millisElapsed() < 1500)
        {
            return;
        }
        
        if(facing.equals("right"))
        {
            setImage(walkRight[imageIndex]);
            imageIndex = (imageIndex + 1) % walkRight.length;
        }
        else
        {
            setImage(walkLeft[imageIndex]);
            imageIndex = (imageIndex + 1) % walkLeft.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            move(-2);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right"))
        {
            move(2);
            facing = "right";
        }
    }
}
