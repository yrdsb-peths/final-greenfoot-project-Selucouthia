import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class insideCabin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class insideCabin extends World
{
    GreenfootSound bugsFlying = new GreenfootSound("bugNoises.wav");
    
    public insideCabin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        bugsFlying.play();
        userTalk();
    }
    
    private SimpleTimer timer = new SimpleTimer();
    private int currentLabelIndex = 0;
    
    private void userTalk() 
    {
        timer.mark();
        
        Label[] talking = {
            new Label("...", 30),
            new Label("..this cabin is infested!", 30),
            new Label("why'd I take this job?", 30),
            new Label("This is going to take a while", 30),
            new Label("ugh", 30),
            new Label("...", 30),
        };
        
        addObject(talking[0], getWidth()/2, 350);
    }
    
    public void act()
    {
        if(currentLabelIndex < 6 && timer.millisElapsed() > 2500)
        {
            removeObject(getObjects(Label.class).get(0));
            currentLabelIndex++;
            if(currentLabelIndex<6)
            {
                addObject(getLabel(currentLabelIndex), getWidth() / 2, 350);
                timer.mark(); //resets the timer
            }
        }
        else if(currentLabelIndex == 6 && timer.millisElapsed() > 2500)
        {
            cabinTopView();
        }
    }
    
    private Label getLabel(int index)
    {
        Label[] talking = {
            new Label("...", 30),
            new Label("..this cabin is infested!", 30),
            new Label("why'd I take this job?", 30),
            new Label("This is going to take a while", 30),
            new Label("ugh", 30),
            new Label("...", 30),
        };
        return talking[index];
    }
    
    private void cabinTopView()
    {
        Greenfoot.setWorld(new cabinLayout());
    }
    
}
