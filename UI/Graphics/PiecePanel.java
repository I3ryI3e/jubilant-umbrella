
package UI.Graphics;


import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class PiecePanel extends JPanel{
    private String type;

    public PiecePanel(String type) {
        super();
        this.type=type;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(34, 34);
    }

   

    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image piece = Images.getImage(type);
        g.drawImage(piece, 0, 0, this);
    }    
}
