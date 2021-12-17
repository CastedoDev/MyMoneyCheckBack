package com.castedodev.mymoneycheckback.operation.application.ports.out;

import com.castedodev.mymoneycheckback.operation.domain.Operation;
import java.util.List;

public interface FindByDaysPort {

    List<Operation> findByDays(Integer days, String userId);

}
