package cn.lalin.springboot.component;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @author lalin
 * @date 2019/4/22 - 23:49
 */
//可以再链接上携带区域信息
public class MyLocaleResolver implements LocaleResolver{
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String i18n_language = request.getParameter("i18n_language");
        Locale locale=Locale.getDefault();
        System.out.println("本地默认语言:"+locale);
        System.out.println("通过地址传递过来:"+i18n_language);
        if(!StringUtils.isEmpty(i18n_language)){
            String[] languagSplit= i18n_language.split("_");
            locale=new Locale(languagSplit[0],languagSplit[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
