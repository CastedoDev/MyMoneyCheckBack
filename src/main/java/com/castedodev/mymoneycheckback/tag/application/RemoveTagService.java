package com.castedodev.mymoneycheckback.tag.application;

import com.castedodev.mymoneycheckback.tag.domain.TagRepository;
import org.springframework.stereotype.Service;

@Service
public class RemoveTagService {

    private final TagRepository repository;

    public RemoveTagService(TagRepository repository) {
        this.repository = repository;
    }

    public void invoke(String tagId) {
        repository.deleteById(tagId);
    }

}
