import greenfoot.Actor;
import greenfoot.Greenfoot;
import greenfoot.GreenfootImage;

public class Spaceship extends Actor {

    private int HP;
    private int damage;
    private int speed;
    GreenfootImage image;
    int cooldown = 0;

    public Spaceship() {
        this.HP = 20;
        this.damage = 2;
        this.speed = 6;
        this.image = new GreenfootImage("Images/spaceship.png");
        setImage(image);
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

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }
    public void shoot(){
        Bullet bullet = new Bullet();
        getWorld().addObject(bullet,getX(),getY());
        cooldown = 25;

    }
    @Override
    public void act() {
        if(cooldown > 0) {
            cooldown -= 1;
        }
        if (Greenfoot.isKeyDown("w")){
            setLocation(getX() ,getY()-speed);
        }
        if (Greenfoot.isKeyDown("a")){
            setLocation(getX() - speed,getY());
        }
        if (Greenfoot.isKeyDown("s")){
            setLocation(getX(),getY()+speed);
        }
        if (Greenfoot.isKeyDown("d")){
            setLocation(getX() + speed,getY());
        }
        if (Greenfoot.isKeyDown("up") && cooldown==0){
            shoot();
        }
    }
}
