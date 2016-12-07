## Spring Cloud Config

### Spring Cloud Config Server
1. how to build config server
  
   add Spring Cloud config Server dependency
   
        <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-config-server</artifactId>
        </dependency>
        
   add @EnableConfigServer
 
2. configuration for config server
    a. git backend : 
       use remote git repository
            
            spring:
              cloud:
                config:
                  server:        
                    git:
                      uri: git@github.com:lxhuang0903/spring-cloud-demo.git
                      basedir: /Users/ychuang/session/config-tmp
                      search-paths: config-service/config-repo

            
       use local git repository
        
            spring:
              cloud:
                config:
                  server:        
                    git:
                      uri: file:///Users/ychuang/session/spring-cloud-demo/
                      search-paths: config-service/config-repo

    b. file system backend : 
        
            spring:
              cloud:
                config:
                  server:
                    native:
                      search-locations: file:///Users/ychuang/session/spring-cloud-demo/config-service/config-repo
              profiles:
                active: native
                
    c. sharing configuration with all applications
    
    
    
### Resources
https://springcloud.cc/spring-cloud-config-zhcn.html
                
    