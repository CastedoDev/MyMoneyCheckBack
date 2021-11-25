package com.castedodev.mymoneycheckback.tag.adapters.out.persistence;

import com.castedodev.mymoneycheckback.tag.application.ports.out.DeleteTagPort;
import com.castedodev.mymoneycheckback.tag.application.ports.out.FindTagByIdPort;
import com.castedodev.mymoneycheckback.tag.application.ports.out.SaveTagPort;
import com.castedodev.mymoneycheckback.tag.domain.Tag;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Component
public class ImplPersistenceTag implements SaveTagPort, DeleteTagPort, FindTagByIdPort {

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

    @Override
    public Optional<Tag> findById(String tagId) {
        Optional<TagEntity> tagEntity = repository.findById(tagId);
        if(tagEntity.isPresent()){
            Tag tag = new Tag(tagEntity.get().getId(), tagEntity.get().getName());
            return Optional.of(tag);
        }
        return Optional.empty();
    }
}

