
package UI.Graphics;

import Model.ObservableGame;
import static UI.Graphics.ConstantsGUI.CARDS_HEIGHT;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.util.Observable;
import java.util.Observer;
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
