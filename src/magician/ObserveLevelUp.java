package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public class ObserveLevelUp extends GrandMagician {
    @Override
    public void observe(Hero a, Hero b, Angel c) throws IOException {
        if (a.isDead() == false) {
            fileio.FileSystem fs = GameFlow.getFS();

            fs.writeWord( a.type + " " + a.getId() + " reached level " + a.getLevel() + "\n");
        }
    }
}
