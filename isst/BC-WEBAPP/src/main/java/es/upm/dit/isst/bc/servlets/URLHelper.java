package es.upm.dit.isst.bc.servlets;


public class URLHelper {

        public static String getURL() {

                String envValue = System.getenv("BCSERVICE_SRV_SERVICE_HOST");

                if(envValue == null)

                        return "http://localhost:8080/BC-SERVICE/rest/Clientes";

                else

                        return envValue;

        }

}
