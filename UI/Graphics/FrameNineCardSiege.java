
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.Initial_State;
import State_Machine.States;
import State_Machine.Wait_Draw_Card;
import java.awt.Container;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;

public class FrameNineCardSiege extends JFrame implements Observer {
    private Siege_Game game;
    private Container cp;
    private InitialPanel initialpanel;
    private boolean quit=false;

    public FrameNineCardSiege(Siege_Game game){
        this(game,560,150,800,800);
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
    }

//    private void registarListeners() {
//        //TODO
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    private void disporVista() {
        cp.add(initialpanel);
    }
    @Override
    public void update(Observable o, Object arg) {
//        States state = game.getState();
//        
//        if(state instanceof Initial_State){
//            initialpanel.setVisible(true);
//        }else if(state instanceof Wait_Draw_Card){
//            initialpanel.setVisible(false);
//        }
    }
    
}
