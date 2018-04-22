package com.regmi.bijay.pasteit.managers;

import com.regmi.bijay.pasteit.domains.DomainPaste;

import java.util.List;

public interface IPasteManager {
    List<DomainPaste> getAllPastes();
    DomainPaste getPasteById(Long pasteId);
    DomainPaste createPaste(DomainPaste domainPaste);
    DomainPaste updatePaste(Long pasteId, DomainPaste domainPaste);
    DomainPaste deletePaste(Long pasteId);
    List<DomainPaste> getPastesBetweenDates(Long startDate, Long endDate);
    List<DomainPaste> getPastesBeforeDate(Long endDate);
}
