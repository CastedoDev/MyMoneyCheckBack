package com.castedodev.mymoneycheckback.account.application.ports.out;

import com.castedodev.mymoneycheckback.account.domain.Account;

public interface DeleteAccountPort {

    void delete(String accountId);

}
