import greenfoot.World;

public class Space extends World {

    Spaceship spaceship = new Spaceship();
    public Space(){
        super(1500,700,1);
        setBackground("Images/space.jpg");
        addObject(spaceship,750,600);

    }
}
