package UI.Graphics;

import Model.ObservableGame;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WinPanel extends JPanel implements Observer, ConstantsGUI{
    private ObservableGame game;
    private JButton newGame;
    private JButton quit;

    public WinPanel(ObservableGame game) {
        super();
        this.game=game;
        game.addObserver(this);
        setVisible(false);
//        createGraphicsObjects();
//        addGraphicsObjects();
//        registerListeners();
        update(game,null);
    }
    
    @Override
    public void update(Observable o, Object o1) {
        //TODO
    }
}
