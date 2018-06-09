
package UI.Graphics;

import Model.ObservableGame;

public class PlayerBoardPanel extends BoardPanel{
    private PlayerPiecePanel wall;
    private PlayerPiecePanel morale;
    private PlayerPiecePanel supply;
    private PlayerPiecePanel tunnel;
    private PlayerPiecePanel supplyCount;
    
    public PlayerBoardPanel(ObservableGame game) {
        super(game, PLAYER_BOARD);
        createObject();
        orderLayout();
    }

    private void createObject() {
        wall = new PlayerPiecePanel(LADDER_ICON, game);
        morale= new PlayerPiecePanel(LADDER_ICON,game);
        supply= new PlayerPiecePanel(LADDER_ICON,game);
        tunnel= new PlayerPiecePanel(LADDER_ICON,game);
        supplyCount= new PlayerPiecePanel(LADDER_ICON,game);
    }

    private void orderLayout() {
        add(wall);
        add(morale);
        add(supply);
        add(tunnel);
        add(supplyCount);
    }
    
}
