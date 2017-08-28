import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import sun.audio.*;

public class GameStart {
    public static void main(String[] args) {
        //Music
        AudioPlayer MGP = AudioPlayer.player;
        try {
            InputStream is =  new FileInputStream(new File("C:\\Users\\alexv\\IdeaProjects\\BubleShooter\\src\\erasure.wav"));
            AudioStream as = new AudioStream(is);
            AudioPlayer.player.start(as);
        } catch (IOException e) {
            e.printStackTrace();
        }




        GamePanel panel = new GamePanel();
        /*Создание фрейма игры*/
        JFrame startFrame = new JFrame("BubleShooter");
        /*Установка дефолтной операции по закрытию через крестик*/
        startFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startFrame.setResizable(false);
        /*Добавляем к фрейму панельку (GamePanel)*/
        startFrame.setContentPane(panel);
        /*Видимость окна в true*/
        startFrame.setVisible(true);
        /*Установка размера окна*/
        /*startFrame.setSize(400, 800);*/
        startFrame.pack();
        startFrame.setLocationRelativeTo(null);
        panel.start();
    }
}
