package com.student.demo_restfulapi.repository;

import com.student.demo_restfulapi.model.Account;
import com.student.demo_restfulapi.model.User;
import com.student.demo_restfulapi.model.UserAccount;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserRepository {

    @Result(column = "id", property = "userId")
    @Select("select * from users_tb")
    List<User> allUsers();
    List<User> findUserByUsername(String username);

    @Insert("insert into  users_tb ( username, gender, address)\n" +
            "values (#{user.username},#{user.gender},#{user.address})")
    int createNewUser(@Param("user") User user );


    int updateUser(User user);
    @Result(column = "id", property = "userId")
    @Select("select * from users_tb where id = #{id}")
    User findUserByID(int id);
    int removeUser(int id);


    @Results({
            @Result(column = "id", property = "userId"),
            @Result(column = "id" , property = "accounts", many = @Many (select = "findAccountByUserId"))
    })
    @Select("select * from users_tb")
    List<UserAccount> getAllUserAccounts();

    @Results({
            @Result( property = "accountName", column = "account_name"),
            @Result(property = "accountNumber", column = "account_no"),
            @Result(property = "transferLimit", column = "transfer_limit"),
            @Result(property = "password", column = "passcode"),
            @Result(property = "accountType", column = "account_type", one = @One(select ="com.student.demo_restfulapi.repository.AccountRepository.getAccountTypeByID"))
    })
    @Select("select * from user_account_tb\n" +
            "         inner join account_tb a on a.id = user_account_tb.account_id\n" +
            "         where user_id = #{id};")
    List<Account> findAccountByUserId(int id);
}
