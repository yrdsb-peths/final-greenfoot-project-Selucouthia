import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ending_left here.
 * 
 * @Alivia
 */
public class Ending_left extends World
{
    private SimpleTimer timer = new SimpleTimer();
    private int currentLabelIndex = 0;
    
    public Ending_left()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        messages();
    }

    private void messages() {
        timer.mark(); // starts the timer

        Label[] message = {
            new Label("Hey,", 30),
            new Label("the cabin looks great..", 30),
            new Label("is what I would say if you actually did your job!", 30),
            new Label("The cabin is still infested with bugs!", 30),
            new Label("...", 30),
            new Label("Tsk.", 30),
            new Label("I better be getting a damn refund.", 30)
        };

        addObject(message[0], getWidth() / 2, 350);
    }

    public void act() 
    {
        if (currentLabelIndex < 7 && timer.millisElapsed() > 2500) 
        {
            // Check if there are labels before removing
            if (!getObjects(Label.class).isEmpty()) {
                removeObject(getObjects(Label.class).get(0));
            }
            currentLabelIndex++;
            if (currentLabelIndex < 7) {
                addObject(getLabel(currentLabelIndex), getWidth() / 2, 350);
                timer.mark(); // Resets the timer
            }
        }
            else if (currentLabelIndex == 7 && timer.millisElapsed() > 2500) 
            {
            // Check if there are labels before removing
            if (!getObjects(Label.class).isEmpty()) {
                removeObject(getObjects(Label.class).get(0));
            }
            addObject(new Label("Ending 1/2", 30), getWidth() / 2, 350);
            currentLabelIndex++;
        }
    }

    private Label getLabel(int index)
    {
        Label[] message = 
        {
            new Label("Hey,", 30),
            new Label("the cabin looks great..", 30),
            new Label("is what I would say if you actually did your job!", 30),
            new Label("The cabin is still infested with bugs!", 30),
            new Label("...", 30),
            new Label("Tsk.", 30),
            new Label("I better be getting a damn refund.", 30)
        };
        return message[index];
    }

}