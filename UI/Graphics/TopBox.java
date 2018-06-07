package UI.Graphics;

import Model.Siege_Game;
import java.awt.Dimension;
import javax.swing.Box;

public class TopBox extends Box {
    private Siege_Game game;
    private DeckPanel deckPanel;
    private DiscardPanel discardPanel;
    private EnemyBoardPanel enemyPanel;
    private PlayerBoardPanel playerPanel;
    
    public TopBox(int axis, Siege_Game game) {
        super(axis);
        this.game=game;
        setVisible(true);
        createObjs();
        setObjLayout();
    }

    private void createObjs() {
        deckPanel= new DeckPanel(game);
        discardPanel= new DiscardPanel(game);
        enemyPanel= new EnemyBoardPanel(game);
        playerPanel= new PlayerBoardPanel(game);
    }

    private void setObjLayout() {
        setMaximumSize(new Dimension(870,260));
        Box player = Box.createVerticalBox();
        Box enemy= Box.createVerticalBox();
        Box deck = Box.createVerticalBox();
        Box discard = Box.createVerticalBox();
        
        player.add(playerPanel);
        enemy.add(enemyPanel);
        deck.add(deckPanel);
        discard.add(discardPanel);
        
        add(Box.createRigidArea(new Dimension(10,0)));
        add(player);
        add(Box.createRigidArea(new Dimension(10,0)));
        add(discard);
        add(Box.createRigidArea(new Dimension(10,0)));
        add(deck);
        add(Box.createRigidArea(new Dimension(10,0)));
        add(enemy);
        add(Box.createRigidArea(new Dimension(10,0)));
    }
}
