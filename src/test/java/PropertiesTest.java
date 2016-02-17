import com.devarchi.CallRestWS;
import com.devarchi.config.AppConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by donghoon on 2016. 2. 17..
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class PropertiesTest {

    @Value("${endPoint}")
    private String endPoint;

    @Test
    public void requestUrlBuilderTest() throws Exception {
        AbstractApplicationContext context = new AnnotationConfigApplicationContext();
        context.refresh();
        CallRestWS cr = (CallRestWS) context.getBean("callRestWS");
        List<String> params = new ArrayList<String>();
        params.add("&numOfRows=1");
        params.add("&pageSize=1");
        params.add("&pageNo=1");
        params.add("&startPage=1");
        System.out.println(cr.restClient(params));
    }
}
