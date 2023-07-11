package TicTacToeGame;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author roman
 */
public class Player {
    
    private int id;
    private String name;
    private ArrayList<String> field;
    private Color color;

    public Player(int id, String spieler_name, Color color, ArrayList<String> Liste_an_Feldern) {
        this.id = id;
        this.name = spieler_name;
        this.color = color;
        this.field = Liste_an_Feldern;
    }

    public Player() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getField() {
        return field;
    }

    public void setField(ArrayList<String> feld) {
        this.field = feld;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Spieler{" + "id=" + id + ", name=" + name + "}";
    }

}
