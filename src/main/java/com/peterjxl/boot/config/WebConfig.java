package com.peterjxl.boot.config;

import com.peterjxl.boot.bean.Pet2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.FormatterRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration(proxyBeanMethods = false)
public class WebConfig  {

    @Bean
    public HiddenHttpMethodFilter hiddenHttpMethodFilter() {
        HiddenHttpMethodFilter filter = new HiddenHttpMethodFilter();
        filter.setMethodParam("_m");
        return filter;
    }

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            //配置路径参数的分隔符
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper urlPathHelper = new UrlPathHelper();
                //不移除；后面的内容。矩阵变量功能就可以生效
                urlPathHelper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(urlPathHelper);
            }

            @Override
            public void addFormatters(FormatterRegistry registry) {
                registry.addConverter(new Converter<String, Pet2>(){
                    @Override
                    public Pet2 convert(String source) {
                        //字符串：name,age
                        if(!StringUtils.isEmpty(source)) {
                            Pet2 pet2 = new Pet2();
                            String[] split = source.split(",");
                            pet2.setName(split[0]);
                            pet2.setAge(split[1]);
                            return pet2;
                        }
                        return null;
                    }
                });
            }
        };
    }
}
