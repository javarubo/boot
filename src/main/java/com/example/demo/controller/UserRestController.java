package com.example.demo.controller;


import com.example.demo.exceptions.DuplicateDataException;
import com.example.demo.exceptions.ForbiddenException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.User;
import com.example.demo.model.dto.ChangeRequestDto;
import com.example.demo.model.dto.RecoveryRequestDto;
import com.example.demo.model.dto.VerifyRequestDto;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/v2/user")
@RestController

public class UserRestController {

    @Autowired
    UserService userService;

   /* @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity res() {

        User user = new User();
        user.setName("ruben");
        user.setSurname("khachatryan");

        return ResponseEntity.ok(user);
    }*/


    @RequestMapping(method = RequestMethod.POST, path = "/recovery")
    public ResponseEntity recovery(@RequestBody RecoveryRequestDto recoveryRequestDto) throws NotFoundException {

        userService.recovery(recoveryRequestDto);
        return ResponseEntity.ok().build();

    }


    @RequestMapping(method = RequestMethod.POST, path = "/signOn")
    public ResponseEntity signOn(@RequestBody User user) throws DuplicateDataException {

        userService.add(user);
        return ResponseEntity.ok().build();

    }


    @RequestMapping(method = RequestMethod.POST, path = "/verify")
    public ResponseEntity verify(@RequestBody VerifyRequestDto verifyRequestDto) throws NotFoundException, ForbiddenException {

        userService.verify(verifyRequestDto);
        return ResponseEntity.ok().build();

    }


    @RequestMapping(method = RequestMethod.POST, path = "/changepass")

    public ResponseEntity changepass(@RequestBody ChangeRequestDto changeRequestDto) throws NotFoundException, ForbiddenException {

        userService.changePass(changeRequestDto);
        return ResponseEntity.ok().build();

    }





            /*    @RequestMapping(method = RequestMethod.POST, path = "/test")
    public ResponseEntity sign(@RequestParam String username) {
        System.out.println(username);
        return ResponseEntity.ok().build();
    }
   */


   /* @RequestMapping(method = RequestMethod.POST, path = "/verify")
    public ResponseEntity ver(@RequestBody VerifyRequestDto verifyRequestDto) {
        System.out.println(verifyRequestDto);
        return ResponseEntity.ok().build();
    }*/


}