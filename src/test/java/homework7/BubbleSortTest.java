package homework7;

import org.homework7.BubbleSort;
import org.homework7.SalesRepresentative;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Random;

public class BubbleSortTest {
    @Test
    public void sort_desc_works() {
        Random randomizer = new Random();
        int length = randomizer.nextInt(20) + 1;
        SalesRepresentative[] salesRep = new SalesRepresentative[length];
        for (int i = 0; i < length; ++i) {
            salesRep[i] = new SalesRepresentative(randomizer.nextInt(20), randomizer.nextInt(1000));
        }

        SalesRepresentative[] copy = salesRep.clone();
        Arrays.sort(copy, (o1, o2) -> (o2.salesNr * o2.quota) - (o1.salesNr * o1.quota));

        BubbleSort bubbleSorter = new BubbleSort();
        SalesRepresentative[] sortedArray = bubbleSorter.sortDesc(salesRep);

        Assertions.assertArrayEquals(salesRep, copy);
    }
}
