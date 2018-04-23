package com.regmi.bijay.pasteit.controllers;

import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.managers.IPasteManager;
import com.regmi.bijay.pasteit.views.ViewPaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/paste")
public class PasteController {

    @Autowired
    private IPasteManager pasteManager;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewPaste>> getAllPastes(){
        return new ResponseEntity<>(pasteManager.getAllPastes(), HttpStatus.OK);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.GET)
    ResponseEntity<ViewPaste> getPaste(@PathVariable Long pasteId){
        return new ResponseEntity<>(pasteManager.getPasteById(pasteId), HttpStatus.OK);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<List<ViewPaste>> getPastesByDate(@RequestParam("startDate") Long startDate,
                                      @RequestParam("endDate") Long endDate){
        return new ResponseEntity<>(pasteManager.getPastesBetweenDates(startDate, endDate), HttpStatus.OK);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewPaste> createPaste(@RequestBody ViewPaste viewPaste){
         return new ResponseEntity<>(pasteManager.createPaste(viewPaste), HttpStatus.OK);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.PUT)
    ResponseEntity<ViewPaste> updatePaste(@PathVariable Long pasteId, @RequestBody ViewPaste viewPaste){
        return new ResponseEntity<>(pasteManager.updatePaste(pasteId, viewPaste), HttpStatus.OK);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewPaste> deletePaste(@PathVariable Long pasteId){
        return new ResponseEntity<>(pasteManager.deletePaste(pasteId), HttpStatus.OK);
    }


}
