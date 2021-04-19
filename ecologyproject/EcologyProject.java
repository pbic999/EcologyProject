package ecologyproject;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Random;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class EcologyProject extends JPanel implements Runnable, MouseListener {

    String t = "Game";
    int w = 800, h = 550;
    Display d;
    Thread th;
    Image i = Toolkit.getDefaultToolkit().createImage(this.getClass().getResource("AFXaGQ.png"));
    boolean run = false;
    Graphics g;
    Level[] l = new Level[4];
    Level cl = new level1();
    int level;
    int tl = 100000000;
    int score = 0;
    boolean lvlclr = false;

    public static void main(String[] args) {
        EcologyProject g = new EcologyProject();
        g.d = new Display(g.t, g.w, g.h);
        g.d.a.add(g);
        g.start();
    }

    private void init() {
        this.addMouseListener(this);
        level = -1;
        l[0] = new level1();
        l[1] = new level2();
        l[2] = new level3();
        l[3] = new level4();
    }

    public void start() {
        if (run) {
            return;
        } else {
            run = true;
            th = new Thread(this);
            th.start();
        }
    }

    @Override
    public void run() {
        init();
        int fps = 30;
        double tpu = 1000000000 / fps;
        long nowTime;
        long lastTime = System.nanoTime();
        double d = 0;
        while (run) {
            nowTime = System.nanoTime();
            d = d + (nowTime - lastTime) / tpu;
            lastTime = nowTime;
            if (d >= 1) {
                update();
                d = 0;
            }
        }
    }

    public void paint(Graphics g1) {
        Graphics2D g = (Graphics2D) g1;
        g.clearRect(0, 0, w, h);
        g.drawImage(i, 0, 0, w, h, null);
        if (level < 3) {
            if (lvlclr) {
                level++;
                lvlclr = false;
            }
        }
        if (level != -1) {
            l[level].draw(g);
        } else {
            g.setFont(new Font("Serif", Font.BOLD, 35));
            g.setColor(Color.red);
            g.drawString("Early Education Learning Game", 30, 50);
            g.setColor(Color.black);
            g.drawString("Environmental game to teach kids about", 100, 180);
            g.drawString("different types of wastes", 200, 220);
            g.setColor(Color.CYAN);
            g.setStroke(new BasicStroke(3));
            g.drawRoundRect(310, 260, 150, 60, 15, 15);
            g.setFont(new Font("Serif", Font.BOLD, 45));
            g.drawString("Start", 335, 305);
        }
        repaint();
        g.dispose();
    }

    public MouseListener getLsnr() {
        return this;
    }

    private void update() {

    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        int x = arg0.getX();
        int y = arg0.getY();
        Rectangle start = new Rectangle(310, 260, 150, 60);
        if (start.contains(x, y) && level == -1) {
            level++;
        }

        if (level != -1) {
            lvlclr = l[level].mouseClk(arg0);
        }
    }

    @Override
    public void mousePressed(MouseEvent arg0) {

    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {

    }

    @Override
    public void mouseExited(MouseEvent arg0) {
    }

}
