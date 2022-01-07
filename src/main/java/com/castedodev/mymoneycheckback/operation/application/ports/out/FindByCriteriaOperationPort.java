package com.castedodev.mymoneycheckback.operation.application.ports.out;

import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationCriteria;

import java.util.List;

public interface FindByCriteriaOperationPort {

    List<Operation> findByCriteria(OperationCriteria criteria);

}
