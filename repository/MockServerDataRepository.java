package org.testsigma.mock_server_api.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.testsigma.mock_server_api.model.MockServerData;

import java.util.Optional;

public interface MockServerDataRepository extends JpaRepository<MockServerData, Long> {
    MockServerData findByUrlAndMethodType(String url, String methodType);
}

