package terrains;

public final class TerrainFactory {
    private static TerrainFactory instance = null;

    private TerrainFactory() {

    }

    public static TerrainFactory getInstance() {
        if (instance == null) {
            instance = new TerrainFactory();
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
