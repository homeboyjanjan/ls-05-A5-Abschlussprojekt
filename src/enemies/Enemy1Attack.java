package enemies;

import greenfoot.Actor;
import greenfoot.GreenfootImage;
import player.Player;

public class Enemy1Attack extends Actor {

    private final int speed;
    GreenfootImage image;

    public Enemy1Attack() {
        this.speed = 6;
        this.image = new GreenfootImage("images/enemy1_attack.png");
        setImage(image);
    }

    public void act() {
        setLocation(getX(), getY() + speed);

        if (isTouching(Player.class)) {
            getIntersectingObjects(Player.class).get(0).setHP(getIntersectingObjects(Player.class).get(0).getHP() - 1);
            getWorld().getObjects(Player.class).get(0).setScore(getWorld().getObjects(Player.class).get(0).getScore() - 100);
            getWorld().removeObject(this);
            return;
        }

        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
