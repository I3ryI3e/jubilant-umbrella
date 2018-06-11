
package UI.Graphics;


import Model.MyException;
import Model.ObservableGame;
import static UI.Graphics.ConstantsGUI.BATTERING_RAM_ICON;
import static UI.Graphics.ConstantsGUI.BATTERING_RAM_ICON_CIRCLE;
import static UI.Graphics.ConstantsGUI.LADDER_ICON;
import static UI.Graphics.ConstantsGUI.LADDER_ICON_CIRCLE;
import static UI.Graphics.ConstantsGUI.SIEGE_TOWER_ICON;
import static UI.Graphics.ConstantsGUI.SIEGE_TOWER_ICON_CIRCLE;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public class WeaponPiecePanel extends JPanel implements Observer {
    private String type;
    private ObservableGame game;

    public WeaponPiecePanel(String type, ObservableGame game) {
        this.game=game;
        this.type=type;
        this.game.addObserver(this);
        setOpaque(false);
    }
    
    @Override
    public Dimension getPreferredSize() {
        return new Dimension(30, 30);
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image piece = Images.getImage(type);
        g.drawImage(piece, 0, 0, this);
    }   
    private int getActualPos(String type) throws MyException{
        return 187-(Math.abs(game.getWeaponPosNum(type)-4)*45);
    }

    protected void setPosition(){
        int newPositionOnScreen;
        int positionOnList=-1;
        switch(type){
            case LADDER_ICON: 
            case LADDER_ICON_CIRCLE:
                try {
                    positionOnList= game.getWeaponPosNum(LADDER_ICON);
                } catch (MyException ex) {}
                try {
                    newPositionOnScreen = getActualPos(LADDER_ICON);
                } catch (MyException ex) {
                    setVisible(false);
                    return;
                }
                if(positionOnList==1){
                    type=LADDER_ICON_CIRCLE;
                }
                else{
                    type=LADDER_ICON;
                }
                if(positionOnList==0){
                    setBounds(65, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                }else{
                    setBounds(14, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                }  
                break;
            case BATTERING_RAM_ICON: 
            case BATTERING_RAM_ICON_CIRCLE:
                try {
                    positionOnList= game.getWeaponPosNum(BATTERING_RAM_ICON);
                } catch (MyException ex) {}
                try {
                    newPositionOnScreen = getActualPos(BATTERING_RAM_ICON);
                } catch (MyException ex) {
                    setVisible(false);
                    return;
                }
                if(positionOnList==1){
                    type=BATTERING_RAM_ICON_CIRCLE;
                }else{
                    type=BATTERING_RAM_ICON;
                }
                setBounds(82, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                break;
            case SIEGE_TOWER_ICON:
            case SIEGE_TOWER_ICON_CIRCLE:
                try {
                    positionOnList= game.getWeaponPosNum(SIEGE_TOWER_ICON);
                } catch (MyException ex) {}
                try {
                    newPositionOnScreen = getActualPos(SIEGE_TOWER_ICON);
                } catch (MyException ex) {
                    setVisible(false);
                    return;
                }
                if(positionOnList==0){
                    setBounds(100, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                }else{
                    setBounds(150, newPositionOnScreen, getPreferredSize().width, getPreferredSize().height);
                }
                if(positionOnList==1){
                    type=SIEGE_TOWER_ICON_CIRCLE;
                }else{
                    type=SIEGE_TOWER_ICON;
                }
                break;
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        setPosition();
    }    
}
