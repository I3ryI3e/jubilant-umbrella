
package UI.Graphics;

import Model.ObservableGame;
import Model.Siege_Game;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class EnemyBoardPanel extends BoardPanel {
    private PiecePanel ladder;
    private PiecePanel batteringRam;
    private PiecePanel siegeTower;
    private PiecePanel trebuchet;
    
    public EnemyBoardPanel(ObservableGame game) {
        super(game, ENEMY_BOARD);
        createObjects();
        orderLayout();
        
    }

    private void createObjects() {
        ladder= new PiecePanel(LADDER_ICON);
        batteringRam= new PiecePanel(LADDER_ICON);
        siegeTower= new PiecePanel(LADDER_ICON);
        trebuchet= new PiecePanel(LADDER_ICON);
    }

    private void orderLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        con.weightx=0.5;
        con.gridx=0;
        con.gridy=3;
        add(ladder,con);
        con.weightx=0.5;
        con.gridx=1;
        con.gridy=3;
        add(batteringRam,con);
        con.weightx=0.5;
        con.gridx=2;
        con.gridy=3;
        add(siegeTower,con);
        con.gridx=3;
        con.gridy=4;
        add(trebuchet,con);
    }
    
}
