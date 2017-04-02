package ua.nenya.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.nenya.dto.HoverDataDTO;
import ua.nenya.service.HoverDataService;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/api")
public class HoverDataController {

    @Autowired
    HoverDataService hoverDataService;

    private static final Logger log = LoggerFactory.getLogger(HoverDataController.class);


    @PostMapping("/hover-data")
    public ResponseEntity<HoverDataDTO> createHoverData(@RequestBody HoverDataDTO hoverDataDTO) throws URISyntaxException {
        log.debug("REST request to save HoverData : {}", hoverDataDTO);
        HoverDataDTO result = hoverDataService.update(hoverDataDTO);
        return ResponseEntity.created(new URI("/api/hover-data/" + result.getId())).body(result);
    }

    @PutMapping("/hover-data")
    public ResponseEntity<HoverDataDTO> updateHoverData(@RequestBody HoverDataDTO hoverDataDTO) throws URISyntaxException {
        log.debug("REST request to update HoverData : {}", hoverDataDTO);
        if (hoverDataDTO.getId() == null) {
            return createHoverData(hoverDataDTO);
        }
        HoverDataDTO result = hoverDataService.save(hoverDataDTO);
        return ResponseEntity.ok().body(result);
    }

    @PutMapping("/hover-data/save-from-site")
    public ResponseEntity<List<HoverDataDTO>> saveAllFromSite() {
        log.debug("REST request to save All HoverData from site table");
        List<HoverDataDTO> hoverDataDTOs = hoverDataService.saveDataFromSite();
        return ResponseEntity.ok().body(hoverDataDTOs);
    }

    @GetMapping("/hover-data/group-by-renderingEngine")
    public List<HoverDataDTO> getAllGroupBy() {
        log.debug("REST request to get All HoverData group by renderingEngine");
        return hoverDataService.getAllGroupBy();
    }

    @GetMapping("/hover-data")
    public List<HoverDataDTO> getAllHoverData() {
        log.debug("REST request to get all HoverData");
        return hoverDataService.findAll();
    }

    @GetMapping("/hover-data/{id}")
    public ResponseEntity<HoverDataDTO> getHoverData(@PathVariable Long id) {
        log.debug("REST request to get HoverData : {}", id);
        HoverDataDTO hoverDataDTO = hoverDataService.findOne(id);
        return ResponseEntity.ok().body(hoverDataDTO);
    }

    @DeleteMapping("/hover-data/{id}")
    public ResponseEntity<Void> deleteHoverData(@PathVariable Long id) {
        log.debug("REST request to delete HoverData : {}", id);
        hoverDataService.delete(id);
        return ResponseEntity.ok().build();
    }

}
