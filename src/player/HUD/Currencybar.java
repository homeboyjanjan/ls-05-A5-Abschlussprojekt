package player.HUD;

import greenfoot.Actor;
import greenfoot.GreenfootImage;
import player.Player;

public class Currencybar extends Actor {

    public Currencybar() {
        setImage(new GreenfootImage("images/currencybar.png"));
    }

    @Override
    public void act() {
        getWorld().showText("x" + getWorld().getObjects(Player.class).get(0).getCurrency(), 100, 120);
    }
}
