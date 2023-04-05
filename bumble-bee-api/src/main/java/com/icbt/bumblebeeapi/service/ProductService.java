package com.icbt.bumblebeeapi.service;

import com.icbt.bumblebeeapi.dto.ProductDTO;
import com.icbt.bumblebeeapi.entity.Product;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */

public interface ProductService {
    String save(ProductDTO dto);
    List<ProductDTO> search(int id);
    Boolean update(int id);
    Boolean delete(int id);
    List<ProductDTO> searchAll();


}
