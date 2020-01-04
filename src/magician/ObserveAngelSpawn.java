package magician;

import angels.Angel;
import gameflow.GameFlow;
import heroes.Hero;

import java.io.IOException;

public class ObserveAngelSpawn extends GrandMagician {
    @Override
    public void observe(Hero a, Hero b, Angel c) throws IOException {
        String[] details = c.getAngelDetails().split(",");
        String name = details[0];
        int angX = Integer.parseInt(details[1]);
        int angY = Integer.parseInt(details[2]);

        fileio.FileSystem fs = GameFlow.getFS();

        if (name == "TheDoomer") {
            name = "The Doomer";
        }

        fs.writeWord("Angel " + name + " was spawned at " + angX + " " + angY + "\n");
    }
}
