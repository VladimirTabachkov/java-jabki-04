import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        System.out.println("Элементы массива: " + printArray(new int[] {2, 4, 6, 8, 10}));
        System.out.println("Сумма элементов массива: " + sumArray(new int[]  {1, 2, 3, 4, 5}));
        System.out.println("Минимум: " + minElement(new int[]{3, 6, -3, 11}));
        String[] months = {
                "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
                "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
        };
        System.out.println("Месяцы начинающиеся с буквы 'М':" + getStartingWithM(months));
        int[] numbers4 = {1, 2, 3, 4, 5};
        invertArray(numbers4);
        System.out.println(Arrays.toString(numbers4));
        System.out.println("Есть дубликаты? " + hasDuplicates(new int[]{1, 2, 3, 4, 2}));
        int[] nums = {5, -3, 0, -7, 2};
        absArray(nums);
        System.out.println(Arrays.toString(nums));

        diagonalMatrix();
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Сумма всех элементов: " + sumMatrix(matrix2));
        int[][] matrix3 = {
                {1, 52, 3},
                {4, 65, 6},
                {76, 8, 39}
        };
        maxMatrix(matrix3);
        int[][] matrix4 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println("Матрица квадратная - " + isSquareMatrix(matrix4));
        int[][] matrix5 = {
                {3, 5, 1},
                {8, 2, 7},
                {4, 6, 9}
        };
        analyzeMatrix(matrix5);

        int[][] matrix6 = cpecialFillMatrix(5,5);
        for (int[] row : matrix6) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

    }

    /**
     * Одномерные массивы
     * 1. Метод, выводящий массив в консоль.
     */
    public static String printArray(int[] numbers) {
        String str = "";
        for (int i = 0; i < numbers.length; i++) {
            if (i < numbers.length - 1) {
                str = str + numbers[i] + ", ";
            } else {
                str = str + numbers[i];
            }
        }
        return  str;
    }

    // 2. Метод, принимающий массив целых чисел и возвращает сумму всех его элементов.
    public static int sumArray(int[] array) {
        int sum = 0;
        for (int number : array) {
            sum += number;
        }
        return sum;
    }

    // 3. Метод поиска минимального элемента в одномерном массиве
    public static int minElement(int[] array) {
        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
        }
        return min;
    }

    // 4. Создайте массив строк, инициализируйте его названиями месяцев года. Выведите все строки, начинающиеся на букву "М"
    public static String getStartingWithM(String[] strArray) {
        String result = "";
        for (String str : strArray) {
            if (str.startsWith("М")) {
                if (!result.isEmpty()) {
                    result += ", ";
                }
                result += str;
            }
        }
        return result;
    }

    // 5. Напишите метод, который инвертирует порядок элементов в одномерном массиве
    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int j = array.length - 1 - i;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    // 6. Метод, проверяющий, есть ли в массиве повторяющиеся элементы
    public static boolean hasDuplicates(int[] numbers) {
        Set<Integer> seen = new HashSet<>();
        for (int num : numbers) {
            if (!seen.add(num)) {
                return true;
            }
        }
        return false;
    }

    // 7. Метод, заменяющий все отрицательные числа в массиве на их абсолютные значения.
    public static void absArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 0) {
                array[i] = -array[i];
            }
        }
    }

    /**
     * Многомерные массивы
     * 1. Метод, создающий двумерный массив 3x3. Массив заполняется единицами на главной диагонали и нулями в остальных ячейках.
     */
    public static void diagonalMatrix() {
        int[][] matrix = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = (i == j) ? 1 : 0;
            }
        }

        for (int[] row : matrix) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    // 2. Сумма всех элементов в двумерном массиве
    public static int sumMatrix(int[][] matrix) {
        int sum = 0;
        for (int[] row : matrix) {
            for (int value : row) {
                sum += value;
            }
        }
        return sum;
    }

    // 3. Поиск максимального элемента в матрице и вывод его координат (строка, столбец)
    public static void maxMatrix(int[][] matrix) {
        int max = matrix[0][0];
        int rowIndex = 0;
        int colIndex = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] > max) {
                    max = matrix[i][j];
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        System.out.printf("Максимальное значение: %d, координаты: строка %d, столбец %d%n", max, rowIndex+1, colIndex+1);
    }

    // 4. Проверяет, является ли двумерный массив квадратным (количество строк = количеству столбцов)
    public static boolean isSquareMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            if (row.length != matrix.length) {
                return false;
            }
        }
        return true;
    }

    // 5. Нахождение суммы элементов в каждой строке, минимальное и максимальное значение двумерного массива и выводит результаты
    public static void analyzeMatrix(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            System.out.println("Матрица пуста.");
            return;
        }

        int min = matrix[0][0];
        int max = matrix[0][0];

        System.out.println("Сумма элементов по строкам");
        System.out.println("--------------------------");
        for (int i = 0; i < matrix.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                int value = matrix[i][j];
                rowSum += value;

                if (value < min) min = value;
                if (value > max) max = value;
            }
            System.out.printf("Строка %d: %d%n", i, rowSum);
        }
        System.out.println("--------------------------");
        System.out.println("Минимальное значение в матрице: " + min);
        System.out.println("Максимальное значение в матрице: " + max);
    }

    // 6. заполнить двумерный массив так, чтобы элементы на четных позициях были 0, на нечетных — 1.
    public static int[][] cpecialFillMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = (i + j) % 2 == 0 ? 0 : 1;
            }
        }
        return matrix;
    }
}