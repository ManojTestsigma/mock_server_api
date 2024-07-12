package org.testsigma.mockserver.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testsigma.mockserver.model.Configuration;
import org.testsigma.mockserver.service.ConfigurationService;
import org.testsigma.mockserver.service.DelayHandlerService;
import org.testsigma.mockserver.service.MockResponseBodyProcessorService;

import java.util.Map;

@RestController
@Log4j2
@RequiredArgsConstructor(onConstructor = @__({ @Autowired, @Lazy }))
public class MockController {

    private final ConfigurationService configurationService;
    private final MockResponseBodyProcessorService mockResponseBodyProcessorService;
    private final DelayHandlerService delayHandlerService;

    @RequestMapping(value = "/**", method = { RequestMethod.GET,
            RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT,RequestMethod.PATCH })
    public ResponseEntity<String> handleAllRequest(HttpServletRequest request,
                                                   @RequestBody(required = false) String body,
                                                   @RequestParam(required = false) Map<String, String> parameters) {
        log.debug("Handling mock server request {}", request);

        // get the configuration
        Configuration configuration = configurationService.getMockConfiguration(request, body);

        // get the res body and process
        String responseBody = configuration.getResponseBody();
        responseBody = mockResponseBodyProcessorService.process(responseBody);

        // handle delay
        delayHandlerService.handleDelay(parameters, configuration);

        return new ResponseEntity<>(responseBody, HttpStatusCode.valueOf(configuration.getStatusCode()));

    }


}
