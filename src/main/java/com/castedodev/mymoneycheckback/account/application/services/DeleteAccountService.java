package com.castedodev.mymoneycheckback.account.application.services;

import com.castedodev.mymoneycheckback.account.application.ports.out.DeleteAccountPort;
import com.castedodev.mymoneycheckback.account.application.ports.out.SaveAccountPort;
import com.castedodev.mymoneycheckback.account.domain.Account;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

@Service
public class DeleteAccountService {

    private final DeleteAccountPort port;

    public DeleteAccountService(DeleteAccountPort port) {
        this.port = port;
    }

    public void invoke(String accountId) {
        port.delete(accountId);
    }
}
