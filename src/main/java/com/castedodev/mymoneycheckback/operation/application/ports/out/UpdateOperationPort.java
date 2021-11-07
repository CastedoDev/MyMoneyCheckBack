package com.castedodev.mymoneycheckback.operation.application.ports.out;

import com.castedodev.mymoneycheckback.operation.domain.Operation;

public interface UpdateOperationPort {

    void update(Operation operation);
}
