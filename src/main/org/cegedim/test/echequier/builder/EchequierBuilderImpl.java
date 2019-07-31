package main.org.cegedim.test.echequier.builder;

import main.org.cegedim.test.echequier.entities.Cavalier;
import main.org.cegedim.test.echequier.entities.Piece;
import main.org.cegedim.test.echequier.entities.Pion;
import main.org.cegedim.test.echequier.entities.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EchequierBuilderImpl  implements EchequierBuilder{

    {
        for (char pos = 'a'; pos <= 'h'; pos++){
            line8.put(String.valueOf(pos), null);
        }

        for (char pos = 'a'; pos <= 'h'; pos++){
            if(pos == 'd'){
                line7.put(String.valueOf(pos), new Pion("Noir"));
            }else{
                line7.put(String.valueOf(pos), null);
            }
        }

        for (char pos = 'a'; pos <= 'h'; pos++){
            line6.put(String.valueOf(pos), null);
        }

        for (char pos = 'a'; pos <= 'h'; pos++){
            if(pos == 'd'){
                line5.put(String.valueOf(pos), new Tour("Blanc"));
            }else if (pos == 'g'){
                line5.put(String.valueOf(pos), new Cavalier("Blanc"));
            }else {
                line5.put(String.valueOf(pos), null);
            }
        }

        for (char pos = 'a'; pos <= 'h'; pos++){
            line4.put(String.valueOf(pos), null);
        }

        for (char pos = 'a'; pos <= 'h'; pos++){
            line3.put(String.valueOf(pos), null);
        }

        for (char pos = 'a'; pos <= 'h'; pos++){
            if(pos == 'd'){
                line2.put(String.valueOf(pos), new Cavalier("Blanc"));
            }else{
                line2.put(String.valueOf(pos), null);
            }
        }

        for (char pos = 'a'; pos <= 'h'; pos++){
            line1.put(String.valueOf(pos), null);
        }

    }

    /**
     * Build the chess board simulation containing the test case
     * @return
     */
    @Override
    public List<Map<String, Piece>> buildEchequier() {
        List<Map<String, Piece>> echequier = new ArrayList<>();
        echequier.add(line1);
        echequier.add(line2);
        echequier.add(line3);
        echequier.add(line4);
        echequier.add(line5);
        echequier.add(line6);
        echequier.add(line7);
        echequier.add(line8);
        return echequier;
    }
}
