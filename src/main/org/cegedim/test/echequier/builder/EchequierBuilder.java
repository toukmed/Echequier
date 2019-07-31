package main.org.cegedim.test.echequier.builder;

import main.org.cegedim.test.echequier.entities.Piece;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface EchequierBuilder {

    Map<String, Piece> line1 = new HashMap<>();
    Map<String, Piece> line2 = new HashMap<>();
    Map<String, Piece> line3 = new HashMap<>();
    Map<String, Piece> line4 = new HashMap<>();
    Map<String, Piece> line5 = new HashMap<>();
    Map<String, Piece> line6 = new HashMap<>();
    Map<String, Piece> line7 = new HashMap<>();
    Map<String, Piece> line8 = new HashMap<>();

    List<Map<String, Piece>> buildEchequier();
}
