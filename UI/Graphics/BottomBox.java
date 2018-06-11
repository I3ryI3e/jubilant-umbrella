package UI.Graphics;

import Model.ObservableGame;
import Model.Siege_Game;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.Box;
import javax.swing.border.LineBorder;

public class BottomBox extends Box implements ConstantsGUI{
    private ObservableGame game;
    private ButtonPanelBorder buttonPanelBorder;
    private TextAreaPanel textPanel;
    private DicePanel dicePanel;
    
    public BottomBox(int axis, ObservableGame game) {
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
        buttons.setMaximumSize(new Dimension(BUTTONS_SPECIAL_WEIGHT, CARDS_HEIGHT));
        dice.setMaximumSize(new Dimension(CARDS_WIDTH,CARDS_HEIGHT));
        text.setMaximumSize(new Dimension(CARDS_WIDTH,CARDS_HEIGHT));

        add(Box.createRigidArea(new Dimension(MARGIN,0)));
        add(text);
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
        add(buttons);
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
        add(dice);
        add(Box.createRigidArea(new Dimension(MARGIN,0)));
    }
}
