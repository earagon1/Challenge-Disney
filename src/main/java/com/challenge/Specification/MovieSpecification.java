package com.challenge.Specification;

import com.challenge.DTO.MovieFiltersDTO;
import com.challenge.Entity.MovieEntity;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class MovieSpecification {

    public Specification<MovieEntity> getByFilters(MovieFiltersDTO filtersDTO){
        return (root,query,criteriaBuilder) ->{
            List<Predicate> predicates =new ArrayList<>();

            if(StringUtils.hasLength(filtersDTO.getTitle())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("titulo")),
                                "%" + filtersDTO.getTitle().toLowerCase() +"%"
                        )
                );
            }

           if(StringUtils.hasLength(filtersDTO.getGenreId().toString())){
                predicates.add(
                        criteriaBuilder.like(
                                criteriaBuilder.lower(root.get("edad")),
                                "%" + filtersDTO.getGenreId().toString().toLowerCase() +"%"
                        )
                );
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
