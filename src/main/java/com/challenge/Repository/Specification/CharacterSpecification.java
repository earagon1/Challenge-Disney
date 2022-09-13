package com.challenge.Repository.Specification;

import com.challenge.DTO.CharacterFiltersDTO;
import com.challenge.Entity.CharacterEntity;
import com.challenge.Entity.MovieEntity;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharacterSpecification {

    public Specification<CharacterEntity> getByFilters(CharacterFiltersDTO filtersDTO){
        return (root,query,criteriaBuilder) ->{
            List<Predicate> predicates =new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getName())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("denominacion")),
                                "%" + filtersDTO.getName().toLowerCase() +"%"
                        )
                );
            }

           if(StringUtils.hasLength(filtersDTO.getAge().toString())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("edad")),
                                "%" + filtersDTO.getAge().toString().toLowerCase() +"%"
                        )
                );
            }

            if(!CollectionUtils.isEmpty(filtersDTO.getMovies())){
                Join<MovieEntity,CharacterEntity> join = root.join("movies", JoinType.INNER);
                Expression<String> moviesId = join.get("id");
                predicates.add(moviesId.in(filtersDTO.getMovies()));
            }

            query.distinct(true);

            String orderByField = "denominacion";
            query.orderBy(
                    filtersDTO.isASC() ?
                            criteriaBuilder.asc(root.get(orderByField)) :
                            criteriaBuilder.desc(root.get(orderByField))
            );
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
