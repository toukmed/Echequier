package main.org.cegedim.test.echequier.parser;

import main.org.cegedim.test.echequier.builder.EchequierBuilder;
import main.org.cegedim.test.echequier.builder.EchequierBuilderImpl;
import main.org.cegedim.test.echequier.entities.Piece;
import main.org.cegedim.test.echequier.entities.Tour;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TourParser implements PieceParser {

    private final EchequierBuilder echequierBuilderImpl = new EchequierBuilderImpl();
    private final List<Map<String, Piece>> echequier = echequierBuilderImpl.buildEchequier();
    private final List<String> coups = new ArrayList<>();

    private Map<String, Piece> tourMap;
    private Tour tour;
    private String tourRowIndex;
    private String tourLineIndex;
    private String tourPosition;

    public List<String> getCoups() {
        return coups;
    }

    public String getTourPosition() {
        return tourPosition;
    }

    /**
     * Constructor set the corresponding coordinates.
     * Build the Rook position.
     * Parse the chess board for possible mouvments of the Rook.
     */
    public TourParser(){
        setCoordinatesFromMapContainigTour();
        tourPosition = "T".concat(tourRowIndex).concat(tourLineIndex);
        parseCoupsUp();
        parseCoupsDown();
        parseCoupsLeft();
        parseCoupsRight();
    }

    /**
     * Parse the possibilites of mouvments of the Rook on its left side.
     * @return a list of those possibilies.
     */
    @Override
    public List<String> parseCoupsLeft() {
        char startFromRow = (char) (tourRowIndex.charAt(0)-1);
        for (char pos = startFromRow; pos >= 'a'; pos--){
            if (parseCoupHorizontally(pos, coups)) break;
        }
        return coups;
    }

    /**
     * Parse the possibilites of mouvments of the Rook on its right side.
     * @return a list of those possibilies.
     */
    @Override
    public List<String> parseCoupsRight() {
        char startFromRow = (char) (tourRowIndex.charAt(0)+1);
        for (char pos = startFromRow; pos <= 'h'; pos++){
            if (parseCoupHorizontally(pos, coups)) break;
        }
        return coups;
    }

    /**
     * Parse the possibilites of mouvments of the Rook on its up side.
     * @return a list of those possibilies.
     */
    @Override
    public List<String> parseCoupsUp(){
        int intTourlineIndex = Integer.parseInt(tourLineIndex);
        for (int indexOfMap = intTourlineIndex; indexOfMap<= 7; indexOfMap++){
            intTourlineIndex++;
            if (parseCoupVertically(intTourlineIndex, indexOfMap)) break;

        }
        return coups;
    }

    /**
     * Parse the possibilites of mouvments of the Rook on its down side.
     * @return a list of those possibilies.
     */
    @Override
    public List<String> parseCoupsDown(){
        int intTourlineIndex = Integer.parseInt(tourLineIndex);
        for (int indexOfMap = intTourlineIndex-2; indexOfMap>= 0; indexOfMap--){
            intTourlineIndex--;
            if (parseCoupVertically(intTourlineIndex, indexOfMap)) break;

        }
        return coups;
    }

    /**
     * Parse the possibility of one mouvment vertically (up or down).
     * @return boolean
     */
    private boolean parseCoupVertically(int intTourlineIndex, int indexOfMap) {
        Map<String, Piece> map = echequier.get(indexOfMap);
        Piece piece = map.get(tourRowIndex);
        if (piece == null) {
            coups.add(buildPosition(tourRowIndex, String.valueOf(intTourlineIndex)));
        } else if (piece instanceof Piece) {
            if (!tour.getColor().equals(piece.getColor())) {
                coups.add("x".concat(tourRowIndex).concat(String.valueOf(intTourlineIndex)));
            }
            return true;
        }
        return false;
    }

    /**
     * Parse the possibility of one mouvment horizontally (left or right).
     * @return boolean
     */
    private boolean parseCoupHorizontally(char pos, List<String> coups) {
        String stringPos = String.valueOf(pos);
        Piece piece = tourMap.get(stringPos);
        if(piece == null){
            coups.add(buildPosition(stringPos, tourLineIndex));
        }else if(piece instanceof Piece){
            if(!tour.getColor().equals(piece.getColor())){
                coups.add("x".concat(stringPos).concat(tourLineIndex));
            }else{
                return true;
            }
        }
        return false;
    }

    /**
     * Build the coordinates of a position
     * @param rowIndex
     * @param lineIndex
     * @return
     */
    private String buildPosition(String rowIndex, String lineIndex) {
        String position = rowIndex.concat(lineIndex);
        return position;
    }

    /**
     * Find the map containing the Rook
     * Find the Rook inside the map
     * Set coordiantes of the Rook
     */
    private void setCoordinatesFromMapContainigTour(){
        for (Map<String, Piece> map : echequier) {
            for (Map.Entry<String, Piece> entry : map.entrySet()) {
                String pos = entry.getKey();
                Piece piece = entry.getValue();
                if (piece instanceof Tour) {
                    tour = (Tour) piece;
                    tourMap = map;
                    tourLineIndex = String.valueOf(echequier.indexOf(map) + 1);
                    tourRowIndex = pos;
                }
            }
        }
    }


}
