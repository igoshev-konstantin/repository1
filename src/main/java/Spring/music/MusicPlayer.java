package Spring.music;

import org.springframework.context.annotation.Configuration;

import java.util.List;

public class MusicPlayer {
    private Music music;
    private List<Music> musicList;
    private String name = "default name";
    private byte volume = 100;

    //IoC
    public MusicPlayer(List<Music> music) {
        this.musicList = music;
    }

    public MusicPlayer(Music music) {
        this.music = music;
    }

    public MusicPlayer(List<Music> music, String name, byte volume) {
        this.musicList = music;
        this.name = name;
        this.volume = volume;
    }

    public MusicPlayer(Music music, String name, byte volume) {
        this.music = music;
        this.name = name;
        this.volume = volume;
    }

    public void playMusic(Music music) {
        System.out.println("played music: " + music.getSong() + " volume: " + volume + " name:" + name);
    }

    public void playMusicFromTheList(List<Music> musicList) {
        for (int i = 0; i < musicList.size() ; i++) {
            playMusic(musicList.get(i));
        }
    }

    public void setMusic(List<Music> music) {
        this.musicList = music;
    }

    public void setVolume(byte volume) {
        this.volume = volume;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Music> getMusicList(){
        return musicList;
    }

    public Music getMusic() {
        return music;
    }
}
