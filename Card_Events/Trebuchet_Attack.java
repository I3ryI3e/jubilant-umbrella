package Card_Events;

import Model.Game;

public class Trebuchet_Attack extends Event {
    public Trebuchet_Attack() {
        super("{Trebuchet Attack}\n\t{3 Trebuchet} - 2 Damage to wall\n\t{2 Trebutchet} - 1 Damage to wall\n\t{1 Trebutchet} - 1 Damage to wall on D6 roll of 4,5 or 6");
    }

    @Override
    public void runEvent(Game game) {
        switch(game.getTrebutchet()){
            case 3:
                game.decreaseWall();
                game.decreaseWall();
                break;
            case 2:
                game.decreaseWall();
                break;
            case 1:
                int option = game.throwDice();
                if(option == 4 || option == 5 || option == 6)
                   game.decreaseWall();
                break;
        }
    }
}
