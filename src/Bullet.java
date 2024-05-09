import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class Bullet extends Actor {

    GreenfootImage image;

    public Bullet() {
        this.image = new GreenfootImage("Images/bullet_level1.png");
        setImage(image);
    }

    @Override
    public void act() {
        setRotation(-90);
        move(15);
        if (isAtEdge()){
            getWorld().removeObject(this);
        }
    }
}
