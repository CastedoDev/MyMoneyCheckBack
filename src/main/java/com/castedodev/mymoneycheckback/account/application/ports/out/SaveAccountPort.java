package com.castedodev.mymoneycheckback.account.application.ports.out;

import com.castedodev.mymoneycheckback.account.domain.Account;

public interface SaveAccountPort {

    void save(Account account, String userId);

}
