package com.castedodev.mymoneycheckback.account.application.services;

import com.castedodev.mymoneycheckback.account.application.ports.out.SaveAccountPort;
import com.castedodev.mymoneycheckback.account.domain.Account;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

@Service
public class SaveAccountService {

    private final SaveAccountPort port;
    private final FindUserService findUserService;

    public SaveAccountService(SaveAccountPort port, FindUserService findUserService) {
        this.port = port;
        this.findUserService = findUserService;
    }

    public void invoke(Account account, String username) throws NotUserFound {
        String userId = findUserService.findByUsername(username).getId();
        port.save(account, userId);
    }
}
