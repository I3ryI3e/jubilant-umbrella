package UI.Graphics;

import Model.Siege_Game;
import javax.swing.Box;

public class BottomBox extends Box {
    private Siege_Game game;
    private ButtonPanel buttonPanel;
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

        buttonPanel = new ButtonPanel(game);
        textPanel = new TextAreaPanel(game);
        dicePanel = new DicePanel(game);
    }

    private void setObjLayout() {
        Box dice = Box.createVerticalBox();
        Box text= Box.createVerticalBox();
        Box buttons= Box.createVerticalBox();
        
        buttons.add(buttonPanel);
        text.add(textPanel);
        dice.add(dicePanel);

        add(Box.createHorizontalStrut(10));
        add(text);
        add(Box.createHorizontalStrut(10));
        add(buttons);
        add(Box.createHorizontalStrut(10));
        add(dice);
        add(Box.createHorizontalStrut(10));
    }
}
