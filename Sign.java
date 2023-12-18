import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sign here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sign extends Actor
{
    /**
     * Act - do whatever the Sign wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        Greenfoot.setWorld(new Ending_left());
    }
}
