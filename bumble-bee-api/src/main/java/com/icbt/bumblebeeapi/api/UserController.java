package com.icbt.bumblebeeapi.api;
/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/2/2023
 */

import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.service.UserService;
import com.icbt.bumblebeeapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,}, produces = {MediaType.APPLICATION_JSON_VALUE,})
    public ResponseEntity<StandardResponse> saveUser(@RequestBody UserDTO dto) {
        System.out.println(dto.toString());
        String userName = userService.SaveUser(dto);
        return new ResponseEntity(new StandardResponse(201, userName + ": Success added", true), HttpStatus.CREATED);
    }
}
