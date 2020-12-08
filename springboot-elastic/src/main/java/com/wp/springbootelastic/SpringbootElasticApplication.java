package com.wp.springbootelastic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * SpringBoot默认支持两种技术和ES交互
 * 1.JEST（默认不生效）
 * 需要导入响应的工具包
 * 2.SpringData ElasticSearch
 *      配置SpringBoot客户端
 * 3.要注意springboot和es的版本适配，版本不适配查看spring官方文档
 */

@EnableAsync        // 开启异步任务
@SpringBootApplication
public class SpringbootElasticApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootElasticApplication.class, args);
    }

}
