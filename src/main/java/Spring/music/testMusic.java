package Spring.music;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

public class testMusic {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        test1(context);
//        test2(context);
//        test3(context);
//        test4(context);
        test5_SingletonPrototype(context);
        context.close();
    }

    private static void test1(ClassPathXmlApplicationContext context) {
        //Запуск Spring. На setMusic отправили Rock в конфиге, также в конфиге у конструктора изначально указана Classic
        MusicPlayer mp = context.getBean("MP", MusicPlayer.class);
        mp.playMusic(mp.getMusic());
    }

    private static void test2(ClassPathXmlApplicationContext context) {
        //Тут у конструктора только Classic
        MusicPlayer mpClassic = context.getBean("MP_Classic", MusicPlayer.class);
        mpClassic.playMusic(mpClassic.getMusic());
    }

    private static void test3(ClassPathXmlApplicationContext context) {
        //Тут у конструктора только Classic
        MusicPlayer mpClassic = context.getBean("MP_Classic2", MusicPlayer.class);
        mpClassic.playMusic(mpClassic.getMusic());
    }

    private static void test4(ClassPathXmlApplicationContext context) {
        //Запуск Spring. На setMusic отправили Rock в конфиге, также в конфиге у конструктора изначально указана Classic
        MusicPlayer mp = context.getBean("MultiMusicPlayer", MusicPlayer.class);
        mp.playMusicFromTheList(mp.getMusicList());
    }

    private static void test5_SingletonPrototype(ClassPathXmlApplicationContext context) {

        //scope="prototype"  using in context config

        MusicPlayer mp = context.getBean("MP", MusicPlayer.class);
        MusicPlayer mp2 = context.getBean("MP", MusicPlayer.class);
        mp.setVolume((byte) 10);
        mp2.setVolume((byte) 29);

        //testing singleton/prototype
        //equals -это сравнение по содержанию, а == -сравнение объектов
        boolean areEquals = mp.equals(mp2);
        boolean areEquals2 = mp == mp2;
        System.out.println(mp + " vol:" + mp.getVolume());
        System.out.println(mp2 + " vol:" + mp2.getVolume());
        System.out.println("Equals: " + areEquals + " " + areEquals2);

    }

    private static void playRockMusic(ClassPathXmlApplicationContext context) {
        Music music = context.getBean("RockMus", RockMusic.class);
        System.out.println("play rock song: " + music.getSong());

    }

    private static void playClassicMusic(ClassPathXmlApplicationContext context) {
        Music music = context.getBean("ClassicMus", ClassicalMusic.class);
        System.out.println("play classic song: " + music.getSong());

    }
}
