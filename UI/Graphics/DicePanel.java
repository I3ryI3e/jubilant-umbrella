package UI.Graphics;

import Model.ObservableGame;
import State_Machine.Initial_State;
import static UI.Graphics.ConstantsGUI.DICE1;
import static UI.Graphics.ConstantsGUI.DICE2;
import static UI.Graphics.ConstantsGUI.DICE3;
import static UI.Graphics.ConstantsGUI.DICE4;
import static UI.Graphics.ConstantsGUI.DICE5;
import static UI.Graphics.ConstantsGUI.DICE6;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;
import javax.swing.Timer;

class DicePanel extends JPanel implements Observer, ConstantsGUI{
    private ObservableGame game;
    private String type;
    private ActionLabelPanel actionLabel;
    private Timer timer;
    
    public DicePanel(ObservableGame game){
        super();
        this.game = game;
        type= null;
        timer=new Timer(10, new TesteListener(this));
        game.addObserver(this);
        actionLabel= new ActionLabelPanel(game);
        setLayout(new BorderLayout());
        add(actionLabel,BorderLayout.NORTH);
        setVisible(true);
        setOpaque(false);
        update(game, null);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image imageBoard = Images.getImage(type);
        g.drawImage(imageBoard, 25, 50, this);
    }

    
    
    @Override
    public void update(Observable o, Object o1) {
        if(!(game.getState() instanceof Initial_State)){
            if(game.diceWasRolled())
                timer.start();
        }
    }
    public String getStringDiceName(int num){
        switch(num){
                case 1:
                    return DICE1;
                case 2:
                    return DICE2;
                case 3:
                    return DICE3;
                case 4:
                    return DICE4;
                case 5:
                    return DICE5;
                case 6:
                    return DICE6;           
            }
        return null;
    }

    class TesteListener implements ActionListener{
        private int countdown;
        private boolean on;
        private DicePanel panel;

        public TesteListener(DicePanel panel) {
            this.panel=panel;
            this.countdown=50;
            this.on=false;
        }
        public String getStringDiceName(int num){
        switch(num){
                case 1:
                    return DICE1;
                case 2:
                    return DICE2;
                case 3:
                    return DICE3;
                case 4:
                    return DICE4;
                case 5:
                    return DICE5;
                case 6:
                    return DICE6;           
            }
        return null;
    }
        

        @Override
        public void actionPerformed(ActionEvent e) {
            if(countdown==0 && on){
                type = getStringDiceName(game.getDiceResult());
                on=false;
                countdown=50;
                timer.stop();
                panel.repaint();
            }else if(on){
                countdown--;
                type= getStringDiceName((int)(Math.random()*6)+1);
                panel.repaint();
            }else{
                on=true;
            }
        }
        
    }
        
}
