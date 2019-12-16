package cn.zut.edu.logcol.logcollecttion.bean;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.springframework.data.hadoop.hbase.HbaseTemplate;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.Map;
import java.util.Set;

@Configuration
@EnableConfigurationProperties(HBaseProperties.class)
public class HBaseConfig {
    private final HBaseProperties properties;

    public HBaseConfig(HBaseProperties properties) {
        this.properties = properties;
    }

    @Bean
    public HbaseTemplate hbaseTemplate() {
        HbaseTemplate hbaseTemplate = new HbaseTemplate();
        hbaseTemplate.setConfiguration(configuration());
        hbaseTemplate.setAutoFlush(true);
        return hbaseTemplate;
    }

    public org.apache.hadoop.conf.Configuration configuration() {

        org.apache.hadoop.conf.Configuration configuration = HBaseConfiguration.create();

        Map<String, String> config = properties.getConfig();
        Set<String> keySet = config.keySet();
        for (String key : keySet) {
            configuration.set(key, config.get(key));
        }

        return configuration;
    }
}
