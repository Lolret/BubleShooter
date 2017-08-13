import java.awt.*;
import java.util.Random;

public class Bullet {
    //Fields
    private double x;
    private double y;
    private int r;
    private Color color;

    private double speed;
    static int bulletFireDelay = 50;
    static long lastBulletTime;

    //Constructor
    public Bullet() {
        this.x = GamePanel.player.getX();
        this.y = GamePanel.player.getY();
        this.r = 3+ new Random().nextInt(2);
        this.color = new Color(0x76B219);
        this.speed = 4.5+ Math.random()*0.5;
        lastBulletTime = System.currentTimeMillis();
    }

    //Functions

    public double getX() {return x;}
    public double getY() {return y;}
    public double getRadius() {return r;}


    public void update(){
        y -=speed;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y, 2*r, 2*r);
    }

    public boolean remove(){
        return y < 0;
    }

}
