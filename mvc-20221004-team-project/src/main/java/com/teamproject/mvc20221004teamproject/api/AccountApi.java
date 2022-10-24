package com.teamproject.mvc20221004teamproject.api;

import com.teamproject.mvc20221004teamproject.aop.annotation.LogAspect;
import com.teamproject.mvc20221004teamproject.dto.CMRespDto;
import com.teamproject.mvc20221004teamproject.dto.LoginReqDto;
import com.teamproject.mvc20221004teamproject.dto.JoinDto;
import com.teamproject.mvc20221004teamproject.dto.validation.ValidationSequence;
import com.teamproject.mvc20221004teamproject.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RequestMapping("/api/account")
@RestController
@RequiredArgsConstructor
public class AccountApi {

    private final AccountService accountService;

    public String login(Model model,
                        @RequestParam @Nullable String username,
                        @RequestParam @Nullable String error) {
        model.addAttribute("username", username == null ? "" : username);
        model.addAttribute("error", error == null ? "" : error);
        return "account/login";
    }

    @LogAspect
    @PostMapping("/join")
    public ResponseEntity<?>join(@Validated(ValidationSequence.class) @RequestBody JoinDto joinDto, BindingResult bindingResult) throws Exception {
        accountService.duplicataEmail(joinDto);
        accountService.join(joinDto);
        return ResponseEntity.created(URI.create("/account/login")).body(new CMRespDto<>("회원가입 성공", joinDto.getUserName()));
    }

}
