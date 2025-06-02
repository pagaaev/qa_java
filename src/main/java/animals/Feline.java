package animals;
import java.util.List;
public class Feline {
    public List<String> eatMeat() {
        return List.of("Животные", "Птицы", "Рыба");
    }
    public int getKittens() {
        return getKittens(1);
    }
    public int getKittens(int count) {
        return count;
    }
}
