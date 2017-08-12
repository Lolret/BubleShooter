import java.awt.*;
import java.util.Map;

public class Player {
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    //Fields
    private double x;
    private double y;
    private int playerRadius;
    public static double speed;
    public static double speedBoostValue;

    private double dx; //Коэффициент смещения
    private double dy;

    private Color color1;
    private Color color2;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean speedUp;
    public static boolean isFiring;



    //Constructor


    public Player(/*double x, double y, int playerRadius, Color color1, Color color2*/) {
        x = GamePanel.WIDTH/2;
        y = GamePanel.HEIGHT/2;
        playerRadius = 8;
        speed = 2.2;
        dx = dy = 0;
        speedBoostValue = 1.5;
        color1 = new Color(0x00_ff_ff_ff);
        color2 = new Color(0x01_5f_5f_0f);
        up = down = left = right = false;
    }

    //Functions
    public void update(){
        if (speedUp) {
            if (up && y > playerRadius) {

                dy -=speed*speedBoostValue;
            }
            if (down && y < GamePanel.HEIGHT - playerRadius) {
                dy +=speed*speedBoostValue;
            }
            if (left && x > playerRadius) {
                dx -=speed*speedBoostValue;
            }
            if (right && x < GamePanel.WIDTH - playerRadius) {
                dx +=speed*speedBoostValue;
            }
            if (up && left || up && right || down && left || down && right){
                double angle = Math.toRadians(45);
                dy = dy*Math.cos(angle);
                dx = dx*Math.cos(angle);
            }

        }

        if (up && y > playerRadius) {

            dy -=speed;
        }
        if (down && y < GamePanel.HEIGHT - playerRadius) {
            dy +=speed;
        }
        if (left && x > playerRadius) {
            dx -=speed;
        }
        if (right && x < GamePanel.WIDTH - playerRadius) {
            dx +=speed;
        }
        if (up && left || up && right || down && left || down && right){
            double angle = Math.toRadians(45);
            dy = dy*Math.cos(angle);
            dx = dx*Math.cos(angle);


        }
        y += dy;
        x += dx;
        dx = dy = 0;

        if (isFiring && System.currentTimeMillis() -Bullet.lastBulletTime > Bullet.bulletFireDelay){
            GamePanel.bullets.add(new Bullet());
        }
    }

    public void draw(Graphics2D g){
        g.setColor(color1);
        g.fillOval((int) (x-playerRadius),(int) (y-playerRadius), 2 * playerRadius,2 * playerRadius);
        //Увеличиваем толщину линии
        g.setStroke(new BasicStroke(3));
        g.setColor(color2);
        g.drawOval((int) (x-playerRadius),(int) (y-playerRadius), 2 * playerRadius,2 * playerRadius);
    }
}
