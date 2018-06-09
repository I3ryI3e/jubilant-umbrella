
package UI.Graphics;

import Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Insets;

public class EnemyBoardPanel extends BoardPanel {
    private WeaponPiecePanel ladder;
    private WeaponPiecePanel batteringRam;
    private WeaponPiecePanel siegeTower;
    private WeaponPiecePanel trebuchet;
    
    public EnemyBoardPanel(ObservableGame game) {
        super(game, ENEMY_BOARD);
        createObjects();
        orderLayout();
        
    }

    private void createObjects() {
        ladder= new WeaponPiecePanel(LADDER_ICON, game);
        batteringRam= new WeaponPiecePanel(BATTERING_RAM_ICON,game);
        siegeTower= new WeaponPiecePanel(SIEGE_TOWER_ICON,game);
        trebuchet= new WeaponPiecePanel(RED_SQUARE_ICON, game);
    }

    private void orderLayout() {
//        setLayout(new GridBagLayout());
//        GridBagConstraints con = new GridBagConstraints();
//        con.weightx=0.5;
//        con.gridx=0;
//        con.gridy=3;
//        add(ladder,con);
//        con.weightx=0.5;
//        con.gridx=1;
//        con.gridy=3;
//        add(batteringRam,con);
//        con.weightx=0.5;
//        con.gridx=2;
//        con.gridy=3;
//        add(siegeTower,con);
//        con.gridx=3;
//        con.gridy=4;
//        add(trebuchet,con);
        setLayout(null);
        Insets inset = getInsets();
        Dimension size = ladder.getPreferredSize();
        ladder.setBounds(inset.left+14, inset.top+187, size.width, size.height);
        add(ladder);
        size = batteringRam.getPreferredSize();
        batteringRam.setBounds(inset.left+82, inset.top+187, size.width, size.height);
        add(batteringRam);
        size = siegeTower.getPreferredSize();
        siegeTower.setBounds(inset.left+149, inset.top+187, size.width, size.height);
        add(siegeTower);
        size= trebuchet.getPreferredSize();
        trebuchet.setBounds(inset.left+149, inset.top+241, size.width, size.height);
        add(trebuchet);
    }
    
}
