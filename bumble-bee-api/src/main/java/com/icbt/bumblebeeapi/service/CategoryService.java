package com.icbt.bumblebeeapi.service;

import com.icbt.bumblebeeapi.dto.CategoryDTO;
import com.icbt.bumblebeeapi.dto.ProductDTO;
import com.icbt.bumblebeeapi.entity.Category;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
public interface CategoryService {
    String save(CategoryDTO category);
    List<CategoryDTO> search(int id);
    Boolean update(int id);
    Boolean delete(int id);
    List<CategoryDTO> searchAll();
}
