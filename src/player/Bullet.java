package player;

import enemies.Enemy2;
import greenfoot.Actor;
import greenfoot.GreenfootImage;
import enemies.Enemy1;

public class Bullet extends Actor {

    public int bulletDamage;
    GreenfootImage image;


    public Bullet(int bulletDamage) {
        this.bulletDamage = bulletDamage;
        this.image = new GreenfootImage("images/bullet_level1.png");
        setImage(image);
    }

    @Override
    public void act() {
        setRotation(-90);
        move(15);

        if (isTouching(Enemy1.class)) {
            getIntersectingObjects(Enemy1.class).get(0).setHP(getIntersectingObjects(Enemy1.class).get(0).getHP() - bulletDamage);
            getWorld().removeObject(this);
            return;
        }
        if (isTouching(Enemy2.class)) {
            getIntersectingObjects(Enemy2.class).get(0).setHP(getIntersectingObjects(Enemy2.class).get(0).getHP() - bulletDamage);
            getWorld().removeObject(this);
            return;
        }

        if (isAtEdge()) {
            getWorld().removeObject(this);
        }

    }
}
