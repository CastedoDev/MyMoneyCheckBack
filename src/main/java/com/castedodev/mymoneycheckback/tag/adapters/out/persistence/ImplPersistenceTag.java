package com.castedodev.mymoneycheckback.tag.adapters.out.persistence;

import com.castedodev.mymoneycheckback.tag.application.ports.out.DeleteTagPort;
import com.castedodev.mymoneycheckback.tag.application.ports.out.SaveTagPort;
import com.castedodev.mymoneycheckback.tag.domain.Tag;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ImplPersistenceTag implements SaveTagPort, DeleteTagPort {

    private final TagRepository repository;

    public ImplPersistenceTag(TagRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public void save(Tag tag, String userId) {
        TagEntity tagEntity = new TagEntity(tag.getId(), tag.getName(), userId);
        repository.save(tagEntity);
    }

    @Override
    public void delete(String id) {
        repository.deleteById(id);
    }
}

