package UI.Graphics;

import Model.ObservableGame;
import static UI.Graphics.ConstantsGUI.CARDS_HEIGHT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import static UI.Graphics.ConstantsGUI.CARDS_WIDTH;

public class PlayerBoardPanel extends JPanel implements ConstantsGUI{
    private PlayerPiecePanel wall;
    private PlayerPiecePanel morale;
    private PlayerPiecePanel supply;
    private TunnelPiecePanel tunnel;
    private RSupplyPiecePanel supplyCount;
    private final String boardName = PLAYER_BOARD;
    private ObservableGame game;
    
    public PlayerBoardPanel(ObservableGame game) {
        this.game=game;
        setVisible(true);
        setBorder(new LineBorder(Color.BLACK));
        createObject();
        orderLayout();
    }

    private void createObject() {
        wall = new PlayerPiecePanel(WALL_ICON, game);
        morale= new PlayerPiecePanel(MORALE_ICON,game);
        supply= new PlayerPiecePanel(SUPPLY_ICON,game);
        tunnel= new TunnelPiecePanel(game);
        supplyCount= new RSupplyPiecePanel(game);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(boardName);
        g.drawImage(imageBoard, 0, 0, CARDS_WIDTH, CARDS_HEIGHT, this);
    }

    private void orderLayout() {
        setLayout(null);
        Insets inset = getInsets();
        Dimension size = wall.getPreferredSize();
        wall.setBounds(inset.left+PLAYER_X_START_WALL, inset.top+PLAYER_Y_START_POSITION, size.width, size.height);
        add(wall);
        size = morale.getPreferredSize();
        morale.setBounds(inset.left+PLAYER_X_START_MORALE, inset.top+PLAYER_Y_START_POSITION, size.width, size.height);
        add(morale);
        size = supply.getPreferredSize();
        supply.setBounds(inset.left+PLAYER_X_START_SUPPLY, inset.top+PLAYER_Y_START_POSITION, size.width, size.height);
        add(supply);
        size = tunnel.getPreferredSize();
        tunnel.setBounds(inset.left+PLAYER_X_START_TUNNEL, inset.top+PLAYER_Y_START_TUNNEL, size.width, size.height);
        add(tunnel);
        size = supplyCount.getPreferredSize();
        supplyCount.setBounds(inset.left+PLAYER_X_START_RSUPPLIES, inset.top+PLAYER_Y_START_RSUPPLIES, size.width, size.height);
        add(supplyCount);
    }

    
}
