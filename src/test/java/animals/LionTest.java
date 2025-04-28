package animals;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
public class LionTest {
    @Test
    void lionHasManeIfMale() throws Exception {
        Lion lion = new Lion("Male", new Feline());
        assertTrue(lion.doesHaveMane());
    }
    @Test
    void lionHasNoManeIfFemale() throws Exception {
        Lion lion = new Lion("Female", new Feline());
        assertFalse(lion.doesHaveMane());
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
        when(feline.getKittens()).thenReturn(3);
        Lion lion = new Lion("Male", feline);
        assertEquals(3, lion.getKittens());
    }
}
