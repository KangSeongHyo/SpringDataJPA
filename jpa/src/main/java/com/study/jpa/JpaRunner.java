package com.study.jpa;
import org.hibernate.Session;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.annotation.Persistent;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContexts;
import javax.transaction.Transactional;

@Component
@Transactional
public class JpaRunner implements ApplicationRunner {

    @PersistenceContext
    EntityManager entityManager;
    // spring의 applicationContext 같은 것으로 JPA의 핵심적인 BEAN을 주입받을 수 있음

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Account account = new Account();
        account.setUsername("ksh");
        account.setPassword("pw");

        //entityManager.persist(account);
        // 데이터 베이스에 영속화(저장)

        Session session = entityManager.unwrap(Session.class);
        session.save(account);
        // 하이버네이트 기반 설정
    }
}
