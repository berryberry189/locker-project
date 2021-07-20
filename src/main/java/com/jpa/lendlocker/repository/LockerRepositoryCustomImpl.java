package com.jpa.lendlocker.repository;

import com.jpa.lendlocker.dto.LockerResponseDto;
import com.jpa.lendlocker.dto.LockerSearchCondition;
import com.jpa.lendlocker.entity.LockerId;
import com.jpa.lendlocker.enums.LockerType;
import com.querydsl.core.QueryResults;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;

import java.util.List;

import static com.jpa.lendlocker.entity.QLocker.locker;

public class LockerRepositoryCustomImpl implements LockerRepositoryCustom{

    private final JPAQueryFactory queryFactory;

    public LockerRepositoryCustomImpl(EntityManager em){
        queryFactory = new JPAQueryFactory(em);
    }

    @Override
    public Page<LockerResponseDto> search(LockerSearchCondition condition, Pageable pageable) {

        QueryResults<LockerResponseDto> results = queryFactory
                .select(Projections.fields(
                        LockerResponseDto.class,
                        locker.area.id,
                        locker.area.name,
                        locker.lockerId.lockerNo,
                        locker.type,
                        locker.price,
                        locker.useYn))
                .from(locker)
                .where(
                        lockerIdEq(condition.getAreaId(), condition.getLockerNo()),
                        typeEq(condition.getType()),
                        userYnEq(condition.getUseYn())
                )
                .orderBy(locker.lockerId.lockerNo.asc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<LockerResponseDto> content = results.getResults();
        long total = results.getTotal();

        return new PageImpl<>(content, pageable, total);
    }

    private BooleanExpression lockerIdEq(Long areaId,  Long lockerNo) {
        return (areaId != null) && (lockerNo != null) ? locker.lockerId.eq(new LockerId(areaId, lockerNo)) : null;
    }

    private BooleanExpression typeEq(LockerType type) {
        return type != null ? locker.type.eq(type) : null;
    }

    private BooleanExpression userYnEq(String useYn) {
        return useYn != null ? locker.useYn.eq(useYn) : null;
    }
}
