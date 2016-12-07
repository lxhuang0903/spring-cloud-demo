## Account Service

### Spring Cloud Config Client
    
    1. Config First Bootstrap : spring.cloud.config.uri
    2. Discovery First Bootstrap : 
       spring.cloud.config.discovery.enabled=true
       eureka.client.serviceUrl.defaultZone
    3. config client fail fast : spring.cloud.config.failFast=true
    4. Locating Remote Configuration Resources : spring.cloud.config.label=feature
