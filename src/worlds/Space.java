package worlds;

import enemies.Enemy2;
import greenfoot.World;
import player.HUD.Currencybar;
import player.HUD.Healthbar;
import player.Player;
import enemies.EnemySpawner;
import worlds.shop.ShopOpenButton;

public class Space extends World {


    Player player = new Player();
    Healthbar healthbar = new Healthbar();
    EnemySpawner enemySpawner = new EnemySpawner();
    Currencybar currencybar = new Currencybar();
    ShopOpenButton shopOpenButton = new ShopOpenButton();
    Enemy2 enemy2 = new Enemy2();


    public Space() {
        super(1200, 580, 1);
        setBackground("images/space.png");
        addObject(player, 600, 500);
        addObject(enemySpawner, 600, 100);
        addObject(healthbar, 220, 50);
        addObject(currencybar, 50, 120);
        addObject(shopOpenButton,75,200);
    }
}
