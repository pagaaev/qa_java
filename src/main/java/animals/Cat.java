package animals;
public class Cat {
    private final Feline feline;
    public Cat(Feline feline) {
        this.feline = feline;
    }
    public String getSound() {
        return "Мяу";
    }
    public int getKittens() {
        return feline.getKittens();
    }
}
