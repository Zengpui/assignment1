package src;

import ch.aplu.jgamegrid.Location;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Statistics {

    public int difficulty;
    List<Round> stats = new ArrayList<Round>();
    public void Statistics(){

    }
    public void updateDifficulty(int difficulty){
        this.difficulty=difficulty;
    }
    public void addRound(int roundNum){
        stats.add(new Round(roundNum));

    }
    public void updateRound(int roundNum, int pieceId, int score){
        this.stats.get(roundNum-1).score=score;
        switch (pieceId) {
            case 0:
                this.stats.get(roundNum-1).I+=1;
                break;
            case 1:
                this.stats.get(roundNum-1).J+=1;
                break;
            case 2:
                this.stats.get(roundNum-1).L+=1;
                break;
            case 3:
                this.stats.get(roundNum-1).O+=1;
                break;
            case 4:
                this.stats.get(roundNum-1).S+=1;
                break;
            case 5:
                this.stats.get(roundNum-1).T+=1;
                break;
            case 6:
                this.stats.get(roundNum-1).Z+=1;
                break;
            case 7:
                this.stats.get(roundNum-1).P+=1;
                break;
            case 8:
                this.stats.get(roundNum-1).Q+=1;
                break;
            case 9:
                this.stats.get(roundNum-1).Plus+=1;
                break;
        }
    }
    public int average(int roundNum){
        int total=0;
        for(int i=0;i<roundNum;i++){
            total += this.stats.get(i).score;
        }
        return total/roundNum;
    }
    public void recordStats(int roundNum){
        Path file = Path.of("Statistics.txt");
        try (
            FileWriter fileWriter = new FileWriter(file.toFile());

            PrintWriter printWriter = new PrintWriter(fileWriter);){
            switch (this.difficulty) {
                case 0:
                    printWriter.printf("Difficulty: Easy\n");
                    break;
                case 1:
                    printWriter.printf("Difficulty: Medium\n");
                    break;
                case 2:
                    printWriter.printf("Difficulty: Madness\n");
            }
            printWriter.printf("Average score per round: %d\n", this.average(roundNum));
            printWriter.printf("------------------------------------------\n");
            for (int i = 0; i < roundNum; i++) {
                printWriter.printf("Round #%d\nScore: %d\n" +
                                "I: %d\nJ: %d\nL: %d\nO: %d\nS: %d\nT: %d\nZ: %d\nP: %d\nPlus: %d\nQ: %d\n",
                        i + 1, this.stats.get(i).score, this.stats.get(i).I, this.stats.get(i).J, this.stats.get(i).L, this.stats.get(i).O,
                        this.stats.get(i).S, this.stats.get(i).T, this.stats.get(i).Z, this.stats.get(i).P,
                        this.stats.get(i).Plus, this.stats.get(i).Q);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
