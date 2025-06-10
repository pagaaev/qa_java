package animals;
import java.util.List;
public class Lion {
    private final boolean hasMane;
    private final Feline feline;
    public Lion(String sex, Feline feline) throws Exception {
        if (!sex.equals("Male") && !sex.equals("Female")) {
            throw new Exception("Unknown sex");
        }
        this.hasMane = sex.equals("Male");
        this.feline = feline;
    }
    public boolean doesHaveMane() {
        return hasMane;
    }
    public int getKittens() {
        return feline.getKittens();
    }
    public List<String> getFood() throws Exception {
        return feline.eatMeat();
    }
}
