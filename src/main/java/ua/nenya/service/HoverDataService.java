package ua.nenya.service;


import ua.nenya.dto.HoverDataDTO;

import java.util.List;

public interface HoverDataService {

    List<HoverDataDTO> saveDataFromSite();

    HoverDataDTO save(HoverDataDTO hoverDataDTO);

    HoverDataDTO update(HoverDataDTO hoverDataDTO);

    List<HoverDataDTO> findAll();

    HoverDataDTO findOne(Long id);

    void delete(Long id);

    List<HoverDataDTO> getAllGroupBy();
}
