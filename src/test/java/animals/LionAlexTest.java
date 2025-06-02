package animals;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class LionAlexTest {
    @Test
    void alexHasNoKittens() throws Exception {
        LionAlex alex = new LionAlex(new Feline());
        assertEquals(0, alex.getKittens());
    }
    @Test
    void alexHasFriends() throws Exception {
        LionAlex alex = new LionAlex(new Feline());
        assertEquals(List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }
    @Test
    void alexLivesInZoo() throws Exception {
        LionAlex alex = new LionAlex(new Feline());
        assertEquals("Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }
}
