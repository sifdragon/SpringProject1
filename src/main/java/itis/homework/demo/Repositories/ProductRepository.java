package itis.homework.demo.Repositories;


import itis.homework.demo.Dto.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product, Long> {

    // SQL -> upper(name) like upper('%Ло%'), HQL -> upper(product.name) like concat('%', upper(:query), '%')
    @Query("from Product product where " +
            "(:available is null or :available = product.available) and " +
            "(upper(product.name) like concat('%', upper(:query), '%') or " +
            "upper(product.description) like concat('%', upper(:query), '%')) ")
    Page<Product> search(@Param("query") String query,
                         @Param("available") Boolean available,
                         Pageable pageable);
}

