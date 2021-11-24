package com.castedodev.mymoneycheckback.account.adapters.out.persistence;

import com.castedodev.mymoneycheckback.account.application.ports.out.DeleteAccountPort;
import com.castedodev.mymoneycheckback.account.application.ports.out.SaveAccountPort;
import com.castedodev.mymoneycheckback.account.domain.Account;
import org.springframework.stereotype.Component;

@Component
public class ImplPersistenceAccount implements SaveAccountPort, DeleteAccountPort {

    private final RepositoryAccount repository;

    public ImplPersistenceAccount(RepositoryAccount repository) {
        this.repository = repository;
    }

    @Override
    public void save(Account account, String userId) {
        AccountEntity accountEntity = new AccountEntity(account.getId(), account.getName(), userId);
        repository.save(accountEntity);
    }

    @Override
    public void delete(String accountId) {
        repository.deleteById(accountId);
    }
}
