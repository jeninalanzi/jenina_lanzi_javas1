package com.company.JeninaLanziU1Capstone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder authBuilder) throws Exception {
        PasswordEncoder encoder = new BCryptPasswordEncoder();

        authBuilder.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from users where username = ?")
                .authoritiesByUsernameQuery("select username, authority from authorities where username = ?")
                .passwordEncoder(encoder);
    }

    public void configure(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.httpBasic();

        httpSecurity.authorizeRequests()
            .mvcMatchers("/login").authenticated()

            // ALL STAFF: look up & create invoices
            .mvcMatchers(HttpMethod.GET, "/invoices/{id}").authenticated()
            .mvcMatchers(HttpMethod.GET, "/invoices").authenticated()
            .mvcMatchers(HttpMethod.POST, "/invoices").authenticated()
            .mvcMatchers(HttpMethod.POST, "/invoices").authenticated()

            // ALL STAFF: update a product & invoice
            .mvcMatchers(HttpMethod.PUT, "/consoles/{consoleId}").authenticated()
            .mvcMatchers(HttpMethod.PUT, "/games/{gameId}").authenticated()
            .mvcMatchers(HttpMethod.PUT, "/invoices/{id}").authenticated()
            .mvcMatchers(HttpMethod.PUT, "/tshirts/{teeId}").authenticated()

            // MGR+ADMIN: post new products, and delete invoices
            .mvcMatchers(HttpMethod.POST, "/consoles").hasAuthority("ROLE_MANAGER")
            .mvcMatchers(HttpMethod.POST, "/consoles").hasAuthority("ROLE_ADMIN")
            .mvcMatchers(HttpMethod.POST, "/games").hasAuthority("ROLE_MANAGER")
            .mvcMatchers(HttpMethod.POST, "/games").hasAuthority("ROLE_ADMIN")
            .mvcMatchers(HttpMethod.POST, "/tshirts").hasAuthority("ROLE_MANAGER")
            .mvcMatchers(HttpMethod.POST, "/tshirts").hasAuthority("ROLE_ADMIN")
            .mvcMatchers(HttpMethod.DELETE, "/invoices/{id}").hasAuthority("ROLE_MANAGER")
            .mvcMatchers(HttpMethod.DELETE, "/invoices/{id}").hasAuthority("ROLE_ADMIN")

            // ADMIN ONLY: delete a product
            .mvcMatchers(HttpMethod.DELETE, "consoles/{consoleId}").hasAuthority("ROLE_ADMIN")
            .mvcMatchers(HttpMethod.DELETE, "/games/{gameId}").hasAuthority("ROLE_ADMIN")
            .mvcMatchers(HttpMethod.DELETE, "/tshirts/{teeId}").hasAuthority("ROLE_ADMIN")

            // All get requests permitted by absolutely anyone.
            .anyRequest().permitAll();


        httpSecurity
                .logout()
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/allDone")
                .deleteCookies("JSESSIONID")
                .deleteCookies("XSRF-TOKEN")
                .invalidateHttpSession(true);

        httpSecurity
                .csrf()
                .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());



    }

}
