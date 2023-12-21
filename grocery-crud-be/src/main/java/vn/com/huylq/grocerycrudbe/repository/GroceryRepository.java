package vn.com.huylq.grocerycrudbe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import vn.com.huylq.grocerycrudbe.dto.GrocerySearchCondition;
import vn.com.huylq.grocerycrudbe.entity.Grocery;

@Repository
public interface GroceryRepository extends JpaRepository<Grocery, Long> {

    @Query("select g from Grocery g " +
            "where (:#{#req.name} is null or g.name like %:#{#req.name}%) " +
            "and (:#{#req.fromPrice} is null or g.price >= :#{#req.fromPrice}) " +
            "and (:#{#req.toPrice} is null or g.price <= :#{#req.toPrice})")
    Page<Grocery> search(@Param("req") GrocerySearchCondition searchCondition, Pageable pageable);
}
