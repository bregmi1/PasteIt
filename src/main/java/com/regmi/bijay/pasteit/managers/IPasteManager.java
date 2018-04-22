package com.regmi.bijay.pasteit.managers;

import com.regmi.bijay.pasteit.domains.DomainPaste;
import com.regmi.bijay.pasteit.views.ViewPaste;

import java.util.List;

public interface IPasteManager {
    List<ViewPaste> getAllPastes();
    ViewPaste getPasteById(Long pasteId);
    ViewPaste createPaste(ViewPaste viewPaste);
    ViewPaste updatePaste(Long pasteId, ViewPaste viewPaste);
    ViewPaste deletePaste(Long pasteId);
    List<ViewPaste> getPastesBetweenDates(Long startDate, Long endDate);
    List<ViewPaste> getPastesBeforeDate(Long endDate);
}
