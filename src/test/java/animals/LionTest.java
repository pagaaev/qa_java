package animals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class LionTest {

    private Feline createFelineMock() {
        return mock(Feline.class);
    }

    @Test
    void lionConstructorWithMale() throws Exception {
        Feline felineMock = createFelineMock();
        Lion lion = new Lion("Male", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void lionConstructorWithFemale() throws Exception {
        Feline felineMock = createFelineMock();  // Исправлено с Fock на Feline
        Lion lion = new Lion("Female", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Unknown", "Мужской"})
    void lionConstructorWithInvalidSexThrowsException(String invalidSex) {
        Feline felineMock = createFelineMock();
        Exception exception = assertThrows(Exception.class, () ->
            new Lion(invalidSex, felineMock));
        assertEquals("Unknown sex", exception.getMessage());
    }

    @Test
    void getKittensUsesFeline() throws Exception {
        Feline felineMock = createFelineMock();
        when(felineMock.getKittens()).thenReturn(3);

        Lion lion = new Lion("Male", felineMock);
        assertEquals(3, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    void getFoodReturnsMeat() throws Exception {
        Feline felineMock = createFelineMock();
        when(felineMock.eatMeat()).thenReturn(List.of("Meat"));

        Lion lion = new Lion("Male", felineMock);
        assertEquals(List.of("Meat"), lion.getFood());
        verify(felineMock, times(1)).eatMeat();
    }
}