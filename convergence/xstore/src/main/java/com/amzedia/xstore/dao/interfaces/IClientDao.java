/**
 * This Class will provide all client services
 */
package com.amzedia.xstore.dao.interfaces;

import java.util.List;

import com.amzedia.xstore.XstoreException;
import com.amzedia.xstore.model.ChangePassword;
import com.amzedia.xstore.model.Client;
import com.amzedia.xstore.model.Group;
import com.amzedia.xstore.model.ResponseWrapper;

/**
 * This Class contains all the client operations methods
 * 
 * @author Sushant
 * 
 */
public interface IClientDao {

	/**
	 * Get client by id of client
	 * 
	 * @param id
	 * @return Client
	 */
	ResponseWrapper getClient(int id) throws XstoreException;

	/**
	 * This api will add new client
	 * 
	 * @param client
	 * @return boolean
	 */
	boolean registerClient(Client client) throws RuntimeException;

	/**
	 * This api will update client profile
	 * 
	 * @param client
	 * @return boolean
	 */
	ResponseWrapper updateClient(Client client) throws XstoreException;

	/**
	 * This will return client object on basis of correct user name and
	 * password
	 * 
	 * @param client
	 * @return Client
	 */
	ResponseWrapper loginClient(Client client) throws XstoreException;

	/**
	 * This api will change client password
	 * 
	 * @param changePassword
	 * @return boolean
	 */
	ResponseWrapper changePassword(ChangePassword changePassword)
			throws XstoreException;

	/**
	 * This will reset the client password
	 * 
	 * @param client
	 * @return boolean
	 */
	ResponseWrapper forgetPassword(Client client) throws XstoreException;

	/**
	 * This api will deactivate client
	 * 
	 * @param client
	 * @return boolean
	 */
	ResponseWrapper deactivateOrActivateClient(Client client)
			throws XstoreException;

	/**
	 * 
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	List<Group> getAllGroupByClient(int id) throws RuntimeException;

	/**
	 * This api will add dummy data to db
	 * 
	 * @return ResponseWrapper
	 */
	ResponseWrapper dummy() throws XstoreException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	List<Group> getDeactivatedGroupByClient(int id) throws RuntimeException;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws RuntimeException
	 */
	List<Group> getActivatedGroupByClient(int id) throws RuntimeException;
	
	/**
	 * 
	 * @param id
	 * @param group
	 * @return boolean
	 * @throws RuntimeException
	 */
	boolean addGroupToClient(int id, Group group) throws RuntimeException;
}
