
package UI.Graphics;

import Model.ObservableGame;
import Model.Siege_Game;

public class PlayerBoardPanel extends BoardPanel{
    private PiecePanel wall;
    private PiecePanel morale;
    private PiecePanel supply;
    private PiecePanel tunnel;
    private PiecePanel supplyCount;
    
    public PlayerBoardPanel(ObservableGame game) {
        super(game, PLAYER_BOARD);
        createObject();
        orderLayout();
    }

    private void createObject() {
        wall = new PiecePanel(LADDER_ICON);
        morale= new PiecePanel(LADDER_ICON);
        supply= new PiecePanel(LADDER_ICON);
        tunnel= new PiecePanel(LADDER_ICON);
        supplyCount= new PiecePanel(LADDER_ICON);
    }

    private void orderLayout() {
        add(wall);
        add(morale);
        add(supply);
        add(tunnel);
        add(supplyCount);
    }
    
}
