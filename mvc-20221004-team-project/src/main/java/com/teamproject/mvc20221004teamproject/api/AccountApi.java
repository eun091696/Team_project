package com.teamproject.mvc20221004teamproject.api;

import com.teamproject.mvc20221004teamproject.dto.LoginReqDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/account")
@RestController
public class AccountApi {

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginReqDto loginReqDto) {
        System.out.println("로그인 요청 데이터:" + loginReqDto);
        return null;
    }

}
