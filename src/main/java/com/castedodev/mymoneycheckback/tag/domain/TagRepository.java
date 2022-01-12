package com.castedodev.mymoneycheckback.tag.domain;

import com.castedodev.mymoneycheckback.tag.adapters.out.persistence.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<Tag, String> {
}
