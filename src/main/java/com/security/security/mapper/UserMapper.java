package com.security.security.mapper;

import com.security.security.model.User;
import com.security.security.model.dto.UserReqDTO;
import com.security.security.model.dto.UserRespDTO;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(UserReqDTO reqDTO) {
        return User.builder().username(reqDTO.getUserName()).email(reqDTO.getEmail()).build();
    }
    public UserRespDTO toRespDTO(User user){
        return UserRespDTO.builder().userName(user.getUsername()).email(user.getEmail()).build();
    }
}
