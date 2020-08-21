package com.pfano.springbootpart4;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .passwordEncoder(encoder)
                .withUser("Pfano02")
                .password(encoder.encode("@P@ssw0rd1"))
                .roles("USER");
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().authorizeRequests();
        http.authorizeRequests()
                .antMatchers("/user")
                .authenticated()
                .antMatchers("/user")
                .permitAll()
                .and()
                .httpBasic();
    }
}
