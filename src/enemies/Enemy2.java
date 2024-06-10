package enemies;

import greenfoot.Actor;
import greenfoot.GreenfootImage;
import player.Player;

public class Enemy2 extends Actor {
    private int HP;
    private int speed;
    private int loot;
    private int damage;
    GreenfootImage image;
    private int spawnTimer;
    int cooldown = 0;


    public Enemy2() {
        this.HP = 15;
        this.speed = 1;
        this.damage = 1;
        this.loot = 10;
        this.image = new GreenfootImage("images/enemy2.png");
        this.spawnTimer = 400;
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
        Enemy2Attack enemyAttack = new Enemy2Attack();
        getWorld().addObject(enemyAttack, getX(), getY());
        cooldown = 80;
    }
    public void movementPattern(){
        setLocation(getWorld().getWidth()/2, getWorld().getHeight()/3);
        turn(speed-90);
        move(100);
        turn(90);
    }

    @Override
    public void act() {
        if (cooldown > 0) {
            cooldown--;
        }
        setImage(image);
        movementPattern();

        if (cooldown == 0) {
            attack();
        }
        if (isTouching(Player.class)) {
            getIntersectingObjects(Player.class).get(0).setHP(getIntersectingObjects(Player.class).get(0).getHP() - 1);
            getWorld().getObjects(Player.class).get(0).setScore(getWorld().getObjects(Player.class).get(0).getScore()-50);
            getWorld().removeObject(this);
            return;
        }
        if (isAtEdge()) {
            getWorld().removeObject(this);
            return;
        }
        if (HP <= 0) {
            getWorld().getObjects(Player.class).get(0).setCurrency(getWorld().getObjects(Player.class).get(0).getCurrency() + getLoot());
            getWorld().getObjects(Player.class).get(0).setScore(getWorld().getObjects(Player.class).get(0).getScore()+200);
            getWorld().getObjects(Player.class).get(0).setKills(getWorld().getObjects(Player.class).get(0).getKills()+1);
            getWorld().removeObject(this);
            HP = 15;
        }
    }
}
