import java.awt.event.KeyListener;
import java.awt.event.*;
public class Listeners implements KeyListener, MouseListener {
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key  == KeyEvent.VK_W) Player.up = true;
        if (key  == KeyEvent.VK_S) Player.down = true;
        if (key  == KeyEvent.VK_A) Player.left = true;
        if (key  == KeyEvent.VK_D) Player.right = true;
        if (key  == KeyEvent.VK_SPACE) Player.isSpeedUp = true;
        if (key  == KeyEvent.VK_E) Player.isFiring = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key  == KeyEvent.VK_W) Player.up = false;
        if (key  == KeyEvent.VK_S) Player.down = false;
        if (key  == KeyEvent.VK_A) Player.left = false;
        if (key  == KeyEvent.VK_D) Player.right = false;
        if (key  == KeyEvent.VK_SPACE) Player.isSpeedUp = false;
        if (key  == KeyEvent.VK_E) Player.isFiring = false;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        int key = e.getButton();
        if (key  == MouseEvent.BUTTON1) Player.isFiring = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        int key = e.getButton();
        if (key  == MouseEvent.BUTTON1) Player.isFiring = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {}
    @Override
    public void mouseExited(MouseEvent e) {}
    @Override
    public void keyTyped(KeyEvent e) { }
    @Override
    public void mouseClicked(MouseEvent e) {}
}
