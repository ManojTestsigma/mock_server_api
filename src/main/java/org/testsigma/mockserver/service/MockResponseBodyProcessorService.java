package org.testsigma.mockserver.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.testsigma.mockserver.repository.ConfigurationRepository;

@Service
@Log4j2
@RequiredArgsConstructor(onConstructor = @__({ @Autowired, @Lazy}))
public class MockResponseBodyProcessorService {

    public String process(String body) {
        log.debug("Processing mocker server response body {}", body);
        return body;
    }

}
