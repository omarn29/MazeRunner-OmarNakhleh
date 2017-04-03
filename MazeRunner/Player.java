import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public Player()
    {
        GreenfootImage wallImage = new GreenfootImage (40, 40); 

        wallImage.setColor(Color.BLUE);
        wallImage.fillRect(0, 0, 40, 40);

        setImage(wallImage);
    }

    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @param There is no paramters
     * @return Nothing is returned 
     */
    public void act() 
    {
        movement();
        checkWin();
    }

    /**
     * movement will determine which way to move and will disaple the user from moving through walls
     * by checking comparing what button is pressed and where the wall is 
     * @param There is no paramters
     * @return Nothing is returned 
     */
    private void movement()
    {
        int xOffset = 0;
        int yOffset = 0;

        if( Greenfoot.isKeyDown("up") == true && getOneObjectAtOffset(0,-1, Wall.class) == null )
        {
            setLocation( getX(), getY()-1 ); 
        }
        else if( Greenfoot.isKeyDown("down") == true && getOneObjectAtOffset(0,+1, Wall.class) == null )
        {
            setLocation( getX(), getY()+1 );      
        }
        else if( Greenfoot.isKeyDown("right") == true && getOneObjectAtOffset(1,0, Wall.class) == null )
        { 
            setLocation( getX()+1, getY() ); 
        }
        else if( Greenfoot.isKeyDown("left") == true && getOneObjectAtOffset(-1,0, Wall.class) == null )
        {
            setLocation( getX()-1, getY() ); 
        }
    }

    /**
     * checkWin will check if MazeWalker has reached winnipegSpace and show a message. Then stop the 
     * program
     * @param There are no parameters
     * @return Nothing is returned 
     */
    private void checkWin()
    {
        if ( isTouching(WinningSpace.class) == true )
        {
            getWorld().showText(":)", getWorld().getWidth()/2, getWorld().getHeight()/2);
            Greenfoot.stop();
        }
    }
}
