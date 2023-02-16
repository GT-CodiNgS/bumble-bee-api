package com.icbt.bumblebeeapi.service.impl;

import com.icbt.bumblebeeapi.dto.CategoryDTO;
import com.icbt.bumblebeeapi.dto.ProductDTO;
import com.icbt.bumblebeeapi.entity.Category;
import com.icbt.bumblebeeapi.entity.Product;
import com.icbt.bumblebeeapi.exception.ValidateException;
import com.icbt.bumblebeeapi.repo.ProductRepo;
import com.icbt.bumblebeeapi.service.ProductService;
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
public class ProductServiceImpl implements ProductService {
    @Autowired
    ModelMapper mapper;
    @Autowired
    ProductRepo repo;

    @Override
    public String save(ProductDTO dto) {
        if (!repo.findByName(dto.getName()).isEmpty()) {
            throw new ValidateException("Product is already exists");
        } else {
            String name = mapper.map(repo.save(mapper.map(dto, Product.class)), ProductDTO.class).getName();
            System.out.println(name);
            return name;
        }
    }

    @Override
    public List<ProductDTO> search(int id) {
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
    public List<ProductDTO> searchAll() {
        return null;
    }
}
