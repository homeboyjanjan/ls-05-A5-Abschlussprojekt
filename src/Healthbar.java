import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Healthbar extends Actor {


    public Healthbar() {
        setImage((GreenfootImage) null);
    }

    @Override
    public void act() {
        int currentHealth = getWorld().getObjects(Player.class).get(0).getHP();
        setImage(new GreenfootImage("Images/healthbar" + currentHealth + ".png"));
    }
}
