import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Player extends Actor {

    private int HP;
    private int currency;
    private int speed;
    GreenfootImage image;
    int cooldown = 0;


    public Player() {
        this.HP = 5;
        this.currency = 0;
        this.speed = 7;
        this.image = new GreenfootImage("Images/spaceship.png");
        setImage(image);
    }

    public int getCurrency() {
        return currency;
    }
    public void setCurrency(int currency) {
        this.currency = currency;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public void shoot() {
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY());
        cooldown = 25;
    }

    @Override
    public void act() {
        if (cooldown > 0) {
            cooldown--;
        }
        if (Greenfoot.isKeyDown("w")) {
            setLocation(getX(), getY() - speed);
        }
        if (Greenfoot.isKeyDown("a")) {
            setLocation(getX() - speed, getY());
        }
        if (Greenfoot.isKeyDown("s")) {
            setLocation(getX(), getY() + speed);
        }
        if (Greenfoot.isKeyDown("d")) {
            setLocation(getX() + speed, getY());
        }
        if (Greenfoot.isKeyDown("up") && cooldown == 0) {
            shoot();
        }
        if (HP == 0) {
            getWorld().setBackground("Images/gameoverscreen.png");
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.stop();
        }
    }
}
