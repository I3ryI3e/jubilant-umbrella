package UI.Graphics;

import Model.ObservableGame;
import java.awt.FlowLayout;
import javax.swing.JPanel;

class ButtonPanel extends JPanel{
    private ObservableGame game;
    private WaitActionPanel waitActionPanel;
    private WaitDrawCardPanel waitDrawCardPanel;
    private WaitArchersPanel waitArchersPanel;
    private WaitBoilingWater waitBoilingWaterPanel;
    private WaitTunnelPanel waitTunnelPanel;
    private WaitCloseCombatPanel waitCloseCombatePanel;
    private WaitBuyActionPanel  waitBuyActionPanel;
    private WaitRallyTroopsPanel waitRallyTroopsPanel;

    public ButtonPanel(ObservableGame game){
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
        waitBoilingWaterPanel= new WaitBoilingWater(game);
        waitTunnelPanel= new WaitTunnelPanel(game);
        waitCloseCombatePanel= new WaitCloseCombatPanel(game);
        waitBuyActionPanel= new WaitBuyActionPanel(game);
        waitRallyTroopsPanel=new WaitRallyTroopsPanel(game);
    }

    private void orderLayout() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(waitActionPanel);
        add(waitDrawCardPanel);
        add(waitArchersPanel);
        add(waitBoilingWaterPanel);
        add(waitTunnelPanel);
        add(waitCloseCombatePanel);
        add(waitBuyActionPanel);
        add(waitRallyTroopsPanel);
    }   
}
