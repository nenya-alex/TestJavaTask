package ua.nenya.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.nenya.domain.HoverData;
import ua.nenya.dto.HoverDataDTO;
import ua.nenya.mapper.HoverDataMapper;
import ua.nenya.parser.TableParser;
import ua.nenya.repository.HoverDataRepository;
import ua.nenya.service.HoverDataService;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Service
@Transactional
public class HoverDataServiceImpl implements HoverDataService{

    @Autowired
    private TableParser tableParser;

    @Autowired
    private HoverDataRepository hoverDataRepository;

    @Autowired
    private HoverDataMapper hoverDataMapper;

    @PersistenceContext
    private EntityManager em;

    private static final Logger log = LoggerFactory.getLogger(HoverDataServiceImpl.class);

    @Override
    public List<HoverDataDTO> saveDataFromSite() {
        List<HoverData> hoverData = tableParser.parseHtmlTable();
        hoverDataRepository.save(hoverData);
        return hoverDataMapper.hoverDataToHoverDataDTOs(hoverData);
    }

    @Override
    public HoverDataDTO save(HoverDataDTO hoverDataDTO) {
        log.debug("Request to save HoverData : {}", hoverDataDTO);
        HoverData hoverData = hoverDataMapper.hoverDataDTOToHoverData(hoverDataDTO);
        hoverData = hoverDataRepository.save(hoverData);
        HoverDataDTO result = hoverDataMapper.hoverDataToHoverDataDTO(hoverData);
        return result;
    }

    @Override
    public HoverDataDTO update(HoverDataDTO hoverDataDTO) {
        log.debug("Request to update HoverData : {}", hoverDataDTO);
        HoverData hoverData = hoverDataMapper.hoverDataDTOToHoverData(hoverDataDTO);
        hoverData = hoverDataRepository.save(hoverData);
        HoverDataDTO result = hoverDataMapper.hoverDataToHoverDataDTO(hoverData);
        return result;
    }


    @Override
    @Transactional(readOnly = true)
    public List<HoverDataDTO> findAll() {
        log.debug("Request to get all HoverData");
        List<HoverDataDTO> result = hoverDataRepository.findAll().stream()
                .map(hoverDataMapper::hoverDataToHoverDataDTO)
                .collect(Collectors.toCollection(LinkedList::new));

        return result;
    }


    @Override
    @Transactional(readOnly = true)
    public HoverDataDTO findOne(Long id) {
        log.debug("Request to get HoverData : {}", id);
        HoverData hoverData = hoverDataRepository.findOne(id);
        HoverDataDTO hoverDataDTO = hoverDataMapper.hoverDataToHoverDataDTO(hoverData);
        return hoverDataDTO;
    }


    @Override
    public void delete(Long id) {
        log.debug("Request to delete HoverData : {}", id);
        hoverDataRepository.delete(id);
    }

    @Override
    public List<HoverDataDTO> getAllGroupBy() {
        Query query = em.createNamedQuery("HoverData.getGrouped");
        List<HoverData> hoverData = query.getResultList();
        return hoverDataMapper.hoverDataToHoverDataDTOs(hoverData);
    }
}
