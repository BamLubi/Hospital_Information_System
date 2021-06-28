package edu.nchu.cloudhis;

import edu.nchu.cloudhis.utils.IdGen;
import edu.nchu.cloudhis.utils.SnowIdWorker;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableDiscoveryClient //允许其他服务来访问该服务
@MapperScan("edu.nchu.cloudhis.dao") //mybatis扫描dao的路径
@EnableCaching //启动spring的缓存框架
@EnableFeignClients //启动feign功能
@EnableTransactionManagement //自动装配事物管理器
public class ChargeServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChargeServerApplication.class, args);
    }

    /**
     * 注入service所需的idGen，这里采用雪花算法
     * @return
     */
    @Bean
    public IdGen<String> idGen(){
        return new SnowIdWorker(1,1);
    }
}
