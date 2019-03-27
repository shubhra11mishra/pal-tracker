package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;



@RestController
public class EnvController {

    private Map<String, String> myMap = new HashMap<>();

    public EnvController(@Value("${port:NOT SET}")String port, @Value("${memory.limit:NOT SET}")String memoryLimit, @Value("${cf.instance.index:NOT SET}")String cfInstanceIndex, @Value("${cf.instance.address:NOT SET}")String cfInstanceAddr){
        myMap.put("PORT", port);
        myMap.put("MEMORY_LIMIT", memoryLimit);
        myMap.put("CF_INSTANCE_INDEX", cfInstanceIndex);
        myMap.put("CF_INSTANCE_ADDR", cfInstanceAddr);
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        return myMap;
    }
}
