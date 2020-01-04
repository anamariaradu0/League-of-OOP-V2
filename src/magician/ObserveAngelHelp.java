package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public class ObserveAngelHelp extends GrandMagician {
    @Override
    public void observe(Hero a, Hero b, Angel c) throws IOException {
        String[] details = Angel.getAngelDetails().split(",");
        String name = details[0];

        fileio.FileSystem fs = GameFlow.getFS();

        fs.writeWord(name + " helped " + a.type + " " + a.getId() + "\n");
    }
}
