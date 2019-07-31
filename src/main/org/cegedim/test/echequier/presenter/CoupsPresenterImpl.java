package main.org.cegedim.test.echequier.presenter;

import main.org.cegedim.test.echequier.parser.TourParser;

import java.util.ArrayList;
import java.util.List;

public class CoupsPresenterImpl implements CoupsPresenter {

    private final TourParser pieceParser = new TourParser();

    /**
     * Build the list of possibles mouvments from the Rook to the next position.
     * @return listCoups
     */
    @Override
    public List<String> buildListCoups() {
        List<String> listCoups = new ArrayList<>();
        List<String> coups = pieceParser.getCoups();
        String tourPosition = pieceParser.getTourPosition();

        coups.forEach((coup) -> {
            String concat = tourPosition.concat("-").concat(coup);
            listCoups.add(concat);
        });
        return listCoups;
    }

}
