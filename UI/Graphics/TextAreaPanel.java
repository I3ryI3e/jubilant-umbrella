package UI.Graphics;

import Model.ObservableGame;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

class TextAreaPanel extends JTextPane implements Observer{
    private ObservableGame game;
    
    public TextAreaPanel(ObservableGame game){
        super();
        this.game = game;
        game.addObserver(this);
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
