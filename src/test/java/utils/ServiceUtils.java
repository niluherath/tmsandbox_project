package utils;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ServiceUtils {

    private final static String ACCEPT = "accept";
    private final static String ACCEPT_ENCODING = "accept-encoding";
    private final static String ACCEPT_LANGUAGE = "accept-language";
    private final static String ACCESS_CONTROL_REQUEST_HEADERS = "access-control-request-headers";
    private final static String ACCEPT_HEADERS = "*/*";
    private final static String ACCEPT_ENCODING_HEADERS = "gzip, deflate, br";
    private final static String ACCEPT_LANGUAGE_HEADERS = "en-US,en;q=0.9";
    private final static String ACCESS_CONTROL_REQUEST_HEADERS_VALUES = "authorization,newrelic,x-trademe-uniqueclientid";
    private final static String CATEGORY_ID = "6327";

    public static Response getCategoryResponse(int catId){

        RestAssured.baseURI = "https://api.tmsandbox.co.nz";
        RequestSpecification request = RestAssured.given().relaxedHTTPSValidation();
        request.header(ACCEPT, ACCEPT_HEADERS);
        request.header(ACCEPT_ENCODING, ACCEPT_ENCODING_HEADERS);
        request.header(ACCEPT_LANGUAGE, ACCEPT_LANGUAGE_HEADERS);
        request.header(ACCESS_CONTROL_REQUEST_HEADERS, ACCESS_CONTROL_REQUEST_HEADERS_VALUES);
        request.param("catalogue", false);
        return request.get("v1/Categories/" + CATEGORY_ID + "/Details.json");

    }

}
