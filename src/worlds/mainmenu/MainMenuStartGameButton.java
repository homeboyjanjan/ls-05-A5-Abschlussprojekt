package worlds.mainmenu;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import worlds.Space;

public class MainMenuStartGameButton extends Actor {

    public MainMenuStartGameButton() {
        setImage(new GreenfootImage("images/mainmenu_startbutton.png"));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Space());
        }
    }
}
