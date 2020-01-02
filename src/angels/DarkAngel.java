package angels;

import heroes.Hero;

public class DarkAngel extends Angel {
    public DarkAngel(String angelDetails) {
        super(angelDetails);
    }

    public static void action(Hero h) {
        switch (h.type) {
            case "K":
                h.damage(40);
                break;
            case "P":
                h.damage(30);
                break;
            case "R":
                h.damage(10);
                break;
            case "W":
                h.damage(20);
                break;
            default:
                break;
        }
    }
}
