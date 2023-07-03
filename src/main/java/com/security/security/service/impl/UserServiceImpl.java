package com.security.security.service.impl;

import com.security.security.mapper.UserMapper;
import com.security.security.model.Role;
import com.security.security.model.User;
import com.security.security.model.dto.UserReqDTO;
import com.security.security.model.dto.UserRespDTO;
import com.security.security.repository.UserRepository;
import com.security.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;


    @Override
    public UserRespDTO createUser(UserReqDTO userReqDTO) {
        if (userRepository.findByUsernameOrEmail(userReqDTO.getUserName(), userReqDTO.getEmail()) != null) {
            throw new DuplicateKeyException("A user with the same username or email already exists");
        }
        User user = userMapper.toUser(userReqDTO);
        user.setRoles(Role.ROLE_USER);
        user.setPassword(passwordEncoder.encode(userReqDTO.getPassword()));
        userRepository.save(user);
        return userMapper.toRespDTO(user);
    }
    @Override
    public UserRespDTO createAdmin(UserReqDTO userReqDTO) {
        if (userRepository.findByUsernameOrEmail(userReqDTO.getUserName(), userReqDTO.getEmail()) != null) {
            throw new DuplicateKeyException("A user with the same username or email already exists");
        }
        User user = userMapper.toUser(userReqDTO);
        user.setRoles(Role.ROLE_ADMIN);
        user.setPassword(passwordEncoder.encode(userReqDTO.getPassword()));
        userRepository.save(user);
        return userMapper.toRespDTO(user);
    }
}
