package com.castedodev.mymoneycheckback.tag.application;

import com.castedodev.mymoneycheckback.tag.domain.Tag;
import com.castedodev.mymoneycheckback.tag.domain.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class FindByIdTagService {

    private final TagRepository repository;

    public FindByIdTagService(TagRepository repository) {
        this.repository = repository;
    }

    public Tag invoke(String tagId){
        return repository.findById(tagId).orElseThrow();
    }
}
