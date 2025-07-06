package com.rsn.user.accounts.repository.impl;

import com.rsn.user.accounts.dto.SearchParamsDto;
import com.rsn.user.accounts.entities.User;
import com.rsn.user.accounts.repository.UserOperationRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static com.pioneer.test.task.users.accounts.constant.DaoConstants.*;


@Service
public class UserOperationRepositoryImpl implements UserOperationRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> searchUsersByParams(SearchParamsDto params) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cr = cb.createQuery(User.class);
        Root<User> root = cr.from(User.class);
        cr.select(root);
        List<Predicate> predicates = new ArrayList<Predicate>();

        if (params.getName() != null) {
            predicates.add(cb.like(root.get(NAME), String.format("%s%s", params.getName(), "%")));
        }
        if (params.getDateOfBirth() != null) {
            predicates.add(cb.greaterThan(root.<Date>get(DATE_OF_BIRTH), java.sql.Date.valueOf(params.getDateOfBirth())));
        }
        if (params.getPhone() != null) {
            Join<Object, Object> phonesJoin = root.join(PHONE_DATA_FIELD);
            predicates.add(cb.equal(phonesJoin.get(PHONE), params.getPhone()));
        }
        if (params.getEmail() != null) {
            Join<Object, Object> emailsJoin = root.join(EMAIL_DATA_FIELD);
            predicates.add(cb.equal(emailsJoin.get(EMAIL), params.getEmail()));
        }

        Predicate[] array = new Predicate[predicates.size()];
        predicates.toArray(array);
        cr.where(array);
        TypedQuery<User> query = em.createQuery(cr);
        if (params.getPage() != null) {
            if (params.getOffset() != null) {
                query.setFirstResult(params.getOffset() * params.getPage());
            }
            if (params.getSize() != null) {
                query.setMaxResults(params.getSize() * params.getPage());
            }
        }
        return query.getResultList();
    }
}
