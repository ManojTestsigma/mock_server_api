package org.testsigma.mockserver.service;


import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.testsigma.mockserver.model.Configuration;
import org.testsigma.mockserver.repository.ConfigurationRepository;

import java.util.Map;

@Service
@Log4j2
@RequiredArgsConstructor(onConstructor = @__({ @Autowired, @Lazy}))
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public Configuration save(Configuration mockServerConfiguration) {
        return configurationRepository.save(mockServerConfiguration);
    }

    public Configuration getMockConfiguration(HttpServletRequest request, String body) {
        log.debug("Get Mock Configuration By Request {}", request);

        // prepare arguments
        String uri = request.getRequestURI();
        String method = request.getMethod();

        // get configuration from database
        return configurationRepository.findByUriPathAndMethodTypeAndRequestBody(uri, method, body);
    }

}
