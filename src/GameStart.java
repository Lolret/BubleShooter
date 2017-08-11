import javax.swing.*;
import java.awt.*;

/*
 * Created by alexv on 11.08.2017.
 */
public class GameStart {
    public static void main(String[] args) {
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
//        /*Установка размера окна*/
//        startFrame.setSize(400, 800);
        startFrame.pack();
        startFrame.setLocationRelativeTo(null);
        panel.start();

    }
}
