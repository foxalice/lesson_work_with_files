import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.io.InputStreamReader;

import static org.assertj.core.api.Assertions.assertThat;

public class GsonParsingTest {

    ClassLoader cl = FilesParsingTest.class.getClassLoader();

    @Test
    void jsonParseTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        try (
                InputStream resource = cl.getResourceAsStream("unpacked/json.json");
                InputStreamReader reader = new InputStreamReader(resource);
        )
        {
            PersonJson personJson = mapper.readValue(reader, PersonJson.class);
            assertThat(personJson.result).isEqualTo(1);
            assertThat(personJson.action).isEqualTo("getdata");
            assertThat(personJson.data).contains("Тестовый Тест Тестович");

        }


    }
}
