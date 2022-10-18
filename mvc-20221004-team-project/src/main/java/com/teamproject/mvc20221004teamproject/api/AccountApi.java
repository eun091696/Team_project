package com.teamproject.mvc20221004teamproject.api;

import com.teamproject.mvc20221004teamproject.dto.CMRespDto;
import com.teamproject.mvc20221004teamproject.dto.LoginReqDto;
import com.teamproject.mvc20221004teamproject.dto.JoinDto;
import com.teamproject.mvc20221004teamproject.dto.validation.ValidationSequence;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/account")
@RestController
public class AccountApi {

    @PostMapping("/login")
    public ResponseEntity<?>login(@Valid @RequestBody LoginReqDto loginReqDto, BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<String, String>();

            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for(FieldError fieldError : fieldErrors) {
                System.out.println("필드명: " + fieldError.getField());
                System.out.println("에러 메세지: " + fieldError.getDefaultMessage());
                errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMap);
        }

        return ResponseEntity.ok().body(null);
    }

    @PostMapping("/join")
    public ResponseEntity<?>join(@Validated(ValidationSequence.class) @RequestBody JoinDto joinDto, BindingResult bindingResult) {
        return ResponseEntity.badRequest().body(new CMRespDto<>("회원가입 성공", joinDto));
    }

}
