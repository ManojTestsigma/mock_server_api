package org.testsigma.mock_server_api.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "mock_server_data")
public class MockServerData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String url;
    private String methodType;
    private String responseBody;
    private int statusCode;
    private String tenantID;
}
