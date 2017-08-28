import java.awt.*;
import java.util.Random;

public class Wave {
    //Fields
    private int waveNumber;
    private int waveMultiplier;
    private long waveTimer;
    private long waveDelay;
    private long waveTimerDiff;
    private String waveText;

    //Constructor
    public Wave() {
        waveNumber = 1;
        waveMultiplier = 5;
        waveTimer = 0;
        waveDelay = 1_000;
        waveTimerDiff = 0;
        waveText = "W A V E";
    }

    //Functions
    public void update() {
        if (GamePanel.enemies.isEmpty() && waveTimer == 0) waveTimer = System.nanoTime();
        if(waveTimer > 0){
            waveTimerDiff += (System.nanoTime() - waveTimer)/1_000_000;
            waveTimer = System.nanoTime();
        }
        if (waveTimerDiff > waveDelay){
            createEnemies();
            waveTimer = 0;
            waveTimerDiff = 0;
        }
    }

    public boolean showWave() {return waveTimer != 0 ? true : false;}

    private void createEnemies() {
        int enemyCount = 10 + (waveNumber) * waveMultiplier;
        Random randomRank = new Random(25);
        while (enemyCount > 0){
            int rank;
            int type = 1;
            if (randomRank.nextInt(100) <50) rank = 1;
            else if (randomRank.nextInt(100) <75) rank = 2;
            else if (randomRank.nextInt(100) <90) rank = 3;
            else rank = 4;
            GamePanel.enemies.add(new Enemy(type,rank));
            enemyCount --;

        }
        waveNumber ++;
    }

    public void draw(Graphics2D g) {
        double divider = waveDelay/180;
        double alpha = waveTimerDiff/divider;
        alpha = 255 * Math.sin(Math.toRadians(alpha));
        if (alpha < 0) alpha = 0;
        if (alpha > 255) alpha = 255;
        g.setFont(new Font("consolas", Font.BOLD, 20));
        g.setColor(new Color(255,255,255, (int)alpha));
        String s = new StringBuffer().append(waveText).append(" ").append(waveNumber).toString();
        long length = (int)g.getFontMetrics().getStringBounds(s, g).getWidth();
        g.drawString(s, GamePanel.WIDTH/2 - length/2, GamePanel.HEIGHT/2);
    }
}
