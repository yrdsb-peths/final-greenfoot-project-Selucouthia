import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Door here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Door extends Actor
{
    /**
     * Act - do whatever the Door wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
       
    //distance needed to interact with an object
    private static final int click_distance = 50;
    public void act()
    {
        if(Greenfoot.isKeyDown("e") && isPlayerClose())
        {
            enterCabin();
        }
    }
    
    private boolean isPlayerClose()
    {
        Actor player = getOneObjectAtOffset(0, 0, Player.class);
        if(player != null)
        {
            int distance = (int) Math.hypot(player.getX() - this.getX(), player.getY() - this.getY());
            return distance <= click_distance;
        }
        return false;
    }
    
    private void enterCabin()
    {
        Greenfoot.setWorld(new insideCabin());
    }
}
