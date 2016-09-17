/**
 * 
 */
package com.amzedia.xstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amzedia.xstore.XstoreException;
import com.amzedia.xstore.dao.interfaces.ITagDao;
import com.amzedia.xstore.model.ListResponseWrapper;
import com.amzedia.xstore.model.ResponseWrapper;
import com.amzedia.xstore.model.Tag;
import com.amzedia.xstore.services.interfaces.ITagService;
import com.amzedia.xstore.util.ResponseCode;
import com.amzedia.xstore.util.ResponseMessage;

/**
 * @author Tarun Keswani
 * 
 * 
 */
@Service
public class TagService implements ITagService {

	@Autowired
	private ITagDao tagDao;

	/*
	 * This will return Tag using TagId
	 */
	public ResponseWrapper getTag(int id) throws XstoreException {
		return this.tagDao.getTag(id);
	}

	/*
	 * getting activated tags under the parent tag
	 */
	public ListResponseWrapper getActivatedTagByParentTag(int id) {

		ListResponseWrapper responseWrapper = new ListResponseWrapper();
		List<Object> objects = new ArrayList<Object>();
		try {
			List<Tag> tags = this.tagDao
					.getActivatedTagByParentTag(id);
			for (Tag tag : tags) {
				objects.add(tag);
			}
			responseWrapper.setStatus(ResponseCode.OK);
			responseWrapper.setResult(objects);
			responseWrapper.setMessage(ResponseMessage.SUCCESS);

		} catch (Exception e) {
			objects.add(e.getCause().getCause().getMessage());
			responseWrapper.setStatus(ResponseCode.FAIL);
			responseWrapper.setMessage(ResponseMessage.FAIL);
			responseWrapper.setResult(objects);
		}

		return responseWrapper;
	}

	/*
	 * getting deactivated tags under the parent tag
	 */
	public ListResponseWrapper getDeActivatedTagByParentTag(int id) {

		ListResponseWrapper responseWrapper = new ListResponseWrapper();
		List<Object> objects = new ArrayList<Object>();
		try {
			List<Tag> tags = this.tagDao
					.getDeActivatedTagByParentTag(id);
			for (Tag tag : tags) {
				objects.add(tag);
			}
			responseWrapper.setStatus(ResponseCode.OK);
			responseWrapper.setResult(objects);
			responseWrapper.setMessage(ResponseMessage.SUCCESS);

		} catch (Exception e) {
			objects.add(e.getCause().getCause().getMessage());
			responseWrapper.setStatus(ResponseCode.FAIL);
			responseWrapper.setMessage(ResponseMessage.FAIL);
			responseWrapper.setResult(objects);
		}

		return responseWrapper;
	}

	/*
	 * update tag
	 */
	public ResponseWrapper updateTag(Tag tag) throws XstoreException {
		return this.tagDao.updateTag(tag);
	}

	/*
	 * activating or deactivating tags
	 */
	public ResponseWrapper deactivateOrActivateTag(Tag tag)
			throws XstoreException {
		return this.tagDao.deactivateOrActivateTag(tag);
	}

	/*
	 * adding tag to its parent tag TODO
	 */
	/*
	 * public ResponseWrapper addTagToParentTag(int id, Tag tag) {
	 * ResponseWrapper responseWrapper = new ResponseWrapper(); try {
	 * boolean status = this.tagDao.addTagToParentTag(id, tag); if (status)
	 * { responseWrapper.setStatus(ResponseCode.OK);
	 * responseWrapper.setMessage(ResponseMessage.SUCCESS);
	 * responseWrapper.setResult(Message.TAG_NOT_ADDED); } else {
	 * responseWrapper.setStatus(ResponseCode.FAIL);
	 * responseWrapper.setMessage(ResponseMessage.FAIL);
	 * responseWrapper.setResult(Message.TAG_NOT_ADDED); } } catch
	 * (Exception e) { responseWrapper.setStatus(ResponseCode.FAIL);
	 * responseWrapper.setMessage(ResponseMessage.FAIL);
	 * responseWrapper.setResult(e.getCause().getCause() .getMessage()); }
	 * return responseWrapper; }
	 */

}
