package service;

import constant.Constants;
import constant.ResponseMessages;
import exception.BadRequestException;
import model.ClientRequestModel;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.logging.Logger;

@Service(value = "clientService")
@Transactional
public class ClientServiceImpl implements ClientService {

    private final Logger logger = Logger.getLogger(String.valueOf(this.getClass()));

    /**
     * This method is used to create a form for client to fill and send Create/Update API hit
     * @return ClientRequestModel
     */
    @Override
    public ClientRequestModel createClientForm(){
        return new ClientRequestModel();
    }

    /**
     * This method is used to create a client
     * @param clientRequestModel - A POJO pertaining client Information
     * @return String
     */
    @Override
    public String createClient(ClientRequestModel clientRequestModel) {
        validationCreateClient(clientRequestModel);
        //requestModel.setAdvId(AuthenticationRe);
        return "";
    }

    /**
     * This method is used to validate the request model for create client
     * @param requestModel - A POJO pertaining client Information
     */
    void validationCreateClient(ClientRequestModel requestModel){
        if(requestModel == null){
            throw new BadRequestException(ResponseMessages.EMPTY_PAYLOAD);
        } else if(requestModel.getClientName().isEmpty()){
            throw new BadRequestException(ResponseMessages.CLIENT_NAME_MISSING);
        } else if(requestModel.getAddress().isEmpty()){
            throw new BadRequestException(ResponseMessages.ADDRESS_MISSING);
        } else if(requestModel.getPhoneNumber() == null){
            throw new BadRequestException(ResponseMessages.PHONE_NUMBER_MISSING);
        } else if(requestModel.getEmail().isEmpty()){
            throw new BadRequestException(ResponseMessages.EMAIL_ID_MISSING);
        } /*else if(!requestModel.getEmail().contains(Constants.AllowedMailExtensions)){
            throw new BadRequestException(ResponseMessages.WRONG_MAIL_ID);
        }*/
    }

    @Override
    public ClientRequestModel updateClient(ClientRequestModel requestModel) {

        return requestModel;
    }
}
