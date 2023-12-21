package vn.com.huylq.grocerycrudbe.service.impl;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.huylq.grocerycrudbe.dto.GrocerySearchCondition;
import vn.com.huylq.grocerycrudbe.entity.Grocery;
import vn.com.huylq.grocerycrudbe.repository.GroceryRepository;
import vn.com.huylq.grocerycrudbe.service.GroceryService;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Slf4j
public class GroceryServiceImpl implements GroceryService {

    private final GroceryRepository groceryRepository;

    @Override
    public Page<Grocery> search(GrocerySearchCondition searchCondition, Pageable pageable) {
        return groceryRepository.search(searchCondition, pageable);
    }

    @Override
    public Grocery findById(Long id) {
        return groceryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Grocery save(Grocery grocery) {
        return groceryRepository.save(grocery);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Grocery save(Long id, Grocery grocery) {
        if (!groceryRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        return groceryRepository.save(grocery);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        if (!groceryRepository.existsById(id)) {
            throw new EntityNotFoundException();
        }
        groceryRepository.deleteById(id);
    }
}
