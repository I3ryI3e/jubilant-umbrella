
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

public class EnemyBoardPanel extends JPanel implements ConstantsGUI {
    private WeaponPiecePanel ladder;
    private WeaponPiecePanel batteringRam;
    private WeaponPiecePanel siegeTower;
    private TrebuchetPiecePanel trebuchet;
    private ObservableGame game;
    private final String boardName = ENEMY_BOARD;
    
    public EnemyBoardPanel(ObservableGame game) {
        this.game=game;
        setVisible(true);
        setBorder(new LineBorder(Color.BLACK));
        createObjects();
        orderLayout();
        
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(boardName);
        g.drawImage(imageBoard, 0, 0, CARDS_WIDTH, CARDS_HEIGHT, this);
    }

    
    private void createObjects() {
        ladder= new WeaponPiecePanel(LADDER_ICON, game);
        batteringRam= new WeaponPiecePanel(BATTERING_RAM_ICON,game);
        siegeTower= new WeaponPiecePanel(SIEGE_TOWER_ICON,game);
        trebuchet= new TrebuchetPiecePanel(game);
    }

    private void orderLayout() {
        setLayout(null);
        Insets inset = getInsets();
        Dimension size = ladder.getPreferredSize();
        ladder.setBounds(inset.left+14, inset.top+187, size.width, size.height);
        add(ladder);
        size = batteringRam.getPreferredSize();
        batteringRam.setBounds(inset.left+82, inset.top+187, size.width, size.height);
        add(batteringRam);
        size = siegeTower.getPreferredSize();
        siegeTower.setBounds(inset.left+150, inset.top+187, size.width, size.height);
        add(siegeTower);
        size= trebuchet.getPreferredSize();
        trebuchet.setBounds(inset.left+152, inset.top+244, size.width, size.height);
        add(trebuchet);
    }
}
