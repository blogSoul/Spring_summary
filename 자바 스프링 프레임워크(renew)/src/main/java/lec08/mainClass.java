package lec08;

import org.springframework.context.support.GenericXmlApplicationContext;

public class mainClass {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext("classpath:applicationContext.xml");

        InjectionBean injectionBean = ctx.getBean("injectionBean", InjectionBean.class);

        DependencyBean dependencyBean1 = ctx.getBean("dependencyBean", DependencyBean.class);

        DependencyBean dependencyBean2 = ctx.getBean("dependencyBean", DependencyBean.class);

        if(dependencyBean1.equals(dependencyBean2)){
            System.out.println("dependencyBean1 is same as dependencyBean2");
        } else {
            System.out.println("dependencyBean1 is different as dependencyBean2");
        }

        // bean을 그대로 사용시 Singleton으로 동일한 객체를 반환합니다.
        // bean을 scope="prototype" 으로 설정시 서로 다른 객체가 반환됩니다.
        ctx.close();
    }
}
