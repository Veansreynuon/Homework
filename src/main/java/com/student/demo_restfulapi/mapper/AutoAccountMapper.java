package com.student.demo_restfulapi.mapper;

import com.student.demo_restfulapi.model.Account;
import com.student.demo_restfulapi.model.response.AccountResponse;
import com.student.demo_restfulapi.repository.AccountRepository;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AutoAccountMapper {
    List<AccountResponse> mapToAccountResponse(List<Account> accounts);
    List<Account>mapToAccount(List<AccountResponse>responses );
}
