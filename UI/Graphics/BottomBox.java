package UI.Graphics;

import Model.Siege_Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class BottomBox extends Box {
    private Siege_Game game;
    private ButtonPanelBorder buttonPanelBorder;
    private TextAreaPanel textPanel;
    private DicePanel dicePanel;
    
    public BottomBox(int axis, Siege_Game game) {
        super(axis);
        this.game=game;
        setVisible(true);
        createObjects();
        setObjLayout();
    }

    private void createObjects() {

        buttonPanelBorder = new ButtonPanelBorder(game);
        textPanel = new TextAreaPanel(game);
        dicePanel = new DicePanel(game);
    }
    

    private void setObjLayout() {
        Box dice = Box.createVerticalBox();
        Box text= Box.createVerticalBox();
        Box buttons= Box.createVerticalBox();
        
        buttons.add(buttonPanelBorder);
        text.add(textPanel);
        dice.add(dicePanel);
        buttons.setMaximumSize(new Dimension(420, 260));
        dice.setMaximumSize(new Dimension(205,260));
        text.setMaximumSize(new Dimension(205,260));

        add(Box.createHorizontalStrut(10));
        add(text);
        add(Box.createHorizontalStrut(10));
        add(buttons);
        add(Box.createHorizontalStrut(10));
        add(dice);
        add(Box.createHorizontalStrut(10));
    }
}
