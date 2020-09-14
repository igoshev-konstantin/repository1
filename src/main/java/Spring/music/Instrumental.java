package Spring.music;

public class Instrumental implements Music{
    @Override
    public String getSong() {
        return "Instrumental song";
    }
    @Override
    public String setName() {
        return "Instrumental name";
    }
}
