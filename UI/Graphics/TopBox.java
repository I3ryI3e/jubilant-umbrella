package UI.Graphics;

import Model.ObservableGame;
import java.awt.Dimension;
import javax.swing.Box;

public class TopBox extends Box implements ConstantsGUI{
    private ObservableGame game;
    private DeckPanel deckPanel;
    private DiscardPanel discardPanel;
    private EnemyBoardPanel enemyPanel;
    private PlayerBoardPanel playerPanel;
    
    public TopBox(int axis, ObservableGame game) {
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
        player.setMaximumSize(new Dimension(CARDS_WIDTH,CARDS_HEIGHT));
        enemy.setMaximumSize(new Dimension(CARDS_WIDTH,CARDS_HEIGHT));
        deck.setMaximumSize(new Dimension(CARDS_WIDTH,CARDS_HEIGHT));
        discard.setMaximumSize(new Dimension(CARDS_WIDTH,CARDS_HEIGHT));
        
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
        add(player);
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
        add(discard);
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
        add(deck);
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
        add(enemy);
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
    }
}
