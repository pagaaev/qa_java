package animals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class LionTest {

    @ParameterizedTest
    @CsvSource({
        "Male, true",
        "Female, false"
    })
    void lionManeDependsOnSex(String sex, boolean expectedHasMane) throws Exception {
        Lion lion = new Lion(sex, new Feline());
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }

    @Test
    void lionThrowsOnInvalidSex() {
        Exception exception = assertThrows(Exception.class, () -> {
            new Lion("Other", new Feline());
        });
        assertEquals("Unknown sex", exception.getMessage());
    }

    @Test
    void lionDelegatesToFeline() throws Exception {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion("Male", feline);
        assertEquals(3, lion.getKittens());
    }
}
