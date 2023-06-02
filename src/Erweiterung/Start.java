/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Erweiterung;

import java.util.Scanner;
import javax.swing.SwingUtilities;
import projekt.TicTacToeFrame;

/**
 *
 * @author roman
 */
public class Start {
    
    public static void main(String[] args) {
        TicTacToeFrame frame = new TicTacToeFrame();
        boolean start = true;
        while (start) {
            if(true) {
                System.out.println("Möchten Sie nochmal spielen? J/N");
                Scanner scanner = new Scanner(System.in);
                String antwort = scanner.next();
                if(antwort.compareTo("J") == 0) {
                    SwingUtilities.invokeLater(() -> new TicTacToeFrame()); 
                    start = false;
                } else {
                    System.out.println("Ende!");
                    start = false;
                    System.exit(0);
                }
                
                
            } else {
                start = false;
            }
        }
    }
    
    public static boolean neustart(int round) {
        return false;
    }
    
}
