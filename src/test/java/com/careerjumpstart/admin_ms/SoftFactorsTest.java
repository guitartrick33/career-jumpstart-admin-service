package com.careerjumpstart.admin_ms;
import com.careerjumpstart.admin_ms.models.SoftFactor;
import com.careerjumpstart.admin_ms.repository.SoftFactorRepo;
import com.careerjumpstart.admin_ms.service.SoftFactorServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SoftFactorsTest {
    @InjectMocks
    private SoftFactorServiceImpl service;

    @Mock
    private SoftFactorRepo repository;

    @Test
    void serviceCreated(){
        assertThat(service).isNotNull();
    }

    @Test
    void findById(){
        SoftFactor softFactor = createSoftFactor();
        when(repository.findSoftFactorById(softFactor.getId())).thenReturn(Optional.of(softFactor));
        Optional<SoftFactor> existingSoftFactor =service.findById(softFactor.getId());
        assertThat(existingSoftFactor).isEqualTo(Optional.of(softFactor));
    }

    @Test
    void findAllSoftFactors(){
        SoftFactor softFactor = createSoftFactor();
        when(repository.findAll()).thenReturn(List.of(softFactor));
        List<SoftFactor> existingSoftFactors = service.findAll();
        assertThat(existingSoftFactors).isEqualTo(List.of(softFactor));
    }


    private SoftFactor createSoftFactor(){
        String title = "test";
        SoftFactor softFactor = new SoftFactor();
        softFactor.setTitle(title);
        return  softFactor;
    }
}
