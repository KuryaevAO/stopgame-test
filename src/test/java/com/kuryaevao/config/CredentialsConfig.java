package com.kuryaevao.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:com/kuryaevao/config/credentials.properties"})
public interface CredentialsConfig extends Config {
    String login();
    String password();
    String siteLogin();
    String sitePassword();
}
