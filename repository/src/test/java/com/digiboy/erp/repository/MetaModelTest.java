package com.digiboy.erp.repository;

import com.digiboy.erp.to.Product;
import com.google.common.collect.ImmutableSet;
import com.google.common.reflect.ClassPath;
import org.hibernate.boot.spi.MetadataBuildingContext;
import org.hibernate.cfg.BinderHelper;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.ApplicationContext;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.Metamodel;
import java.io.IOException;
import java.util.Arrays;

@DataJpaTest
class MetaModelTest {

    private Logger logger = LoggerFactory.getLogger(MetaModelTest.class);

    @Autowired
    private EntityManager em;

    @Test
    void name() {
        Metamodel metamodel = em.getMetamodel();
//        BinderHelper.buildAnyValue()
        logger.info("{}", metamodel);
    }

    @Test
    void name1() {
        Arrays.stream(Product.class.getPackage().getAnnotations()).forEach(a -> {
            logger.info("{}", a.annotationType());
        });
    }

    @Test
    void name2() throws IOException {
        ClassPath classPath = ClassPath.from(ApplicationContext.class.getClassLoader());

//        classPath.getTopLevelClassesRecursive("com.digiboy.erp")
//                .stream()
//                .filter(c -> c.getSimpleName().equals("package-info"))
//                .map(c -> c.load().getPackage().getAnnotation(PackageOwner.class))
//                .forEach(a -> System.out.println(a.owner()));

        ImmutableSet<ClassPath.ClassInfo> x = classPath.getTopLevelClassesRecursive("com.digiboy.erp.to");

        System.out.println(x.size());
    }
}
