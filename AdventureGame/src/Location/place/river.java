package Location.place;
import Location.battleLocation;
import obstacle.*;
import player.Player;

public class river extends battleLocation{
    public river(Player player){
        super(player , "River" ,new Bear(),"water",2 );
    }
}
