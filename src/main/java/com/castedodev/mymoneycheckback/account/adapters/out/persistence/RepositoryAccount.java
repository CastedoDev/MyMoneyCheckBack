package com.castedodev.mymoneycheckback.account.adapters.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryAccount extends JpaRepository<AccountEntity, String> {
}
