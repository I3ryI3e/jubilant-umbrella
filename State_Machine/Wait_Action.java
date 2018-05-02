package State_Machine;

import Model.*;

public class Wait_Action extends State_Adapter implements Constants{

    public Wait_Action(Game g){
        super(g);
    }
    @Override
    public States archers() {
        return new Wait_Archers(getGame());
    }

    @Override
    public States Tunnel() {
        return super.Tunnel(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public States Boiling() {
        return super.Boiling(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public States Rally_Troops() {
        return super.Rally_Troops(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public States endTurn() { // TODO check if this is ok!
        if(getGame().getGame_day()!= 2){
            getGame().endTurn();
            return new Wait_Draw_Card(getGame());
        }
        return new Game_Over(getGame());
    }
    

}
