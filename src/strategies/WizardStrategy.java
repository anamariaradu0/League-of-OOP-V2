package strategies;

import heroes.Hero;

public class WizardStrategy implements IStrategy {
    @Override
    public void applyStrategy(Hero h) {
        System.out.println("WIZARD STRATEGY");
    }
}
