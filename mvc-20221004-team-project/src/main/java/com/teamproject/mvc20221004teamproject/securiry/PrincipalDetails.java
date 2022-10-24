package com.teamproject.mvc20221004teamproject.securiry;

import com.teamproject.mvc20221004teamproject.domain.User;
import com.teamproject.mvc20221004teamproject.exception.CustomInternalServerException;
import com.teamproject.mvc20221004teamproject.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.extern.slf4j.XSlf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PrincipalDetails implements UserDetailsService {

    User user = null;

    private final AccountRepository accountRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            user = accountRepository.findUserByUserName(username);
            if(user == null) {
                throw new UsernameNotFoundException("잘못된 사용자 정보");
            }
        } catch (Exception e) {
            throw new CustomInternalServerException("회원 정보 조회 오류");
        }
        return null;
    }
}
