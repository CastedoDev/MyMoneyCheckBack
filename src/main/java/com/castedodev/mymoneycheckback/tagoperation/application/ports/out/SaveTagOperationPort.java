package com.castedodev.mymoneycheckback.tagoperation.application.ports.out;

import com.castedodev.mymoneycheckback.tagoperation.domain.TagOperation;

public interface SaveTagOperationPort {

    void save(TagOperation tagoperation);

}
