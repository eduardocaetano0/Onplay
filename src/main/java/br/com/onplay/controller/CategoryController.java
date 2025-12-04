package br.com.onplay.controller;

import br.com.onplay.controller.request.CategoryRequest;
import br.com.onplay.controller.response.CategoryResponse;
import br.com.onplay.entity.Category;
import br.com.onplay.mapper.CategoryMapper;
import br.com.onplay.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/onplay/category")
public class CategoryController {

    private final CategoryService  categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<CategoryResponse> categories = categoryService.findAll()
                .stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();

        return ResponseEntity.ok(categories);

    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id){
         return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.notFound().build());

    }

    @PostMapping
    public ResponseEntity<CategoryResponse> CreateCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category Createcategory = categoryService.CreateCategory(newCategory);
        return ResponseEntity.status(HttpStatus.CREATED).body(CategoryMapper.toCategoryResponse(Createcategory));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
