package animals;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.List;
public class FelineTest {
    @Test
    void eatMeatReturnsList() {
        Feline feline = new Feline();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), feline.eatMeat());
    }
    @Test
    void getKittensDefaultReturnsOne() {
        Feline feline = new Feline();
        assertEquals(1, feline.getKittens());
    }
    @Test
    void getKittensWithParamReturnsCorrect() {
        Feline feline = new Feline();
        assertEquals(5, feline.getKittens(5));
    }
}
