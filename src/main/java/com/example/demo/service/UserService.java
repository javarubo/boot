package com.example.demo.service;

import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.dto.ChangeRequestDto;
import com.example.demo.model.dto.RecoveryRequestDto;
import com.example.demo.model.dto.VerifyRequestDto;
import com.example.demo.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public interface UserService {





    void add(User user) throws DuplicateDataException;

    void verify(VerifyRequestDto verifyRequestDto) throws NotFoundException, ForbiddenException;

    void recovery(RecoveryRequestDto recoveryRequestDto) throws NotFoundException;

    void changePass(ChangeRequestDto changeRequestDto) throws NotFoundException, ForbiddenException;
}


