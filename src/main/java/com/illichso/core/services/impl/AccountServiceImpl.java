package com.illichso.core.services.impl;

import com.illichso.core.models.entities.Account;
import com.illichso.core.models.entities.Blog;
import com.illichso.core.repositories.AccountRepo;
import com.illichso.core.repositories.BlogRepo;
import com.illichso.core.services.AccountService;
import com.illichso.core.services.exceptions.AccountDoesNotExistException;
import com.illichso.core.services.exceptions.AccountExistsException;
import com.illichso.core.services.exceptions.BlogExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepo accountRepo;

    @Autowired
    private BlogRepo blogRepo;

    @Override
    public Account findAccount(Long id) {
        return accountRepo.findAccount(id);
    }

    @Override
    public Account createAccount(Account data) {
        Account account = accountRepo.findAccountByName(data.getName());
        if(account != null)
        {
            throw new AccountExistsException();
        }
        return accountRepo.createAccount(data);
    }

    @Override
    public Blog createBlog(Long accountId, Blog data) {
        Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());

        if(blogSameTitle != null)
        {
            throw new BlogExistsException();
        }

        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }

        Blog createdBlog = blogRepo.createBlog(data);

        createdBlog.setOwner(account);

        return createdBlog;
    }

    @Override
    public com.illichso.core.services.util.BlogList findBlogsByAccount(Long accountId) {
        Account account = accountRepo.findAccount(accountId);
        if(account == null)
        {
            throw new AccountDoesNotExistException();
        }
        return new com.illichso.core.services.util.BlogList(blogRepo.findBlogsByAccount(accountId));
    }

    @Override
    public com.illichso.core.services.util.AccountList findAllAccounts() {
        return new com.illichso.core.services.util.AccountList(accountRepo.findAllAccounts());
    }

    @Override
    public Account findByAccountName(String name) {
        return accountRepo.findAccountByName(name);
    }
}
