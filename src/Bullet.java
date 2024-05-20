import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Bullet extends Actor {

    private final int bulletDamage;
    GreenfootImage image;


    public Bullet() {
        bulletDamage = 2;
        this.image = new GreenfootImage("Images/bullet_level1.png");
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
