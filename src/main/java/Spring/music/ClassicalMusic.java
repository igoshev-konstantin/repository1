package Spring.music;

import org.springframework.beans.factory.InitializingBean;

public class ClassicalMusic implements Music {
    @Override
    public String getSong() {
        return "Vengerian rapsody";
    }

    @Override
    public String setName() {
        return getAnotherName();
    }

    private String getAnotherName() {
        return "Chaykovsky song";
    }

    public void InitBean() {
        setName();
        System.out.println("Classic: Init bean");
    }

    public void DestroyBean(){
        System.out.println("Classic: Destroy bean");
    }
}
