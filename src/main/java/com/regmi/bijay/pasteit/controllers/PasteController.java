package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.domains.Paste;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/v1/paste")
public class PasteController {

    @RequestMapping(method = RequestMethod.GET)
    List<Paste> getAllPastes(){
        return Collections.emptyList();
    }

    @RequestMapping(value = "/{pasteId}", method = RequestMethod.GET)
    Paste getPaste(@PathVariable Long pasteId){
        return null;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    List<Paste> getPastesByDate(@RequestParam("startDate") Long startDate,
                                @RequestParam("endDate") Long endDate){
        return Collections.emptyList();
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    Paste createPaste(@RequestBody Paste paste){
        return null;
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.PUT)
    Paste updatePaste(@PathVariable Long pasteId, @RequestBody Paste paste){
        return null;
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.DELETE)
    Paste deletePaste(@PathVariable Long pasteId){
        return null;
    }


}
