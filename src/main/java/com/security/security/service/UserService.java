package com.security.security.service;

import com.security.security.model.dto.UserReqDTO;
import com.security.security.model.dto.UserRespDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service

public interface UserService {
  //  List<UserRespDTO> findUsers();

  //  Optional<UserRespDTO> findUserById(Long userId);

    UserRespDTO createUser(UserReqDTO userReqDTO);
    public UserRespDTO createAdmin(UserReqDTO userReqDTO);

 //   UserRespDTO updateUser(Map<Object, Object> fields, Long userId);

 //   boolean deleteUser(Long userId);

 //   boolean activateUser(String activateCode);

  //  boolean requestChangePassword(String email);

   // boolean resetPassword(PasswordReqDTO password);
}
