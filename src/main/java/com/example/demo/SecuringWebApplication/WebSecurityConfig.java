package com.example.demo.SecuringWebApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
      .authorizeRequests()
        .antMatchers("/SecuringWebApplication", "/SecuringWebApplication/home").permitAll() // アクセス制限のないURL
        .anyRequest().authenticated()  // その他は認証済みでしかアクセスできない
        .and()
      .formLogin()
        .loginPage("/SecuringWebApplication/login") // ログイン画面もアクセス制限なし
        .permitAll()
        .and()
      .logout()
        .permitAll();
  }


  // SpringBootGuidesのやり方は非推奨らしいので、以下ページを参考にした。
  // https://qiita.com/ryotaro76/items/6c8405fada7a6fead7cc
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    // パスワード
    String password = passwordEncoder().encode("password");

    // インメモリの認証を行うための設定
    auth.inMemoryAuthentication()
        .passwordEncoder(passwordEncoder())
        .withUser("user").password(password).roles("USER");
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
  }
}