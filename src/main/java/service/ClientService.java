package service;

import model.ClientRequestModel;

public interface ClientService {
    ClientRequestModel createClientForm();

    String createClient(ClientRequestModel requestModel);

    ClientRequestModel updateClient(ClientRequestModel requestModel);
}
