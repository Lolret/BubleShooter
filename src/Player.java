import java.awt.*;

public class Player {
    //Fields
    private double x;
    private double y;
    private int playerRadius;
    public static int speed;
    public static double speedBoostValue;


    private Color color1;
    private Color color2;

    public static boolean up;
    public static boolean down;
    public static boolean left;
    public static boolean right;
    public static boolean speedUp;




    //Constructor


    public Player(/*double x, double y, int playerRadius, Color color1, Color color2*/) {
        x = GamePanel.WIDTH/2;
        y = GamePanel.HEIGHT/2;
        playerRadius = 5;
        speed = 3;
        speedBoostValue = 1.5;
        color1 = new Color(0x00_ff_ff_ff);
        color2 = new Color(0x01_5f_5f_0f);
        up = down = left = right = false;
    }

    //Functions
    public void update(){
        if (speedUp) {
            if (up && x > playerRadius) {

                y -=speed*speedBoostValue;
            }
            if (down && x < GamePanel.HEIGHT - playerRadius) {
                y +=speed*speedBoostValue;
            }
            if (left && x > playerRadius) {
                x -=speed*speedBoostValue;
            }
            if (right && x < GamePanel.WIDTH - playerRadius) {
                x +=speed*speedBoostValue;
            }
        }

        if (up && x > playerRadius) {

            y -=speed;
        }
        if (down && x < GamePanel.HEIGHT - playerRadius) {
            y +=speed;
        }
        if (left && x > playerRadius) {
            x -=speed;
        }
        if (right && x < GamePanel.WIDTH - playerRadius) {
            x +=speed;
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
