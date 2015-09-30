package com.illichso.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import com.illichso.core.services.util.AccountList;
import com.illichso.rest.mvc.AccountController;
import com.illichso.rest.resources.AccountListResource;
import com.illichso.rest.resources.AccountResource;

import java.util.List;

public class AccountListResourceAsm extends ResourceAssemblerSupport<AccountList, AccountListResource> {


    public AccountListResourceAsm() {
        super(AccountController.class, AccountListResource.class);
    }

    @Override
    public AccountListResource toResource(AccountList accountList) {
        List<AccountResource> resList = new AccountResourceAsm().toResources(accountList.getAccounts());
        AccountListResource finalRes = new AccountListResource();
        finalRes.setAccounts(resList);
        return finalRes;
    }
}
