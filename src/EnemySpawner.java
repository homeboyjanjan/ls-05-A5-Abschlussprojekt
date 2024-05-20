import greenfoot.Actor;
import greenfoot.GreenfootImage;

public class EnemySpawner extends Actor {

    private int spawntimer;
    Enemy enemy = new Enemy();

    public EnemySpawner() {
        this.spawntimer = enemy.getSpawnTimer();
        setImage((GreenfootImage) null);
    }

    public void spawnEnemy() {
        for (int i = 0; i < 5; i++) {
            if (spawntimer > 0) {
                spawntimer--;
            }
            if (spawntimer == 0) {
                getWorld().addObject(enemy, getX(), getY());
                spawntimer = enemy.getSpawnTimer() * 2;
            }
        }
    }

    @Override
    public void act() {
        spawnEnemy();

    }
}
