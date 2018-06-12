package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Game_Over;
import State_Machine.States;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class LossPanel extends JPanel implements Observer, ConstantsGUI{
    private ObservableGame game;
    private JButton newGame;
    private JButton quit;

    public LossPanel(ObservableGame game) {
        super();
        this.game=game;
        game.addObserver(this);
        setVisible(false);
        createGraphicsObjects();
        addGraphicsObjects();
        registerListeners();
        update(game,null);
    }
    
    private void createGraphicsObjects() {
        newGame= new JButton("New Game");
        quit=new JButton("Quit Game");
    }

    private void addGraphicsObjects() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(newGame, gbc);
        add(quit, gbc);
    }
    private void registerListeners() {
        newGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                game.returnInitialState();
            }
        });
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if((JOptionPane.showConfirmDialog(LossPanel.this, "Exit?", "Warning", JOptionPane.YES_NO_OPTION))== 0){
                    System.exit(0);
                }
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(LOSS_ICON);
        g.drawImage(imageBoard, 0, 0, getParent().getWidth(),getParent().getHeight(), this);
    }
    
    
    @Override
    public void update(Observable o, Object o1) {
       States state=game.getState();
       if(state instanceof Game_Over){
           setVisible(true);
       }else
           setVisible(false);
    }

    
}