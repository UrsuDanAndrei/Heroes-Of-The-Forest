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
        try {
            // displaying all notifications received by The Great Magician
            List<String> notifications = gameOutput.getNotifications();
            for (String notification : notifications) {
                if (notification.equals("NewLine")) {
                    fs.writeNewLine();
                } else {
                    fs.writeWord(notification);
                    fs.writeNewLine();
                }
            }

            // displaying the results at the end of the game
            fs.writeWord("~~ Results ~~");
            fs.writeNewLine();
            List<Hero> heroes = gameOutput.getHeroes();
            for (Hero hero : heroes) {
                fs.writeWord(hero.toStringFullStatistics());
                fs.writeNewLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
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
