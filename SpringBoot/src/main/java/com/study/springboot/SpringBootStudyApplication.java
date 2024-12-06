package com.study.springboot;

import com.study.springboot.properties.DogProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableAsync;


/**
 * @Profile() 环境隔离：
 * 1、定义环境： dev、test、prod；
 * 2、定义这个环境下生效哪些组件或者哪些配置？
 * 1）、生效哪些组件： 给组件 @Profile("dev")
 * 2）、生效哪些配置： application-{环境标识}.properties
 * 3、激活这个环境：这些组件和配置就会生效
 * 1）、application.properties:  配置项：spring.profiles.active=dev
 * 2）、命令行：java -jar xxx.jar --spring.profiles.active=dev
 * <p>
 * 注意：激活的配置优先级高于默认配置
 * 生效的配置 = 默认配置 + 激活的配置(profiles.active) +  包含的配置(profiles.include)
 */
//@EnableConfigurationProperties(DogProperties.class)
@EnableAsync   // 基于注解开启自动异步（多线程）
@Slf4j
@SpringBootApplication
public class SpringBootStudyApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootStudyApplication.class, args);

//        SpringApplication application = new SpringApplication(SpringBootStudyApplication.class);
//        application.setBannerMode(Banner.Mode.CONSOLE); // 启动时不显示banner
//        application.run(args);


        SpringApplicationBuilder app = new SpringApplicationBuilder();
        app.sources(SpringBootStudyApplication.class).bannerMode(Banner.Mode.OFF).run(args);
    }


    @Bean
    public CommandLineRunner commandLineRunner() {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                for (String arg : args) {
                    System.out.println("应用启动后，只执行一次" + arg);
                }

                log.info("commandLineRunner......run....");


                // 项目启动后，只执行一次
                // 适用项目启动后，执行一次的代码，比如：垃圾清理等
            }
        };
    }


}
