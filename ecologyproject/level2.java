/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecologyproject;

import ecologyproject.EcologyProject;
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

class level2 extends Level {

    int crntq = 0;
    String crctans[];
    Image waste[];
    Image pa, pl, m, gl, r, w;
    Rectangle paper, plastic, metal, glass;
    EcologyProject eco;

    public level2() {
        eco = new EcologyProject();
        waste = new Image[20];
        crctans = new String[20];
        plastic = new Rectangle(25, 300, 150, 175);
        paper = new Rectangle(225, 300, 150, 175);
        metal = new Rectangle(425, 300, 150, 175);
        glass = new Rectangle(625, 300, 150, 175);
        slctitm = "";
        ans = "";
        setAns();
        try {
            pa = ImageIO.read(this.getClass().getResource("p.png")).getScaledInstance(150, 175, 0);
            pl = ImageIO.read(this.getClass().getResource("n.png")).getScaledInstance(150, 175, 0);
            m = ImageIO.read(this.getClass().getResource("m.png")).getScaledInstance(150, 175, 0);
            gl = ImageIO.read(this.getClass().getResource("g.png")).getScaledInstance(150, 175, 0);
            r = ImageIO.read(this.getClass().getResource("right.png")).getScaledInstance(50, 60, 0);
            w = ImageIO.read(this.getClass().getResource("wrong.png")).getScaledInstance(50, 60, 0);
            for (int i = 0; i < 20; i++) {
                String name = "x" + i + ".png";
                waste[i] = ImageIO.read(this.getClass().getResource(name)).getScaledInstance(300, 200, 0);
            }
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    public void draw(Graphics2D g) {
        try{
        if (crntq != 20) {
            g.drawImage(pl, 25, 300, null);
            g.drawImage(pa, 225, 300, null);
            g.drawImage(m, 425, 300, null);
            g.clearRect(625, 300, 150, 175);
            g.drawImage(gl, 625, 300, null);
            g.clearRect(250, 60, 300, 200);
            g.drawImage(waste[crntq], 250, 60, null);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.setColor(Color.red);
            g.drawString("Level 2 : Separate Plastic, Paper, Metal and Glass wastes", 20, 30);
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.setColor(Color.MAGENTA);
            g.drawString("Plastic waste", 50, 470);
            g.drawString("Paper waste", 250, 470);
            g.drawString(" Metal Waste", 450, 470);
            g.drawString("Glass waste", 650, 470);
            if (ans == "true") {
                if (slctitm == "pl") {
                    g.drawImage(r, 85, 360, null);
                }
                if (slctitm == "pa") {
                    g.drawImage(r, 285, 360, null);
                }
                if (slctitm == "m") {
                    g.drawImage(r, 485, 360, null);
                }
                if (slctitm == "g") {
                    g.drawImage(r, 685, 360, null);
                }
            } else {
                if (ans == "false") {
                    if (slctitm == "pl") {
                        g.drawImage(w, 85, 360, null);
                    }
                    if (slctitm == "pa") {
                        g.drawImage(w, 285, 360, null);
                    }
                    if (slctitm == "m") {
                        g.drawImage(w, 485, 360, null);
                    }
                    if (slctitm == "g") {
                        g.drawImage(w, 685, 360, null);
                    }
                }
            }
            ans = "";
            slctitm = "";
        } else {
            g.setFont(new Font("Serif", Font.BOLD, 50));
            g.setColor(Color.red);
            g.drawString("Well Done! Level2 Complete", 100, 200);
            g.setFont(new Font("Serif", Font.BOLD, 30));
            g.drawString("Do right click for contiue with Level3", 180, 250);
        }
        Thread.sleep(500);
        g.dispose();
    }
    catch (Exception e) {
     System.out.print(e);
    }
    }
    
    public void update() {
    }

    public boolean lvlClear() {
        eco.i.flush();
        w.flush();
        r.flush();
        return true;
    }

    @Override
    public boolean mouseClk(MouseEvent arg0) {
        int x = arg0.getX();
        int y = arg0.getY();
        if (crntq != 20) {
            if (plastic.contains(x, y)) {
                if (crctans[crntq] == "pl") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "pl";
            } else if (paper.contains(x, y)) {
                if (crctans[crntq] == "pa") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "pa";
            } else if (metal.contains(x, y)) {
                if (crctans[crntq] == "m") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "m";
            } else if (glass.contains(x, y)) {
                if (crctans[crntq] == "g") {
                    ans = "true";
                    crntq++;
                } else {
                    ans = "false";
                }
                slctitm = "g";
            } else {
                ans = "";
                slctitm = "";
            }
        } else {
            return lvlClear();
        }
        return false;
    }

    private void dplyans(Graphics2D g) {
    }

    private void setAns() {
        crctans[0] = "pa";
        crctans[1] = "m";
        crctans[2] = "pl";
        crctans[3] = "pl";
        crctans[4] = "g";
        crctans[5] = "m";
        crctans[6] = "pl";
        crctans[7] = "pl";
        crctans[8] = "g";
        crctans[9] = "pa";
        crctans[10] = "pa";
        crctans[11] = "m";
        crctans[12] = "pl";
        crctans[13] = "m";
        crctans[14] = "pl";
        crctans[15] = "g";
        crctans[16] = "m";
        crctans[17] = "g";
        crctans[18] = "pa";
        crctans[19] = "pl";
    }

}
