package Model;

import java.util.List;



public class Game {
    private final Player player;
    private final Enemy enemy;
    private List<Card> deck;
    private List<Card> discard;

    public Game(){
        this.player= new Player();
        this.enemy= new Enemy();
    }

    public Player getPlayer() {
        return player;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}