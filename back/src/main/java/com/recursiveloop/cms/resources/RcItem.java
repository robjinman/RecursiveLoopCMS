// This file is property of Recursive Loop Ltd.
//
// Author: Rob Jinman
// Web: http://recursiveloop.org
// Copyright Recursive Loop Ltd 2015
// Copyright Rob Jinman 2015


package com.recursiveloop.cms.resources;

import com.recursiveloop.cms.ShallowItem;
import com.recursiveloop.cms.StringItem;
import javax.json.JsonObject;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;


@Path("/repository/itemTree")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface RcItem {
  /**
  * For CORS compliance
  */
  @OPTIONS
  public Response doNothing();

  /**
  * Returns the full item tree. The items do not contain any content
  */
  @GET
  public ShallowItem get() throws Exception;

  /**
  * Returns the subtree at specified path. The items do not contain any content
  */
  @GET
  @Path("{path}")
  public ShallowItem getSubtree(@PathParam("path") String path) throws Exception;

  /**
  * Retrieves a full item (excluding its children)
  */
  @GET
  @Path("item/{path}")
  public StringItem getItem(@PathParam("path") String path) throws Exception;

  /**
  * Insert a new item at the location specified by the item's path property
  */
  @POST
  public Response insertItem(JsonObject item) throws Exception;

  /**
  * Update an existing item at the location specified by the item's path property
  */
  @PUT
  public Response updateItem(JsonObject item) throws Exception;

  /**
  * Delete the subtree at the specified path
  */
  @DELETE
  @Path("item/{path}")
  public Response deleteItem(@PathParam("path") String path) throws Exception;
}
