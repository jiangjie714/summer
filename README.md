# summer
cloud code test

# jj-eureka-ha
Eureka 的HA： 通过类似于zookeeper 集群的形式相互发现，三个不一起启动的时候会报错，单依然可用
  配置文件中的 jie1 jie2 jie3 均为系统的host名称 对应的ip 127.0.0.1

# jj-session-share
该项目为我做测试spring-session和redis做 session共享的测试项目。

#jj-gateway-zuul
该项目为网关入口。配置文件中要注意：
zuul:
  add-host-header: true
  sensitive-headers:  （这里一定要不填写） 
默认源码里是这样写的：  
  private Set<String> sensitiveHeaders = new LinkedHashSet<>(
			Arrays.asList("Cookie", "Set-Cookie", "Authorization"));
 也就是说默认不写这里面就是 "Cookie", "Set-Cookie", "Authorization" Cookie和权限都被拦截。
 这里不要填写，然后将子包需要用到Session共享的request
 都得添加spring-session-data-redis 和 spring-boot-starter-data-redis
 然后 配置redis的信息。
  
  子包的启动主类必须加上 @EnableRedisHttpSession 标签 才可扫描并由spring-session接管request中的session。
  
  如何验证session 共享成功？ 你访问接口时，如果sessionid 是不变的  与 zuul上的测试sessionid 一致说明共享成功。
  feign中的session 共享也匹配成功。


#jj-rabbitmq
RabbitMQ的服务端，用springboot 写的，比较方便，比传统的配置XML文件形式舒服很多
#jj-rabbit-client
RabbitMQ的客户端，用例很简单。
本人测试用例运行在Windows 10上 1个服务端8万数据的发送，差不多5分钟，启了3个接收端差不多10分钟内完成，速度还是可以接受。

#关于 Ribbon 的项目暂时不想写
个人觉得不是特殊的项目需要运用到其他方式的负责均衡用feign就可以了。参考了很多国外的高手写的微服务，大多都直接上feign。

#关于 Hystrix的项目 没有整合好  hystrix-turbine-mq
如有其他问题或是关于技术的讨论可通过本人的邮箱联系 可能提Issues会比较慢回复。

#本人邮箱jiangjie714@163.com

