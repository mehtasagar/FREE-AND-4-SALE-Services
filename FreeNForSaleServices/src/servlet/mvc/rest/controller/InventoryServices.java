package servlet.mvc.rest.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import servlet.mvc.rest.beans.IDclass;
import servlet.mvc.rest.beans.InventoryBean;
import servlet.mvc.rest.beans.ItemDetailBean;
import servlet.mvc.rest.manager.InventoryManager;
 
@Path("/InventoryServices")
public class InventoryServices {
	static InventoryManager manager = new InventoryManager();
	static String secretKey = "1234567890"; 
	
	
	/**
	 * Inventory For home Page.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/InventoryForHomePage")
	@GET
	//@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response fetchInventory(@HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
		if(key!=null && key.equals(secretKey))
		{
			Map<Integer,ArrayList<InventoryBean>>inventoryMap= new HashMap<Integer,ArrayList<InventoryBean>>();
			try{
				
				inventoryMap=manager.fetchInventoryForHomePage();
			}catch(Exception e){
				e.printStackTrace();
			}
			return Response.ok().entity(inventoryMap).build();			

		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
	
	/**
	 * Inventory For home Page.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/InventoryByCategoryId")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response fetchInventoryById(InventoryBean bean,@HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
		if(key!=null && key.equals(secretKey))
		{
			ArrayList<InventoryBean> inventoryMap= new ArrayList<InventoryBean>();
			try{
				
				inventoryMap=manager.fetchInventoryByCategory(bean.getCategoryId());
			}catch(Exception e){
				e.printStackTrace();
			}
			return Response.ok().entity(inventoryMap).build();			

		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
	
	/**
	 * Inventory For home Page.
	 * @param bean
	 * @param key
	 * @return
	 * @throws URISyntaxException 
	 */
	@Path("/FetchMoreDetails")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
	public Response FetchMoreDetails(InventoryBean bean,@HeaderParam("secretKey")String key) throws URISyntaxException {
        URI tempRedirect=new URI("../error.html");
		if(key!=null && key.equals(secretKey))
		{
			ItemDetailBean itemDetailBean= new ItemDetailBean();
			try{
				
				itemDetailBean=manager.fetchMoreDetails(bean.getItemId());
			}catch(Exception e){
				e.printStackTrace();
			}
			return Response.ok().entity(itemDetailBean).build();			

		}
		else
		{
			System.out.println("redirecting");
			return Response.seeOther(tempRedirect).build();
		}
		
	}
	
}
