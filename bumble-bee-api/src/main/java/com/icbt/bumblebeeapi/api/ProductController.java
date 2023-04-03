package com.icbt.bumblebeeapi.api;

import com.icbt.bumblebeeapi.dto.ProductDTO;
import com.icbt.bumblebeeapi.service.ProductService;
import com.icbt.bumblebeeapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
@RestController
@RequestMapping("api/v1/product")
@CrossOrigin
public class ProductController {
    @Autowired
    ProductService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,}, produces = {MediaType.APPLICATION_JSON_VALUE,})
    public ResponseEntity<StandardResponse> saveProduct(@RequestBody ProductDTO dto) {
        String name = service.save(dto);
        return new ResponseEntity(new StandardResponse(201, name + ": Success added", true), HttpStatus.CREATED);
    }
}
