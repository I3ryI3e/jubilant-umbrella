
package UI.Graphics;

import Model.ObservableGame;
import Model.Siege_Game;
import State_Machine.States;
import State_Machine.Wait_Draw_Card;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class WaitDrawCardPanel extends JPanel implements Observer {
    private ObservableGame game;
    private JButton drawCardButton;

    public WaitDrawCardPanel(ObservableGame game) {
        super();
        this.game = game;
        game.addObserver(this);
        setVisible(false);
        createObjects();
        orderLayout();
        registerListeners();
        
    }
    
    private void createObjects() {
        drawCardButton= new JButton("Draw Card");
    }

    private void orderLayout() {
        setLayout(new BorderLayout());
        add(drawCardButton, BorderLayout.CENTER);
    }
    private void registerListeners() {
        drawCardButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.drawCard();
            }
        });
    }

    @Override
    public void update(Observable o, Object arg) {
        States state= game.getState();
        if(state instanceof Wait_Draw_Card)
            setVisible(true);
        else 
            setVisible(false);
    }

  
}
