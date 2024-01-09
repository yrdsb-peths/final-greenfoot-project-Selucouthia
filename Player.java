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
    
    GreenfootImage[] R_walk = new GreenfootImage[8];
    GreenfootImage[] L_walk = new GreenfootImage[8];
    
    String facing = "right";
    
    int idleIndex = 0;
    int walkIndex = 0;
    SimpleTimer animationTimer = new SimpleTimer();
    public Player()
    {
        //idle animation
        for(int i = 0; i < R_idle.length; i++)
        {
            R_idle[i] = new GreenfootImage("images/idle_right/idle" + i + ".png");
            R_idle[i].scale(150, 224);
            
            L_idle[i] = new GreenfootImage("images/idle_right/idle" + i + ".png");
            L_idle[i].mirrorHorizontally();
            L_idle[i].scale(150, 224);
        }
        
        //walking animation
        for(int i = 0; i < R_walk.length; i++)
        {
             R_walk[i] = new GreenfootImage("images/walking_right/walk" + i + ".png");
             R_walk[i].scale(150, 224);
             
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
        if(animationTimer.millisElapsed() < 150)
        {
            return;
        }
        animationTimer.mark();
        
        //idle animation
        if(facing.equals("right") || facing.equals("d"))
        {
            setImage(R_idle[idleIndex]);
            idleIndex = (idleIndex + 1) % R_idle.length;
        }
        else
        {
            setImage(L_idle[idleIndex]);
            idleIndex = (idleIndex + 1) % L_idle.length;
        }
        
        //walking animation
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            //walking animation for left
            setImage(L_walk[walkIndex]);
            walkIndex = (walkIndex + 1) % L_walk.length;
        }
        else if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            //walking animation for right
            setImage(R_walk[walkIndex]);
            walkIndex = (walkIndex + 1) % R_walk.length;
        }
    }
    
    public void act()
    {
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("a"))
        {
            move(-2);
            facing = "left";
        }
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("d"))
        {
            move(2);
            facing = "right";
        }
        
        if(Greenfoot.isKeyDown("space"))
        {
            
        }
        
        animatePlayer();
    }
}
