package com.castedodev.mymoneycheckback.tag.adapters.in.api;

import com.castedodev.mymoneycheckback.tag.application.service.RemoveTagService;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/tag" })
public class RemoveTagController {

    private final RemoveTagService service;

    public RemoveTagController(RemoveTagService service) {
        this.service = service;
    }

    @DeleteMapping
    public ResponseEntity<?> call(@RequestParam String id) {
        service.invoke(id);
        return ResponseEntity.accepted().build();
    }

}
