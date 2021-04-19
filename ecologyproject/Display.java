package ecologyproject;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author SOURABH KUMAR
 */
public class Display {

    JFrame a;
    String t;
    int w, h;

    public Display(String t, int w, int h) {
        this.t = t;
        this.w = w;
        this.h = h;
        createDisplay();
    }

    private void createDisplay() {
        a = new JFrame();
        a.setBounds(400, 100, w, h);
        a.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        a.setResizable(false);
        a.setVisible(true);
    }

}
