// O.java
package src;
import ch.aplu.jgamegrid.*;

import java.util.ArrayList;
import java.util.Arrays;

class O extends Piece
{


  O(Tetris tetris) {
    super(tetris, 3, "O");

    Location[][] r = new Location[4][4];
    // rotId 0
    r[0][0] = new Location(new Location(0, 0));
    r[1][0] = new Location(new Location(1, 0));
    r[2][0] = new Location(new Location(1, 1));
    r[3][0] = new Location(new Location(0, 1));
    // rotId 1
    r[0][1] = new Location(new Location(0, 0));
    r[1][1] = new Location(new Location(1, 0));
    r[2][1] = new Location(new Location(1, 1));
    r[3][1] = new Location(new Location(0, 1));
    // rotId 2
    r[0][2] = new Location(new Location(0, 0));
    r[1][2] = new Location(new Location(1, 0));
    r[2][2] = new Location(new Location(1, 1));
    r[3][2] = new Location(new Location(0, 1));
    // rotId 3
    r[0][3] = new Location(new Location(0, 0));
    r[1][3] = new Location(new Location(1, 0));
    r[2][3] = new Location(new Location(1, 1));
    r[3][3] = new Location(new Location(0, 1));

    this.setR(r);

    for (int i = 0; i < r.length; i++)
      blocks.add(new TetroBlock(this.getBlockId(), r[i]));
  }



}



