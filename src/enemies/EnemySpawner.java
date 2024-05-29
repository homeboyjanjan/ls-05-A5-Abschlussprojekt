package enemies;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.Random;

public class EnemySpawner extends Actor {

    private int spawntimer;
    Enemy enemy = new Enemy();
    Random random = new Random();

    public EnemySpawner() {
        this.spawntimer = enemy.getSpawnTimer();
        setImage((GreenfootImage) null);
    }

    public void spawnEnemy() {

        if (spawntimer > 0) {
            spawntimer--;
        }
        if (spawntimer == 0) {
            getWorld().addObject(enemy, random.nextInt(getWorld().getWidth()-100) , getY()-50);
            spawntimer = enemy.getSpawnTimer();
        }

    }

    @Override
    public void act() {
        spawnEnemy();

    }
}
