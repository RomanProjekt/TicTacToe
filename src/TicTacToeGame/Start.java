package TicTacToeGame;

import javax.swing.SwingUtilities;

/**
 *
 * @author roman
 */
public class Start {
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlayField();
            }
        });
    }
    
}
