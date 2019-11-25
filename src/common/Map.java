package common;

import heroes.Hero;
import terrains.Land;
import terrains.Terrain;
import terrains.TerrainFactory;
import terrains.TerrainTypes;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Map {
    private static Map instance = null;

    private int dimX;
    private int dimY;

    private List<ArrayList<Terrain>> mapMatrix;

    private Map() {

    }

    private Map(int dimX, int dimY,  List<String> charMatrix) {
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

    public static Map getInstance(int dimX, int dimY, List<String> charMatrix) {
        if (instance == null) {
            instance = new Map(dimX, dimY, charMatrix);
        }

        return instance;
    }

    private void setMapMatrix(List<String> charMatrix) {
        mapMatrix = new ArrayList<>(dimX);
        TerrainFactory terrainFactory = TerrainFactory.getInstance();

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

    public Terrain getTerrain(int x, int y) {
        return mapMatrix.get(x).get(y);
    }

    public void moveHero(Hero hero, char move) {
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
        }

        hero.setPosMapX(posHeroX);
        hero.setPosMapY(posHeroY);
    }

    public int getDimX() {
        return dimX;
    }

    public int getDimY() {
        return dimY;
    }

    public List<ArrayList<Terrain>> getMapMatrix() {
        return mapMatrix;
    }
}
