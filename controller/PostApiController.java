package org.testsigma.mock_server_api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.testsigma.mock_server_api.model.MockServerData;
import org.testsigma.mock_server_api.service.MockServerService;

@RestController
@RequestMapping("/api")
public class PostApiController {
    @Autowired
    private MockServerService mockServerService;

    // post controller to save values into database
    @PostMapping("/config")
    public MockServerData postReceive(@RequestBody MockServerData mockServerData) {
        return mockServerService.save(mockServerData);
    }
}
