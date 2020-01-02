package strategies;

import heroes.Hero;
import heroes.Pyromancer;

public class Context {
    private IStrategy strategy;

    public Context(Hero h) {
        switch (h.type) {
            case "Knight":
                this.strategy = new KnightStrategy();
                break;
            case "Pyromancer":
                this.strategy = new PyromancerStrategy();
                break;
            case "Rogue":
                this.strategy = new RogueStrategy();
                break;
            case "Wizard":
                this.strategy = new WizardStrategy();
                break;
        }
    }

    public void executeStrategy(Hero h) {
        strategy.applyStrategy(h);
    }
}
