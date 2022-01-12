package com.castedodev.mymoneycheckback.tag.application;

import com.castedodev.mymoneycheckback.tag.application.ports.out.SaveTagPort;
import com.castedodev.mymoneycheckback.tag.domain.Tag;
import com.castedodev.mymoneycheckback.tag.domain.TagRepository;
import com.castedodev.mymoneycheckback.user.application.services.FindUserService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.stereotype.Service;

@Service
public class EditTagService {

    private final FindUserService findUserService;
    private final TagRepository repository;

    public EditTagService(FindUserService findUserService, TagRepository repository) {
        this.findUserService = findUserService;
        this.repository = repository;
    }

    public void invoke(Tag tag, String username) throws NotUserFound {
        String userId = findUserService.findByUsername(username).getId();
        tag.setUserId(userId);
        repository.save(tag);
    }

}
