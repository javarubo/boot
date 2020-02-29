package com.example.demo.service.impl;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.dto.ChangeRequestDto;
import com.example.demo.model.dto.RecoveryRequestDto;
import com.example.demo.model.dto.VerifyRequestDto;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.Generator;
import com.example.demo.util.MailSenderClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private MailSenderClient mailSenderClient;


    @Override
    public void add(User user) throws DuplicateDataException {
        boolean exists = userRepository.existsByUsername(user.getUsername());

        DuplicateDataException.check(exists, "user.already.exist");


        user.setStatus(-1);
        user.setCode(Generator.randomString(5));
        userRepository.save(user);
        mailSenderClient.send("username", "verification", user.getCode());

    }

    @Override
    public void verify(VerifyRequestDto verifyRequestDto) throws NotFoundException, ForbiddenException {


        User user = userRepository.getByUsername(verifyRequestDto.getEmail());

        NotFoundException.check(user == null, "user.not.found");
        ForbiddenException.check(!user.getCode().equals(verifyRequestDto.getCode()), "verify.error");

        user.setStatus(0);
        userRepository.save(user);
    }

    @Override
    public void recovery(RecoveryRequestDto recoveryRequestDto) throws NotFoundException {


        User user = userRepository.getByUsername(recoveryRequestDto.getEmail());

        NotFoundException.check(user == null, "user.not.found");

        user.setStatus(-1);
        user.setCode(Generator.randomString(5));
        userRepository.save(user);
        mailSenderClient.send("username", "verification", user.getCode());
    }

    @Override
    public void changePass(ChangeRequestDto changeRequestDto) throws NotFoundException, ForbiddenException {


        User user = userRepository.getByUsername(changeRequestDto.getUsername());
        boolean exists = userRepository.existsByUsername(changeRequestDto.getUsername());

        NotFoundException.check(!exists, "username.not.found");
        ForbiddenException.check(!changeRequestDto.getChangedcode().equals(user.getCode()), "code.error");


        user.setPassword(changeRequestDto.getNewpassword());
        user.setStatus(0);
        userRepository.save(user);

    }

}
