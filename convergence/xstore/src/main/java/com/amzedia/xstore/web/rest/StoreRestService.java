/**
 * 
 */
package com.amzedia.xstore.web.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.amzedia.xstore.XstoreException;
import com.amzedia.xstore.model.ListResponseWrapper;
import com.amzedia.xstore.model.ResponseWrapper;
import com.amzedia.xstore.model.Store;
import com.amzedia.xstore.model.Tag;
import com.amzedia.xstore.services.interfaces.IStoreService;

/**
 * @author Tarun
 * 
 */
@Controller
@RequestMapping(value = "/store")
public class StoreRestService {

	@Autowired
	private IStoreService storeService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseWrapper getStore(@PathVariable("id") int id) {
		try {
			return this.storeService.getStore(id);
		} catch (XstoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * This api will add new store
	 * 
	 * @param Store
	 * @return boolean TODO
	 */
	/*@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapper addStore(@RequestBody Store store) {
		try {
			return this.storeService.addStore(store);
		} catch (XstoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}*/

	/*
	 * @RequestMapping(value = "/dummy", method = RequestMethod.GET)
	 * 
	 * @ResponseBody public Store dummy() { Store store = new Store();
	 * Client client = new Client(); client.setId(5); store.setId(1);
	 * store.setName("nan"); store.setTimeZone("IST");
	 * store.setCurrency("Rs."); store.setClient(client); return store; }
	 */

	/**
	 * This api will update store info
	 * 
	 * @param Store
	 * @return boolean
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapper updateStore(@RequestBody Store store) {
		try {
			return this.storeService.updateStore(store);
		} catch (XstoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/activateordeactivate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapper deactivateOrActivateStore(
			@RequestBody Store store) {
		try {
			return this.storeService
					.deactivateOrActivateStore(store);
		} catch (XstoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	@RequestMapping(value = "/{id}/category/add", method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapper addTagToStore(@PathVariable String id, @RequestBody Tag tag) {
		int storeId = Integer.parseInt(id);
		return  this.storeService.addTagToStore(storeId, tag);
	}
	
	@RequestMapping(value = "/{id}/categories", method = RequestMethod.GET)
	@ResponseBody
	public ListResponseWrapper getTagsByStore(@PathVariable String id) {
		int storeId = Integer.parseInt(id);
		return this.storeService.getTagsByStore(storeId);
	}
	
	@RequestMapping(value = "/{id}/categories/activated", method = RequestMethod.GET)
	@ResponseBody
	public ListResponseWrapper getActivatedTagsByStore(@PathVariable String id) {
		int storeId = Integer.parseInt(id);
		return this.storeService.getActivatedTagsByStore(storeId);
	}
	
	@RequestMapping(value = "/{id}/categories/deactivated", method = RequestMethod.GET)
	@ResponseBody
	public ListResponseWrapper getDeactivatedTagsByStore(@PathVariable String id) {
		int storeId = Integer.parseInt(id);
		return this.storeService.getDeactivatedTagsByStore(storeId);
	}
	
	@RequestMapping(value = "/dummy", method = RequestMethod.GET)
	@ResponseBody
	public Store dummy() {
		Store store = new Store();
		store.setName("MyStore");
		store.setCurrency("Rs.");
		store.setTimeZone("IST");
		store.setStatus(true);
		return store;
	}
}
