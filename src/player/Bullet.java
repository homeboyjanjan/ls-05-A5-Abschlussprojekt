package player;

import greenfoot.Actor;
import greenfoot.GreenfootImage;
import enemies.Enemy;

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

        if (isTouching(Enemy.class)) {
            getIntersectingObjects(Enemy.class).get(0).setHP(getIntersectingObjects(Enemy.class).get(0).getHP() - bulletDamage);
            getWorld().removeObject(this);
            return;
        }

        if (isAtEdge()) {
            getWorld().removeObject(this);
        }

    }
}
