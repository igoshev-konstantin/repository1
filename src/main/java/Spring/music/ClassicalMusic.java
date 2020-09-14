package Spring.music;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Vengerian rapsody";
    }

    @Override
    public String setName() {
        return "Classic name";
    }
}
