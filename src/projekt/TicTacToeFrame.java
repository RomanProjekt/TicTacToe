/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekt;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 *
 * @author roman
 */
public class TicTacToeFrame extends JFrame {

    private GridBagConstraints gbc;
    public static int z = 1;
    private List<JLabel> jlabelList;
    private ArrayList<String> felder1 = new ArrayList<>();
    private ArrayList<String> felder2 = new ArrayList<>();
    

    public TicTacToeFrame() {
        gbc = new GridBagConstraints();
        jlabelList = new ArrayList<>(9);
        init();
    }

    private void init() {
        createLayout();
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setTitle("Tic Tac Toe Game");
        this.setVisible(true);
        this.setSize(1000, 1000);
        this.setPreferredSize(getSize());
    }
    
    private void createLayout() {
        GridBagLayout grid = new GridBagLayout();
        setLayout(grid);
        GridBagLayout layout = new GridBagLayout();
        this.setLayout(layout);
        this.createGridBagConstraints();
        this.conMouseListener();
    }

    private void createGridBagConstraints() {
        gbc.fill = GridBagConstraints.HORIZONTAL;
        JLabel l = null;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                gbc.gridx = x;
                gbc.gridy = y;
                l = createLabel(l, Color.WHITE, String.valueOf(x).concat(String.valueOf(y)));
                jlabelList.add(l);
                this.add(l, gbc);
            }
        }
    }
    
    public void neuStart() {
        gbc = new GridBagConstraints();
        createGridBagConstraints();
    }
    
    
    public void conMouseListener() {
        for (JLabel l : jlabelList) {
            l.addMouseListener(new TicTacToeLogik(
                    l, 
                    new Spieler(1, "Spieler1", Color.RED, 1, felder1), 
                    new Spieler(2, "Spieler2", Color.BLUE, 1,felder2), 
                    true));
        }
    }


    private JLabel createLabel(JLabel label, Color c, String txt) {
        label = new JLabel(txt, SwingConstants.CENTER);
        label.setPreferredSize(new Dimension(120, 120));
        label.setOpaque(true);
        label.setBackground(c);
        return label;
    }


}
