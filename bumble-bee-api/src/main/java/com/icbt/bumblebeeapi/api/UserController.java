package com.icbt.bumblebeeapi.api;
/**
 * @author Gayas Thasmika <gayasthasmika.w@gmail.com>
 * @projectname bumble-bee-api
 * @since 2/2/2023
 */

import com.icbt.bumblebeeapi.dto.UserDTO;
import com.icbt.bumblebeeapi.entity.enums.Gender;
import com.icbt.bumblebeeapi.entity.enums.Type;
import com.icbt.bumblebeeapi.service.UserService;
import com.icbt.bumblebeeapi.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,}, produces = {MediaType.APPLICATION_JSON_VALUE,})
    public ResponseEntity<StandardResponse> saveUser(@RequestBody UserDTO dto, HttpServletRequest request) throws MessagingException, UnsupportedEncodingException {
        UserDTO userDTO = userService.save(dto,getSiteURL(request)+"api/v1/user");

        return new ResponseEntity(new StandardResponse(201, userDTO.getUserName() + ": Success added", userDTO), HttpStatus.CREATED);
    }
    private String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
    @GetMapping(path = "/{searchBy}/{value}")
    public ResponseEntity Search(@PathVariable("searchBy") Type searchBy, @PathVariable("value") String value) throws Exception {
        return new ResponseEntity(new StandardResponse(200, "Done", userService.search(searchBy, value)), HttpStatus.OK);

    }
    @DeleteMapping(path = "{id}")
    public ResponseEntity Delete(@PathVariable("id") int id){
        userService.Delete(id);
        return new ResponseEntity(new StandardResponse(200, "Done", true), HttpStatus.OK);

    }
    @GetMapping("/")
    public ResponseEntity<StandardResponse> getAllCustomers(){
        List<UserDTO> allCustomers = userService.getAllCustomers();
        return new ResponseEntity(new StandardResponse(200, "Done", allCustomers), HttpStatus.OK);
    }
    @GetMapping("/verify")
    public String verifyUser(@Param("code") String code) {

        if (userService.verify(code)) {
            return "verify_success";
        } else {
            return "verify_fail";
        }
    }

}
