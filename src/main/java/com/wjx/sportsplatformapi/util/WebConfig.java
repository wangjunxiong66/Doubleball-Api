package com.wjx.sportsplatformapi.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author wjx
 * @version 1.0
 * @date 2020/10/10 下午3:54
 */
// 全局配置类--配置跨域请求
@Configuration
//public class WebConfig implements WebMvcConfigurer {    或者如下
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addCorsMappings(CorsRegistry corsRegistry){
        //设置允许跨域的路径，可以任意配置，可以具体到直接请求路径。
        corsRegistry.addMapping("/**")
                // 请求来源，允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，可以指定IP地址和端口，也可以指定域名，
                // 如 allowedOrigins("http://192.168.0.0:8080","http://192.168.0.1:8081") ，或者 allowedOrigins("http://www.baidu.com")，只有百度可以访问我们的跨域资源。
                .allowedOrigins("*")
                //  允许所有的请求方法访问该跨域资源服务器，如：HEAD、POST、GET、PUT、DELETE、OPTIONS等，如下所示，或者设置为 allowedMethods("*")
                .allowedMethods("GET","HEAD","POST","PUT","DELETE","OPTIONS")
                //  是否允许证书 不再默认开启
                .allowCredentials(true)
                //  跨域允许最大时间
                .maxAge(3600)
                //  允许所有的请求header访问，可以自定义设置任意请求头信息，如："X-YAUTH-TOKEN"
                .allowedHeaders("*");
    }

}
