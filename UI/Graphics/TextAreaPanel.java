package UI.Graphics;

import Model.ObservableGame;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextPane;

class TextAreaPanel extends JTextPane implements Observer,ConstantsGUI{
    private ObservableGame game;
    
    public TextAreaPanel(ObservableGame game){
        super();
        this.game = game;
        game.addObserver(this);
        setMaximumSize(new Dimension(CARDS_WIDTH,CARDS_HEIGHT));
        setBackground(Color.GRAY);
        setEditable(false);
        setVisible(true);
        update(game, null);
    }

    @Override
    public void update(Observable o, Object o1) {
        setText(game.getText());
    }
}
