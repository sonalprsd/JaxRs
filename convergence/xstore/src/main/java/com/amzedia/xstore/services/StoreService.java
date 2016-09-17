/**
 * 
 */
package com.amzedia.xstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amzedia.xstore.XstoreException;
import com.amzedia.xstore.dao.interfaces.IStoreDao;
import com.amzedia.xstore.model.Customer;
import com.amzedia.xstore.model.ListResponseWrapper;
import com.amzedia.xstore.model.Product;
import com.amzedia.xstore.model.ResponseWrapper;
import com.amzedia.xstore.model.Store;
import com.amzedia.xstore.model.Tag;
import com.amzedia.xstore.services.interfaces.IStoreService;
import com.amzedia.xstore.util.Message;
import com.amzedia.xstore.util.ResponseCode;
import com.amzedia.xstore.util.ResponseMessage;

/**
 * @author Tarun Keswani
 * 
 */
@Service
public class StoreService implements IStoreService {

	@Autowired
	private IStoreDao storeDao;

	/**
	 * @throws XstoreException
	 * 
	 */
	/*
	 * public ResponseWrapper addStore(Store store) throws XstoreException {
	 * return this.storeDao.addStore(store); }
	 */

	public ResponseWrapper deactivateOrActivateStore(Store store)
			throws XstoreException {
		return this.storeDao.deactivateOrActivateStore(store);
	}

	/**
	 * Get client by id of client
	 * 
	 * @param id
	 * @return Store
	 * @throws XstoreException
	 */
	public ResponseWrapper getStore(int id) throws XstoreException {
		return this.storeDao.getStore(id);
	}

	/*
	 * This API will update the Store info
	 */
	public ResponseWrapper updateStore(Store store) throws XstoreException {

		return this.storeDao.updateStore(store);
	}

	/*
	 * API to add Product to store
	 */
	public ResponseWrapper addProductToStore(int id, Product product) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			boolean status = this.storeDao.addProductToStore(id,
					product);
			if (status) {
				responseWrapper.setStatus(ResponseCode.OK);
				responseWrapper.setMessage(ResponseMessage.SUCCESS);
				responseWrapper.setResult(Message.PRODUCT_ADDED);
			} else {
				responseWrapper.setStatus(ResponseCode.FAIL);
				responseWrapper.setMessage(ResponseMessage.FAIL);
				responseWrapper.setResult(Message.PRODUCT_NOT_ADDED);
			}

		} catch (Exception e) {
			responseWrapper.setStatus(ResponseCode.FAIL);
			responseWrapper.setMessage(ResponseMessage.FAIL);
			responseWrapper.setResult(e.getCause().getCause()
					.getMessage());
		}
		return responseWrapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amzedia.xstore.services.interfaces.IStoreService#addTagToStore
	 * (int, com.amzedia.xstore.model.Tag)
	 */
	public ResponseWrapper addTagToStore(int id, Tag tag) {
		ResponseWrapper responseWrapper = new ResponseWrapper();
		try {
			boolean status = this.storeDao.addTagToStore(id, tag);
			if (status) {
				responseWrapper.setStatus(ResponseCode.OK);
				responseWrapper.setMessage(ResponseMessage.SUCCESS);
				responseWrapper.setResult(Message.TAG_ADDED);
			} else {
				responseWrapper.setStatus(ResponseCode.FAIL);
				responseWrapper.setMessage(ResponseMessage.FAIL);
				responseWrapper.setResult(Message.TAG_NOT_ADDED);
			}
		} catch (Exception e) {
			responseWrapper.setStatus(ResponseCode.FAIL);
			responseWrapper.setMessage(ResponseMessage.FAIL);
			responseWrapper.setResult(e.getCause().getCause()
					.getMessage());
		}
		return responseWrapper;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amzedia.xstore.services.interfaces.IStoreService#getTagsByStore
	 * (int)
	 */
	public ListResponseWrapper getTagsByStore(int id) {
		ListResponseWrapper listResponseWrapper = new ListResponseWrapper();
		List<Object> objects = new ArrayList<Object>();
		try {
			List<Tag> tags = this.storeDao.getTagsByStore(id);

			for (Tag tag : tags) {
				objects.add(tag);
			}
			listResponseWrapper.setStatus(ResponseCode.OK);
			listResponseWrapper.setMessage(ResponseMessage.SUCCESS);
			listResponseWrapper.setResult(objects);
		} catch (Exception e) {
			objects.add(e.getCause().getCause().getMessage());
			listResponseWrapper.setStatus(ResponseCode.FAIL);
			listResponseWrapper.setMessage(ResponseMessage.FAIL);
			listResponseWrapper.setResult(objects);
		}
		return listResponseWrapper;
	}

	/* (non-Javadoc)
	 * @see com.amzedia.xstore.services.interfaces.IStoreService#getActivatedTagsByStore(int)
	 */
	public ListResponseWrapper getActivatedTagsByStore(int id) {
		ListResponseWrapper listResponseWrapper = new ListResponseWrapper();
		List<Object> objects = new ArrayList<Object>();
		try {
			List<Tag> tags = this.storeDao.getActivatedTagsByStore(id);

			for (Tag tag : tags) {
				objects.add(tag);
			}
			listResponseWrapper.setStatus(ResponseCode.OK);
			listResponseWrapper.setMessage(ResponseMessage.SUCCESS);
			listResponseWrapper.setResult(objects);
		} catch (Exception e) {
			objects.add(e.getCause().getCause().getMessage());
			listResponseWrapper.setStatus(ResponseCode.FAIL);
			listResponseWrapper.setMessage(ResponseMessage.FAIL);
			listResponseWrapper.setResult(objects);
		}
		return listResponseWrapper;
	}

	/* (non-Javadoc)
	 * @see com.amzedia.xstore.services.interfaces.IStoreService#getDeactivatedTagsByStore(int)
	 */
	public ListResponseWrapper getDeactivatedTagsByStore(int id) {
		ListResponseWrapper listResponseWrapper = new ListResponseWrapper();
		List<Object> objects = new ArrayList<Object>();
		try {
			List<Tag> tags = this.storeDao.getDeactivatedTagsByStore(id);

			for (Tag tag : tags) {
				objects.add(tag);
			}
			listResponseWrapper.setStatus(ResponseCode.OK);
			listResponseWrapper.setMessage(ResponseMessage.SUCCESS);
			listResponseWrapper.setResult(objects);
		} catch (Exception e) {
			objects.add(e.getCause().getCause().getMessage());
			listResponseWrapper.setStatus(ResponseCode.FAIL);
			listResponseWrapper.setMessage(ResponseMessage.FAIL);
			listResponseWrapper.setResult(objects);
		}
		return listResponseWrapper;
	}

}
