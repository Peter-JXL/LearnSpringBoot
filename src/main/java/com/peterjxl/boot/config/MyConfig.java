package com.peterjxl.boot.config;


import ch.qos.logback.core.db.DBHelper;
import com.peterjxl.boot.bean.Pet;
import com.peterjxl.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


/**
 * 1.配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2.配置类本身也是组件
 * 3.proxyBeanMethods:代理bean的方法
 *     Full(proxyBeanMethods = true)  代理bean的方法
 *     Lite(proxyBeanMethods = false)  不代理bean的方法
 *     组件依赖必须使用Full模式默认。其他默认是否Lite模式
*/
@Import({User.class, DBHelper.class})
@Configuration(proxyBeanMethods = false)
public class MyConfig {


    @Bean //给容器中添加组件，以方法名作为组件的id，返回类型就是组件类型，返回的值，就是组件在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan",18);
        // user组件依赖了pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }


    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
