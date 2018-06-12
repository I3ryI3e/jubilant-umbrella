package UI.Graphics;

import Model.ObservableGame;
import java.awt.Dimension;
import javax.swing.Box;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

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
        text.add(new JScrollPane(textPanel));
        dice.add(dicePanel);
        buttons.setMaximumSize(new Dimension(BUTTONS_SPECIAL_WITDH, CARDS_HEIGHT));
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
