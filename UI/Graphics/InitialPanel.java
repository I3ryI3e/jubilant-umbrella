package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Initial_State;
import State_Machine.States;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class InitialPanel extends JPanel implements Observer, ConstantsGUI{
    private ObservableGame game;
    private JButton newGame;
    private JButton loadGame;
    private JButton saveGame;
    private JButton quit;
    
    public InitialPanel(ObservableGame game) {
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
        loadGame=new JButton("Load Game");
        saveGame= new JButton("Save Game");
        quit=new JButton("Quit Game");
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
        Image imageBoard = Images.getImage(BACKGROUND);
        g.drawImage(imageBoard, 0, 0, getParent().getWidth(),getParent().getHeight(), this);
    }
    
    private void registerListeners() {
        newGame.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                game.setup();
            }
        });
        loadGame.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JFileChooser fileChooser = new JFileChooser();
//                FileNameExtensionFilter filter = new FileNameExtensionFilter("Game file only", "g");
//                fileChooser.setFileFilter(filter);
                int n = fileChooser.showOpenDialog(InitialPanel.this);
                if(n == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    game.loadGame(file);
                }
            }      
        });
        saveGame.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                JFileChooser fileChooser = new JFileChooser();
//                FileNameExtensionFilter filter = new FileNameExtensionFilter("Game file only", "g");
//                fileChooser.setFileFilter(filter);
                int n = fileChooser.showSaveDialog(InitialPanel.this);
                if(n == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    boolean saved = game.saveGame(file);
                }
            }
        });
        quit.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if((JOptionPane.showConfirmDialog(InitialPanel.this, "Exit?", "Warning", JOptionPane.YES_NO_OPTION))== 0){
                    System.exit(0);
                }
            }
        });
    }   

    @Override
    public void update(Observable o, Object arg) {
       States state=game.getState();
       if(state instanceof Initial_State){
           setVisible(true);
       }else
           setVisible(false);
    }
}
