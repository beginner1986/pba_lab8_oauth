package io.swagger.api;

import io.swagger.DatabaseMock;
import io.swagger.model.CreateRequest;
import io.swagger.model.Error;
import java.util.UUID;
import io.swagger.model.UpdateRequest;
import io.swagger.model.UserListResponse;
import io.swagger.model.UserResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2020-12-05T10:37:58.829+01:00")

@Controller
public class UsersApiController implements UsersApi {
    private DatabaseMock databaseMock = new DatabaseMock();

    private static final Logger log = LoggerFactory.getLogger(UsersApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public UsersApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<UserResponse> createUser(@ApiParam(value = "User object that has to be added" ,required=true )  @Valid @RequestBody CreateRequest body) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(databaseMock.createUser(body));

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(@ApiParam(value = "",required=true) @PathVariable("id") UUID id) {
        databaseMock.deleteUser(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<UserListResponse> getAllUsers() {
        UserListResponse userListResponse = new UserListResponse();
        userListResponse.setUsersList(databaseMock.getAllUsers());

        return new ResponseEntity<UserListResponse>(userListResponse, HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> getUserById(@ApiParam(value = "",required=true) @PathVariable("id") UUID id) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(databaseMock.getUserById(id));

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

    public ResponseEntity<UserResponse> updateUser(@ApiParam(value = "",required=true) @PathVariable("id") UUID id,@ApiParam(value = "" ,required=true )  @Valid @RequestBody UpdateRequest body) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUser(databaseMock.updateUser(id, body));

        return new ResponseEntity<UserResponse>(userResponse, HttpStatus.OK);
    }

}
