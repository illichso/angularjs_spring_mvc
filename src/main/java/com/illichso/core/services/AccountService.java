package com.illichso.core.services;

import com.illichso.core.entities.Account;
import com.illichso.core.entities.Blog;

public interface AccountService {
    Account findAccount(Long id);
    Account createAccount(Account data);
    Blog createBlog(Long accountId, Blog data);
}