package animals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class FelineTest {

    @Test
    void testFelineConstructor() {
        Feline feline = new Feline();
        assertNotNull(feline);
    }

    @Test
    void eatMeatReturnsCorrectList() {
        Feline feline = new Feline();
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 3, 5, 10, Integer.MAX_VALUE})
    void getKittensWithParamReturnsCorrect(int kittensCount) {
        Feline feline = new Feline();
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }

    @Test
    void getKittensWithoutParamReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
}