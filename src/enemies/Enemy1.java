package enemies;

import greenfoot.Actor;
import greenfoot.GreenfootImage;
import player.Player;

public class Enemy1 extends Actor {
    private int HP;
    private int speed;
    private int loot;
    private int damage;
    GreenfootImage image;
    private int spawnTimer;
    int cooldown = 0;


    public Enemy1() {
        this.HP = 10;
        this.speed = 1;
        this.damage = 1;
        this.loot = 5;
        this.image = new GreenfootImage("images/enemy1.png");
        this.spawnTimer = 200;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpawnTimer() {
        return spawnTimer;
    }

    public void setSpawnTimer(int spawnTimer) {
        this.spawnTimer = spawnTimer;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public void attack() {
        Enemy1Attack enemyAttack = new Enemy1Attack();
        getWorld().addObject(enemyAttack, getX(), getY());
        cooldown = 120;
    }

    @Override
    public void act() {
        if (cooldown > 0) {
            cooldown--;
        }
        setImage(image);
        setLocation(getX(), getY() + speed);

        if (cooldown == 0) {
            attack();
        }
        if (isTouching(Player.class)) {
            getIntersectingObjects(Player.class).get(0).setHP(getIntersectingObjects(Player.class).get(0).getHP() - 1);
            getWorld().getObjects(Player.class).get(0).setScore(getWorld().getObjects(Player.class).get(0).getScore() - 50);
            getWorld().removeObject(this);
            return;
        }
        if (isAtEdge()) {
            getWorld().removeObject(this);
            return;
        }
        if (HP <= 0) {
            getWorld().getObjects(Player.class).get(0).setCurrency(getWorld().getObjects(Player.class).get(0).getCurrency() + getLoot());
            getWorld().getObjects(Player.class).get(0).setScore(getWorld().getObjects(Player.class).get(0).getScore() + 125);
            getWorld().getObjects(Player.class).get(0).setKills(getWorld().getObjects(Player.class).get(0).getKills() + 1);
            getWorld().removeObject(this);
            HP = 10;
        }
    }
}

