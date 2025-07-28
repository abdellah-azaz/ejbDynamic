package fol1.fol2.filters;


import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements Filter {

   

	   @Override
	    public void init(FilterConfig filterConfig) throws ServletException {
	        // Initialisation si nécessaire
	    }

	    @Override
	    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	            throws IOException, ServletException {
	        // Vérifie que la requête et la réponse sont de type HTTP
	        if (request instanceof HttpServletRequest && response instanceof HttpServletResponse) {
	            HttpServletResponse httpResponse = (HttpServletResponse) response;

	            // Ajouter les en-têtes CORS
	            httpResponse.setHeader("Access-Control-Allow-Origin", "*");
	            httpResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT, OPTIONS");
	            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, Authorization");
	            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");

	            // Si la méthode est OPTIONS, on peut ignorer la requête ici
	            HttpServletRequest httpRequest = (HttpServletRequest) request;
	            if ("OPTIONS".equalsIgnoreCase(httpRequest.getMethod())) {
	                httpResponse.setStatus(HttpServletResponse.SC_OK);
	                return;
	            }
	        }

	        // Poursuivre la chaîne de filtres
	        chain.doFilter(request, response);
	    }

	    @Override
	    public void destroy() {
	        // Libération des ressources si nécessaire
	    }
}
