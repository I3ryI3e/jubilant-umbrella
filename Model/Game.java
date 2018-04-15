package Model;

import java.util.List;



public class Game {
    private Player player;
    private Enemy enemy;
    private List<Card> deck;
    private List<Card> discard;

    public Game(){
        this.player= new Player();
        this.enemy= new Enemy();
    }
}