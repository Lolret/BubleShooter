import java.awt.*;
import java.util.Random;

public class Enemy {
    //Fields
    private double x;

    public double getX() {return x;}
    public double getY() {return y;}
    public double getRadius() {return enemyRadius;}
    public double getEnemyHealth() {return enemyHealth;}


    private double y;
    private int enemyRadius;
    private Color enemyColor;
    private int enemyType;
    private int enemyRank;
    private double enemyHealth;
    private double speed;
    private double dx;
    private double dy;

    public Enemy(int enemyType, int enemyRank) {
        this.enemyType = enemyType;
        this.enemyRank = enemyRank;

        switch (enemyType){
            case 1:
                enemyColor = Color.ORANGE;
                switch (enemyRank){
                case 1:
                    x = Math.random()*GamePanel.WIDTH;
                    y = 0;
                    speed = 2;
                    enemyRadius = 10;
                    enemyHealth = 6;
                    double angle = Math.toRadians(Math.random()*360);
                    dx = Math.sin(angle)*speed;
                    dy = Math.cos(angle)*speed;


            }
        }

    }
    //Constructor

    //Functions
    public void hit(){
        enemyHealth--;
    }

    public void update(){
        x += dx;
        y += dy;
        if (x < 0 && dx <0)dx = -dx;
        if (x > GamePanel.WIDTH && dx > 0) dx = -dx;
        if (y < 0 && dy <0)dy = -dy;
        if (y >= GamePanel.HEIGHT && dy > 0) dy = -dy;


    }

    public void draw(Graphics2D g){
        g.setColor(enemyColor);
        g.fillOval((int)x-enemyRadius, (int)y - enemyRadius, enemyRadius*2, enemyRadius*2);
        g.setStroke(new BasicStroke(3));
        g.setColor(enemyColor.darker());
        g.drawOval((int)x-enemyRadius, (int)y - enemyRadius, enemyRadius*2, enemyRadius*2);
        g.setStroke(new BasicStroke(1));
    }
    public boolean remove(){
        return enemyHealth <= 0;
    }
}
