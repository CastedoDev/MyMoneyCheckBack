package com.castedodev.mymoneycheckback.tag.application.ports.out;

import com.castedodev.mymoneycheckback.tag.domain.Tag;

import java.util.Optional;

public interface FindTagByIdPort {

    Optional<Tag> findById(String tagId);
}
