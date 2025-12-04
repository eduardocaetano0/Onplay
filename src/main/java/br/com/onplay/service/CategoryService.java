package br.com.onplay.service;

import br.com.onplay.entity.Category;
import br.com.onplay.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Optional<Category> findById(Long id) {
        return repository.findById(id);
    }

    public Category CreateCategory(Category category) {
        return repository.save(category);
    }

    public void deleteCategoryById(Long id) {
        repository.deleteById(id);
    }
}
