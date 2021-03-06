import java.awt.*;

public class Player {

    //Fields
    public static double speed;
    public static double speedBoostValue;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean isSpeedUp;
    public static boolean isFiring;

    private double x;
    private double y;
    private int playerRadius;
    private int health;
    private int boostFuel;
    private int maxBoostFuel;
    private double dx; //Коэффициент смещения
    private double dy;
    private Color color1;
    private Color color2;

    //Constructor
    public Player() {
        x = GamePanel.WIDTH/2;
        y = GamePanel.HEIGHT/2 +50;
        playerRadius = 8;
        health = 50;
        speed = 2.2;
        dx = dy = 0;
        speedBoostValue = 1.5;
        color1 = new Color(0x00_ff_ff_ff);
        color2 = new Color(0x912E3D);
        up = down = left = right = false;
        boostFuel = 200;
        maxBoostFuel = 200;
    }

    //Functions
    public double getX() {return x;}
    public double getY() {return y;}
    public int getPlayerRadius() {return playerRadius;}
    public int getHealth() {return health;}
    public int getBoostFuel() {return boostFuel;}
    public int getMaxBoostFuel() {return maxBoostFuel;}
    public int hit() {return --health;}

    public void update(){
        if (getBoostFuel() > 0 && isSpeedUp) {
            if (up && y > playerRadius) {dy -=speed*speedBoostValue;}
            if (down && y < GamePanel.HEIGHT - playerRadius) {dy +=speed*speedBoostValue;}
            if (left && x > playerRadius) {dx -=speed*speedBoostValue;}
            if (right && x < GamePanel.WIDTH - playerRadius) {dx +=speed*speedBoostValue;}
            if (up && left || up && right || down && left || down && right){
                double angle = Math.toRadians(45);
                dy = dy*Math.cos(angle);
                dx = dx*Math.cos(angle);
            }
            boostFuel -=2;
        }
        if (up && y > playerRadius) {dy -=speed;}
        if (down && y < GamePanel.HEIGHT - playerRadius) {dy +=speed;}
        if (left && x > playerRadius) {dx -=speed;}
        if (right && x < GamePanel.WIDTH - playerRadius) {dx +=speed;}
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
        if (!isSpeedUp && boostFuel < maxBoostFuel)  boostFuel++;
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
