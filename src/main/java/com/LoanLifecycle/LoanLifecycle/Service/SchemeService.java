package com.LoanLifecycle.LoanLifecycle.Service;

import com.LoanLifecycle.LoanLifecycle.Entity.SchemeEntity;

import java.util.List;

public interface SchemeService {
    List<SchemeEntity>getAllSchemes();
    SchemeEntity getSchemeId(int id);

    String SaveScheme(SchemeEntity schemeData);

    String updateScheme(int schemeId,SchemeEntity schemeData);

    void DeleteScheme(int schemeId);

}
