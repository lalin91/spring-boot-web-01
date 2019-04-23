package cn.lalin.springboot.config;

import cn.lalin.springboot.component.LoginHandlerInterceptor;
import cn.lalin.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * @author lalin
 * @date 2019/4/21 - 23:06
 */
//使用WebMvcConfigurerAdapter，可以扩张SpringMvc的功能
//@EnableWebMvc         不要接管SpringMvc
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        //浏览器发送lalin,请求来到 success
        registry.addViewController("/lalin").setViewName("success");
//        registry.addViewController("/login").setViewName("login");
//        registry.addViewController("/").setViewName("login");
//        registry.addViewController("/index.html").setViewName("login");
//        registry.addViewController("/main.html").setViewName("dashboard");
    }

    //所有的WebMvcConfigurerAdapter都会一起起作用
    //将组件注册在容器
    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter(){
            @Override
            public void addViewControllers(ViewControllerRegistry registry){
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }
            @Override
            public void addInterceptors(InterceptorRegistry registry){
                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/index.html","/","/user/login");
            }

        };
        return adapter;
    }

//    @Bean
//    public WebMvcConfigurer webMvcConfigurer(){
//        return new WebMvcConfigurer(){
//            //添加视图控制器配置默认的欢迎页
//            @Override
//            public void addViewControllers(ViewControllerRegistry registry) {
//                registry.addViewController("/").setViewName("main/login");
//                registry.addViewController("/index.html").setViewName("main/login");
//
//            }
//        };
//    }


    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
