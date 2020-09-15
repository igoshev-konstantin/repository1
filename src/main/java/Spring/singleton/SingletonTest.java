package Spring.singleton;

class StartTest {
    public static void main(String[] args) {
        SingletonTest s = SingletonTest.getSingleton();
        SingletonTest2 s2 = SingletonTest2.INSTANCE;
    }
}


class SingletonTest {
    private static SingletonTest singleton;

    protected SingletonTest() {}

    public static SingletonTest getSingleton() {
        if (singleton == null) {
            return new SingletonTest();
        }
        return singleton;
    }
}

class SingletonTest2 {
    public static final SingletonTest2 INSTANCE = new SingletonTest2();
}

