package UI.Graphics;

import Model.Siege_Game;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

class ButtonPanel extends JPanel{
    private Siege_Game game;
    private WaitActionPanel waitActionPanel;
    private WaitDrawCardPanel waitDrawCardPanel;
    private WaitArchersPanel waitArchersPanel;

    public ButtonPanel(Siege_Game game){
        super();
        this.game = game;
        setOpaque(false);
        createObjects();
        orderLayout();
        validate();
    }

    private void createObjects() {
        waitActionPanel= new WaitActionPanel(game);
        waitDrawCardPanel= new WaitDrawCardPanel(game);
        waitArchersPanel= new WaitArchersPanel(game);
    }

    private void orderLayout() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(waitActionPanel);
        add(waitDrawCardPanel);
        add(waitArchersPanel);
    }   
}
