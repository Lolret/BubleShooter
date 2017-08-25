import java.awt.*;
import java.util.Random;

public class Bullet {
    //Fields
    static int bulletFireDelay = 10;
    static long lastBulletTime;

    private int r;
    private double x;
    private double y;
    private double speed;
    private Color color;

    //Constructor
    public Bullet() {
        this.x = GamePanel.player.getX();
        this.y = GamePanel.player.getY();
        this.r = 3;
        this.color = new Color(0x76B219);
        this.speed = 5.5+ Math.random()*0.5;
        lastBulletTime = System.currentTimeMillis();
    }

    //Functions
    public double getX() {return x;}
    public double getY() {return y;}
    public double getRadius() {return r;}
    public void update() {y -=speed;}
    public boolean remove() {return y < 0;}

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y, 2*r, 2*r);
    }
}
