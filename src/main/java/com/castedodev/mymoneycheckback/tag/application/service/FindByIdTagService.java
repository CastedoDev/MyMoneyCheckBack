package com.castedodev.mymoneycheckback.tag.application.service;

import com.castedodev.mymoneycheckback.tag.application.ports.out.FindTagByIdPort;
import com.castedodev.mymoneycheckback.tag.domain.Tag;
import org.springframework.stereotype.Service;

@Service
public class FindByIdTagService {

    private final FindTagByIdPort findTagByIdPort;

    public FindByIdTagService(FindTagByIdPort findTagByIdPort) {
        this.findTagByIdPort = findTagByIdPort;
    }

    public Tag invoke(String tagId){
        return findTagByIdPort.findById(tagId).orElseThrow();
    }
}
