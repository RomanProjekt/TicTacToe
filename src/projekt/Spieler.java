/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projekt;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author roman
 */
public class Spieler {
    
    private int id;
    private String name;
    private ArrayList<String> feld;
    private Color color;
    private int zaehler;

    public Spieler(int id, String name, Color color, int zaehler, ArrayList<String> feld) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.zaehler = zaehler;
        this.feld = feld;
    }

    public Spieler() {
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

    public ArrayList<String> getFeld() {
        return feld;
    }

    public void setFeld(ArrayList<String> feld) {
        this.feld = feld;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getZaehler() {
        return zaehler;
    }

    public void setZaehler(int zaehler) {
        this.zaehler = zaehler;
    }
    
    @Override
    public String toString() {
        return "Spieler{" + "id=" + id + ", name=" + name + "}";
    }

}
