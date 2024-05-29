package worlds.shop;

import greenfoot.*;
import worlds.Space;

public class ShopOpenButton extends Actor {

    public ShopOpenButton() {
        setImage(new GreenfootImage("images/shop_open_button.png"));
    }

    @Override
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new Shop((Space) this.getWorld()));
        }
    }
}