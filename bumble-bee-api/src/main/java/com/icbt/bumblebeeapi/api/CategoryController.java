package com.icbt.bumblebeeapi.api;

import com.icbt.bumblebeeapi.dto.CategoryDTO;
import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.service.CategoryService;
import com.icbt.bumblebeeapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/17/2023
 */
@RestController
@RequestMapping("api/v1/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    CategoryService service;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,}, produces = {MediaType.APPLICATION_JSON_VALUE,})
    public ResponseEntity<StandardResponse> saveCategory(@RequestBody CategoryDTO dto) {

        String name = service.save(dto);
        return new ResponseEntity(new StandardResponse(201, name + ": Success added", true), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllCategory(){

        List<CategoryDTO> categoryDTOS = service.searchAll();
        return new ResponseEntity(new StandardResponse(200, ": Success", categoryDTOS), HttpStatus.OK);

    }


}
