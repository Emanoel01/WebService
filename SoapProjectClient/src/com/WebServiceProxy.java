package com;

public class WebServiceProxy implements com.WebService {
  private String _endpoint = null;
  private com.WebService webService = null;
  
  public WebServiceProxy() {
    _initWebServiceProxy();
  }
  
  public WebServiceProxy(String endpoint) {
    _endpoint = endpoint;
    _initWebServiceProxy();
  }
  
  private void _initWebServiceProxy() {
    try {
      webService = (new com.WebServiceServiceLocator()).getWebService();
      if (webService != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)webService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)webService)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (webService != null)
      ((javax.xml.rpc.Stub)webService)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.WebService getWebService() {
    if (webService == null)
      _initWebServiceProxy();
    return webService;
  }
  
  public java.lang.String returnNameAndAge(java.lang.String name) throws java.rmi.RemoteException{
    if (webService == null)
      _initWebServiceProxy();
    return webService.returnNameAndAge(name);
  }
  
  
}