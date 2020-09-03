package com.dgyt.tank;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class TankFrame extends Frame {

    private int moves = 0;
    private int x = 80;
    private int y = 80;

    public TankFrame() {
        super.setVisible(true);
        super.setResizable(true);
        super.setSize(800, 800);
        super.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        super.addKeyListener(new MyKeyListener());
    }

    @Override
    public void paint(Graphics g) {
        System.out.println(moves++);
        g.fillRect(x, y, 10, 10);
    }

    class MyKeyListener implements KeyListener {
        public void keyTyped(KeyEvent e) {

        }

        public void keyPressed(KeyEvent e) {
            x += 10;
            if (x + 10 > 800) {
                y = y + 100;
                x = 0;
            }
            repaint();
        }

        public void keyReleased(KeyEvent e) {

        }
    }
}


