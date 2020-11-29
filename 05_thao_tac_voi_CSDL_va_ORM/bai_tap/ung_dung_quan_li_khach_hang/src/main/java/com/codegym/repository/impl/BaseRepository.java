package com.codegym.repository.impl;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.io.File;

@Repository
public class BaseRepository {
    public static SessionFactory sessionFactory;
    public static EntityManager entityManager;

    static {
        try {
            sessionFactory = new Configuration()
                    .configure(new File("D:\\C0720G1_ThanhLuyen_module4\\05_thao_tac_voi_CSDL_va_ORM\\bai_tap\\ung_dung_quan_li_khach_hang\\src\\main\\java\\com\\codegym\\hibernate.conf.xml"))
                    .buildSessionFactory();
            entityManager = sessionFactory.createEntityManager();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }
}
