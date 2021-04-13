package es.upm.dit.isst.bc.rest;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

@ApplicationPath("rest")
public class BCApp extends ResourceConfig {
		public BCApp() {
			packages("es.upm.dit.isst.bc.rest");
		}
}
