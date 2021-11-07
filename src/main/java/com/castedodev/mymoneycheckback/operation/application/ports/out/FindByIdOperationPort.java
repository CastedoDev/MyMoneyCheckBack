package com.castedodev.mymoneycheckback.operation.application.ports.out;

import com.castedodev.mymoneycheckback.operation.domain.Operation;

import java.util.Optional;

public interface FindByIdOperationPort {

    Optional<Operation> findById(String id);

}
