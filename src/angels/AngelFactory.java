package angels;

public final class AngelFactory {
    private AngelFactory() {
    }

    public static Angel getAngel(final String inputAngel) {
        String[] details = inputAngel.split(",");
        String name = details[0];

        switch (name) {
            case "DamageAngel":
                return new DamageAngel(inputAngel);
            case "DarkAngel":
                return new DarkAngel(inputAngel);
            case "Dracula":
                return new Dracula(inputAngel);
            case "GoodBoy":
                return new GoodBoy(inputAngel);
            case "LevelUpAngel":
                return new LevelUpAngel(inputAngel);
            case "LifeGiver":
                return new LifeGiver(inputAngel);
            case "SmallAngel":
                return new SmallAngel(inputAngel);
            case "Spawner":
                return new Spawner(inputAngel);
            case "TheDoomer":
                return new TheDoomer(inputAngel);
            case "XPAngel":
                return new XPAngel(inputAngel);
            default:
                return null;
        }
    }
}
