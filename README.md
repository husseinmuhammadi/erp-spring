# Enterprise Resource Planning

## Data Layer

### Testing a Module’s Data Layer with @DataJpaTest
Our data layer mainly contains our JPA entities and Spring Data repositories. 
Our testing efforts in this layer concentrate on testing the interaction between 
our repositories and the underlying database.  

Spring Boot provides the **@DataJpaTest** annotation to set up a stripped application context 
with only the beans needed for JPA, Hibernate and an embedded database.




### Reference Documentation

For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.4.3/maven-plugin/reference/html/#build-image)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data MongoDB](https://docs.spring.io/spring-boot/docs/2.4.3/reference/htmlsingle/#boot-features-mongodb)

### Guides

The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/bookmarks/)
* [Accessing Data with MongoDB](https://spring.io/guides/gs/accessing-data-mongodb/)

* [Testing vertical layer in spring boot](https://reflectoring.io/testing-verticals-and-layers-spring-boot/)