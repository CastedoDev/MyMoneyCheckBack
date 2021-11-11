package com.castedodev.mymoneycheckback.tag.application.service;

import com.castedodev.mymoneycheckback.tag.application.ports.out.DeleteTagPort;
import com.castedodev.mymoneycheckback.tag.domain.Tag;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

@Service
public class RemoveTagService {

    private final DeleteTagPort deleteTagPort;

    public RemoveTagService(DeleteTagPort deleteTagPort) {
        this.deleteTagPort = deleteTagPort;
    }

    public void invoke(String tagId) {
        deleteTagPort.delete(tagId);
    }

}
