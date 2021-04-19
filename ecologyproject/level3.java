/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecologyproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

class level3 extends Level {

    int crntq = 0;
    String crctans[];
    Image waste[];
    Image e, d, m, r, w;
    Rectangle electronic, medical, demolition;

    public level3() {
        waste = new Image[20];
        crctans = new String[20];
        electronic = new Rectangle(60, 300, 150, 175);
        medical = new Rectangle(330, 300, 150, 175);
        demolition = new Rectangle(555, 300, 150, 175);
        slctitm = "";
        ans = "";
        setAns();
        try {
            e = ImageIO.read(this.getClass().getResource("ele.png")).getScaledInstance(150, 175, 0);
            m = ImageIO.read(this.getClass().getResource("med.png")).getScaledInstance(150, 175, 0);
            d = ImageIO.read(this.getClass().getResource("dem.png")).getScaledInstance(150, 175, 0);
            r = ImageIO.read(this.getClass().getResource("right.png")).getScaledInstance(50, 60, 0);
            w = ImageIO.read(this.getClass().getResource("wrong.png")).getScaledInstance(50, 60, 0);
            for (int i = 0; i < 20; i++) {
                String name = "y" + i + ".png";
                waste[i] = ImageIO.read(this.getClass().getResource(name)).getScaledInstance(300, 200, 0);
            }
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g) {
        if (crntq != 20) {
            g.drawImage(e, 60, 300, null);
            g.drawImage(m, 310, 300, null);
            g.clearRect(560, 300, 150, 175);
            g.drawImage(d, 560, 300, null);
            g.clearRect(250, 60, 300, 200);
            g.drawImage(waste[crntq], 250, 60, null);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.setColor(Color.red);
            g.drawString("Level 3 : Separate Electronic, Paper, Medical and Demolition(or Construction) wastes", 20, 30);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.setColor(Color.MAGENTA);
            g.drawString("Electronic waste", 65, 470);
            g.drawString("Medical waste", 330, 470);
            g.drawString(" Demolition Waste", 555, 470);
            if (ans == "true") {
                if (slctitm == "e") {
                    g.drawImage(r, 120, 360, null);
                }
                if (slctitm == "m") {
                    g.drawImage(r, 370, 360, null);
                }
                if (slctitm == "d") {
                    g.drawImage(r, 620, 360, null);
                }
            } else {
                if (ans == "false") {
                    if (slctitm == "e") {
                        g.drawImage(w, 120, 360, null);
                    }
                    if (slctitm == "m") {
                        g.drawImage(w, 370, 360, null);
                    }
                    if (slctitm == "d") {
                        g.drawImage(w, 620, 360, null);
                    }
                }
            }
            for (int i = 0; i < 5000; i++) {
                System.out.println("u");
            }
            ans = "";
            slctitm = "";
        } else {
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.setColor(Color.red);
            g.drawString("Well Done! Level3 Complete", 100, 200);
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.drawString("Do right click for contiue with Level4", 180, 250);
        }
        g.dispose();
    }

    public void update() {
    }

    public boolean lvlClear() {
        e.flush();
        m.flush();
        d.flush();
        w.flush();
        r.flush();
        return true;
    }

    @Override
    public boolean mouseClk(MouseEvent arg0) {
        int x = arg0.getX();
        int y = arg0.getY();
        if (crntq != 20) {
            if (electronic.contains(x, y)) {
                if (crctans[crntq] == "e") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "e";
            } else if (medical.contains(x, y)) {
                if (crctans[crntq] == "m") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "m";
            } else if (demolition.contains(x, y)) {
                if (crctans[crntq] == "d") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "d";
            } else {
                ans = "";
                slctitm = "";
            }
        } else {
            return lvlClear();
        }
        return false;
    }

    private void setAns() {
        crctans[0] = "m";
        crctans[1] = "d";
        crctans[2] = "e";
        crctans[3] = "m";
        crctans[4] = "e";
        crctans[5] = "d";
        crctans[6] = "m";
        crctans[7] = "d";
        crctans[8] = "e";
        crctans[9] = "e";
        crctans[10] = "d";
        crctans[11] = "m";
        crctans[12] = "e";
        crctans[13] = "e";
        crctans[14] = "d";
        crctans[15] = "d";
        crctans[16] = "m";
        crctans[17] = "e";
        crctans[18] = "e";
        crctans[19] = "m";
    }

}
