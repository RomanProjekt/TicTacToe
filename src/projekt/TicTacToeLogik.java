package projekt;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static projekt.TicTacToeFrame.z;


public final class TicTacToeLogik implements MouseListener {

    private final Spieler spieler1, spieler2;
    private final JLabel label;
    ArrayList<ArrayList<String>> winges;
    private boolean start;
    private boolean win;

    public TicTacToeLogik(JLabel label, Spieler spieler1, Spieler spieler2, boolean start) {
        this.label = label;
        this.spieler1 = spieler1;
        this.spieler2 = spieler2;
        this.start = start;
        winges = getWinList();
    }

    public ArrayList<ArrayList<String>> getWinList() {
        winges = new ArrayList<>();
        ArrayList<String> win1 = new ArrayList<>(3);
        ArrayList<String> win2 = new ArrayList<>(3);
        ArrayList<String> win3 = new ArrayList<>(3);
        ArrayList<String> win4 = new ArrayList<>(3);
        ArrayList<String> win5 = new ArrayList<>(3);
        ArrayList<String> win6 = new ArrayList<>(3);

        win1.add("00"); //1,2,3 
        win1.add("10");
        win1.add("20");

        win2.add("01"); //4,5,6
        win2.add("11");
        win2.add("21");

        win3.add("02");  //7,8,9   
        win3.add("12");
        win3.add("22");

        win4.add("00");   //1,4,7
        win4.add("01");   //1,4,7
        win4.add("02");   //1,4,7

        win5.add("10");   //2,5,8
        win5.add("11");   //2,5,8
        win5.add("12");   //2,5,8

        win6.add("20");   //3,6,9
        win6.add("21");   //3,6,9
        win6.add("22");   //3,6,9

        winges.add(win1);
        winges.add(win2);
        winges.add(win3);
        winges.add(win4);
        winges.add(win5);
        winges.add(win6);
        return winges;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (start && z < 10) {
            if (z == 1 || z % 2 != 0) {
                setze_RotesFeld_Spieler1(true);
            } else {
                setze_BlauesFeld_Spieler2(true);
            }
            if (win) {
                //Erweiterung
                //neuStart();
            } 
            if (z == 10 && !win) {
                System.out.println("Unentschieden - Kein Spieler hat gewonnen!");
                JOptionPane.showMessageDialog(label, "Unentschieden - Kein Spieler hat gewonnen!");
            }

        }
    }


    private void setze_BlauesFeld_Spieler2(boolean feldFarbe) {
        start = false;
        for (String feld2 : spieler2.getFeld()) {
            feldFarbe = !feld2.equals(label.getText());
        }

        if (feldFarbe) {
            for (String feld1 : spieler1.getFeld()) {
                feldFarbe = !feld1.equals(label.getText());
            }
        }
        if (feldFarbe && z % 2 == 0) {
            label.setBackground(Color.BLUE);
            spieler2.getFeld().add(label.getText());
            System.out.println("Spieler 2: " + label.getText());
            int back = 0;
            start = true;
            for (List<String> winL : winges) {
                for (String elem : winL) {
                    for (String feldsp2 : spieler2.getFeld()) {
                        if (feldsp2.compareTo(elem) == 0) {
                            back += 1;
                        }
                    }
                }
                if (back == 3) {
                    System.out.println("Spieler 2 hat gewonnen!");
                    JOptionPane.showMessageDialog(label, "Spieler 2 hat gewonnen!");
                    start = false;
                    z = 10;
                    back = 0;
                    win = true;
                    break;
                } else {
                    back = 0;
                    win = false;
                }
            }
            z += 1;
            if (!win) {
                System.out.println("Naechster Spieler 1 ist an der Reihe!");
            }

        } else {
            start = true;
        }
    }

    private void setze_RotesFeld_Spieler1(boolean feldFarbe) {
        start = false;
        for (String feld2 : spieler2.getFeld()) {
            feldFarbe = !feld2.equals(label.getText());
        }

        if (feldFarbe) {
            for (String feld1 : spieler1.getFeld()) {
                feldFarbe = !feld1.equals(label.getText());
            }
        }
        if (feldFarbe && z % 2 != 0) {
            label.setBackground(Color.RED);
            spieler1.getFeld().add(label.getText());
            System.out.println("Spieler 1: " + label.getText());
            int back = 0;
            start = true;
            for (List<String> winL : winges) {
                for (String elem : winL) {
                    for (String feldsp2 : spieler1.getFeld()) {
                        if (feldsp2.compareTo(elem) == 0) {
                            back += 1;
                        }
                    }
                }
                if (back == 3) {
                    System.out.println("Spieler 1 hat gewonnen!");
                    JOptionPane.showMessageDialog(label, "Spieler 1 hat gewonnen!");
                    start = false;
                    z = 10;
                    back = 0;
                    win = true;
                    break;
                } else {
                    back = 0;
                    win = false;
                }
            }
            z += 1;
            if (!win) {
                System.out.println("Naechster Spieler 2 ist an der Reihe!");
            }

        } else {
            start = true;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    public boolean isWin() {
        return win;
    }

}
