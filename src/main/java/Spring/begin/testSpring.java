package Spring.begin;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class testSpring {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        bean b = context.getBean("testBean",bean.class);
        System.out.println(b.getName());
        context.close();
    }
}
