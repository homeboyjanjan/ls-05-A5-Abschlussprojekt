package worlds.shop;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import greenfoot.World;

public class ShopExitButton extends Actor {
    World exitTo;
    public ShopExitButton(World world){
        setImage(new GreenfootImage("images/shop_open_button.png"));
        this.exitTo = world;
    }
    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(exitTo);
        }
    }
}
