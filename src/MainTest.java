import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void sumArray() {
        int[] input = {1, 2, 3, 4};
        assertEquals(10, Main.sumArray(input));
    }

    @Test
    void minElement() {
        int[] input = {5, 5, 7, 1, 5};
        assertEquals(1, Main.minElement(input));
    }

    @Test
    void getStartingWithM() {
        String[] months = {
                "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };
        assertEquals("Март, Май", Main.getStartingWithM(months));
    }

    @Test
    void invertArray() {
        int[] input = {1, 2, 3, 4};
        Main.invertArray(input);
        assertArrayEquals(new int[]{4, 3, 2, 1}, input);
    }

    @Test
    void hasDuplicates() {
        int[] input = {1, 2, 3, 2};
        assertTrue(Main.hasDuplicates(input));
    }

    @Test
    void absArray() {
        int[] input = {1, -22, 3};
        Main.absArray(input);
        assertArrayEquals(new int[]{1, 22, 3}, input);
    }

    @Test
    void sumMatrix() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        assertEquals(10, Main.sumMatrix(matrix));
    }

    @Test
    void isSquareMatrix() {
        int[][] matrix = {
                {1, 2},
                {3, 4}
        };
        assertTrue(Main.isSquareMatrix(matrix));
    }

    @Test
    void cpecialFillMatrix() {
        int[][] expected = {
                {0, 1, 0},
                {1, 0, 1}
        };
        assertArrayEquals(expected, Main.cpecialFillMatrix(2, 3));
    }
}