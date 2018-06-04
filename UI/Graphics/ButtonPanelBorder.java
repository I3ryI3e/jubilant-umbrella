
package UI.Graphics;

import Model.Siege_Game;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ButtonPanelBorder extends JPanel {
    private Siege_Game game;
    private ButtonPanel buttonPanel;

    public ButtonPanelBorder(Siege_Game game) {
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
