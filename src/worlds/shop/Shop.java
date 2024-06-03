package worlds.shop;

import greenfoot.Greenfoot;
import greenfoot.World;
import player.Player;
import worlds.Space;

public class Shop extends World {

    public Space spaceWorld;
    public int timer = 0;

    public Shop(Space world) {
        super(1200, 580, 1);
        setBackground("images/shop.png");
        this.spaceWorld = world;
        ShopExitButton shopExitButton = new ShopExitButton(world);
        addObject(shopExitButton, 75, 200);
    }

    @Override
    public void act() {
        if (timer >0) {
            timer--;
        }
        showText("On this planet you get the ability to upgrade your ship!", 500, 100);
        showText("Press the corresponding key to upgrade whatever part of your ship you want!", 500, 150);
        showText("Your current currency is:  " + spaceWorld.getObjects(Player.class).get(0).getCurrency(), 150, 500);
        if (Greenfoot.isKeyDown("1") && spaceWorld.getObjects(Player.class).get(0).getCurrency() >= 50 && timer == 0) {
            if (spaceWorld.getObjects(Player.class).get(0).getHP() < 7) {
                spaceWorld.getObjects(Player.class).get(0).setHP(spaceWorld.getObjects(Player.class).get(0).getInitialHP() + 1);
                spaceWorld.getObjects(Player.class).get(0).setInitialHP(spaceWorld.getObjects(Player.class).get(0).getInitialHP() + 1);
                spaceWorld.getObjects(Player.class).get(0).setCurrency(spaceWorld.getObjects(Player.class).get(0).getCurrency() - 50);
                timer = 50;
            } else {
                showText("You have reached maximum HP amount!", 900, 200);
            }
        }
        if (Greenfoot.isKeyDown("2") && spaceWorld.getObjects(Player.class).get(0).getCurrency() >= 30 && timer == 0) {
            spaceWorld.getObjects(Player.class).get(0).setSpeed(spaceWorld.getObjects(Player.class).get(0).getSpeed() + 2);
            spaceWorld.getObjects(Player.class).get(0).setCurrency(spaceWorld.getObjects(Player.class).get(0).getCurrency() - 30);
            timer = 50;
        }
        if (Greenfoot.isKeyDown("3") && spaceWorld.getObjects(Player.class).get(0).getCurrency() >= 75 && timer == 0) {
            spaceWorld.getObjects(Player.class).get(0).setBulletDamage(1);
            spaceWorld.getObjects(Player.class).get(0).setCurrency(spaceWorld.getObjects(Player.class).get(0).getCurrency() - 75);
            timer = 50;
        }
    }
}
