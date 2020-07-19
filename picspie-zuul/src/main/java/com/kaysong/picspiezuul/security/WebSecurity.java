package com.kaysong.picspiezuul.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

  private final Environment environment;

  @Autowired
  public WebSecurity(Environment environment) {
    this.environment = environment;
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {

    http.csrf().disable();
    http.headers().frameOptions().disable();
    http.authorizeRequests().antMatchers(environment.getProperty("api.user.actuator")).permitAll()
        .antMatchers(environment.getProperty("api.zuul.actuator")).permitAll()
        .antMatchers(HttpMethod.POST, environment.getProperty("api.user.signin")).permitAll()
        .antMatchers(HttpMethod.POST, environment.getProperty("api.user.signup")).permitAll()
        .antMatchers(HttpMethod.GET, environment.getProperty("api.user.status")).permitAll()
        .antMatchers(HttpMethod.GET, environment.getProperty("api.post.status")).permitAll()
        .antMatchers(HttpMethod.GET, environment.getProperty("api.post.index")).permitAll()
        .antMatchers(HttpMethod.GET, environment.getProperty("api.comment.status")).permitAll()
        .antMatchers(HttpMethod.GET, environment.getProperty("api.comment.index")).permitAll().anyRequest()
        .authenticated().and().addFilter(new AuthorizationFilter(authenticationManager(), environment));

    http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

  }

}
