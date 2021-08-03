package cucumber.hooks;

import com.fasterxml.jackson.core.JsonProcessingException;
import core.api.ApiMethod;
import core.api.ApiResponse;
import io.cucumber.java.After;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import salesforce.Configuration.Api.Config.Endpoints;
import salesforce.Configuration.Api.Config.Request;
import salesforce.entities.CreatedResponse;
import salesforce.entities.LegalEntity;
import salesforce.entities.RequisiteElement;
import java.util.HashMap;
import java.util.Map;

public class LegalEntityHooks {

    private Logger logger = LogManager.getLogger(getClass());
    private CreatedResponse createdResponse;
    private RequisiteElement requisiteElement;
    private LegalEntity legalEntity;

    public LegalEntityHooks(final CreatedResponse createdResponse, final RequisiteElement requisiteElement, LegalEntity legalEntity) {
        this.createdResponse = createdResponse;
        this.requisiteElement = requisiteElement;
        this.legalEntity = legalEntity;
    }

    @After(value = "@CreateLegaEntity", order = 2)
    public void setLast() throws JsonProcessingException {
        Map<String, String> pathParams = new HashMap<>();
        pathParams.put(Endpoints.ID.get(), legalEntity.getId());
        ApiResponse apiResponse = Request.execute(Endpoints.LEGAL_ENTITY.get(), pathParams, ApiMethod.DELETE);
    }
}
