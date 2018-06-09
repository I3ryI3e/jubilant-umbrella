
package UI.Graphics;


import Model.ObservableGame;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

public abstract  class PiecePanel extends JPanel implements Observer{
    private String type;
    private ObservableGame game;

    public PiecePanel(String type, ObservableGame game) {
        super();
        this.game=game;
        this.type=type;
        this.game.addObserver(this);
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

    @Override
    public abstract void update(Observable o, Object arg);
}
