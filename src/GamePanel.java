import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;


public class GamePanel extends JPanel implements Runnable{

    //Fields
    public static int WIDTH = 400;
    public static int HEIGHT = 400;
    private Thread tread;
    private BufferedImage image; //Переменная холста, на котором будем рисовать
    private Graphics2D g; //Наша кисточка (oO)

    private int FPS;
    private double millisToFPS;
    private long timerFPS;
    private int sleepTime;


    public static GameBack background;
    public static Player player;
    public static ArrayList<Bullet> bullets;
    public static ArrayList<Enemy> enemies;
    public static int score;
    public static Wave wave;

    long startTime = System.currentTimeMillis();
    private Color BACKGROUND_COLOR = new Color(0x3A46A7);
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
        FPS = 30;
        millisToFPS = 1_000/FPS;

        image = new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D)image.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        background = new GameBack(BACKGROUND_COLOR);
        player = new Player();
        bullets = new ArrayList<>();
        enemies = new ArrayList<>();
        wave = new Wave();
        startTime = System.currentTimeMillis();
        while (true && player.getHealth() > 0){
            gameUpdate();
            gameRender();
            gameDraw();

            timerFPS = System.nanoTime();
            timerFPS = (System.nanoTime() - timerFPS)/1_000_000;
            if (millisToFPS > timerFPS) {
                sleepTime = (int)(millisToFPS - timerFPS);
            } else sleepTime = 1;
            try {
                tread.sleep(sleepTime);
                System.out.println(sleepTime);
            } catch (InterruptedException e) {e.printStackTrace();}
            timerFPS = 0;
            sleepTime = 1;
        }
    }

    public void gameUpdate(){
        //TODO Updates objects
        background.update();
        player.update();
        for (Bullet b: new ArrayList<>(bullets)) {
            b.update();
            if (b.remove()) bullets.remove(b);
        }
        for (Enemy e: new ArrayList<>(enemies)) {
            e.update();
        }
        for (Enemy e: new ArrayList<>(enemies)) {
            double ex = e.getX();
            double ey = e.getY();
            for (Bullet b : new ArrayList<>(bullets)) {
                double bx = b.getX();
                double by = b.getY();
                double dx = ex - bx;
                double dy = ey - by;
                double dist = Math.sqrt(dx * dx + dy * dy);
                if ((int) dist <= b.getRadius() + e.getRadius()) {
                    e.hit();
                    bullets.remove(b);
                }
            }
            double px = player.getX();
            double py = player.getY();
            double dx = ex - px;
            double dy = ey - py;
            double dist = Math.sqrt(dx * dx + dy * dy);
            if ((int) dist <= player.getPlayerRadius() + e.getRadius()) {
                e.hit();
                player.hit();
                if (player.getHealth() <= 0) {}//TODO GameOver
            }
        }
        wave.update();
    }

    public void gameRender(){
        //TODO Renderings
        background.draw(g);
        player.draw(g);
        for (Bullet b:bullets) {b.draw(g);}
        for (Enemy e:enemies) {e.draw(g);}
        if (wave.showWave()) wave.draw(g);
    }

    private void gameDraw(){
        Graphics g2 =this.getGraphics();
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
    }
}
