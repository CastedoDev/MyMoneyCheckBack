package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.FindByCriteriaOperationPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import com.castedodev.mymoneycheckback.operation.domain.OperationCriteria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindFilterOperationsService {

    private final FindByCriteriaOperationPort port;

    public FindFilterOperationsService(FindByCriteriaOperationPort port) {
        this.port = port;
    }

    public List<Operation> invoke(OperationCriteria criteria){
        return port.findByCriteria(criteria);
    }
}
