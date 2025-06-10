package animals;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LionTest {

    @Test
    void getKittensReturnsOneFromMock() throws Exception {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(1);

        Lion lion = new Lion("Male", felineMock);

        assertEquals(1, lion.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    void lionWithFemaleSexHasNoMane() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Female", felineMock);
        assertFalse(lion.doesHaveMane());
    }

    @Test
    void lionWithMaleSexHasMane() throws Exception {
        Feline felineMock = mock(Feline.class);
        Lion lion = new Lion("Male", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    void lionWithInvalidSexThrowsException() {
        Feline felineMock = mock(Feline.class);
        Exception exception = assertThrows(Exception.class, () -> new Lion("Самец", felineMock));
        assertEquals("Unknown sex", exception.getMessage());
    }
}