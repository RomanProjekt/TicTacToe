package TicTacToeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

/**
 *
 * @author roman
 */
public class PlayField extends JFrame {

    private GridBagConstraints gbc;
    public static int count_game_state = 1;
    private List<JLabel> lists_of_fields;
    private ArrayList<String> field_of_player1 = new ArrayList<>();
    private ArrayList<String> field_of_player2 = new ArrayList<>();
    

    public PlayField() {
        gbc = new GridBagConstraints();
        lists_of_fields = new ArrayList<>(9);
        create_TicTacToe_Playfield();
    }

    private void create_TicTacToe_Playfield() {
        createLayout();
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable( false );
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
        JLabel playfield = null;
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                gbc.gridx = x;
                gbc.gridy = y;
                playfield = createLabel(playfield, Color.WHITE, String.valueOf(x).concat(String.valueOf(y)));
                lists_of_fields.add(playfield);
                this.add(playfield, gbc);
            }
        }
    }
    
   
    
    public void conMouseListener() {
        for (JLabel game_fields : lists_of_fields) {
            game_fields.addMouseListener(new GameLogic(
                    this,
                    game_fields, 
                    new Player(1, "Spieler1", Color.RED, field_of_player1), 
                    new Player(2, "Spieler2", Color.BLUE,field_of_player2), 
                    true));
        }
    }


    private JLabel createLabel(JLabel game_field, Color farbe_spielfeld, String txt) {
        game_field = new JLabel(txt, SwingConstants.CENTER);
        game_field.setPreferredSize(new Dimension(120, 120));
        game_field.setOpaque(true);
        game_field.setBackground(farbe_spielfeld);
        EmptyBorder eBorder = new EmptyBorder(2, 10, 2, 10); // oben, rechts, unten, links
        LineBorder lBorder = new LineBorder(new Color(100, 100, 100));
        game_field.setBorder(BorderFactory.createCompoundBorder(lBorder, eBorder)); 
        return game_field;
    }


}
