package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.domains.Paste;
import com.regmi.bijay.pasteit.managers.IPasteManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/paste")
public class PasteController {

    @Autowired
    private IPasteManager pasteManager;

    @RequestMapping(method = RequestMethod.GET)
    List<Paste> getAllPastes(){
        return pasteManager.getAllPastes();
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.GET)
    Paste getPaste(@PathVariable Long pasteId){
        return pasteManager.getPasteById(pasteId);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Paste> getPastesByDate(@RequestParam("startDate") Long startDate,
                                @RequestParam("endDate") Long endDate){
        return Collections.emptyList();
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    Paste createPaste(@RequestBody Paste paste){
         return pasteManager.createPaste(paste);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.PUT)
    Paste updatePaste(@PathVariable Long pasteId, @RequestBody Paste paste){
        return pasteManager.updatePaste(pasteId, paste);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.DELETE)
    Paste deletePaste(@PathVariable Long pasteId){
        return pasteManager.deletePaste(pasteId);
    }


}
