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
import com.amzedia.xstore.model.Group;
import com.amzedia.xstore.model.ListResponseWrapper;
import com.amzedia.xstore.model.ResponseWrapper;
import com.amzedia.xstore.model.Store;
import com.amzedia.xstore.model.Tag;
import com.amzedia.xstore.services.interfaces.ITagService;

/**
 * @author Tarun Keswani
 * 
 */

@Controller
@RequestMapping(value = "/category")
public class TagRestService {

	@Autowired
	private ITagService tagService;

	@RequestMapping(value = "/{id}")
	@ResponseBody
	public ResponseWrapper getTagById(@PathVariable String id) {
		int tagId = Integer.parseInt(id);
		try {
			return this.tagService.getTag(tagId);
		} catch (XstoreException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/{id}/activated", method = RequestMethod.GET)
	@ResponseBody
	public ListResponseWrapper getActivatedTagByParentTag(
			@PathVariable String id) {
		int tagId = Integer.parseInt(id);
		return this.tagService.getActivatedTagByParentTag(tagId);
	}

	@RequestMapping(value = "/{id}/deactivated", method = RequestMethod.GET)
	@ResponseBody
	public ListResponseWrapper getDeActivatedTagByParentTag(
			@PathVariable String id) {
		int tagId = Integer.parseInt(id);
		return this.tagService.getDeActivatedTagByParentTag(tagId);
	}

	/**
	 * This api will update tag info
	 * 
	 * @param Tag
	 * @return boolean
	 */
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapper updateTag(@RequestBody Tag tag) {
		try {
			return this.tagService.updateTag(tag);
		} catch (XstoreException e) {
			e.printStackTrace();
			return null;
		}
	}

	@RequestMapping(value = "/activateordeactivate", method = RequestMethod.POST)
	@ResponseBody
	public ResponseWrapper deactivateOrActivateTag(@RequestBody Tag tag) {
		try {
			return this.tagService.deactivateOrActivateTag(tag);
		} catch (XstoreException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * Adding Tag to its parent tag TODO
	 */

	/*
	 * @RequestMapping(value = "/{id}/add", method = RequestMethod.POST)
	 * 
	 * @ResponseBody public ResponseWrapper addTagToParentTag(@PathVariable
	 * String id,
	 * 
	 * @RequestBody Tag tag) { int tagId = Integer.parseInt(id); return
	 * this.tagService.addTagToParentTag(tagId, tag); }
	 */
}
