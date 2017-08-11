import java.awt.event.KeyListener;
import java.awt.event.*;
public class Listeners implements KeyListener {


    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
//        switch (key) {
//            case KeyEvent.VK_W:
//                Player.up = true;
//                break;
//            case KeyEvent.VK_S:
//                Player.down = true;
//                break;
//            case KeyEvent.VK_A:
//                Player.left = true;
//                break;
//            case KeyEvent.VK_D:
//                Player.right = true;
//                break;
//        }
        if (key  == KeyEvent.VK_W) Player.up = true;
        if (key  == KeyEvent.VK_S) Player.down = true;
        if (key  == KeyEvent.VK_A) Player.left = true;
        if (key  == KeyEvent.VK_D) Player.right = true;
        if (key  == KeyEvent.VK_SPACE) Player.speedUp = true;

    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key  == KeyEvent.VK_W) Player.up = false;
        if (key  == KeyEvent.VK_S) Player.down = false;
        if (key  == KeyEvent.VK_A) Player.left = false;
        if (key  == KeyEvent.VK_D) Player.right = false;
        if (key  == KeyEvent.VK_SPACE) Player.speedUp = false;

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
