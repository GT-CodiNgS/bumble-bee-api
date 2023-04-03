package com.icbt.bumblebeeapi.api;

import com.icbt.bumblebeeapi.service.AdminService;
import com.icbt.bumblebeeapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 4/3/2023
 */
@RestController
@RequestMapping("/api/v1/admin")
@CrossOrigin
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping(path = "/{username}/{password}")
    public ResponseEntity searchAdmin(@PathVariable String username, @PathVariable String password) {
        System.out.println("username = " + username+"password = " + password);
        Boolean isAuthenticated = adminService.searchUser(username, password);
        System.out.println("isAu = " + isAuthenticated);

        return new ResponseEntity(new StandardResponse(200, "Done",isAuthenticated), HttpStatus.OK);
    }

}
