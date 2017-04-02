package ua.nenya.mapper;


import ua.nenya.domain.HoverData;
import ua.nenya.dto.HoverDataDTO;

import java.util.List;

public interface HoverDataMapper {

    HoverDataDTO hoverDataToHoverDataDTO(HoverData hoverData);

    List<HoverDataDTO> hoverDataToHoverDataDTOs(List<HoverData> hoverData);

    HoverData hoverDataDTOToHoverData(HoverDataDTO hoverDataDTO);

    List<HoverData> hoverDataDTOsToHoverData(List<HoverDataDTO> hoverDataDTOs);
}
