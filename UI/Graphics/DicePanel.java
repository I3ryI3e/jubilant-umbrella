package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Initial_State;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class DicePanel extends JPanel implements Observer, ConstantsGUI{
    private ObservableGame game;
    private String type;
    
    public DicePanel(ObservableGame game){
        super();
        this.game = game;
        type= null;
        game.addObserver(this);
        setVisible(true);
        setOpaque(false);
//        setBorder(new LineBorder(Color.BLACK));
        update(game, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(type);
        g.drawImage(imageBoard, 50, 50, this);
    }

    
    
    @Override
    public void update(Observable o, Object o1) {
        if(!(game.getState() instanceof Initial_State)){
            switch(game.getDiceResult()){
                case 1:
                    type= DICE1;
                    break;
                case 2:
                    type= DICE2;
                    break;
                case 3:
                    type= DICE3;
                    break;
                case 4:
                    type= DICE4;
                    break;
                case 5:
                    type= DICE5;
                    break;
                case 6:
                    type= DICE6;           
            }
            repaint();
        }
    }
}
