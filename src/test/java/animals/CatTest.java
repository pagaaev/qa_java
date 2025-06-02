package animals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
public class CatTest {
    @Test
    void getSoundReturnsMeow() {
        Feline feline = mock(Feline.class);
        Cat cat = new Cat(feline);
        assertEquals("Мяу", cat.getSound());
    }
    @Test
    void getKittensDelegatesToFeline() {
        Feline feline = mock(Feline.class);
        when(feline.getKittens()).thenReturn(2);
        Cat cat = new Cat(feline);
        assertEquals(2, cat.getKittens());
    }
}
