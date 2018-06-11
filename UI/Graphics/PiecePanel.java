
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
        return ((game.getWeaponPosNum(type)-4)*45);
    }

    protected void setPosition(){
        int posicaoAtual;
        switch(type){
            case LADDER_ICON:
                try {
                    posicaoAtual = getActualPos(LADDER_ICON);
                } catch (MyException ex) {
                    setVisible(false);
                    return;
                }
                if(getInsets().top != posicaoAtual){
                    setBounds(getInsets().left+14, getInsets().top+187+posicaoAtual, getPreferredSize().width, getPreferredSize().height);
                }
                break;
            case BATTERING_RAM_ICON:
                try {
                    posicaoAtual = getActualPos(BATTERING_RAM_ICON);
                } catch (MyException ex) {
                    setVisible(false);
                    return;
                }
                if(getInsets().top != posicaoAtual){
                    setBounds(getInsets().left+82, getInsets().top+187+posicaoAtual, getPreferredSize().width, getPreferredSize().height);
                }
                break;
            case SIEGE_TOWER_ICON:
                try {
                    posicaoAtual = getActualPos(SIEGE_TOWER_ICON);
                } catch (MyException ex) {
                    setVisible(false);
                    return;
                }
                if(getInsets().top != posicaoAtual){
                    setBounds(getInsets().left+150, getInsets().top+187+posicaoAtual, getPreferredSize().width, getPreferredSize().height);
                }
                break;
        }
    }
    @Override
    public abstract void update(Observable o, Object arg);
}
