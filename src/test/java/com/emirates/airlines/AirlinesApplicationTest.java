
  package com.emirates.airlines;
  
  import static org.junit.jupiter.api.Assertions.*;
  
  import org.assertj.core.api.Assertions; import org.junit.jupiter.api.Test;
  import org.junit.jupiter.api.extension.ExtendWith; import
  org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.boot.test.context.SpringBootTest; import
  org.springframework.boot.test.mock.mockito.MockBean; import
  org.springframework.test.context.junit.jupiter.SpringExtension;
  
  import com.emirates.airlines.controller.FlightController;
  
  @ExtendWith(SpringExtension.class)
  
  @SpringBootTest class AirlinesApplicationTest {
  
  @Autowired FlightController flightController;
  
  @Test public void contextLoads() {
  
  }
  
  }
 