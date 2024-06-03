package worlds.mainmenu;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import worlds.Space;

public class MainMenuExitButton extends Actor {
    public MainMenuExitButton() {
        setImage(new GreenfootImage("images/mainmenu_exitbutton.png"));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.stop();
            System.exit(0);
        }
    }
}
