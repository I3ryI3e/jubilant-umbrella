
package UI.Graphics;

import Model.Siege_Game;
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
        Box player = Box.createVerticalBox();
        Box enemy= Box.createVerticalBox();
        Box deck = Box.createVerticalBox();
        Box discard = Box.createVerticalBox();
        
        player.add(playerPanel);
        enemy.add(enemyPanel);
        deck.add(deckPanel);
        discard.add(discardPanel);
        
        add(Box.createHorizontalStrut(10));
        add(player);
        add(Box.createHorizontalStrut(10));
        add(discard);
        add(Box.createHorizontalStrut(10));
        add(deck);
        add(Box.createHorizontalStrut(10));
        add(enemy);
        add(Box.createHorizontalStrut(10));
    }
    
}
