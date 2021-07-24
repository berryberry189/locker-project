package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LendResponseDto;
import com.jpa.lendlocker.dto.LendSearchCondition;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.enums.LendStatus;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Predicate;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.time.LocalDateTime;
import java.util.List;

import static com.jpa.lendlocker.entity.QLend.lend;
import static com.jpa.lendlocker.entity.QLocker.locker;
import static com.jpa.lendlocker.entity.QLockerArea.lockerArea;
import static com.jpa.lendlocker.entity.QUser.user;

public class LendRepositoryCustomImpl implements LendRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public LendRepositoryCustomImpl(EntityManager em) {
        this.queryFactory = new JPAQueryFactory(em);
    }

    /**
     * 대여 검색 조회
     * 검색 조건: 사용자id, 구역명, 대여 상태, 대여 기간
     * @param condition
     * @param pageable
     * @return
     */

    @Override
    public Page<LendResponseDto> search(LendSearchCondition condition, Pageable pageable) {

        QueryResults<LendResponseDto> results = queryFactory
                .select(Projections.fields(
                        LendResponseDto.class,
                        user.userId,
                        lockerArea.id.as("areaId"),
                        lockerArea.name.as("areaName"),
                        locker.lockerId.lockerNo,
                        lend.hour,
                        lend.price,
                        lend.status,
                        lend.lendDate
                        ))
                .from(lend)
                .innerJoin(lend.user, user)
                .innerJoin(lend.locker.area, lockerArea)
                .innerJoin(lend.locker, locker)
                .where(
                    userIdEq(condition.getUserId()),
                    areaNameEq(condition.getAreaName()),
                    statusEq(condition.getStatus()),
                    lendDateBetween(condition.getStartDateTime(), condition.getEndDateTime())
                )
                .orderBy(lend.id.asc(),
                        user.userId.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<LendResponseDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    @Override
    public Boolean checkDuplication(LockerId lockerId) {
        Long count = queryFactory
                .select(lend.count())
                .from(lend)
                .where(
                       lockerIdEq(lockerId),
                       lend.status.eq(LendStatus.valueOf("LEND"))
                )
                .fetchCount();

        return (count == 0 ? true : false);
    }

    private BooleanExpression lockerIdEq(LockerId lockerId) {
        return lockerId != null ? lend.locker.lockerId.eq(lockerId) : null;
    }

    private BooleanExpression userIdEq(String userId) {
        return userId != null ? user.userId.eq(userId) : null;
    }

    private BooleanExpression areaNameEq(String areaName) {
        return areaName != null ? lockerArea.name.eq(areaName) : null;
    }

    private BooleanExpression statusEq(LendStatus status) {
        return status != null ? lend.status.eq(status) : null;
    }

    private BooleanExpression lendDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        return (startDateTime != null) || (endDateTime != null) ?  lend.lendDate.between(startDateTime, endDateTime): null;
    }
}
