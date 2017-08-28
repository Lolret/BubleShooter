import com.sun.org.apache.xpath.internal.SourceTree;

import java.awt.*;
import java.util.Random;

public class Bullet {
    //Fields
    static int bulletFireDelay = 10;
    static long lastBulletTime;
    public static int colorNumber = 0xFF0000;
    public Color color = new Color(colorNumber);
    public static short colorMultiplyer;


    private int r;
    private double x;
    private double y;
    private double speed;
    double dx;
    double dy;
    int dist;

    //Constructor
    public Bullet() {
        this.x = GamePanel.player.getX();
        this.y = GamePanel.player.getY();
        this.r = 3;
        switch (colorMultiplyer % 3){
            case 1: color = new Color(colorNumber += 0x00FF00/2);
            case 2: color = new Color(colorNumber += 0x0000FF/2);
            case 3: color = new Color(colorNumber += 0xFF0000/2);
        }
        colorMultiplyer++;
//        color = new Color(0x76B219);
        this.speed = 7.5+ Math.random()*0.5;
        lastBulletTime = System.currentTimeMillis();

        dx = GamePanel.player.getX() - GamePanel.mouseX;
        dy = GamePanel.player.getY() - GamePanel.mouseY;
        dist = (int)Math.sqrt(dx * dx + dy * dy);
    }

    //Functions
    public double getX() {return x;}
    public double getY() {return y;}
    public double getRadius() {return r;}
    public void update() {
        y -= dy/dist * speed;
        x -= dx/dist * speed ;
    }
    public boolean remove() {return y < 0;}

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y, 2*r, 2*r);
    }
}
