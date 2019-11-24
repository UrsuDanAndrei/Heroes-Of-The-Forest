package main;

import abilities.Ability;
import abilities.knightAbilities.Execute;
import common.Map;
import heroes.Hero;
import heroes.Knight;
import heroes.Pyromancer;
import input.GameInputReader;
import terrains.Terrain;
import terrains.Volcanic;
import terrains.Woods;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameInputReader gameInputReader = new GameInputReader(args[0], args[1]);
        gameInputReader.read();
    }
}
