package com.castedodev.mymoneycheckback.tag.adapters.in.api;

import com.castedodev.mymoneycheckback.config.jwt.JwtTokenUtil;
import com.castedodev.mymoneycheckback.tag.application.service.SaveTagService;
import com.castedodev.mymoneycheckback.tag.domain.Tag;
import com.castedodev.mymoneycheckback.user.domain.NotUserFound;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/tag" })
public class EditTagController {

    private final JwtTokenUtil jwtTokenUtil;
    private final SaveTagService service;

    public EditTagController(JwtTokenUtil jwtTokenUtil, SaveTagService service) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<?> call(@RequestHeader("Authorization") String token, @RequestBody Tag tagRequest) throws NotUserFound {
        String username = jwtTokenUtil.getUsernameFromToken(token);
        service.invoke(tagRequest, username);
        return ResponseEntity.accepted().build();
    }

}
