package cn.zut.edu.logcol.logcollecttion;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("cn.zut.edu.logcol.logcollecttion.dao")
public class LogcollecttionApplication {

    public static void main(String[] args) {
        SpringApplication.run(LogcollecttionApplication.class, args);
    }

}
