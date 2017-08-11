import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by alexv on 11.08.2017.
 */
public class GamePanel extends JPanel implements Runnable{

    //Field
    public static int WIDTH = 400;
    public static int HEIGHT = 400;
    private Thread tread;
    //Переменная холста, на котором будем рисовать
    private BufferedImage image;
    //Наша кисточка (oO)
    private Graphics2D g;

    public static GameBack background;
    private Color BACKGROUND_COLOR = new Color(0x01_00_00_ff);
    public static Player player;

    //Constructor
    public GamePanel(){
        super();

        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(new Listeners());
    }

    //Functions
    public void start(){
        tread = new Thread(this);
        tread.start();
    }

    @Override
    public void run(){

        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D)image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        background = new GameBack(BACKGROUND_COLOR);
        player = new Player();

        while (true){
            //TODO States
            gameUpdate();
            gameRender();
            gameDraw();
            try {
                tread.sleep(33); //TODO FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void gameUpdate(){
        //TODO Updates objects
        //Background update
        background.update();
        //Player update
        player.update();

    }

    public void gameRender(){
        //TODO Renderings
        background.draw(g);
        player.draw(g);
    }

    private void gameDraw(){
        Graphics g2 = this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

}
