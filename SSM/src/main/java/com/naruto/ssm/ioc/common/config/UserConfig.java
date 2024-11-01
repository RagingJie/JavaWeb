package com.naruto.ssm.ioc.common.config;

import com.naruto.ssm.ioc.dao.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author
 * @Date 2024/11/1 14:39
 * @Description:
 */
@Configuration
public class UserConfig {

    @Bean(name = "user", initMethod = "initUser", destroyMethod = "destroyUser")
    public User user() {
        return new User();
    }
}
