package animals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FelineTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 3, 5, 10})
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