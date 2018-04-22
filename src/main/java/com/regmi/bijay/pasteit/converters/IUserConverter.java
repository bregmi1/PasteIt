package com.regmi.bijay.pasteit.converters;

import com.regmi.bijay.pasteit.domains.DomainUser;
import com.regmi.bijay.pasteit.views.ViewUser;

public interface IUserConverter {
    DomainUser viewToDomain(ViewUser viewUser);
    ViewUser domainToView(DomainUser domainUser);
}
