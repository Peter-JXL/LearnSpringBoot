package com.peterjxl.boot;

import ch.qos.logback.core.db.DBHelper;
import com.peterjxl.boot.bean.Pet;
import com.peterjxl.boot.bean.User;
import com.peterjxl.boot.config.MyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 主程序类
 * @SpringBootApplication 这是一个SpringBoot应用程序
 */
@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        // 1.返回IOC容器
        ConfigurableApplicationContext run = SpringApplication.run(MainApplication.class, args);

        // 2.查看容器里面的组件
        String[] names = run.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println(name);
        }

        // 3.从容器中获取组件
        Pet tom01 = run.getBean("tom", Pet.class);
        Pet tom02 = run.getBean("tom", Pet.class);
        System.out.println("组件：tom01 == tom02 :" + ( tom01 == tom02 ));    //运行结果：ture

        // 4.验证MyConfig类是否是单例的
        MyConfig bean = run.getBean(MyConfig.class);
        System.out.println(bean);    //com.peterjxl.boot.config.MyConfig$$EnhancerBySpringCGLIB$$fff9f8b1@415e0bcb
        User user = bean.user01();
        User user1 = bean.user01();
        System.out.println("组件：user == user1 :" + ( user == user1 ));    //运行结果：ture

        User user01 = run.getBean("user01", User.class);
        Pet tom = run.getBean("tom", Pet.class);
        System.out.println("组件：user01.getPet() == tom :" + ( user01.getPet() == tom ));    //运行结果：ture

        // @Import注解
        System.out.println("=========");
        String[] beanNamesForType = run.getBeanNamesForType(User.class);
        for (String s : beanNamesForType) {
            System.out.println(s);
        }

        DBHelper bean1 = run.getBean(DBHelper.class);
        System.out.println(bean1);    //ch.qos.logback.core.db.DBHelper@7e0babb4
    }
}
