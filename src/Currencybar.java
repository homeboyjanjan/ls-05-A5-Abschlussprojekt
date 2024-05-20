import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Currencybar extends Actor {

    public Currencybar() {
        GreenfootImage image = new GreenfootImage("Images/currencybar.png");
        setImage(image);
    }

    @Override
    public void act() {
        getWorld().showText("x" + getWorld().getObjects(Player.class).get(0).getCurrency(),100, 120);
    }
}
