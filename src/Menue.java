import java.awt.*;

public class Menue {
    //Fields
    private  int buttonWidth;
    private  int buttonHeight;
    private Color color1;
    private String s;
    int alpha = 0;



    //Constructor
    public Menue(){
        buttonWidth = 120;
        buttonHeight = 60;

        color1  = Color.orange;
        s = "PLAY!";
    }
    //Functions
    public void update(){
        if (GamePanel.mouseX >  GamePanel.WIDTH/2 - buttonWidth/2 &&
                GamePanel.mouseX < GamePanel.WIDTH + buttonWidth/2 &&
                GamePanel.mouseY > GamePanel.HEIGHT/2 - buttonHeight/2 &&
                GamePanel.mouseY <  GamePanel.HEIGHT/2 + buttonHeight/2){
                alpha = 60;
                if (GamePanel.player.isFiring == true) GamePanel.state = GamePanel.STATES.PLAY;
        } else alpha = 0;

    }

    public void draw(Graphics2D g){
        g.setColor(color1);
        g.setStroke(new BasicStroke(3));
        g.drawRect(GamePanel.WIDTH/2 - buttonWidth/2,
                   GamePanel.HEIGHT/2 - buttonHeight/2, buttonWidth, buttonHeight);
        g.setColor(new Color(color1.getRed(), color1.getGreen(), color1.getBlue(), alpha));
        g.fillRect(GamePanel.WIDTH/2 - buttonWidth/2,
                GamePanel.HEIGHT/2 - buttonHeight/2, buttonWidth, buttonHeight);
        g.setStroke(new BasicStroke(1));
        g.setColor(color1);
        g.setFont(new Font("consolas", Font.BOLD, 40));
        long lenght = (int) g.getFontMetrics().getStringBounds(s, g).getWidth();
        g.drawString(s, GamePanel.HEIGHT/2 - lenght/2, GamePanel.HEIGHT/2 + buttonHeight/4);
    }
}
