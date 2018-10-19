# spring cloud 多模块项目Demo

参考博客https://blog.csdn.net/forezp/article/details/70148833 搭建，添加了hystrix、config的特殊配置。

## 需要的中间件服务
### docker 启动rabbitmq 
```shell
docker run -d -p 15672:15672 -p 5672:5672 --hostname=my-rabbitmq rabbitmq:3.7.3-management
```
默认账号密码是：guest/guest
### docker 启动zipkin (服务追踪)
```
docker run -d -p 9411:9411 openzipkin/zipkin
```

## Demo中一些组件的配置情况
### config-client
config-server: 配置中心
ribbon-client进行了配置客户端改造
将'ribbon-client-test.yml'拷贝到配置中心的git仓库中；

## 关于hytrix熔断的配置
在ribbon-client、feign-client配置文件中有详细的注释

## zipkin
feign-client接入了zipkin, 具体配置在其配置文件中