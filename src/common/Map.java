package common;

import heroes.Hero;

import terrains.Terrain;
import terrains.TerrainsFactory;
import terrains.TerrainTypes;

import java.util.ArrayList;
import java.util.List;

public final class Map {
    private static Map instance = null;

    private int dimX;
    private int dimY;

    private List<ArrayList<Terrain>> mapMatrix;

    // singleton pattern
    private Map() {

    }

    private Map(final int dimX, final int dimY,  final List<String> charMatrix) {
        this.dimX = dimX;
        this.dimY = dimY;

        setMapMatrix(charMatrix);
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }

        return instance;
    }

    public static Map getInstance(final int dimX, final int dimY, final List<String> charMatrix) {
        if (instance == null) {
            instance = new Map(dimX, dimY, charMatrix);
        }

        return instance;
    }

    // transforms a char matrix into a terrain matrix
    private void setMapMatrix(final List<String> charMatrix) {
        mapMatrix = new ArrayList<>(dimX);
        TerrainsFactory terrainFactory = TerrainsFactory.getInstance();

        for (int i = 0; i < dimX; i++) {
            ArrayList<Terrain> row = new ArrayList<>(dimY);

            for (int j = 0; j < dimY; j++) {
                Terrain terrain;

                switch (charMatrix.get(i).charAt(j)) {
                    case 'L':
                        terrain = terrainFactory.createTerrain(TerrainTypes.LAND);
                        break;
                    case 'V':
                        terrain = terrainFactory.createTerrain(TerrainTypes.VOLCANIC);
                        break;
                    case 'D':
                        terrain = terrainFactory.createTerrain(TerrainTypes.DESERT);
                        break;
                    case 'W':
                        terrain = terrainFactory.createTerrain(TerrainTypes.WOODS);
                        break;
                    default:
                        terrain = null;
                        break;
                }

                row.add(terrain);
            }

            mapMatrix.add(row);
        }
    }

    // returns the terrain instances that is stored at (x, y) in matrix
    public Terrain getTerrain(final int x, final int y) {
        return mapMatrix.get(x).get(y);
    }

    // moves the hero as dictated by move
    public void moveHero(final Hero hero, final char move) {
        int posHeroX = hero.getPosMapX();
        int posHeroY = hero.getPosMapY();

        switch (move) {
            case 'U':
                --posHeroX;
                break;
            case 'D':
                ++posHeroX;
                break;
            case 'L':
                --posHeroY;
                break;
            case 'R':
                ++posHeroY;
                break;
            default:
                break;
        }

        hero.setPosMapX(posHeroX);
        hero.setPosMapY(posHeroY);
    }
}
