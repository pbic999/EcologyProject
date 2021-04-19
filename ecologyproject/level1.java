/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecologyproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

class level1 extends Level {

    int crntq = 0;
    Image b, n, r, w;
    String crctans[];
    Image waste[];
    Rectangle degradable, nondegradable;

    public level1() {
        waste = new Image[20];
        crctans = new String[20];
        degradable = new Rectangle(550, 300, 170, 175);
        nondegradable = new Rectangle(100, 300, 170, 175);
        slctitm = "";
        ans = "";
        setAns();
        try {
            n = ImageIO.read(this.getClass().getResource("n.png")).getScaledInstance(170, 175, 0);
            b = ImageIO.read(this.getClass().getResource("bn.png")).getScaledInstance(170, 175, 0);
            r = ImageIO.read(this.getClass().getResource("right.png")).getScaledInstance(50, 60, 0);
            w = ImageIO.read(this.getClass().getResource("wrong.png")).getScaledInstance(50, 60, 0);
            for (int i = 0; i < 20; i++) {
                String name = "w" + i + ".png";
                waste[i] = ImageIO.read(this.getClass().getResource(name)).getScaledInstance(300, 200, 0);
            }
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g) {
        try {
        if (crntq != 20) {
            g.drawImage(n, 100, 300, null);
            g.drawImage(b, 550, 300, null);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.setColor(Color.red);
            g.clearRect(250, 60, 300, 200);
            g.drawImage(waste[crntq], 250, 60, null);
            g.drawString("Level 1 : Separate the Degradable and Non-biodegradable wastes", 20, 30);
            g.setColor(Color.MAGENTA);
            g.drawString("Non-biodegradable", 105, 470);
            g.drawString("Biodegradable", 575, 470);
            g.setColor(Color.green);
            if (ans == "true") {
                if (slctitm == "d") {
                    g.drawImage(r, 620, 360, null);
                }
                if (slctitm == "n") {
                    g.drawImage(r, 170, 360, null);
                }
            }
            if (ans == "false") {
                if (slctitm == "d") {
                    g.drawImage(w, 620, 360, null);
                }
                if (slctitm == "n") {
                    g.drawImage(w, 170, 360, null);
                }
            }
            ans = "";
            slctitm = "";
        } else {
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.setColor(Color.red);
            g.drawString("Well Done! Level1 Complete", 100, 200);
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.drawString("Do right click for contiue with Level2", 180, 250);
        }
        Thread.sleep(500);
        g.dispose();
        }
        catch (Exception err) {
                System.out.print(err);
        }
    }

    @Override
    public void update() {

    }

    public boolean lvlClear() {
        b.flush();
        n.flush();
        w.flush();
        r.flush();
        return true;
    }

    @Override
    public boolean mouseClk(MouseEvent arg0) {
        int x = arg0.getX();
        int y = arg0.getY();
        if (crntq != 20) {
            if (degradable.contains(x, y)) {
                if (crctans[crntq] == "d") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "d";
            } else if (nondegradable.contains(x, y)) {
                if (crctans[crntq] == "n") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "n";
            } else {
                ans = "";
                slctitm = "";
            }
        } else {
            return lvlClear();
        }
        return false;
    }

    public void setAns() {
        crctans[0] = "d";
        crctans[1] = "d";
        crctans[2] = "n";
        crctans[3] = "n";
        crctans[4] = "d";
        crctans[5] = "d";
        crctans[6] = "d";
        crctans[7] = "n";
        crctans[8] = "n";
        crctans[9] = "d";
        crctans[10] = "d";
        crctans[11] = "d";
        crctans[12] = "n";
        crctans[13] = "n";
        crctans[14] = "d";
        crctans[15] = "n";
        crctans[16] = "n";
        crctans[17] = "n";
        crctans[18] = "d";
        crctans[19] = "d";
    }
}
