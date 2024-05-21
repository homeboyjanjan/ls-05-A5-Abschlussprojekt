import greenfoot.Greenfoot;
import greenfoot.World;

public class Space extends World {

    private int timer = 0;

    Player player = new Player();
    Bullet bullet = new Bullet();
    Healthbar healthbar = new Healthbar();
    EnemySpawner enemySpawner = new EnemySpawner();
    Currencybar currencybar = new Currencybar();


    public Space() {
        super(1800, 900, 1);
        setBackground("Images/space.png");
        addObject(player, 900, 800);
        addObject(enemySpawner, 900, 100);
        addObject(healthbar, 220, 50);
        addObject(currencybar, 50, 120);
    }

    public void act() {
        timer++;
        if (timer >= 20) {
            getObjects(Player.class).get(0).setHP(getObjects(Player.class).get(0).getInitialHP());
            removeObject(enemySpawner);
            setBackground("Images/planet.png");
            showText("On this planet you get the ability to upgrade your ship and we also healed you^^", 900, 100);
            showText("Press the corresponding key to upgrade whatever part of your ship you want or press 'ESC' to leave the Shop!", 900, 150);

            if (Greenfoot.isKeyDown("1") && getObjects(Player.class).get(0).getCurrency() >= 50) {
                if (getObjects(Player.class).get(0).getHP() < 7) {
                    getObjects(Player.class).get(0).setHP(getObjects(Player.class).get(0).getHP() + 1);
                    getObjects(Player.class).get(0).setInitialHP(getObjects(Player.class).get(0).getInitialHP() + 1);
                    getObjects(Player.class).get(0).setCurrency(getObjects(Player.class).get(0).getCurrency() - 50);

                } else {
                    showText("You have reached maximum HP amount!", 900, 200);
                }
            }
            if (Greenfoot.isKeyDown("2") && getObjects(Player.class).get(0).getCurrency() >= 30) {
                getObjects(Player.class).get(0).setSpeed(getObjects(Player.class).get(0).getSpeed() + 2);
                getObjects(Player.class).get(0).setCurrency(getObjects(Player.class).get(0).getCurrency() - 30);

            }
            if (Greenfoot.isKeyDown("3") && getObjects(Player.class).get(0).getCurrency() >= 75) {
                bullet.setBulletDamage(bullet.getBulletDamage() + 1);
                getObjects(Player.class).get(0).setCurrency(getObjects(Player.class).get(0).getCurrency() - 75);
            }
        }
    }
}
