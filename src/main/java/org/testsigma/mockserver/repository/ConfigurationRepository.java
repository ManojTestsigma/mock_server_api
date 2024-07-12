package org.testsigma.mockserver.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.testsigma.mockserver.model.Configuration;

@Repository
@Transactional
public interface ConfigurationRepository extends JpaRepository<Configuration, Long> {

    Configuration findByUriPathAndMethodTypeAndRequestBody(String url, String methodType, String body);
}

