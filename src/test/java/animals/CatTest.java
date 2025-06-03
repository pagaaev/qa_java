package animals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CatTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 5})
    void getKittensReturnsExpectedCount(int ignoredCount) {
        // Создаем реальный объект Feline
        Feline realFeline = new Feline();

        // Оборачиваем его в spy
        Feline spyFeline = spy(realFeline);

        // Переопределяем метод getKittens() чтобы всегда возвращал 1
        when(spyFeline.getKittens()).thenReturn(1);

        Cat cat = new Cat(spyFeline);

        // Проверяем, что cat.getKittens() всегда 1
        assertEquals(1, cat.getKittens());
    }
}

