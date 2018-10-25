package com.example.springcloud.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;

public class OAuth2Config extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Override
    //覆盖configure()方法，定义了哪些客户端将注册到服务
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception{
        clients.inMemory()
                .withClient("eagleeye")//注册的应用程序名称
                .secret("thisissecret")//秘钥
                .authorizedGrantTypes("refresh_token","password","client_credentials")//授权类型
                .scopes("webclient","mobileclient");//定义访问令牌时可以操作的范围
    }
    @Override
    //定义了AuthorizationServerEndpointsConfigurer中使用的不同组件。
    //告诉spring使用spring提供的默认验证管理器和用户详细信息服务
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager)
                .userDetailsService(userDetailsService);
    }
}
