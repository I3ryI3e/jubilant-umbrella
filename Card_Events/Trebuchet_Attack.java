
package Card_Events;

import Model.Event;
import Model.Siege_Game;

public class Trebuchet_Attack extends Event {

    public Trebuchet_Attack() {
        super("Trebuchet Attack\n\t{3 Trebuchet} - 2 Damage to wall;\n\t{2 Trebutchet} - 1 Damage to wall\n\t{1 Trebutchet} - 1 Damage to wall on D6 roll of 4,5 or 6");
    }

    @Override
    public void runEvent(Siege_Game game) {
        switch(game.getGame().getEnemy().getTrebutchet()){
            case 3:
                game.getGame().getPlayer().setWall(game.getGame().getPlayer().getWall()-2);
                break;
            case 2:
                game.getGame().getPlayer().setWall(game.getGame().getPlayer().getWall()-1);
                break;
            case 1:
                int option = (int)(Math.random()*5+1);
                if(option == 4 || option == 5 || option == 6)
                   game.getGame().getPlayer().setWall(game.getGame().getPlayer().getWall()-1);
                break;
        }
    }
    
}
