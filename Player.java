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
    GreenfootImage[] R_idle = new GreenfootImage[4];
    GreenfootImage[] L_idle = new GreenfootImage[4];
    
    GreenfootImage[] R_walk = new GreenfootImage[4];
    GreenfootImage[] L_walk = new GreenfootImage[4];
    
    String facing = "right";
    
    int imageIndex = 0;
    SimpleTimer animationTimer = new SimpleTimer();
    public Player()
    {
        //idle animation
        for(int i = 0; i < R_idle.length; i++)
        {
             R_idle[i] = new GreenfootImage("images/idle_right/idle" + i + ".png");
             R_idle[i].scale(150, 224);
        }
        for(int i = 0; i < R_idle.length; i++)
        {
             L_idle[i] = new GreenfootImage("images/idle_right/idle" + i + ".png");
             L_idle[i].mirrorHorizontally();
             L_idle[i].scale(150, 224);
        }
        
        //walking animation
        for(int i = 0; i < R_idle.length; i++)
        {
             R_walk[i] = new GreenfootImage("images/walking_right/walk" + i + ".png");
             R_walk[i].scale(150, 224);
        }
        for(int i = 0; i < R_idle.length; i++)
        {
             L_walk[i] = new GreenfootImage("images/walking_right/walk" + i + ".png");
             L_walk[i].mirrorHorizontally();
             L_walk[i].scale(150, 224);
        }
        
        animationTimer.mark();
        
        //starting image for the player
        setImage(R_idle[0]);
    }
    
    public void animatePlayer()
    {    
        if(animationTimer.millisElapsed() < 200)
        {
            return;
        }
        animationTimer.mark();
        
        //idle animation
        if(facing.equals("right"))
        {
            setImage(R_idle[imageIndex]);
            imageIndex = (imageIndex + 1) % R_idle.length;
        }
        else
        {
            setImage(L_idle[imageIndex]);
            imageIndex = (imageIndex + 1) % L_idle.length;
        }
        
        //walking animation
            if(Greenfoot.isKeyDown("left"))
        {
            //walking animation for left
            setImage(L_walk[imageIndex]);
            imageIndex = (imageIndex + 1) % L_walk.length;
        }
        if(Greenfoot.isKeyDown("right"))
        {
            //walking animation for right
            setImage(R_walk[imageIndex]);
            imageIndex = (imageIndex + 1) % R_walk.length;
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
        
        animatePlayer();
    }
}
