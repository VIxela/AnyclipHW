package tests.repository;

public interface Repository {

    String START_URL = "https://bootsnipp.com/login";
    String LOGIN_BUTTON = "//*[@class='btn btn-lg btn-success btn-block']";
    String EMAIL_INPUT = "//*[@class='form-control email-title']";
    String EMAIL = "protsik@inbox.ru";
    String EMAIL1 = "protsik@rambler.ru";
    String PASSWORD_INPUT = " //*[@class='form-control']";
    String PASSWORD = "cospp02b";
    String PASSWORD1 = "cospp02b";
    String REMEMBER_ME_CHECKBOX = "//*[@name='remember']";
    String PROFILE = "(//a[contains(text(),'Profile')])[1]";
    String LOGIN =   "(//a[contains(text(),'Login')])[1]";
    String LOGOUT = "//a[contains(text(),'Logout')]";

    Boolean REMEMBER_ME =true;



}
