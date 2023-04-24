package dev.ifrs;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cupom")
public class Cupom {
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String calculaCupom(@FormParam("valor") float valor, @FormParam("cupom") String cupom){
        if(cupom.equals("CUPOM10")){
            float valorComDesconto = Math.round(valor * 90.0f);
            return String.format("%.0f", valorComDesconto);
        } else if (cupom.equals("CUPOM15")) {
            float valorComDesconto = Math.round(valor * 85.0f);
            return String.format("%.0f", valorComDesconto);
        }
        return "fail";
    }
}