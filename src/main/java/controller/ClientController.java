package controller;

import lombok.extern.slf4j.Slf4j;
import model.ClientRequestModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.HttpClientErrorException;
import service.ClientService;
import service.ClientServiceImpl;
import util.APIResponseStructure;

@Slf4j
@Controller(value = "/client/")
public class ClientController {

    @Autowired
    private ClientServiceImpl clientService;

    /*API to create a form for client to fill and send Create/Update API hit*/
    @RequestMapping(value = "client/createForm", method = RequestMethod.GET)
    @ResponseBody
    public APIResponseStructure<ClientRequestModel> createClientForm() {
        APIResponseStructure<ClientRequestModel> apiResponse = new APIResponseStructure<>();
        try {
            ClientRequestModel clientFormAPIResponse = this.clientService.createClientForm();
            apiResponse.setResponse(clientFormAPIResponse);
            apiResponse.setSuccess(true);
            apiResponse.setResponseCode(HttpStatus.OK.value());
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            log.error("Error occurred while creating a client due to error: ", e);
        }
        return apiResponse;
    }

    /*API to create a client*/
    @RequestMapping(value = "client/create", method = RequestMethod.POST)
    @ResponseBody
    public APIResponseStructure<String> createClient(@RequestBody ClientRequestModel clientRequestModel) {
        APIResponseStructure<String> apiResponse = new APIResponseStructure<>();
        try {
            String clientAPIResponse = this.clientService.createClient(clientRequestModel);
            apiResponse.setResponse(clientAPIResponse);
            apiResponse.setSuccess(true);
            apiResponse.setResponseCode(HttpStatus.OK.value());
        } catch (HttpClientErrorException.BadRequest e) {
            apiResponse.setResponse(e.getMessage());
            apiResponse.setSuccess(false);
            apiResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            log.error("BadRequest Received due to error: ", e);
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            log.error("Error occurred while creating a client due to error: ", e);
        }
        return apiResponse;
    }

    /*API to update a client*/
    @RequestMapping(value = "client/update", method = RequestMethod.POST)
    @ResponseBody
    public APIResponseStructure<ClientRequestModel> updateClient(@RequestBody ClientRequestModel clientRequestModel) {
        APIResponseStructure<ClientRequestModel> apiResponse = new APIResponseStructure<>();
        try {
            ClientRequestModel clientAPIResponse = this.clientService.updateClient(clientRequestModel);
            apiResponse.setResponse(clientAPIResponse);
            apiResponse.setSuccess(true);
            apiResponse.setResponseCode(HttpStatus.OK.value());
        } catch (HttpClientErrorException.BadRequest e) {
            apiResponse.setSuccess(false);
            apiResponse.setResponseCode(HttpStatus.BAD_REQUEST.value());
            log.error("BadRequest Received due to error: ", e);
        } catch (Exception e) {
            apiResponse.setSuccess(false);
            apiResponse.setResponseCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
            log.error("Error occurred while creating a client due to error: ", e);
        }
        return apiResponse;
    }
}
