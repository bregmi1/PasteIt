package com.regmi.bijay.pasteit.converters;

import com.regmi.bijay.pasteit.domains.DomainPaste;
import com.regmi.bijay.pasteit.views.ViewPaste;

public interface IPasteConverter {
    DomainPaste viewToDomain(ViewPaste viewPaste);
    ViewPaste domainToView(DomainPaste domainPaste);
}
