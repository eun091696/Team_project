package com.teamproject.mvc20221004teamproject.service;

import com.teamproject.mvc20221004teamproject.domain.User;
import com.teamproject.mvc20221004teamproject.dto.JoinDto;
import com.teamproject.mvc20221004teamproject.exception.CustomValidationException;
import com.teamproject.mvc20221004teamproject.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService{

    private final AccountRepository accountRepository;

    @Override
    public void join(JoinDto joinDto) throws Exception {
        User user = accountRepository.findUserByUserName(joinDto.getUserName());
        if(user != null) {
            Map<String, String> errorMap = new HashMap<String, String>();
            errorMap.put("userName", "이미 사용중인 아이디입니다.");

            throw new CustomValidationException("Duplicate email", errorMap);
        }
    }

}
