import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Player extends Actor {

    private int HP;
    private int initialHP;
    private int currency;
    private int speed;
    GreenfootImage image;
    private int ShotCooldown;


    public Player() {
        this.initialHP = 5;
        this.ShotCooldown = 0;
        this.HP = 5;
        this.currency = 400;
        this.speed = 7;
        this.image = new GreenfootImage("Images/spaceship.png");
        setImage(image);
    }

    public int getInitialHP() {
        return initialHP;
    }

    public void setInitialHP(int initialHP) {
        this.initialHP = initialHP;
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

    public int getShotCooldown() {
        return ShotCooldown;
    }

    public void setShotCooldown(int shotCooldown) {
        this.ShotCooldown = shotCooldown;
    }

    public void shoot() {
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet, getX(), getY());
        setShotCooldown(25);
    }

    @Override
    public void act() {
        if (ShotCooldown > 0) {
            ShotCooldown--;
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
        if (Greenfoot.isKeyDown("up") && ShotCooldown == 0) {
            shoot();
        }
        if (HP == 0) {
            getWorld().setBackground("Images/gameoverscreen.png");
            getWorld().removeObjects(getWorld().getObjects(null));
            Greenfoot.stop();
        }
    }
}
