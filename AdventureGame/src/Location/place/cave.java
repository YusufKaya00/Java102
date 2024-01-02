package Location.place;
import Location.battleLocation;
import obstacle.*;
import player.Player;

public class cave extends battleLocation{
    public cave(Player player){
        super(player,"Cave" ,new Vampire() ,"firewood" , 3);
    }
}
