package projekt;

import java.util.Scanner;
import javax.swing.SwingUtilities;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author roman
 */
public class Start {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new TicTacToeFrame());
    }
}
