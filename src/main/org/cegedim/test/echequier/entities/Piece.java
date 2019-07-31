package main.org.cegedim.test.echequier.entities;

public abstract class Piece {

    private String nom;
    private String color;

    public Piece(String nom, String color) {
        this.nom = nom;
        this.color = color;
    }

    public String getColor() {
        return color;
    }

}
