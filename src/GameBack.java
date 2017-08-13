import java.awt.*;

public class GameBack {
    //Fields
    private  Color color;

    //Constructor
    GameBack(Color color) {
        this.color = color;
    }
    //Functions
    public void update(){
       //TODO
    }

    public void draw(Graphics2D g){
        g.setColor(color);
        g.fillRect(0,0, GamePanel.WIDTH, GamePanel.HEIGHT);
        g.setColor(Color.WHITE);
        g.drawString(Integer.toString(GamePanel.score), 10, 10);
    }

}
