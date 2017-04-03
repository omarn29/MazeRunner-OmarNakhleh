import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class WinningSpace here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinningSpace extends Actor
{
    public WinningSpace()
    {
        GreenfootImage wallImage = new GreenfootImage (40, 40); 

        wallImage.setColor(Color.GREEN);
        wallImage.fillRect(0, 0, 40, 40);

        setImage(wallImage);
    }

    /**
     * Act - do whatever the WinningSpace wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @param There are no parameters
     * @return Nothing is returned 
     */
    public void act() 
    {
        // Add your action code here.
    }
}
