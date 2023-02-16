package com.icbt.bumblebeeapi.service.impl;

import com.icbt.bumblebeeapi.dto.CategoryDTO;
import com.icbt.bumblebeeapi.entity.Category;
import com.icbt.bumblebeeapi.exception.ValidateException;
import com.icbt.bumblebeeapi.repo.CategoryRepo;
import com.icbt.bumblebeeapi.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo repo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public String save(CategoryDTO dto) {
        if (!repo.findByName(dto.getName()).isEmpty()) {
            throw new ValidateException("Category is already exists");
        } else {
            String name = mapper.map(repo.save(mapper.map(dto, Category.class)), CategoryDTO.class).getName();
            System.out.println(name);
            return name;
        }
    }

    @Override
    public List<CategoryDTO> search(int id) {
        return null;
    }

    @Override
    public Boolean update(int id) {
        return null;
    }

    @Override
    public Boolean delete(int id) {
        return null;
    }

    @Override
    public List<CategoryDTO> searchAll() {
        return null;
    }
}
