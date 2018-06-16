package UI.Graphics;

import Model.ObservableGame;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ActionLabelPanel extends JPanel implements Observer {
    private JLabel actions;
    private ObservableGame game;

    public ActionLabelPanel(ObservableGame game) {
        this.game = game;
        this.game.addObserver(this);
        actions= new JLabel("Number of actions left: 0");
        actions.setForeground(Color.BLACK);
        add(actions);
        setBackground(Color.GRAY);
    }

    @Override
    public void update(Observable o, Object arg) {
        actions.setText("Number of actions left: " + game.getNumberOfActions() + " Turn " + (7-game.getNumberOfCardsInDeck()));
    }
}
