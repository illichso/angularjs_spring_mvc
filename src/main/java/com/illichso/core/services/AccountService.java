package com.illichso.core.services;

import com.illichso.core.models.entities.Account;
import com.illichso.core.models.entities.Blog;
import com.illichso.core.services.util.AccountList;
import com.illichso.core.services.util.BlogList;

public interface AccountService {
    Account findAccount(Long id);
    Account createAccount(Account data);
    Blog createBlog(Long accountId, Blog data);
    BlogList findBlogsByAccount(Long accountId);
    AccountList findAllAccounts();
    Account findByAccountName(String name);
}
