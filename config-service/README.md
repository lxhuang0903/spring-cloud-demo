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
    
    d. encryption and decryption 
       
       install JCE
       add key to bootstrap.yml of config server
       
        encrypt:
          key: yourkey
    
       add config
        
         password: '{cipher}13b41ad240aaf1579b2291d373de802af6bcc5925396cdd0869db7ffc04dec83'
         
      - curl localhost:8888/encrypt -d mysecret
      - curl localhost:8888/decrypt -d 682bc583f4641835f
      - spring encrypt mysecret --key foo  
      - spring decrypt --key foo 682bc583f46418
       
    e. Pattern Matching and Multiple Repositories
    
           spring:
             cloud:
               config:
                 server:
                   git:
                     uri: https://github.com/spring-cloud-samples/config-repo
                     repos:
                       simple: https://github.com/simple/config-repo
                       special:
                         pattern: special*/dev*,*special*/dev*
                         uri: https://github.com/special/config-repo
                       local:
                         pattern: local*
                         uri: file:/home/configsvc/config-repo
       
    f. Overriding values of remote properties
       
           spring:
             cloud:
               config:
                 overrideNone: true
                 overrideSystemProperties: false
### Resources
https://springcloud.cc/spring-cloud-config-zhcn.html
                
    