
package Board;

import java.util.ArrayList;

public class Tunnel_Track extends Track{
    
    public Tunnel_Track(Piece p){
        track = new ArrayList<>(N_TUNNEL_SPACES+2);
        track.add(new Square(p));
        for(int i=0;i < N_TUNNEL_SPACES;i++){
            track.add(new Square());
        }
        track.add(new Enemy_Line_Position());
    }
}
