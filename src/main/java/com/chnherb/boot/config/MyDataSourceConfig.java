package com.chnherb.boot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

@Deprecated
//@Configuration
public class MyDataSourceConfig {
    // 参考：org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.PooledDataSourceConfiguration
    // org.springframework.boot.autoconfigure.jdbc.DataSourceConfiguration.Hikari.dataSource
    // 默认配置：@ConditionalOnMissingBean(DataSource.class)
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() throws SQLException {
        DruidDataSource druidDataSource = new DruidDataSource();
//        druidDataSource.setUrl();
//        druidDataSource.setUsername();
//        druidDataSource.setPassword();

        // 开启 SQL监控 功能(http://localhost:8888/druid/sql.html)，否则不会监控到请求db的监控 + 防火墙
        // 参考：https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98#5-%E6%80%8E%E4%B9%88%E6%89%93%E5%BC%80druid%E7%9A%84%E7%9B%91%E6%8E%A7%E7%BB%9F%E8%AE%A1%E5%8A%9F%E8%83%BD
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    /**
     * 配置Druid的内置监控页面 https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98
     * 参考：https://github.com/alibaba/druid/wiki/%E9%85%8D%E7%BD%AE_StatViewServlet%E9%85%8D%E7%BD%AE
     * 访问：http://localhost:8888/druid
     * @return
     */
    @Bean
    public ServletRegistrationBean statViewServlet() {
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(statViewServlet, "/druid/*");
        return servletRegistrationBean;
    }

    /**
     * 配置 WebStatFilter
     * 参考：https://github.com/alibaba/druid/wiki/%E5%B8%B8%E8%A7%81%E9%97%AE%E9%A2%98#7-%E5%86%85%E7%BD%AE%E7%9B%91%E6%8E%A7%E4%B8%AD%E7%9A%84web%E5%92%8Cspring%E5%85%B3%E8%81%94%E7%9B%91%E6%8E%A7%E6%80%8E%E4%B9%88%E9%85%8D%E7%BD%AE
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        WebStatFilter webStatFilter = new WebStatFilter();
        FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<>(webStatFilter);
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }
}
