package Model;

import java.io.Serializable;

public interface Constants extends Serializable{
    enum Enemy_Attack{
        NONE,LADDER,BATTERING_RAM,SIEGE_TOWER,SWORD
    }
    
    final int N_ENEMY_SQUARES=3;
    final int N_ENEMY_CIRCLES=1;
    final int N_ENEMY_CLOSE_COMBAT=1;
    final int TAM_TRACKS_ENEMY=N_ENEMY_CIRCLES+N_ENEMY_CLOSE_COMBAT+N_ENEMY_SQUARES;
    final int N_PLAYER_SQUARES=5;
    final int N_TUNNEL_SPACES=2;
    final int CLOSE_COMBAT_POSITION_POWER = 4;
}
