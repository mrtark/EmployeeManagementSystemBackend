package com.example.employee.auditing;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareI implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("MuratArık");
    }
}
