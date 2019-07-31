package main.org.cegedim.test.echequier.parser;

import java.util.List;

public interface PieceParser {

    List<String> parseCoupsLeft();
    List<String> parseCoupsRight();
    List<String> parseCoupsUp();
    List<String> parseCoupsDown();
}
