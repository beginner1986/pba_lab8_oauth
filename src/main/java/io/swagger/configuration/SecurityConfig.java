package io.swagger.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class SecurityConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and().authorizeRequests()
                .antMatchers("/api/**")
                .access("#oauth2.hasScope('pba_user')")
                .anyRequest().permitAll();
    }

    @Override
    public void configure(ResourceServerSecurityConfigurer resource) {
        resource.tokenServices(defaultTokenServices());
    }

    @Bean
    JwtAccessTokenConverter jwtAccessTokenConverter() {
        JwtAccessTokenConverter jwtAccessTokenConverter = new JwtAccessTokenConverter();
        jwtAccessTokenConverter.setVerifierKey("-----BEGIN PUBLIC KEY-----\n" +
                "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAxBXKflInOIinBr2Y0rEB" +
                "9VkDp/+bzXMB0cPr94wLUsV2uY8wI0j2JormJmU2JlNWiIgnJFVNBzFhvOTT6eeR" +
                "L72+eKHWCiZz2FKEcjTTPt15Bdj78He5WLz3B5ezCvZMpYHbM8+NQ1wCkQt3G/ZL" +
                "txZ71hj60V0/RxXP1ltFScZ3IGFzNpI1nw11foQTzeOxmgYu0iuqIQXYBa6IpbBR" +
                "2VKcKXa9a4M4e2jB6FisfnEae701KhmjHMPo3pUwzRtrcSegBTmtECQaW66yJibX" +
                "saErLz4R0lElyjAg8uD4IZLrni26V12HqLerVY3guRm5U2s9U2HBDKVohD/fTTJ0" +
                "MwIDAQAB\n" +
                "-----END PUBLIC KEY-----");
        return jwtAccessTokenConverter;
    }

    @Bean
    public TokenStore tokenStore() {
        return new JwtTokenStore(jwtAccessTokenConverter());
    }

    @Bean
    @Primary
    public DefaultTokenServices defaultTokenServices() {
        DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
        defaultTokenServices.setTokenStore(tokenStore());
        return defaultTokenServices;
    }
}
