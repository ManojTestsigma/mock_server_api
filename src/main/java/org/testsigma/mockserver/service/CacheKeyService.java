package org.testsigma.mockserver.service;

import org.springframework.stereotype.Service;

@Service
public class CacheKeyService {
    public String getCacheKey(String... components) {
        return String.join("_", components);
    }
}
