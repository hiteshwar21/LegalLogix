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

    @Override
    public ClientRequestModel createClientForm(){
        ClientRequestModel clientRequestModel = new ClientRequestModel();
        return clientRequestModel;
    }

    @Override
    public String createClient(ClientRequestModel requestModel) {
        validationCreateClient(requestModel);
        //requestModel.setAdvId(Authentication);
        return "";
    }

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
