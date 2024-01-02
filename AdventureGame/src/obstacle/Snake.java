package obstacle;

public class Snake extends Obstacle {
// bwteen damage 3 and  6
  static int  damage  = (int) (Math.random() * (6-3 )  ) + 4;
    public Snake(){
        super(4 , "Snake" , damage , 12 , 1);
    }
}
