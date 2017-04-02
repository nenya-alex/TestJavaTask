package ua.nenya.mapper.impl;


import org.springframework.stereotype.Service;
import ua.nenya.domain.HoverData;
import ua.nenya.dto.HoverDataDTO;
import ua.nenya.mapper.HoverDataMapper;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HoverDataMapperImpl implements HoverDataMapper{

    @Override
    public HoverDataDTO hoverDataToHoverDataDTO(HoverData hoverData) {
        return new HoverDataDTO()
                .withId(hoverData.getId())
                .withBrowser(hoverData.getBrowser())
                .withCssGrade(hoverData.getCssGrade())
                .withEngineVersion(hoverData.getEngineVersion())
                .withPlatform(hoverData.getPlatform())
                .withRenderingEngine(hoverData.getRenderingEngine());
    }

    @Override
    public List<HoverDataDTO> hoverDataToHoverDataDTOs(List<HoverData> hoverData) {
        return hoverData.stream().map(this::hoverDataToHoverDataDTO).collect(Collectors.toList());
    }

    @Override
    public HoverData hoverDataDTOToHoverData(HoverDataDTO hoverDataDTO) {
        return new HoverData()
                .withId(hoverDataDTO.getId())
                .withBrowser(hoverDataDTO.getBrowser())
                .withCssGrade(hoverDataDTO.getCssGrade())
                .withEngineVersion(hoverDataDTO.getEngineVersion())
                .withPlatform(hoverDataDTO.getPlatform())
                .withRenderingEngine(hoverDataDTO.getRenderingEngine());
    }

    @Override
    public List<HoverData> hoverDataDTOsToHoverData(List<HoverDataDTO> hoverDataDTOs) {
        return hoverDataDTOs.stream().map(this::hoverDataDTOToHoverData).collect(Collectors.toList());
    }
}
