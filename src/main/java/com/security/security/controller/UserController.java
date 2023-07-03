package com.security.security.controller;

import com.security.security.model.dto.UserReqDTO;
import com.security.security.model.dto.UserRespDTO;
import com.security.security.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("users/registration")
    public ResponseEntity<? super UserRespDTO> registrationUser(@Valid @RequestBody UserReqDTO userReqDTO,
                                                                BindingResult result) {
        if (result.hasErrors()) {
            return checkingErrorValidation(result);
        }
        UserRespDTO user = userService.createUser(userReqDTO);
        return ResponseEntity.status(201).body(user);
    }

    @PostMapping("users/registration/admin")
    public ResponseEntity<? super UserRespDTO> registrationAdmin(@Valid @RequestBody UserReqDTO userReqDTO,
                                                                BindingResult result) {
        if (result.hasErrors()) {
            return checkingErrorValidation(result);
        }
        UserRespDTO user = userService.createAdmin(userReqDTO);
        return ResponseEntity.status(201).body(user);
    }

    private ResponseEntity<? super UserRespDTO> checkingErrorValidation(BindingResult result) {
        Map<String, String> message = new HashMap<>();
        List<FieldError> fieldErrors = result.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            message.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}



