
package Model;

import java.io.Serializable;

public interface Constants extends Serializable{
    
    public enum Enemy_Attack{
        NONE,LADDER,BATTERING_RAM,SIEGE_TOWER,SWORD
    }
    
    public int N_ENEMY_SQUARES=3;
    public int N_ENEMY_CIRCLES=1;
    public int N_ENEMY_CLOSE_COMBAT=1;
    public int TAM_TRACKS_ENEMY= N_ENEMY_CIRCLES+N_ENEMY_CLOSE_COMBAT+N_ENEMY_SQUARES;
    public int N_PLAYER_SQUARES=5;
    public int N_TUNNEL_SPACES=2;
}
