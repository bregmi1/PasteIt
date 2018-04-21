package com.regmi.bijay.pasteit.managers.impl;

import com.regmi.bijay.pasteit.accessors.IPasteAccessor;
import com.regmi.bijay.pasteit.domains.Paste;
import com.regmi.bijay.pasteit.domains.User;
import com.regmi.bijay.pasteit.managers.IPasteManager;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PasteManger implements IPasteManager {

    @Autowired
    private IPasteAccessor pasteAccessor;
    @Override
    public List<Paste> getAllPastes() {
        return pasteAccessor.findAll();
    }

    @Override
    public Paste getPasteById(Long pasteId) {
        return pasteAccessor.findOne(pasteId);
    }

    @Override
    public Paste createPaste(Paste paste) {
        return pasteAccessor.save(paste);
    }

    @Override
    public Paste updatePaste(Long pasteId, Paste paste) {
        Paste currentPaste = pasteAccessor.findOne(pasteId);
        if(currentPaste == null || !paste.getPasteId().equals(pasteId)){
            return null;
        }
        return pasteAccessor.save(paste);
    }

    @Override
    public Paste deletePaste(Long pasteId) {
        Paste paste = pasteAccessor.findOne(pasteId);
        if(paste == null){
            return null;
        }
        pasteAccessor.delete(pasteId);
        return paste;
    }

    @Override
    public List<Paste> getAllPastesByUser(User user) {
        return null;
    }
}
