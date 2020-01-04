package output;

import heroes.Hero;

import java.util.List;

import fileio.FileSystem;
import heroes.Pyromancer;

public final class GameOutputWriter {
    private final String inputPath;
    private final String outputPath;
    private FileSystem fs;

    public GameOutputWriter(final String inputPath, final String outputPath) {
        this.inputPath = inputPath;
        this.outputPath = outputPath;

        try {
            fs = new FileSystem(inputPath, outputPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void write(final GameOutput gameOutput) {
        List<Hero> heroes = gameOutput.getHeroes();
        for (Hero hero : heroes) {
            try {

                System.out.println(hero.toString());
                fs.writeWord(hero.toString());
                fs.writeNewLine();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void close() {
        try {
            fs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
