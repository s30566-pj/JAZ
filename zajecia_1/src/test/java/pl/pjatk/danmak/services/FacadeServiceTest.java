package pl.pjatk.danmak.services;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;
import pl.pjatk.danmak.interfaces.HandlerServiceInterface;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class FacadeServiceTest {
    @Mock
    private HandlerServiceInterface devService;
    @Mock
    private HandlerServiceInterface qaService;
    @Mock
    private HandlerServiceInterface prodService;
    @Mock
    private HandlerServiceInterface stagingService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        when(devService.returnCommunicate()).thenReturn("Hello from Dev");
        when(qaService.returnCommunicate()).thenReturn("Hello from Qa");
        when(prodService.returnCommunicate()).thenReturn("Hello from Prod");
        when(stagingService.returnCommunicate()).thenReturn("Hello from Staging");
    }

    @Test
    void shouldReturnDevMessage(){
        Map<String, HandlerServiceInterface> services = new HashMap<>();
        services.put("dev", devService);
        FacadeService facadeService = new FacadeService(services);
        ReflectionTestUtils.setField(facadeService,  "env", "dev");

        String result = facadeService.execute();

        assertThat(result).isNotNull().isEqualTo("Hello from Dev");
    }

    @Test
    void shouldReturnProdMessage(){
        Map<String, HandlerServiceInterface> services = new HashMap<>();
        services.put("prod", prodService);
        FacadeService facadeService = new FacadeService(services);
        ReflectionTestUtils.setField(facadeService,  "env", "prod");

        String result = facadeService.execute();

        assertThat(result).isNotNull().isEqualTo("Hello from Prod");
    }

    @Test
    void shouldReturnQaMessage(){
        Map<String, HandlerServiceInterface> services = new HashMap<>();
        services.put("qa", qaService);
        FacadeService facadeService = new FacadeService(services);
        ReflectionTestUtils.setField(facadeService,  "env", "qa");

        String result = facadeService.execute();

        assertThat(result).isNotNull().isEqualTo("Hello from Qa");
    }
    @Test
    void shouldReturnStagingMessage(){
        Map<String, HandlerServiceInterface> services = new HashMap<>();
        services.put("staging", stagingService);
        FacadeService facadeService = new FacadeService(services);
        ReflectionTestUtils.setField(facadeService,  "env", "staging");

        String result = facadeService.execute();

        assertThat(result).isNotNull().isEqualTo("Hello from Staging");
    }
}
