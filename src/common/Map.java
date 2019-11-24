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

    private int dimX = 0;
    private int dimY = 0;

    private List<ArrayList<MapCell>> mapMatrix = null;

    private class MapCell {
        private Terrain terrain = null;
        private List<Hero> inCellHeroes = null;

        MapCell(char terrainChar) {
            inCellHeroes = new ArrayList<>();
            TerrainFactory terrainFactory = TerrainFactory.getInstance();

            switch (terrainChar) {
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
        }

        private void addHero(Hero hero) {
            inCellHeroes.add(hero);
        }

        private void removeHero(Hero hero) {
            ListIterator<Hero> it = inCellHeroes.listIterator();

            while(it.hasNext()) {
                if (hero == it.next()) {
                    it.remove();
                }
            }
        }
    }

    private Map() {

    }

    private Map(int dimX, int dimY,  List<ArrayList<Character>> charMatrix) {
        this.dimX = dimX;
        this.dimY = dimY;

        mapMatrix = new ArrayList<>(dimX);
        ListIterator<ArrayList<MapCell>> it = mapMatrix.listIterator();
        while (it.hasNext()) {
            it.next();
            it.set(new ArrayList<>(dimY));
        }

        setMapMatrix(charMatrix);
    }

    public static Map getInstance() {
        if (instance == null) {
            instance = new Map();
        }

        return instance;
    }

    public static Map getInstance(int dimX, int dimY, List<ArrayList<Character>> charMatrix) {
        if (instance == null) {
            instance = new Map(dimX, dimY, charMatrix);
        }

        return instance;
    }

    private void setMapMatrix(List<ArrayList<Character>> charMatrix) {
        ListIterator<ArrayList<MapCell>> itMap = mapMatrix.listIterator();
        ListIterator<ArrayList<Character>> itCharMatrix = charMatrix.listIterator();

        // iterates thru charMatrix rows
        while (itCharMatrix.hasNext()) {
            ListIterator<MapCell> itRowMap = itMap.next().listIterator();
            ListIterator<Character> itRowCharMatrix = itCharMatrix.next().listIterator();

            // iterates thru a charMatrix row and sets up every MapCell in mapMatrix for that row
            while (itRowCharMatrix.hasNext()) {
                itRowMap.set(new MapCell(itRowCharMatrix.next()));
            }
        }
    }

    public Terrain getTerrain(int x, int y) {
        return mapMatrix.get(x).get(y).terrain;
    }

    public void moveHero(Hero hero, char move) {
        int posHeroX = hero.getPosMapX();
        int posHeroY = hero.getPosMapY();
        mapMatrix.get(posHeroX).get(posHeroY).removeHero(hero);

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
        mapMatrix.get(posHeroX).get(posHeroY).addHero(hero);
    }

    public int getNoHeroes(int posMapX, int posMapY) {
        return mapMatrix.get(posMapX).get(posMapY).inCellHeroes.size();
    }

    public List<Hero> getHeroes(int posMapX, int posMapY) {
        return mapMatrix.get(posMapX).get(posMapY).inCellHeroes;
    }
}
