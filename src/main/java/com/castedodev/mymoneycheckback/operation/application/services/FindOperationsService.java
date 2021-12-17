package com.castedodev.mymoneycheckback.operation.application.services;

import com.castedodev.mymoneycheckback.operation.application.ports.out.FindByDaysPort;
import com.castedodev.mymoneycheckback.operation.domain.Operation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FindOperationsService {

    private final FindByDaysPort findByDaysPort;

    public FindOperationsService(FindByDaysPort findByDaysPort) {
        this.findByDaysPort = findByDaysPort;
    }

    public List<Operation> invoke(Integer days, String userId){
        return findByDaysPort.findByDays(days, userId);
    }
}
