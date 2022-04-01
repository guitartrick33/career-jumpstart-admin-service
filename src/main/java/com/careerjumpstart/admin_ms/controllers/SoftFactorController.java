package com.careerjumpstart.admin_ms.controllers;

import com.careerjumpstart.admin_ms.models.QType;
import com.careerjumpstart.admin_ms.models.Question;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.service.SoftFactorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
@RequestMapping("/admin/softfactor")
public class SoftFactorController {

    private final SoftFactorService sfService;

    @PostMapping(path="/create")
    public SoftFactor save()
    {
        SoftFactor sf = new SoftFactor(1L,"Initial title");
        return sfService.createSF(sf);
    }
}
