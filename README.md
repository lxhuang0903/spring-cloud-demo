## Spring Cloud Demo

### Spring Cloud Dependency

  Add Spring Boot Dependency
  
      <parent>
          <groupId>org.springframework.boot</groupId>
          <artifactId>spring-boot-starter-parent</artifactId>
          <version>1.4.0.RELEASE</version>
      </parent>
  
  Add Spring Cloud Dependency
  
    <dependencyManagement>
      <dependencies>
          <dependency>
              <groupId>org.springframework.cloud</groupId>
              <artifactId>spring-cloud-dependencies</artifactId>
              <version>Camden.SR3</version>
              <type>pom</type>
              <scope>import</scope>
          </dependency>
      </dependencies>
    </dependencyManagement>


