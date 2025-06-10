package animals;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class CatTest {

    @Test
    void constructorProperlySetsDependency() {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);

        assertNotNull(cat);
        // Можно добавить проверку получения зависимости через рефлексию при необходимости
    }

    @Test
    void getSoundReturnsCorrectValue() {
        Feline felineMock = mock(Feline.class);
        Cat cat = new Cat(felineMock);

        assertEquals("Мяу", cat.getSound());
    }

    @Test
    void getKittensReturnsOneFromMock() {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(1);

        Cat cat = new Cat(felineMock);

        assertEquals(1, cat.getKittens());
        verify(felineMock, times(1)).getKittens();
    }

    @Test
    void getKittensUsesInjectedFeline() {
        Feline felineMock = mock(Feline.class);
        when(felineMock.getKittens()).thenReturn(5); // Проверяем с другим значением

        Cat cat = new Cat(felineMock);

        assertEquals(5, cat.getKittens());
        verify(felineMock, times(1)).getKittens();
    }
}