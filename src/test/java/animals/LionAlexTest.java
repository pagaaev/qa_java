package animals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.List;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionAlexTest {

    static Stream<List<String>> friendsProvider() {
        return Stream.of(
            List.of("Марти", "Глория", "Мелман"),
            List.of("Марти", "Глория", "Мелман")  // можно добавить другие варианты для проверки
        );
    }

    @ParameterizedTest
    @MethodSource("friendsProvider")
    void alexHasFriends(List<String> expectedFriends) throws Exception {
        LionAlex alex = new LionAlex(new Feline());
        assertEquals(expectedFriends, alex.getFriends());
    }
}
