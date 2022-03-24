import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;


public class Cursor extends Grid implements KeyboardHandler {


    private Rectangle cursor;
    private int cursorCol;
    private int cursorRow;
    private  Rectangle[][] allCells = getCells();

    public Cursor() {


        cursorCol = 0;
        cursorRow = 0;
        cursor = new Rectangle(getPADDING(), getPADDING(), getCELLSIZE(), getCELLSIZE());
        cursor.draw();
        cursor.fill();
        cursor.setColor(Color.MAGENTA);
        KeyboardMove();

    }

    public void paint() {


        Rectangle[][] pos = getCells();

        Rectangle currentPos = pos[cursorCol][cursorRow];

        currentPos.fill();


    }

    public void delete() {


        Rectangle currentPos = allCells[cursorCol][cursorRow];
        currentPos.draw();
    }

    public void deleteAll(){


    }

    private void KeyboardMove() {

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);


        KeyboardEvent fill = new KeyboardEvent();
        fill.setKey(KeyboardEvent.KEY_SPACE);
        fill.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(fill);

        KeyboardEvent delete = new KeyboardEvent();
        delete.setKey(KeyboardEvent.KEY_S);
        delete.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(delete);

        KeyboardEvent deleteAll = new KeyboardEvent();
        deleteAll.setKey(KeyboardEvent.KEY_D);
        deleteAll.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(deleteAll);


    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                cursor.translate(-getCELLSIZE(), 0);
                cursorCol--;
                break;
            case KeyboardEvent.KEY_RIGHT:
                cursor.translate(getCELLSIZE(), 0);
                cursorCol++;
                break;
            case KeyboardEvent.KEY_UP:
                cursor.translate(0, -getCELLSIZE());
                cursorRow--;
                break;
            case KeyboardEvent.KEY_DOWN:
                cursor.translate(0, getCELLSIZE());
                cursorRow++;
                break;
            case KeyboardEvent.KEY_C:
                cursor.translate(0, getCELLSIZE());

                break;


            case KeyboardEvent.KEY_SPACE:
                paint();
                break;
            case KeyboardEvent.KEY_D:
                delete();
                break;


        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
