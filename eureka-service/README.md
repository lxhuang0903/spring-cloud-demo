## Spring Cloud Eureka

### Build Eureka Server

1. add Eureka Dependency

            <dependency>
    			<groupId>org.springframework.cloud</groupId>
    			<artifactId>spring-cloud-starter-eureka-server</artifactId>
    		</dependency>
2. add @EnableEurekaServer to Bootstrap App

3. Standalone Mode
 
     server:
       port: 8761
     
     eureka:
       instance:
         hostname: localhost
       client:
         registerWithEureka: false
         fetchRegistry: false
         serviceUrl:
           defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/

4. Peer Awareness

###Resources
https://github.com/spring-cloud/spring-cloud-netflix/blob/master/spring-cloud-netflix-eureka-client/src/main/java/org/springframework/cloud/netflix/eureka/EurekaInstanceConfigBean.java
https://github.com/spring-cloud/spring-cloud-netflix/blob/master/spring-cloud-netflix-eureka-client/src/main/java/org/springframework/cloud/netflix/eureka/EurekaClientConfigBean.java
http://cloud.spring.io/spring-cloud-netflix/spring-cloud-netflix.html