import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;


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
    private Color BACKGROUND_COLOR = new Color(0x3A46A7);
    public static Player player;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Enemy> enemies;
    Listeners listeners =  new Listeners();

    //Constructor
    public GamePanel(){
        super();

        setPreferredSize(new Dimension(WIDTH,HEIGHT));
        setFocusable(true);
        requestFocus();
        addKeyListener(listeners);
        addMouseListener(listeners);
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
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        enemies.add(new Enemy(1,1));
        enemies.add(new Enemy(1,1));

        while (true){
            //TODO States
            gameUpdate();
            gameRender();
            gameDraw();
            try {
                tread.sleep(20); //TODO FPS
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
        //Bullets update
        for (Bullet b: new ArrayList<>(bullets)) {
            b.update();
            if (b.remove()) bullets.remove(b);
        }
        //Enemies update
        for (Enemy e: new ArrayList<>(enemies)) {
            e.update();
            if (e.remove()) bullets.remove(e);
        }
    }

    public void gameRender(){
        //TODO Renderings
        background.draw(g);
        player.draw(g);
        for (Bullet b:bullets){
            b.draw(g);
        }
        for (Enemy e:enemies){
            e.draw(g);
        }
    }

    private void gameDraw(){
        Graphics g2 =this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }

}
