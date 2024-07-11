package org.testsigma.mock_server_api.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.testsigma.mock_server_api.service.MockServerService;

import java.util.Map;

@RestController
public class MockServerApiController {
    @Autowired
    private MockServerService mockServerService;

    @RequestMapping(value = "/**", method = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT,RequestMethod.PATCH})
    public ResponseEntity<String> handleAllRequest(
            HttpServletRequest request,
            @RequestBody(required = false) String body,
            @RequestParam Map<String, String> params,
            @RequestHeader Map<String, String> headers) {
        String url = request.getRequestURI();
        String method = request.getMethod();
        headers.put("url", url);
        headers.put("method", method);
        String response = mockServerService.getResponseForRequest(body, params, headers);

        HttpStatus status = mockServerService.getHttpStatusForRequest(body, params, headers);

        return new ResponseEntity<>(response, status);

    }


}
