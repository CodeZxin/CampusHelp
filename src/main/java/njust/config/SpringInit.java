package njust.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInit extends AbstractAnnotationConfigDispatcherServletInitializer {

    //rootioc容器的配置类
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{DataSourceConfig.class, MapperConfig.class, ServiceConfig.class};
    }

    //webioc容器的配置类指定
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    //dispatcherServlet的拦截路径
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
