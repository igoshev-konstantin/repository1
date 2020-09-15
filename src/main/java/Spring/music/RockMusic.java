package Spring.music;

public class RockMusic implements Music {
    private RockMusic rockMusic;

    private RockMusic() {}

    public static RockMusic getRockMusic(Music music) {
        if (music == null) {
            return new RockMusic();
        }
        return (RockMusic) music;
    }

    @Override
    public String getSong() {
        return "Carry f**";
    }

    @Override
    public String setName() {
        return "RockMusic name";
    }
}
