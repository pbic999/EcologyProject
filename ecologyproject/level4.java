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
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

class level4 extends Level {

    String ques[];
    int score = 0;
    int ans = -1;
    int crctans[];
    String choice[];
    Rectangle o[];
    int crntq = 0;

    public level4() {
        o = new Rectangle[4];
        ques = new String[10];
        choice = new String[10];
        crctans = new int[10];
        setValues();
    }

    public void draw(Graphics2D g) {
        try {
        if (crntq != 10) {
            g.setFont(new Font("Serif", Font.BOLD, 20));
            g.setColor(Color.red);
            g.drawString("Level 4 : Quiz ", 20, 30);
            int qno = crntq + 1;
            g.setColor(Color.black);
            String q = "Q" + qno + ". " + ques[crntq];
            String t[] = choice[crntq].split(",");
            g.drawString(q, 30, 60);
            g.drawString(t[0], 50, 100);
            g.drawString(t[1], 430, 100);
            g.drawString(t[2], 50, 130);
            g.drawString(t[3], 430, 130);
            g.setColor(Color.black);
            g.fillOval(40, 90, 8, 8);
            g.fillOval(420, 90, 8, 8);
            g.fillOval(40, 120, 8, 8);
            g.fillOval(420, 120, 8, 8);
            g.setColor(Color.red);
            if (ans == 0) {
                if (crctans[crntq] == 0) {
                    g.setColor(Color.green);
                }
                g.fillOval(40, 90, 8, 8);
            } else if (ans == 1) {
                if (crctans[crntq] == 1) {
                    g.setColor(Color.green);
                }
                g.fillOval(420, 90, 8, 8);
            } else if (ans == 2) {
                if (crctans[crntq] == 2) {
                    g.setColor(Color.green);
                }
                g.fillOval(40, 120, 8, 8);
            } else if (ans == 3) {
                if (crctans[crntq] == 3) {
                    g.setColor(Color.green);
                }
                g.fillOval(420, 120, 8, 8);
            }
            if (ans != -1) {
                g.setColor(Color.green);
                if (crctans[crntq] == 0) {
                    g.fillOval(40, 90, 8, 8);
                }
                if (crctans[crntq] == 1) {
                    g.fillOval(420, 90, 8, 8);
                }
                if (crctans[crntq] == 2) {
                    g.fillOval(40, 120, 8, 8);
                }
                if (crctans[crntq] == 3) {
                    g.fillOval(420, 120, 8, 8);
                }
                crntq++;
            }
            
            ans = -1;
        } else {
            g.setFont(new Font("Serif", Font.BOLD, 40));
            g.setColor(Color.red);
            g.drawString("Thank you !!", 250, 200);
        }
        g.dispose();
        Thread.sleep(500);
        }
                    catch (Exception err) {
                System.out.print(err);
            }
    }

    public void update() {
    }

    public boolean lvlClear() {
        return true;
    }

    @Override
    public boolean mouseClk(MouseEvent arg0) {
        int x = arg0.getX();
        int y = arg0.getY();
        if (crntq != 10) {
            if (o[0].contains(x, y)) {
                ans = 0;
            }
            if (o[1].contains(x, y)) {
                ans = 1;
            }
            if (o[2].contains(x, y)) {
                ans = 2;
            }
            if (o[3].contains(x, y)) {
                ans = 3;
            }
        } else {
            return lvlClear();
        }
        return false;
    }

    private void setValues() {
        ques[0] = "Which item does not belong in the recycling bin?";
        ques[1] = "Which aluminum item is not recyclable?";
        ques[2] = "How does organic material in the buried solid waste will decompose?";
        ques[3] = "Problem of solid waste disposal can be reduced through…….";
        ques[4] = "Which of the below is not an idea behind solid waste management?";
        ques[5] = "Making new containers from crushed glass helps to…..";
        ques[6] = "What is true about Aerobic bacteria?";
        ques[7] = "Why plastics are difficult to recycle?";
        ques[8] = "Which of the following can be recycled many times?";
        ques[9] = "The term ISWM refers to:";

        choice[0] = "Plastic Milk Jug,Plastic Soda Bottle,Laundry Detergent Bottle,Styrofoam Cup";
        choice[1] = "Soda Cans,Pots and Pans,Aluminum Foil,Aluminum Pie Pans";
        choice[2] = " By the action of oxidation,By the action of microorganisms,By the flow of water,By the soil particles";
        choice[3] = "Recycling,Lesser pollution,More timber,Population control";
        choice[4] = "Control of waste generation,Storage and collection,Disposal,Stop waste generation";
        choice[5] = "Save materials,Save fuel,Both of these,None of these";
        choice[6] = "Flourish in the presence of free oxygen,Consume organic matter as their food,Oxidise organic matter in sewage,All";
        choice[7] = "Because it is very hard material,Because it is very adhesive in its nature,Because of different types of polymer resins,Because of different sizes of plastic";
        choice[8] = "Plastic,Wood,Organic materials,Aluminum";
        choice[9] = "International Solid Waste Management,Integrated Solid Waste Management,Integrated Solid Waste Machine,International Solid Waste Mechanism";

        crctans[0] = 3;
        crctans[1] = 1;
        crctans[2] = 1;
        crctans[3] = 0;
        crctans[4] = 3;
        crctans[5] = 2;
        crctans[6] = 3;
        crctans[7] = 2;
        crctans[8] = 3;
        crctans[9] = 1;

        o[0] = new Rectangle(40, 90, 8, 8);
        o[1] = new Rectangle(420, 90, 8, 8);
        o[2] = new Rectangle(40, 120, 8, 8);
        o[3] = new Rectangle(420, 120, 8, 8);
    }
}
