package org.testsigma.mock_server_api.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.testsigma.mock_server_api.model.MockServerData;
import org.testsigma.mock_server_api.repository.MockServerDataRepository;

import java.util.List;
import java.util.Map;

@Service
public class MockServerService {
    @Autowired
    private MockServerDataRepository mockServerDataRepository;

    public MockServerData save(MockServerData mockServerData) {
        return mockServerDataRepository.save(mockServerData);
    }

    // body and params parameters are not used still i am sending it hoping it will be useful later...
    public String getResponseForRequest(String body, Map<String, String> params, Map<String, String> headers) {
        String url = headers.get("url");
        String methodType = headers.get("method");


        MockServerData data = mockServerDataRepository.findByUrlAndMethodType(url, methodType);
        if (data != null) {
            return data.getResponseBody();
        } else {
            return "No matching data found";
        }
    }

    public HttpStatus getHttpStatusForRequest(String body, Map<String, String> params, Map<String, String> headers) {
        String url = headers.get("url");
        String methodType = headers.get("method");

        MockServerData data = mockServerDataRepository.findByUrlAndMethodType(url, methodType);
        if (data != null) {
            return HttpStatus.valueOf(data.getStatusCode());
        } else {
            return HttpStatus.NOT_FOUND;
        }
    }
}
