package university.jala.capstonelegion.printer;

/*
Muestra visual del campo de batalla una al principio y al final del ordenamiento.
 */

public class PrintManager {

    public PrintManager() {

    }

    public void printFieldOfGame(Object[][] field) {

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i < rows.length && j < rows[i].length()) {
                    board[i][j] = new Cell(rows[i].charAt(j) == '1' ? 1 : 0);
                } else {
                    board[i][j] = new Cell(0);
                }
            }
        }
        return board;
    }

    public void printFieldWithStrings(Object [][] fields) {
    }

    public void printFieldWithNumbers(Object [][] fields) {
    }
}
