import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Currencybar extends Actor {


    public Currencybar() {
        setImage((GreenfootImage) null);
    }

    @Override
    public void act() {
        setImage(new GreenfootImage("Images/currencybar.png"));
        getWorld().showText("x" + getWorld().getObjects(Player.class).get(0).getCurrency(), 100, 120);
    }
}
