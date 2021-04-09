# Enterprise Resource Planning


### Controller

```
Customer
Invoice

1) return all customers
   -> /api/v1/customers (GET)

2) get a customer by id
   ->JSON /api/v1/customers/{customer_id} (GET)
   ->XML  header -> accept=text/xml
   ->PDF
   ->JPG

3) find a customer by first name,last name,age
   -> /api/v1/customers?fname=X&lname=Y&age=14 (GET)

4) add a new customer
   -> /api/v1/customers (POST) body=CustInfo

5) update a customer
   -> /api/v1/customers/{cid} (PUT) replace (PATCH) partial

6) delete a customer
   -> /api/v1/customers/{cid} (DELETE)

7) get all invoices of a customer
   -> /api/v1/invoices?cid=12345 (GET)
   -> /api/v1/customers/{cid}/invoices


8) add an invoice to a customer
   -> /api/v1/invoices (POST) invoices{cid=1}
```   

## Service Layer

### Mapper

[Map Struct Polymorphism](https://stackoverflow.com/questions/39773923/mapstruct-generic-map-and-map-combined-list-of-children-objects)


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