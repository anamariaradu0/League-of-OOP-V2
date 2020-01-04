package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public class ObserveAngelRevive extends GrandMagician {
    @Override
    public void observe(Hero a, Hero b, Angel c) throws IOException {
        fileio.FileSystem fs = GameFlow.getFS();

        fs.writeWord("Player " + a.type + " " + a.getId() + " was brought to life by an angel\n");
    }
}
