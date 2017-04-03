import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;
/**
 * Write a description of class MazeWalker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MazeWalker extends Actor
{
    private final int NORTH = 270;
    private final int EAST = 0;
    private final int SOUTH = 90;
    private final int WEST = 180;

    public MazeWalker()
    {
        GreenfootImage wallImage = new GreenfootImage (40, 40); 

        wallImage.setColor(Color.RED);
        wallImage.fillRect(0, 0, 40, 40);

        setImage(wallImage);
        setRotation(WEST);
    }

    /**
     * Act - do whatever the MazeWalker wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * @param There are no parameters
     * @return Nothing is returned 
     */
    public void act() 
    {
        checkWin();

        if (wallOnLefT() == true )
        {
            if (canMoveForward() == true )
            {
                move(1);
            }
            else
            {
                setRotation( getRotation() + 90 );
            }
        }
        else
        {
            setRotation( getRotation() - 90 );

            if (canMoveForward() == true )
            {
                move(1);
            }
        }
    } 

    /**
     * checkWin will check if MazeWalker has reached winnipegSpace and show a message
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

    /**
     * wallOnLeft will check if there is a wall on the players left
     * @param There are no parameters
     * @return boolean stating whether or not there is a wall on the left 
     */
    private boolean wallOnLefT()
    {
        int xOffset = 0;
        int yOffset = 0;

        boolean wallLeft = false;

        if (getRotation() == NORTH)
        {
            xOffset = -1;
        }
        else if (getRotation() == SOUTH)
        {
            xOffset = +1;
        }
        else if (getRotation() == EAST)
        {
            yOffset = -1;
        }
        else if (getRotation() == WEST)
        {
            yOffset = +1;
        }

        if( getOneObjectAtOffset( xOffset, yOffset, Wall.class ) != null )
        {
            wallLeft = true;
        }

        return wallLeft;
    }

    /**
     * canMoveForward checks wheather MazeWalker can move forward
     * @param There are no parameters
     * @return boolean stating whether or not can move forward
     */
    private boolean canMoveForward()
    {
        int xOffset = 0;
        int yOffset = 0;

        boolean moveForward = false;

        if ( getRotation() == NORTH )
        {
            yOffset = -1;
        }
        else if ( getRotation() == SOUTH )
        {
            yOffset = +1;
        }
        else if ( getRotation() == EAST )
        {
            xOffset = +1;
        }
        else if ( getRotation() == WEST )
        {
            xOffset = -1;
        }

        if( getOneObjectAtOffset( xOffset, yOffset, Wall.class ) == null )
        {
            moveForward = true;
        }

        return moveForward;
    }
}
