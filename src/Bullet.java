import java.awt.*;

public class Bullet {
    //Fields
    private double x;
    private double y;
    private int r;
    private Color color;

    private int speed;

    //Constructor
    public Bullet() {
        this.x = GamePanel.player.getX();
        this.y = GamePanel.player.getY();
        this.r = 2;
        this.color = Color.BLACK;
        this.speed = 6;
    }

    //Functions
    public void update(){
        y -=speed;
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillOval((int)x,(int)y, r, 2*r);
    }
}
