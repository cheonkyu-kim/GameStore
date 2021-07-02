package com.app.gamestore.core.domain.spec;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Predicate;

import com.app.gamestore.core.domain.entity.Game;

public class GameSpec {
    public enum SearchKey {
        TITLE("title"),
        PRICE("price");

        private final String value;

        SearchKey(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static Specification<Game> searchWith(Map<SearchKey, Object> searchKeyword) {
        return (Specification<Game>) ((root, query, builder) -> {
            List<Predicate> predicate = getPredicateWithKeyword(searchKeyword, root, builder);
            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

    public static Specification<Game> searchWith(Map<SearchKey, Object> searchKeyword, Pageable page) {
        return (Specification<Game>) ((root, query, builder) -> {
            List<Predicate> predicate = getPredicateWithKeyword(searchKeyword, root, builder);
            return builder.and(predicate.toArray(new Predicate[0]));
        });
    }

    private static List<Predicate> getPredicateWithKeyword(Map<SearchKey, Object> searchKeyword, Root<Game> root, CriteriaBuilder builder) {
        List<Predicate> predicate = new ArrayList<>();
        for (SearchKey key : searchKeyword.keySet()) {
            switch (key) {
                case TITLE:
                    predicate.add(
                        builder.equal(
                            root.get(key.value), searchKeyword.get(key)
                        )
                        // builder.like(root.get(key.value), "%" + searchKeyword.get(key) + "%")
                    );
                    break;
                case PRICE:
                    predicate.add(
                        builder.gt(
                            root.get(key.value), 0
                        )
                    );
                    break;
            }
        }
        return predicate;
    }
}
