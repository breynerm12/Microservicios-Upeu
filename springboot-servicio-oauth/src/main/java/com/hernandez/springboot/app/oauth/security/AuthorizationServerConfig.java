package com.hernandez.springboot.app.oauth.security;



import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;


@RefreshScope
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	 @Autowired
	    private Environment env;

	    @Autowired
	    private BCryptPasswordEncoder passwordEncoder;

	    @Autowired
	    private AuthenticationManager authenticationManager;

	   @Autowired
	    private InfoAdicionalToken infoAdicionaltoken;

	    @Override
	    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
	        TokenEnhancerChain tokenEnhancerChain = new TokenEnhancerChain();

	        tokenEnhancerChain.setTokenEnhancers(Arrays.asList(infoAdicionaltoken, accessTokenConverter()));

	        endpoints.authenticationManager(authenticationManager)
	            .tokenStore(tokenStore())
	            .accessTokenConverter(accessTokenConverter())
	            .tokenEnhancer(tokenEnhancerChain);
	    }

	 

	    @Bean
	    public JwtTokenStore tokenStore() {
	        return new JwtTokenStore(accessTokenConverter());
	    }

	    @Override
	    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
	        security.tokenKeyAccess("permitAll()")
	            .checkTokenAccess("isAuthenticated()");
	    }

	    @Override
	    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
	        clients.inMemory().withClient("front")
	                .secret(passwordEncoder.encode("12345"))
	                .scopes("read", "write")
	                .authorizedGrantTypes("password", "refresh_token")
	                .accessTokenValiditySeconds(3600)
	                .refreshTokenValiditySeconds(3600);
	    }

	    @Bean
	    public JwtAccessTokenConverter accessTokenConverter() {
	        JwtAccessTokenConverter tokenConverter = new JwtAccessTokenConverter();
	        tokenConverter.setSigningKey("Contraseña_sicret");
	        return tokenConverter;
	    }
	}

// no funciona con el boostrap