import model.*;
import org.junit.jupiter.api.Test;
import structures.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class TestSumSubArr {
    private Integer[] arr1;
    void setUp1() {
        arr1 = new Integer[]{3, 4, -7, 1, 3, 3, 1, -4}; // Caso con subarreglo en medio
    }

    @Test
    void testCaso1() {
        setUp1();
        assertArrayEquals(new int[]{0, 1}, SumSubArr.findSubarrayWithSum(arr1, 7));
    }
}
