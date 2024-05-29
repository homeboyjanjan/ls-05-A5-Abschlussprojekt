package player;

import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;
import worlds.Gameover;

public class Player extends Actor {

    private int HP;
    private int initialHP;
    private int currency;
    private int speed;
    GreenfootImage image;
    private int ShotCooldown;
    private int bulletDamage = 2;

    public Player() {
        this.initialHP = 5;
        this.ShotCooldown = 0;
        this.HP = 5;
        this.currency = 0;
        this.speed = 7;
        this.image = new GreenfootImage("images/spaceship.png");
        setImage(image);
    }

    public int getBulletDamage() {
        return bulletDamage;
    }

    public void setBulletDamage(int bulletDamage) {
        this.bulletDamage += bulletDamage;
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
        Bullet bullet = new Bullet(getBulletDamage());
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
        if (HP <= 0) {
            Gameover gameover = new Gameover();
            Greenfoot.setWorld(gameover);
            Greenfoot.stop();
        }
    }
}
