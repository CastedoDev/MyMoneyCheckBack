package com.castedodev.mymoneycheckback.tag.application.ports.out;

import com.castedodev.mymoneycheckback.tag.domain.Tag;

public interface SaveTagPort {

    void save(Tag tag, String userId);
}
