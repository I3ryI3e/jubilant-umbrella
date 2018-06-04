package UI.Graphics;

import Model.Siege_Game;
import State_Machine.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

public class FrameNineCardSiege extends JFrame implements Observer, ConstantsGUI{
    private Siege_Game game;
    private Container cp;
    private CardLayout cardManager;
    private JPanel cards;
    private InitialPanel initialpanel;
    private MainGameBoard mainGamePanel;
    private JPanel winnerPanel; //TODO
    private JPanel gameOverPanel; //TODO
    private boolean quit=false;

    public FrameNineCardSiege(Siege_Game game){
        this(game,560,150,870,600);
    }
    
    public FrameNineCardSiege(Siege_Game game, int x, int y, int largura, int altura){
        super("9 Card Siege Game");
        this.game=game;
        game.addObserver(this);
        
        cp = getContentPane(); // obtem o contentor desta frame

        createGraphicsObjects(); // cria os objectos graficos 
        addGraphicsObjects();  // faz a montagem visual dos objectos graficos

        addMenu();
        
        setLocation(x, y);
        setSize(largura, altura);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setMinimumSize(new Dimension(870, 592));
        validate();
        update(game,null);
    }

    private void createGraphicsObjects() {
        initialpanel= new InitialPanel(game);
        cardManager = new CardLayout();
        cards= new JPanel();
        mainGamePanel= new MainGameBoard(game);
    }


    private void addGraphicsObjects() {
        cp.add(cards,BorderLayout.CENTER);
        cards.setLayout(cardManager);
        cards.add(initialpanel,INITIAL_PANEL);
        cards.add(mainGamePanel,DRAW_CARD_PANEL);
    }
    
    private void addMenu() {
        JMenu menu1 = new JMenu("File");
        
        JMenuItem menuitem1a = new JMenuItem("New");
        menuitem1a.setMnemonic(KeyEvent.VK_N);
        menuitem1a.setToolTipText("Start a new game");
        menuitem1a.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        menuitem1a.setIcon(new ImageIcon(Images.getImage(NEW)));
        menuitem1a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                game.setup();
            }
        });
        
        JMenuItem menuitem1b = new JMenuItem("Load");
        menuitem1b.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_L, ActionEvent.CTRL_MASK));
        menuitem1b.setIcon(new ImageIcon(Images.getImage(LOAD)));
        menuitem1b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                int n = fileChooser.showOpenDialog(FrameNineCardSiege.this);
                if(n == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
//                    boolean loaded = game.loadGame(file);
                }
            }
        });
        
        JMenuItem menuitem1c = new JMenuItem("Save");
        menuitem1c.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        menuitem1c.setIcon(new ImageIcon(Images.getImage(SAVE)));
        menuitem1c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JFileChooser fileChooser = new JFileChooser();
                int n = fileChooser.showSaveDialog(FrameNineCardSiege.this);
                if(n == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
//                    boolean saved = game.saveGame(file);
                }
            }
        });
        
        JMenuItem menuExit = new JMenuItem("Exit");
        menuExit.setIcon(new ImageIcon(Images.getImage(REDCROSS)));
        menuExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if((JOptionPane.showConfirmDialog(FrameNineCardSiege.this, "Exit?", "Warning", JOptionPane.YES_NO_OPTION)) == 0){
                    game.quit();
                    System.exit(0);
                }
            }
        });
        
        menu1.add(menuitem1a);
        menu1.add(menuitem1b);
        menu1.add(menuitem1c);
        menu1.addSeparator();
        menu1.add(menuExit);
        
        JMenu menu2 = new JMenu("Options");
        
        JMenuItem menuitem2a = new JMenuItem("Preferences");
        menuitem2a.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        menuitem2a.setIcon(new ImageIcon(Images.getImage(OPTIONS)));
        menuitem2a.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                //TODO  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        JMenuItem menuitem2b = new JMenuItem("Instructions");
        menuitem2b.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
        menuitem2b.setIcon(new ImageIcon(Images.getImage(INFO2)));
        menuitem2b.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(FrameNineCardSiege.this, "Insert Instructions here", "Instructions", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JMenuItem menuitem2c = new JMenuItem("About");
        menuitem2c.setIcon(new ImageIcon(Images.getImage(INFO)));
        menuitem2c.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                JOptionPane.showMessageDialog(FrameNineCardSiege.this, "Nice work Francisco Fialho and Jorge Grunho!!", "About", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        menu2.add(menuitem2a);
        menu2.add(menuitem2b);
        menu2.add(menuitem2c);
        
        JMenuBar menubar = new JMenuBar();
        menubar.add(menu1);
        menubar.add(menu2);
        this.setJMenuBar(menubar);
    }
        
    @Override
    public void update(Observable o, Object arg) {

        States state = game.getState();
        
        if(state instanceof Initial_State){
            cardManager.show(cards, INITIAL_PANEL);
        }else if(state instanceof Wait_Draw_Card){
            setSize(870, 592);
            cardManager.show(cards, DRAW_CARD_PANEL);
        }
    }
}
