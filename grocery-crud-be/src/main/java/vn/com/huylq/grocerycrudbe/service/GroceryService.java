package vn.com.huylq.grocerycrudbe.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.com.huylq.grocerycrudbe.dto.GrocerySearchCondition;
import vn.com.huylq.grocerycrudbe.entity.Grocery;

public interface GroceryService {

    Page<Grocery> search(GrocerySearchCondition searchCondition, Pageable pageable);

    Grocery findById(Long id);

    Grocery save(Grocery grocery);

    Grocery save(Long id, Grocery grocery);

    void delete(Long id);
}
