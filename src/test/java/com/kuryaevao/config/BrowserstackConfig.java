package com.kuryaevao.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:com/kuryaevao/config/browserstack.properties"})
public interface BrowserstackConfig extends Config {
    @Key("user")
    String user();

    @Key("key")
    String key();

    @Key("app")
    String app();

    @Key("baseUrl")
    String baseUrl();
}

