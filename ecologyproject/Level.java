/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ecologyproject;

import java.awt.Graphics;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;

public abstract class Level {

    Level crntlvl = null;
    String ans, slctitm;

    public void setLvl(Level l) {
        crntlvl = l;
    }

    public Level getLevel() {
        return crntlvl;
    }

    public abstract boolean mouseClk(MouseEvent arg0);

    public abstract void update();

    public abstract void draw(Graphics2D g);

    public abstract boolean lvlClear();
}
