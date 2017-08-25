import java.awt.*;

public class Wave {

    //Fields
    private int waveNumber;

    private long waveTimer;
    private long waveDelay;
    private long waveTimerDiff;
    private String waveText;

    //Constructor

    public Wave() {
        this.waveNumber = waveNumber;
        this.waveTimer = 0;
        this.waveDelay = 10_000;
        this.waveTimerDiff = 0;
        waveText = "W A V E " + waveNumber;
    }

    //Functions
    public void update() {
        if (GamePanel.enemies.isEmpty() && waveTimer == 0) {
            waveTimer = System.nanoTime();
        }
        if(waveTimer > 0){
            waveTimerDiff += (System.nanoTime() - waveTimer)/1_000_000;
            waveTimer = System.nanoTime();
        }
    }


    public void draw(Graphics2D g) {
        g.drawString(waveText, GamePanel.WIDTH/2, GamePanel.HEIGHT/2);
    }


}
