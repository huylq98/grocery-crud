package vn.com.huylq.grocerycrudbe.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import vn.com.huylq.grocerycrudbe.dto.GrocerySearchCondition;
import vn.com.huylq.grocerycrudbe.entity.Grocery;
import vn.com.huylq.grocerycrudbe.service.GroceryService;

@RestController
@RequestMapping("/groceries")
@RequiredArgsConstructor
public class GroceryController {

    private final GroceryService groceryService;

    @GetMapping
    public Page<Grocery> searchGroceries(GrocerySearchCondition searchCondition, Pageable pageable) {
        return groceryService.search(searchCondition, pageable);
    }

    @GetMapping("/{id}")
    public Grocery getGrocery(@PathVariable("id") Long id) {
        return groceryService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Grocery createGrocery(@RequestBody Grocery grocery) {
        return groceryService.save(grocery);
    }

    @PutMapping("/{id}")
    public Grocery updateGrocery(@PathVariable("id") Long id, @RequestBody Grocery grocery) {
        return groceryService.save(id, grocery);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGrocery(@PathVariable("id") Long id) {
        groceryService.delete(id);
    }
}
