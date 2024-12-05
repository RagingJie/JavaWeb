package com.study.springboot;

import com.study.springboot.properties.DogProperties;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableConfigurationProperties(DogProperties.class)
@SpringBootApplication
public class SpringBootStudyApplication {

    public static void main(String[] args) {
//        SpringApplication.run(SpringBootStudyApplication.class, args);

//        SpringApplication application = new SpringApplication(SpringBootStudyApplication.class);
//        application.setBannerMode(Banner.Mode.CONSOLE); // 启动时不显示banner
//        application.run(args);


        SpringApplicationBuilder app = new SpringApplicationBuilder();
        app
            .sources(SpringBootStudyApplication.class)
            .bannerMode(Banner.Mode.OFF)
            .run(args);
    }


}
