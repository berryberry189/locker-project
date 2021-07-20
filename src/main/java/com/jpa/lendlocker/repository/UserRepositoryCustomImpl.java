package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.UserResponseDto;
import com.jpa.lendlocker.dto.UserSearchCondition;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.util.List;

import static com.jpa.lendlocker.entity.QUser.user;

public class UserRepositoryCustomImpl implements UserRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public UserRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<UserResponseDto> search(UserSearchCondition condition, Pageable pageable) {

       QueryResults<UserResponseDto> results = queryFactory
                .select(Projections.fields(
                        UserResponseDto.class,
                        user.userKey,
                        user.userId,
                        user.name,
                        user.mobile
                ))
                .from(user)
                //.where(allCheck(condition.getName(), condition.getUserId(), condition.getMobile()))
                .where(
                        nameLike(condition.getName()),
                        userIdEq(condition.getUserId()),
                        mobileEq(condition.getMobile())
                )
                .orderBy(user.userId.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<UserResponseDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    private Predicate allCheck(String name, String userId, String mobile){
        return nameLike(name).and(userIdEq(userId)).and(mobileEq(mobile));
    }

    private BooleanExpression nameLike(String name) {
        return name != null ? user.name.contains(name) : null;
    }

    private BooleanExpression userIdEq(String userId) {
        return userId != null ? user.userId.eq(userId) : null;
    }

    private BooleanExpression mobileEq(String mobile) {
        return mobile != null ? user.mobile.eq(mobile) : null;
    }


}
