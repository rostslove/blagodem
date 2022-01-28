package webproject.blagodem.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import webproject.blagodem.repo.UserRepo;
import webproject.blagodem.services.UserDetailServiceImpl;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserRepo userRepo;

    @Override
   protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/blagodem/choose","/blagodem/registration-disabled", "/blagodem/registration-volunteer").anonymous()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/blagodem/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/blagodem/main", true)
                .permitAll()
                .and()
                .logout().permitAll()
                .and()
                .rememberMe()
                .and()
                .httpBasic();
        http.csrf().disable();
        http.headers().frameOptions().disable();
    }
    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailServiceImpl(userRepo));
    }

}
