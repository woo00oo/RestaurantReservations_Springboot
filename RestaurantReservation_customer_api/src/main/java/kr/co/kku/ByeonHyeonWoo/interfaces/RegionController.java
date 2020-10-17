package kr.co.kku.ByeonHyeonWoo.interfaces;

import kr.co.kku.ByeonHyeonWoo.application.RegionService;
import kr.co.kku.ByeonHyeonWoo.domain.Region;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.rsocket.context.LocalRSocketServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class RegionController {

    @Autowired
    private RegionService regionService;

    @GetMapping("/regions")
    public List<Region> list(){
        List<Region> regions = regionService.getRegions();
        return regions;
    }

}
