
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Draw_Card;
import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class DrawCardBoard extends JPanel implements Observer, ConstantsGUI {
    private Siege_Game game;
    private CardsPanel cardsPanel;
    private JPanel buttonsPanel;
    private CardsPanel discardPanel;
    private EnemyBoardPanel enemyPanel;
    private PlayerBoardPanel playerPanel;

    public DrawCardBoard(Siege_Game game) {
        super();
        this.game=game;
        game.addObserver(this);
        setVisible(false);
        createGraphicsObjects();
        addGraphicsObjects();
        registerListeners();
        update(game,null);
    }
    
    private void createGraphicsObjects() {
        
        cardsPanel= new CardsPanel(game,DISCARD);
        buttonsPanel= new JPanel();
        discardPanel= new CardsPanel(game,CARD_BACK);
        enemyPanel= new EnemyBoardPanel(game);
        playerPanel= new PlayerBoardPanel(game);
    }

    private void addGraphicsObjects() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        Box firstHorizontal = Box.createHorizontalBox();
        Box secondHorizontal = Box.createHorizontalBox();
        Box player = Box.createVerticalBox();
        Box enemy= Box.createVerticalBox();
        Box cards = Box.createVerticalBox();
        Box discard = Box.createVerticalBox();
        Box dado = Box.createVerticalBox();
        Box text= Box.createVerticalBox();
        Box buttons= Box.createVerticalBox();
        player.add(playerPanel);
        enemy.add(enemyPanel);
        cards.add(cardsPanel);
        buttons.add(buttonsPanel);
        discard.add(discardPanel);
        
        firstHorizontal.add(Box.createHorizontalStrut(10));
        firstHorizontal.add(player);
        firstHorizontal.add(Box.createHorizontalStrut(10));
        firstHorizontal.add(cards);
        firstHorizontal.add(Box.createHorizontalStrut(10));
        firstHorizontal.add(discard);
        firstHorizontal.add(Box.createHorizontalStrut(10));
        firstHorizontal.add(enemy);
        firstHorizontal.add(Box.createHorizontalStrut(10));
        
        secondHorizontal.add(dado);
        secondHorizontal.add(Box.createHorizontalStrut(15));
        secondHorizontal.add(buttons);
        secondHorizontal.add(Box.createHorizontalStrut(15));
        secondHorizontal.add(text);
        secondHorizontal.add(Box.createHorizontalStrut(15));
        add(firstHorizontal);
        add(secondHorizontal);
        buttonsPanel.add(new JButton("Draw Card"));
    }

    private void registerListeners() {
//        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    

    @Override
    public void update(Observable o, Object arg) {
        States state= game.getState();
        if( state instanceof Wait_Draw_Card){
            setVisible(true);
            cardsPanel.setVisible(true);
            buttonsPanel.setVisible(true);
            enemyPanel.setVisible(true);
            playerPanel.setVisible(true);
            discardPanel.setVisible(true);
        }
    }

 
}
