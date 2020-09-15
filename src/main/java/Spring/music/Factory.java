package Spring.music;

enum MusicTypes {
    CLASSIC, ROCK, INSTRUMENTAL
}

public class Factory {
    private static Factory factory;

    private Factory() {
    }

    public static Factory getFactory(Factory factory){
        if(factory==null){
            return new Factory();
        }
        return factory;
    }

    public Music createMusic(MusicTypes musicTypes) {
        switch (musicTypes) {
            case CLASSIC:
                return new ClassicalMusic();
            case ROCK:
                return RockMusic.getRockMusic(null);
            case INSTRUMENTAL:
                //return new Instrumental();
                return Instrumental.getInstrumentalMusic();
        }
        return null;
    }


}
