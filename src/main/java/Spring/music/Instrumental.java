package Spring.music;

public class Instrumental implements Music{

    private Instrumental() {}
    public static Instrumental getInstrumentalMusic(){
        return new Instrumental();
    }

    @Override
    public String getSong() {
        return "Instrumental song";
    }
    @Override
    public String setName() {
        return "Instrumental name";
    }
}
