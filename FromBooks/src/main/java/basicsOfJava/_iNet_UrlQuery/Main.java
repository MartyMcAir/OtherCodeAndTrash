/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basicsOfJava._iNet_UrlQuery;

import org.jsoup.Connection;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;

/**
 *
 * @author MartyMcAir
 */
public class Main {

    public static void main(String[] args) throws URISyntaxException, MalformedURLException, UnsupportedEncodingException, UnsupportedEncodingException, IOException {
        clsUrlQuery urlQuery = new clsUrlQuery();
        // urlQuery.uriMethods();
        // urlQuery.urlMethods();
        // urlQuery.urlToUriDeCode();
        // urlQuery.getFromInternet();
        // urlQuery.setServHead();
        // urlQuery.getServerInfo();
        // urlQuery.getServInfByIndex();
        // urlQuery.getQuery();
        // urlQuery.queryGetTest();
        // urlQuery.postQuery();
        // urlQuery.postReadWriteFileQuery();
        
        checkDbConnect();
    }

    public static void checkDbConnect(){
        
    }
    
    public static Connection connect(String db){
        
        
        return null;
    }

}
