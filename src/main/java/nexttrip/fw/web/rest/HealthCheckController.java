package nexttrip.fw.web.rest;

import nexttrip.fw.web.rest.vm.BaseResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("health")
public class HealthCheckController {
    @GetMapping("status")
    public BaseResponse<Map<String, Object>> status() {
        Map<String, Object> map = new HashMap<>();
        map.put("status", "RUNNING");
        return BaseResponse.ok(map);
    }
}
