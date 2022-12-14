package Day08;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Part1and2 {
    String input;
    String[] lines;
    String path = "./Day08/input.txt";
    String testPath = "./Day08/testInput.txt";
    int[][] forest;
    boolean[][] visible;
    int part1;

    public void readFromInput() {
        StringBuilder contentBuilder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String sCurrentLine;
            while ((sCurrentLine = reader.readLine()) != null) {
                contentBuilder.append(sCurrentLine).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        this.input = contentBuilder.toString();
        lines = input.split("\n");

        forest = new int[lines.length][lines[0].length()];
        for (int row = 0; row < lines.length; row++) {
            for (int col = 0; col < lines[row].length(); col++) {
                forest[row][col] = Integer.parseInt(String.valueOf(lines[row].charAt(col)));
            }
        }
    }

    public int p1() {
        readFromInput();
        int numRows = forest.length;
        int numCols = forest[0].length;
        visible = new boolean[numRows][numCols];

        //visible from the left side
        for (int row = 0; row < numRows; row++) {
            int height = -1;
            for (int col = 0; col < numCols; col++) {
                if (forest[row][col] > height) {
                    visible[row][col] = true;
                    height = forest[row][col];
                }
            }
            //Visible from the right side
            height = -1;
            for (int col = numCols - 1; col >= 0; col--) {
                if (forest[row][col] > height) {
                    visible[row][col] = true;
                    height = forest[row][col];
                }
            }
        }
        //Visible from the top side
        for (int col = 0; col < numCols; col++) {
            int height = -1;
            for (int row = 0; row < numRows; row++) {
                if (forest[row][col] > height) {
                    visible[row][col] = true;
                    height = forest[row][col];
                }
            }
            //Visible from the bottom side
            height = -1;
            for (int row = numRows - 1; row >= 0; row--) {
                if (forest[row][col] > height) {
                    visible[row][col] = true;
                    height = forest[row][col];
                }
            }
        }
        //Now to count the total number of visible trees
        for (int row = 0; row < numRows; row++) {
            for (int col = 0; col < numCols; col++) {
                if (visible[row][col])
                    part1++;
            }
        }
        return part1;
    }

    //Finding the best tree
    public int p2() {
        int maxScore = 0;
        int[][] scenic = getScenicScores(forest);
        int numRows = forest.length;
        int numCols = forest[0].length;

        for (int i = 0; i<numRows; i++) {
            for (int j = 0; j<numCols; j++) {
                maxScore = Math.max(scenic[i][j], maxScore);
            }
        }

        return maxScore;
    }

    public int[][] getScenicScores(int[][] trees){
        int[][] scenicScores = new int[trees.length][trees.length];
        for (int i = 0; i<trees.length; i++) {
            for (int j = 0; j<trees.length; j++) {
                scenicScores[i][j] = getScenicScore(trees,i,j);
            }
        }
        return scenicScores;
    }

    public int getScenicScore(int[][] trees, int i, int j) {
        int step = 1;
        int scenicRight = 0;
        while (true) {
            try {
                if (trees[i+step][j] >= trees[i][j]) {
                    scenicRight += step;
                    break;
                } else {
                    step++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                scenicRight += step-1;
                break;
            }
        }

        step = 1;
        int scenicLeft = 0;
        while (true) {
            try {
                if (trees[i-step][j] >= trees[i][j]) {
                    scenicLeft += step;
                    break;
                } else {
                    step++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                scenicLeft += step-1;
                break;
            }
        }

        step = 1;
        int scenicTop = 0;
        while (true) {
            try {
                if (trees[i][j+step] >= trees[i][j]) {
                    scenicTop += step;
                    break;
                } else {
                    step++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                scenicTop += step-1;
                break;
            }
        }

        step = 1;
        int scenicBottom = 0;
        while (true) {
            try {
                if (trees[i][j-step] >= trees[i][j]) {
                    scenicBottom += step;
                    break;
                } else {
                    step++;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                scenicBottom += step-1;
                break;
            }
        }

        return scenicLeft * scenicRight * scenicTop * scenicBottom;
    }

}
