package com.kuryaevao.config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:com/kuryaevao/config/local.properties"})
public interface LocalConfig extends Config {
    @Key("platformName")
    String platformName();

    @Key("deviceName")
    String deviceName();

    @Key("version")
    String version();

    @Key("baseUrl")
    String baseUrl();
}

