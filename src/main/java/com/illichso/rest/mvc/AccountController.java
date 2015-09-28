package com.illichso.rest.mvc;

import com.illichso.core.entities.Account;
import com.illichso.core.entities.Blog;
import com.illichso.core.services.AccountService;
import com.illichso.core.services.exceptions.AccountDoesNotExistException;
import com.illichso.core.services.exceptions.AccountExistsException;
import com.illichso.core.services.exceptions.BlogExistsException;
import com.illichso.rest.exceptions.BadRequestException;
import com.illichso.rest.exceptions.ConflictException;
import com.illichso.rest.resources.AccountResource;
import com.illichso.rest.resources.BlogResource;
import com.illichso.rest.resources.asm.AccountResourceAsm;
import com.illichso.rest.resources.asm.BlogResourceAsm;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.net.URI;

@Controller
@RequestMapping("/rest/accounts")
public class AccountController {
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountResource> createAccount(
            @RequestBody AccountResource sentAccount
    ) {
        try {
            Account createdAccount = accountService.createAccount(sentAccount.toAccount());
            AccountResource res = new AccountResourceAsm().toResource(createdAccount);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);
        } catch(AccountExistsException exception) {
            throw new ConflictException(exception);
        }
    }

    @RequestMapping( value="/{accountId}",
            method = RequestMethod.GET)
    public ResponseEntity<AccountResource> getAccount(
            @PathVariable Long accountId
    ) {
        Account account = accountService.findAccount(accountId);
        if(account != null)
        {
            AccountResource res = new AccountResourceAsm().toResource(account);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value="/{accountId}/blogs",
            method = RequestMethod.POST)
    public ResponseEntity<BlogResource> createBlog(
            @PathVariable Long accountId,
            @RequestBody BlogResource res)
    {
        try {
            Blog createdBlog = accountService.createBlog(accountId, res.toBlog());
            BlogResource createdBlogRes = new BlogResourceAsm().toResource(createdBlog);
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(createdBlogRes.getLink("self").getHref()));
            return new ResponseEntity<>(createdBlogRes, headers, HttpStatus.CREATED);
        } catch(AccountDoesNotExistException exception) {
            throw new BadRequestException(exception);
        }catch (BlogExistsException exception){
            throw new ConflictException(exception);
        }
    }


}