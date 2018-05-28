
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameNineCardSiege extends JFrame implements Observer, ConstantsGUI{
    private Siege_Game game;
    private Container cp;
    private CardLayout cardManager;
    private JPanel cards;
    private InitialPanel initialpanel;
    private DrawCardBoard drawCardPanel;
    private boolean quit=false;

    public FrameNineCardSiege(Siege_Game game){
        this(game,560,150,560,400);
    }
    public FrameNineCardSiege(Siege_Game game, int x, int y, int largura, int altura){
        super("9 Card Siege Game");
        this.game=game;
        game.addObserver(this);
        
        cp = getContentPane(); // obtem o contentor desta frame

        criarObjGraf(); // cria os objectos graficos 
        disporVista();  // faz a montagem visual dos objectos graficos
        //registarListeners(); // liga os objectos graficos aos respectivos listeners

        setLocation(x, y);
        setSize(largura, altura);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validate();
        update(game,null);
    }

    private void criarObjGraf() {
        initialpanel= new InitialPanel(game);
        cardManager = new CardLayout();
        cards= new JPanel();
        drawCardPanel= new DrawCardBoard(game);
    }

//    private void registarListeners() {
//        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    private void disporVista() {
        cp.add(cards,BorderLayout.CENTER);
        cards.setLayout(cardManager);
        cards.add(initialpanel,INITIAL_PANEL);
        cards.add(drawCardPanel,DRAW_CARD_PANEL);
        
    }
    @Override
    public void update(Observable o, Object arg) {
        
        
        States state = game.getState();
        
        if(state instanceof Initial_State){
            cardManager.show(cards, INITIAL_PANEL);
        }else if(state instanceof Wait_Draw_Card){
            setSize(850, 600);
            cardManager.show(cards, DRAW_CARD_PANEL);
        }
    }
    
}
