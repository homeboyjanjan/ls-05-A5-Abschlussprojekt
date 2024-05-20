import greenfoot.World;

public class Space extends World {


    Player player = new Player();
    Healthbar healthbar = new Healthbar();
    EnemySpawner enemySpawner = new EnemySpawner();
    Currencybar currencybar = new Currencybar();


    public Space() {
        super(1800, 900, 1);
        setBackground("Images/space.png");
        addObject(player, 900, 800);
        addObject(enemySpawner, 900, 100);
        addObject(healthbar,170,50);
        addObject(currencybar,50,120);
    }
}
