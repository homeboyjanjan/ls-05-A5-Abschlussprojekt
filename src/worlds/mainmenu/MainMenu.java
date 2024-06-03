package worlds.mainmenu;

import greenfoot.World;

public class MainMenu extends World {

    MainMenuStartGameButton mainMenuStartGameButton = new MainMenuStartGameButton();
    MainMenuExitButton mainMenuExitButton = new MainMenuExitButton();

    public MainMenu() {
        super(1200, 580, 1);
        setBackground("images/mainmenu.png");
        addObject(mainMenuStartGameButton,600,350);
        addObject(mainMenuExitButton,600,500);
    }
}
