package com.regmi.bijay.pasteit.controllers.v1;

import com.regmi.bijay.pasteit.accessors.IUserAccessor;
import com.regmi.bijay.pasteit.converters.ILocalDateTimeConverter;
import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.managers.IPasteManager;
import com.regmi.bijay.pasteit.views.ViewPaste;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/paste")
public class PasteController {

    @Autowired
    private IUserAccessor userAccessor;

    @Autowired
    private IPasteManager pasteManager;

    @Autowired
    private ILocalDateTimeConverter localDateTimeConverter;

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ViewPaste>> getAllPastes(Principal principal){
        DomainUser user = userAccessor.findByEmail(principal.getName());
        return new ResponseEntity<>(pasteManager.getAllPastesByUserId(user.getUserId()), HttpStatus.OK);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.GET)
    ResponseEntity<ViewPaste> getPaste(@PathVariable Long pasteId, Principal principal){
        DomainUser user = userAccessor.findByEmail(principal.getName());
        ViewPaste requestedPaste = pasteManager.getPasteById(pasteId);
        if(!user.getUserId().equals(requestedPaste.getUserId())){
            throw new UnauthorizedClientException("Unauthrized User");
        }
        return new ResponseEntity<>(pasteManager.getPasteById(pasteId), HttpStatus.OK);
    }


    @RequestMapping(value = "/", method = RequestMethod.GET)
    ResponseEntity<List<ViewPaste>> getPastesByDate(@RequestParam("startDate") Long startDate,
                                      @RequestParam("endDate") Long endDate){
        return new ResponseEntity<>(pasteManager.getPastesBetweenDates(startDate, endDate), HttpStatus.OK);
    }


    @RequestMapping(value = "/", method = RequestMethod.POST)
    ResponseEntity<ViewPaste> createPaste(@RequestBody ViewPaste viewPaste, Principal principal){
        DomainUser user = userAccessor.findByEmail(principal.getName());
        viewPaste.setUserId(user.getUserId());
        return new ResponseEntity<>(pasteManager.createPaste(viewPaste), HttpStatus.OK);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.PUT)
    ResponseEntity<ViewPaste> updatePaste(@PathVariable Long pasteId, @RequestBody ViewPaste viewPaste, Principal principal){
        DomainUser user = userAccessor.findByEmail(principal.getName());
        if(!viewPaste.getUserId().equals(user.getUserId())){
            throw new UnauthorizedClientException("Unauthorized user for updating the paste");
        }
        return new ResponseEntity<>(pasteManager.updatePaste(pasteId, viewPaste), HttpStatus.OK);
    }


    @RequestMapping(value = "/{pasteId}", method = RequestMethod.DELETE)
    ResponseEntity<ViewPaste> deletePaste(@PathVariable Long pasteId, Principal principal){
        DomainUser user = userAccessor.findByEmail(principal.getName());
        if(!pasteId.equals(user.getUserId())){
            throw new UnauthorizedClientException("Unauthorized user for deleting the paste");
        }
        return new ResponseEntity<>(pasteManager.deletePaste(pasteId), HttpStatus.OK);
    }


}
