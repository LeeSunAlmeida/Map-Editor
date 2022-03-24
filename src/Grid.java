import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private final int PADDING = 10;
    private final int CELLSIZE = 20;

    private final int COLS = 20;
    private final int ROWS = 20;

    private final int width = CELLSIZE * COLS;
    private final int heigth = CELLSIZE * ROWS;

    private Rectangle[][] cells;


    public Grid() {

        cells = new Rectangle[COLS][ROWS];

        for(int i = 0; i < cells.length; i++){

            for(int j = 0; j < cells[i].length; j++){

                cells[i][j] = new Rectangle(PADDING + i * CELLSIZE, PADDING + j * CELLSIZE, CELLSIZE, CELLSIZE);


                cells[i][j].draw();
            }


        }

    }

    public int getCELLSIZE() {
        return CELLSIZE;
    }

    public int getPADDING() {
        return PADDING;
    }

    public Rectangle[][] getCells() {
        return cells;
    }
}
