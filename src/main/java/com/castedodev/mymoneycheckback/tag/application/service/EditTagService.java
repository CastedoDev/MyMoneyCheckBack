package com.castedodev.mymoneycheckback.tag.application.service;

import com.castedodev.mymoneycheckback.tag.application.ports.out.SaveTagPort;
import com.castedodev.mymoneycheckback.tag.domain.Tag;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

@Service
public class EditTagService {

    private final FindUserService findUserService;
    private final SaveTagPort saveTagPort;

    public EditTagService(FindUserService findUserService, SaveTagPort saveTagPort) {
        this.findUserService = findUserService;
        this.saveTagPort = saveTagPort;
    }

    public void invoke(Tag tag, String username) throws NotUserFound {
        String userId = findUserService.findByUsername(username).getId();
        saveTagPort.save(tag, userId);
    }

}
