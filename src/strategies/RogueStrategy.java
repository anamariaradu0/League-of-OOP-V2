package strategies;

import heroes.Hero;

public class RogueStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h ) {
        System.out.println("ROGUE STRATEGY");
    }
}
