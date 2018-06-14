
package UI.Graphics;

import Model.ObservableGame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

public class ButtonPanelBorder extends JPanel {
    private ObservableGame game;
    private ButtonPanel buttonPanel;

    public ButtonPanelBorder(ObservableGame game) {
        super();
        this.game = game;
        setVisible(true);
        setOpaque(false);
        createObjects();
        orderLayout();
    }

    private void createObjects() {
        buttonPanel= new ButtonPanel(game);
    }

    private void orderLayout() {
        
        setLayout(new BorderLayout());
        add(buttonPanel,BorderLayout.SOUTH);
    }
    
    
    
}
