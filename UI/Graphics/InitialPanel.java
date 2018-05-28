
package UI.Graphics;

import Model.Siege_Game;
import State_Machine.Initial_State;
import State_Machine.States;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;

public class InitialPanel extends JPanel implements Observer, ConstantsGUI{
    private Siege_Game game;
    private JButton newGame;
    private JButton loadGame;
    private JButton saveGame;
    private JButton quit;
    

    public InitialPanel(Siege_Game game) {
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
        //newGame.setSize(25, 25);
        loadGame=new JButton("Load Game");
        //loadGame.setSize(25, 25);
        saveGame= new JButton("Save Game");
        //saveGame.setSize(25, 25);
        quit=new JButton("Quit Game");
        //quit.setSize(25, 25);
        
    }

    private void addGraphicsObjects() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        add(newGame, gbc);
        add(loadGame, gbc);
        add(saveGame, gbc);
        add(quit, gbc);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image teste = Images.getImage(BACKGROUND);
        g.drawImage(teste, 0, 0, this);
    }
    

    private void registerListeners() {
        newGame.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                game.setup();
            }
        });
//        loadGame.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e); 
//            }      
//});
//        saveGame.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//            }
//        });
//        quit.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mousePressed(MouseEvent e) {
//                super.mousePressed(e);
//            }
//        });
    }   

    @Override
    public void update(Observable o, Object arg) {
       States state=game.getState();
       if(state instanceof Initial_State)
           setVisible(true);
       else
           setVisible(false);
    }
}
