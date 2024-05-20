import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class EnemyAttack extends Actor {

    private final int speed;
    GreenfootImage image;

    public EnemyAttack() {
        this.speed = 6;
        this.image = new GreenfootImage("Images/enemy_attack.png");
        setImage(image);
    }

    public void act() {
        setLocation(getX(), getY() + speed);

        if (isTouching(Player.class)) {
            getIntersectingObjects(Player.class).get(0).setHP(getIntersectingObjects(Player.class).get(0).getHP() - 1);
            getWorld().removeObject(this);
            return;
        }

        if (isAtEdge()) {
            getWorld().removeObject(this);
        }
    }
}
