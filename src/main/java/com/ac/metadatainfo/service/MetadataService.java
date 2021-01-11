package com.ac.metadatainfo.service;

import java.util.List;

import com.ac.metadatainfo.model.MetadataInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ac.metadatainfo.dao.MetadataDAO;

@Service
@Slf4j
public class MetadataService {

  private MetadataDAO metadataDAO;

  @Autowired
  public MetadataService(MetadataDAO metadataDAO) {
    this.metadataDAO = metadataDAO;
  }

  public MetadataInfo findMetadataInfo(String docId) {
    return metadataDAO
            .findById(docId)
            .orElse(MetadataInfo.EMPTY_METADATA);
  }

  public List<MetadataInfo> getAllMetadataInfos() {
    return metadataDAO.findAll();
  }

  public void addMetadataInfo(MetadataInfo metadataInfo) {
    MetadataInfo metadata = metadataDAO.save(metadataInfo);
    log.info("metadata added/updated - {}", metadata);
  }

  public void updateMetadatInfo(MetadataInfo metadataInfo) {
    if (metadataInfo.hasId()) {
      addMetadataInfo(metadataInfo);
    } else {
      throwMetaInfoNotExistException(metadataInfo);
    }
  }

  public void deleteMetadatInfo(String docId) {
    metadataDAO.deleteById(docId);
  }

  private void throwMetaInfoNotExistException(MetadataInfo metadataInfo) {
    log.warn("metadataInfo {} doesn't exist and so can't be updated");
    throw new RuntimeException("Document " + metadataInfo + " doesn't exist and so can't be updated");
  }

}
