import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class insideCabin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class insideCabin extends World
{
    /**
     * Constructor for objects of class insideCabin.
     * 
     */
    
    public insideCabin()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        userTalk();
    }
    
    private SimpleTimer timer = new SimpleTimer();
    private int currentLabelIndex = 0;
    
    private void userTalk() 
    {
        timer.mark();
        
        Label[] talking = {
            new Label("..the cabins not as bad as I thought it would be.", 30),
            new Label("It'll take me like what..", 30),
            new Label("half an hour?", 30),
            new Label("that sounds right", 30),
            new Label("...", 30),
        };
        
        addObject(talking[0], getWidth()/2, 350);
    }
    
    public void act()
    {
        if(currentLabelIndex < 7 && timer.millisElapsed() > 2500)
        {
            removeObject(getObjects(Label.class).get(0));
            currentLabelIndex++;
            if(currentLabelIndex<7)
            {
                addObject(getLabel(currentLabelIndex), getWidth() / 2, 350);
                timer.mark(); //resets the timer
            }
        }
        else if(currentLabelIndex == 7 && timer.millisElapsed() > 2500)
        {
            removeObject(getObjects(Label.class).get(0));
            addObject(new Label("Ending 1/2", 30), getWidth() / 2, 350);
            currentLabelIndex++;
        }
    }
    
    private Label getLabel(int index)
    {
        Label[] talking = {
            new Label("Hey,", 30),
            new Label("the cabin looks great..", 30),
            new Label("is what I would say if you actually did your job!", 30),
            new Label("The cabin is still infested with bugs!", 30),
            new Label("...", 30),
            new Label("Tsk.", 30),
            new Label("I better be getting a damn refund.", 30)
        };
        return talking[index];
    }
    
    
}
