package animals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5})
    void getKittensReturnsExpectedCount(int kittensCount) {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(kittensCount);
        Cat cat = new Cat(feline);

        assertEquals(kittensCount, cat.getKittens());
    }
}
