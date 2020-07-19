package com.kaysong.picspieauth.security;

import com.kaysong.picspieauth.services.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {

  @Autowired
  private UserService userService;

  @Autowired
  private Environment env;

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable(); // disable all CROS
    http.authorizeRequests().antMatchers("/**").hasIpAddress(env.getProperty("gateway.ip")).and()
        .addFilter(getAuthenticationFilter());
  }

  private AuthenticationFilter getAuthenticationFilter() throws Exception {
    AuthenticationFilter authenticationFilter = new AuthenticationFilter(userService, env, authenticationManager());
    authenticationFilter.setAuthenticationManager(authenticationManager());
    authenticationFilter.setFilterProcessesUrl(env.getProperty("signin.url.path")); // custom login URL
    return authenticationFilter;
  }

}