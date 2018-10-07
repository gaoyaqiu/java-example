# build 镜像
```
./gradlew spring-boot-jpa-example:buildImage -Pdocker_repo=registry.cn-shanghai.aliyuncs.com/gaoyaqiu/spring-boot-jpa-example -x test

```

# 运行测试
```
docker run -e "SPRING_PROFILES_ACTIVE=local" -e "JAVA_OPTS=-server -Xms256M -Xmx256M" -p 8084:8084 -t [imageId]
--name [别名]
```

