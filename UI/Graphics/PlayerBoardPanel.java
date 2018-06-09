
package UI.Graphics;

import Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Insets;

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
        wall = new PlayerPiecePanel(WALL_ICON, game);
        morale= new PlayerPiecePanel(MORALE_ICON,game);
        supply= new PlayerPiecePanel(SUPPLY_ICON,game);
        tunnel= new PlayerPiecePanel(SOLDIER_ICON,game);
        supplyCount= new PlayerPiecePanel(APPLES_ICON,game);
    }

    private void orderLayout() {
        setLayout(null);
        Insets inset = getInsets();
        Dimension size = wall.getPreferredSize();
        wall.setBounds(inset.left+11, inset.top+9, size.width, size.height);
        add(wall);
        size = morale.getPreferredSize();
        morale.setBounds(inset.left+75, inset.top+9, size.width, size.height);
        add(morale);
        size = supply.getPreferredSize();
        supply.setBounds(inset.left+140, inset.top+9, size.width, size.height);
        add(supply);
        size = tunnel.getPreferredSize();
        tunnel.setBounds(inset.left+8, inset.top+243, size.width, size.height);
        add(tunnel);
        size = supplyCount.getPreferredSize();
        supplyCount.setBounds(inset.left+145, inset.top+242, size.width, size.height);
        add(supplyCount);
    }
    
}
