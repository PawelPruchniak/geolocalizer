package pp.geolocalizer.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure( AuthenticationManagerBuilder aAuth ) throws Exception {

        aAuth
                .inMemoryAuthentication()
                .withUser( "user" )
                .password( "{noop}user" )
                .roles( "USER" )
                .and()
                .withUser( "admin" )
                .password( "{noop}admin" )
                .roles( "USER", "ADMIN" );
    }

    @Override
    protected void configure( HttpSecurity aHttp ) throws Exception {

        aHttp.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers( HttpMethod.POST, "/device" ).hasRole( "ADMIN" )
                .and()
                .csrf()
                .disable();
    }
}