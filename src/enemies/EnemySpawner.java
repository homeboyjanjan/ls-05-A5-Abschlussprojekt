package enemies;

import greenfoot.Actor;
import greenfoot.GreenfootImage;

import java.util.Random;

public class EnemySpawner extends Actor {

    private int spawntimer1;
    private int spawntimer2;
    
    Enemy1 enemy1 = new Enemy1();
    Enemy2 enemy2 = new Enemy2();
    Random random = new Random();

    public EnemySpawner() {
        this.spawntimer1 = enemy1.getSpawnTimer();
        this.spawntimer2 = enemy2.getSpawnTimer();
        setImage((GreenfootImage) null);
    }

    public void spawnEnemy() {
        if (spawntimer1 > 0) {
            spawntimer1--;
        }
        if (spawntimer2 > 0) {
            spawntimer2--;
        }
        if (spawntimer1 == 0) {
            getWorld().addObject(enemy1, random.nextInt(getWorld().getWidth()-100) , getY()-50);
            spawntimer1 = enemy1.getSpawnTimer();
        }
        if (spawntimer2 == 0){
            getWorld().addObject(enemy2,0,0);
            spawntimer2 = enemy2.getSpawnTimer();
        }
    }

    @Override
    public void act() {
        spawnEnemy();

    }
}
