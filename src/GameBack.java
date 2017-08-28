import java.awt.*;

public class GameBack {
    //Fields
    private  Color color;

    //Constructor
    GameBack(Color color) {
        this.color = color;
    }

    //Functions
    public void update() {} //TODO

    public void draw(Graphics2D g){
        g.setFont(new Font("consolas", Font.BOLD, 20));
        g.setColor(color);
        g.fillRect(0,0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString("Счет: " + Integer.toString(GamePanel.score), GamePanel.WIDTH /2 + 60, 20);
        g.drawString("Здоровье:" +Integer.toString(GamePanel.player.getHealth()), 10, 20);
        g.setFont(new Font("consolas", Font.BOLD, 10));
        g.drawString("Boost Fuel:", 40, GamePanel.HEIGHT - 20);
        g.setColor(Color.BLACK);
        g.setStroke(new BasicStroke(3));
        g.drawLine(40,GamePanel.HEIGHT - 10,120,GamePanel.HEIGHT - 10);
        int dx = (int)(40 + ((double)GamePanel.player.getBoostFuel()/(double)GamePanel.player.getMaxBoostFuel()*80));
        g.drawLine(dx,GamePanel.HEIGHT - 5,dx,GamePanel.HEIGHT - 15);
    }
}
