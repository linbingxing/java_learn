import com.lean.demo.user.UserApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest(classes = {UserApplication.class})
@RunWith(SpringJUnit4ClassRunner.class)
public class AutodeliverApplicationTest {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Test
    public void test() {
        // 从EurekaServer获取指定微服务实例
        List<ServiceInstance> serviceInstanceList =
                discoveryClient.getInstances("learn-service-user");
        // 循环打印每个微服务实例的元数据信息
        for (int i = 0; i < serviceInstanceList.size(); i++) {
            ServiceInstance serviceInstance =
                    serviceInstanceList.get(i);
            System.out.println(serviceInstance.toString());
        }
    }
}
