package com.wjx.sportsplatformapi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@MapperScan
//		(1)作用：指定要变成实现类的接口所在的包，然后包下面的所有接口在编译之后都会生成相应的实现类
//		(2)添加位置：是在Springboot启动类上面添加，
//		(3)例如，添加@MapperScan(“com.winter.dao”)注解以后，com.winter.dao包下面的接口类，在编译之后都会生成相应的实现类。
//		(4)如果dao接口类没有在Spring Boot主程序可以扫描的包或者子包下面，可以使用如下方式进行配置：
//                @MapperScan({"com.kfit.*.mapper","org.kfit.*.mapper"})
//		(5)早点的时间是直接在Mapper类上面添加注解@Mapper，这种方式要求每一个mapper类都需要添加此注解，比较麻烦。现在通过使用@MapperScan可以指定要扫描的Mapper类的包的路径。
@MapperScan("com.wjx.sportsplatformapi.dao")
@SpringBootApplication
public class SportsplatformapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SportsplatformapiApplication.class, args);
	}

}
