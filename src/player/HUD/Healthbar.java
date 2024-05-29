package player.HUD;

import greenfoot.Actor;
import greenfoot.GreenfootImage;
import player.Player;

public class Healthbar extends Actor {


    public Healthbar() {
        setImage(new GreenfootImage("images/healthbar5.png"));
    }

    @Override
    public void act() {
        int currentHealth = getWorld().getObjects(Player.class).get(0).getHP();
        setImage(new GreenfootImage("images/healthbar" + currentHealth + ".png"));
    }
}
