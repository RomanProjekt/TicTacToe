package TicTacToeGame;

import static TicTacToeGame.PlayField.count_game_state;
import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;


public final class GameLogic implements MouseListener {
    
    private final static int MAX_WIN_FIELDS = 3;
    private final static int MAX_GAMECOUNT_PER_PLAY = 9;

    private final Player player1, player2;
    private final JLabel playfield;
    public ArrayList<ArrayList<String>> all_win_list_chances;
    private boolean start;
    private boolean player_has_win;
    private PlayField playField;
   

    public GameLogic(PlayField spielFeld, JLabel label, Player spieler1, Player spieler2, boolean start) {
        this.playField = spielFeld;
        this.playfield = label;
        this.player1 = spieler1;
        this.player2 = spieler2;
        this.start = start;
        all_win_list_chances = Liste_Aller_GewinnMöglichkeiten();
    }

    public ArrayList<ArrayList<String>> Liste_Aller_GewinnMöglichkeiten() {
        all_win_list_chances = new ArrayList<>();
        ArrayList<String> Win_Field_1 = new ArrayList<>(3);
        ArrayList<String> Win_Field_2 = new ArrayList<>(3);
        ArrayList<String> Win_Field_3 = new ArrayList<>(3);
        ArrayList<String> Win_Field_4 = new ArrayList<>(3);
        ArrayList<String> Win_Field_5 = new ArrayList<>(3);
        ArrayList<String> Win_Field_6 = new ArrayList<>(3);
        
        //Mit Diogonale
        ArrayList<String> Win_Field_7 = new ArrayList<>(3);
        ArrayList<String> Win_Field_8 = new ArrayList<>(3);
        
        Win_Field_1.add("00"); //1,2,3 
        Win_Field_1.add("10");
        Win_Field_1.add("20");

        Win_Field_2.add("01"); //4,5,6
        Win_Field_2.add("11");
        Win_Field_2.add("21");

        Win_Field_3.add("02");  //7,8,9   
        Win_Field_3.add("12");
        Win_Field_3.add("22");

        Win_Field_4.add("00");   //1,4,7
        Win_Field_4.add("01");   //1,4,7
        Win_Field_4.add("02");   //1,4,7

        Win_Field_5.add("10");   //2,5,8
        Win_Field_5.add("11");   //2,5,8
        Win_Field_5.add("12");   //2,5,8

        Win_Field_6.add("20");   //3,6,9
        Win_Field_6.add("21");   //3,6,9
        Win_Field_6.add("22");   //3,6,9
        
        //Diogonale
        Win_Field_7.add("00");   
        Win_Field_7.add("11");  
        Win_Field_7.add("22");
        
        Win_Field_8.add("20");   
        Win_Field_8.add("11");  
        Win_Field_8.add("02");
        
        all_win_list_chances.add(Win_Field_1);
        all_win_list_chances.add(Win_Field_2);
        all_win_list_chances.add(Win_Field_3);
        all_win_list_chances.add(Win_Field_4);
        all_win_list_chances.add(Win_Field_5);
        all_win_list_chances.add(Win_Field_6);
        all_win_list_chances.add(Win_Field_7);
        all_win_list_chances.add(Win_Field_8);
        
        return all_win_list_chances;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (start && count_game_state <= MAX_GAMECOUNT_PER_PLAY) {
            if (count_game_state == 1 || count_game_state % 2 != 0) {
                set_red_Field_on_Playfield(true);
            } else {
                set_blue_Field_on_Playfield(true);
            }
        }
    }


    private void set_blue_Field_on_Playfield(boolean istFeldFrei) {
        start = false;
        for (String opponent_field : player2.getField()) {
            istFeldFrei = !opponent_field.equals(playfield.getText());
        }

        if (istFeldFrei) {
            for (String meineFelder : player1.getField()) {
                istFeldFrei = !meineFelder.equals(playfield.getText());
            }
        }
        if (istFeldFrei && count_game_state % 2 == 0) {
            playfield.setBackground(Color.BLUE);
            player2.getField().add(playfield.getText());
            System.out.println("Spieler 2: " + playfield.getText());
            int current_count_win_fields = 0;
            start = true;
            for (List<String> winL : all_win_list_chances) {
                for (String winElement : winL) {
                    for (String feld_von_spieler2 : player2.getField()) {
                        if (feld_von_spieler2.compareTo(winElement) == 0) {
                            current_count_win_fields += 1;
                        }
                    }
                }
                if (current_count_win_fields == MAX_WIN_FIELDS) {
                    System.out.println("Spieler 2 hat gewonnen!");
                    start = false;
                    count_game_state = MAX_GAMECOUNT_PER_PLAY;
                    current_count_win_fields = 0;
                    player_has_win = true;
                    this.repeat_the_Game("Spieler 2 hat gewonnen! - Möchten Sie das Spiel wiederholen?");
                    break;
                } else {
                    current_count_win_fields = 0;
                    player_has_win = false;
                }
            }
            if (count_game_state == MAX_GAMECOUNT_PER_PLAY && !player_has_win ) {
                System.out.println("Unentschieden - Kein Spieler hat gewonnen!");
                repeat_the_Game("Unentschieden - Kein Spieler hat gewonnen! ".concat(" ").concat(" Möchten Sie das Spiel wiederholen?"));
            }
            if (!player_has_win) {
                System.out.println("Naechster Spieler 1 ist an der Reihe!");
                count_game_state += 1;
            }
        } else {
            start = true;
        }
    }

    private void set_red_Field_on_Playfield(boolean istFeldFrei) {
        start = false;
        for (String gegnerFeld : player2.getField()) {
            istFeldFrei = !gegnerFeld.equals(playfield.getText());
        }

        if (istFeldFrei) {
            for (String meineFelder : player1.getField()) {
                istFeldFrei = !meineFelder.equals(playfield.getText());
            }
        }
        if (istFeldFrei && count_game_state % 2 != 0) {
            playfield.setBackground(Color.RED);
            
            
            player1.getField().add(playfield.getText());
            System.out.println("Spieler 1: " + playfield.getText());
            int current_gameround_count  = 0;
            start = true;
            for (List<String> winL : all_win_list_chances) {
                for (String winElement : winL) {
                    for (String feld_von_Spieler1 : player1.getField()) {
                        if (feld_von_Spieler1.compareTo(winElement) == 0) {
                            current_gameround_count  += 1;
                        }
                    }
                }
                if (current_gameround_count  == MAX_WIN_FIELDS) {
                    System.out.println("Spieler 1 hat gewonnen!");
                    start = false;
                    count_game_state = MAX_GAMECOUNT_PER_PLAY;
                    current_gameround_count  = 0;
                    player_has_win = true;
                    this.repeat_the_Game("Spieler 1 hat gewonnen! - Möchten Sie das Spiel wiederholen?");
                    break;
                } else {
                    current_gameround_count  = 0;
                    player_has_win = false;
                }
            }
            if (count_game_state == MAX_GAMECOUNT_PER_PLAY && !player_has_win ) {
                System.out.println("Unentschieden - Kein Spieler hat gewonnen!");
                repeat_the_Game("Unentschieden - Kein Spieler hat gewonnen! ".concat(" ").concat(" Möchten Sie das Spiel wiederholen?"));
            }
            else if (!player_has_win) {
                System.out.println("Naechster Spieler 2 ist an der Reihe!");
                count_game_state += 1;
            }

        } else {
            start = true;
        }
    }

    private void repeat_the_Game(String message) throws HeadlessException {
        
        int answer = JOptionPane.showOptionDialog(
                this.playField,
                message,"Info" ,
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.WARNING_MESSAGE,
                null,
                new String[]{"Ja", "Nein"},
                "Nein");
        
        if(answer == 0) {
            start_new_Game();
            count_game_state = 1;
            start = true;
            playField.dispose();
            
        } else {
            System.exit(0);
            System.out.println("Spielende!");
        }
    }
    
    private void start_new_Game() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PlayField();
            }
        });
        System.out.println("Wiederholung des Spiels!");
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

}
