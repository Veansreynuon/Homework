package com.student.demo_restfulapi.controller;

import com.student.demo_restfulapi.mapper.AutoAccountMapper;
import com.student.demo_restfulapi.model.Account;
import com.student.demo_restfulapi.model.response.AccountResponse;
import com.student.demo_restfulapi.service.AccountService;
import com.student.demo_restfulapi.utils.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
//    inject account service
    final private AccountService accountService;
    final private AutoAccountMapper autoAccountMapper ;

    AccountController(AccountService accountService, AutoAccountMapper autoAccountMapper){
        this.accountService = accountService;
        this.autoAccountMapper=autoAccountMapper;
    }

    @GetMapping("/all-accounts")
    public Response<List<AccountResponse>> getAllAccounts(){
        try{
//            model-mapper, mapstruct
            List<Account> allAccount = accountService.getAllAccounts();
            List<AccountResponse> accountResponses = autoAccountMapper.mapToAccountResponse(allAccount);


//            HashMap<String , Object> response = new HashMap<>();
//            response.put("payload", accountResponses);
//            response.put("message", "Successfully retrieve all accounts info !");
//            response.put("status", HttpStatus.OK);


            return Response.<List<AccountResponse>>ok().setPayload(accountResponses).setMessage("successfully retrieved all accounts information");

        }catch (Exception ex){
            System.out.println("Something wrong"+ ex.getMessage());
            return Response.<List<AccountResponse>>exception().setMessage("Exception occurs! Failed to retrieved account information");
        }
    }
}
