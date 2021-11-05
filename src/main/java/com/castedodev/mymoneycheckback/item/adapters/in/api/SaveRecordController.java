package com.castedodev.mymoneycheckback.item.adapters.in.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping({ "/v1/item" })
public class SaveRecordController {

    @PostMapping
    public ResponseEntity<?> invoke(@RequestBody SaveRecordRequest){

    }

}
