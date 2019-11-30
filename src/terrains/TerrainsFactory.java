package terrains;

public final class TerrainsFactory {
    private static TerrainsFactory instance = null;

    private TerrainsFactory() {

    }

    public static TerrainsFactory getInstance() {
        if (instance == null) {
            instance = new TerrainsFactory();
        }

        return instance;
    }

    public Terrain createTerrain(final TerrainTypes type) {
        switch (type) {
            case LAND:
                return new Land();
            case VOLCANIC:
                return new Volcanic();
            case DESERT:
                return new Desert();
            case WOODS:
                return new Woods();
            default:
                return null;
        }
    }
}
