import net.airene.questionnaire.Application;
import net.airene.questionnaire.generator.service.GenService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class GeneratorTest {

    @Autowired
    private GenService genService;

    @Test
    public void test() throws Exception {
        genService.generatorCode("t_merch_data");
    }

}
