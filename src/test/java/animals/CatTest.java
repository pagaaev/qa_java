package animals;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CatTest {

    @Test
    void getKittensReturnsOneFromMock() {
        Feline felineMock = mock(Feline.class);
        // Исправлено: мок теперь всегда возвращает 1, как реальный Feline
        when(felineMock.getKittens()).thenReturn(1);

        Cat cat = new Cat(felineMock);

        assertEquals(1, cat.getKittens());
        // Проверяем, что мок был вызван ровно один раз
        verify(felineMock, times(1)).getKittens();
    }
}