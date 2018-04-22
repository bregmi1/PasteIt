package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.managers.IPasteManager;
import com.regmi.bijay.pasteit.views.ViewPaste;
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
    List<ViewPaste> getAllPastes(){
        return pasteManager.getAllPastes();
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.GET)
    ViewPaste getPaste(@PathVariable Long pasteId){
        return pasteManager.getPasteById(pasteId);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<ViewPaste> getPastesByDate(@RequestParam("startDate") Long startDate,
                                      @RequestParam("endDate") Long endDate){
        return Collections.emptyList();
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    ViewPaste createPaste(@RequestBody ViewPaste viewPaste){
         return pasteManager.createPaste(viewPaste);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.PUT)
    ViewPaste updatePaste(@PathVariable Long pasteId, @RequestBody ViewPaste viewPaste){
        return pasteManager.updatePaste(pasteId, viewPaste);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.DELETE)
    ViewPaste deletePaste(@PathVariable Long pasteId){
        return pasteManager.deletePaste(pasteId);
    }


}
