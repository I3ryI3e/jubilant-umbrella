
package UI.Graphics;


import Model.MyException;
import Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

public abstract  class PiecePanel extends JPanel implements Observer, ConstantsGUI{
    private String type;
    private ObservableGame game;

    public PiecePanel(String type, ObservableGame game) {
        super();
        this.game=game;
        this.type=type;
        this.game.addObserver(this);
        setOpaque(false);
    }
    public String getType(){
        return type;
    }
    public ObservableGame getGame(){
        return game;
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
    public abstract void update(Observable o, Object arg);
}
