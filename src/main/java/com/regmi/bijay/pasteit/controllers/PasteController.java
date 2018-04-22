package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.domains.DomainPaste;
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
    List<DomainPaste> getAllPastes(){
        return pasteManager.getAllPastes();
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.GET)
    DomainPaste getPaste(@PathVariable Long pasteId){
        return pasteManager.getPasteById(pasteId);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<DomainPaste> getPastesByDate(@RequestParam("startDate") Long startDate,
                                      @RequestParam("endDate") Long endDate){
        return Collections.emptyList();
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    DomainPaste createPaste(@RequestBody DomainPaste domainPaste){
         return pasteManager.createPaste(domainPaste);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.PUT)
    DomainPaste updatePaste(@PathVariable Long pasteId, @RequestBody DomainPaste domainPaste){
        return pasteManager.updatePaste(pasteId, domainPaste);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.DELETE)
    DomainPaste deletePaste(@PathVariable Long pasteId){
        return pasteManager.deletePaste(pasteId);
    }


}
