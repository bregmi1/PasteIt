package com.regmi.bijay.pasteit.managers;

import com.regmi.bijay.pasteit.domains.Paste;

import java.util.List;

public interface IPasteManager {
    List<Paste> getAllPastes();
    Paste getPasteById(Long pasteId);
    Paste createPaste(Paste paste);
    Paste updatePaste(Long pasteId, Paste paste);
    Paste deletePaste(Long pasteId);
    List<Paste> getAllPastesByUserId(Long userId);
}