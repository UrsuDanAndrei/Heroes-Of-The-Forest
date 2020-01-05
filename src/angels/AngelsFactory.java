package angels;

public final class AngelsFactory {
    private static AngelsFactory instance = null;
    private AngelsFactory() {

    }

    public static AngelsFactory getInstance() {
        if (instance == null) {
            instance = new AngelsFactory();
        }

        return instance;
    }

    public Angel createAngel(final AngelTypes type, final int posMapX, final int posMapY) {
        Angel angel;

        switch (type) {
            case DamageAngel:
                angel = new DamageAngel(posMapX, posMapY);
                break;
            case DarkAngel:
                angel = new DarkAngel(posMapX, posMapY);
                break;
            case Dracula:
                angel = new Dracula(posMapX, posMapY);
                break;
            case GoodBoy:
                angel = new GoodBoy(posMapX, posMapY);
                break;
            case LevelUpAngel:
                angel = new LevelUpAngel(posMapX, posMapY);
                break;
            case LifeGiver:
                angel = new LifeGiver(posMapX, posMapY);
                break;
            case SmallAngel:
                angel = new SmallAngel(posMapX, posMapY);
                break;
            case Spawner:
                angel = new Spawner(posMapX, posMapY);
                break;
            case TheDoomer:
                angel = new TheDoomer(posMapX, posMapY);
                break;
            case XPAngel:
                angel = new XPAngel(posMapX, posMapY);
                break;
            default:
                angel = null;
        }

        return angel;
    }
}
