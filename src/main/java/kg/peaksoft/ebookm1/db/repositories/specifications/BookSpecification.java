package kg.peaksoft.ebookm1.db.repositories.specifications;

import kg.peaksoft.ebookm1.db.entities.others.Promocode;
import kg.peaksoft.ebookm1.db.enums.Genre;
import kg.peaksoft.ebookm1.db.enums.RequestStatus;
import kg.peaksoft.ebookm1.db.enums.TypeOfBook;
import kg.peaksoft.ebookm1.db.entities.book.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification  {

    public static Specification<Book> getFilter(Genre genre, TypeOfBook typeOfBook){
        return ((root, query, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            if (genre != null) {
              predicates.add(criteriaBuilder.equal(root.get("genre"),genre));
            }
            if (typeOfBook != null) {
                predicates.add(criteriaBuilder.equal(root.get("typeOfBook"),typeOfBook));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
    public static Specification<Promocode> getPromocode(String promoName){
        return ((root, query, criteriaBuilder) ->{
            List<Predicate> predicates = new ArrayList<>();
            if (promoName != null) {
                predicates.add(criteriaBuilder.equal(root.get("promoName"),promoName));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }

}
