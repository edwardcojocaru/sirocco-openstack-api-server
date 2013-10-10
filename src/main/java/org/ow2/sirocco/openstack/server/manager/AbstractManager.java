/*
 * SIROCCO
 * Copyright (C) 2013 Orange Labs
 * Contact: sirocco@ow2.org
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307
 * USA
 */

package org.ow2.sirocco.openstack.server.manager;

import org.ow2.sirocco.cloudmanager.core.api.exception.*;
import org.ow2.sirocco.openstack.server.converter.InvalidConversionException;
import org.ow2.sirocco.openstack.server.request.MessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.Response;

/**
 * User: Eduard.Cojocaru
 * Date: 10/10/13
 */
public abstract class AbstractManager implements IManager {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractManager.class);

    private Object serviceHelper;

    @Override
    public void execute(MessageContext context, OperationEnum operation) {

        try {
            context.setCallServiceHelper(this.serviceHelper);

            if (this.doValidate(context)) {
                Object dataServiceIn = this.convertToDataService(context);
                Object dataServiceOut;
                switch (operation) {
                    case READ:
                        dataServiceOut = this.read(context, dataServiceIn);
                        break;
                    case CREATE:
                        dataServiceOut = this.create(context, dataServiceIn);
                        break;
                    case UPDATE:
                        dataServiceOut = this.update(context, dataServiceIn);
                        break;
                    case DELETE:
                        dataServiceOut = this.delete(context, dataServiceIn);
                        break;
                    default:
                        throw new InvalidOperationException("This operation is not supported.");
                }


                if (!context.getResponse().isCommitted()) {
                    this.convertToResponse(context, dataServiceOut);
                }
            }
        } catch (InvalidConversionException e) {
            this.convertToResponse(context, e);
        } catch (ResourceNotFoundException e) {
            this.convertToResponse(context, e);
        } catch (InvalidRequestException e) {
            this.convertToResponse(context, e);
        } catch (ResourceConflictException e) {
            this.convertToResponse(context, e);
        } catch (ServiceUnavailableException e) {
            this.convertToResponse(context, e);
        } catch (SecurityException e) {
            this.convertToResponse(context, e);
        } catch (UnsupportedOperationException e) {
            this.convertToResponse(context, e);
        } catch (CloudProviderException e) {
            this.convertToResponse(context, e);
        } catch (Exception e) {
            this.convertToResponse(context, e);
        }
    }

    /**
     * Validate the request.
     *
     * @param context The message context
     * @return True if the request is valid
     * @throws Exception In case of validation error
     */
    protected boolean validate(MessageContext context) throws Exception {
        // TODO to be changed if the request parameters will be taken as they are and not as method parameters. Otherwise it may be removed.
        return true;
    }

    /**
     * Convert the message data from request to a service data.
     *
     * @param context The message context
     * @return The input service data
     * @throws Exception In case of conversion error
     */
    protected abstract Object convertToDataService(MessageContext context) throws Exception;

    /**
     * Perform read operation.
     *
     * @param context The message context
     * @param dataService The input service data
     * @return The output service data or null if none output
     * @throws Exception In case of error in service
     */
    protected abstract Object read(MessageContext context, Object dataService) throws Exception;

    /**
     * Perform create operation.
     *
     * @param context The message context
     * @param dataService The input service data
     * @return The output service data or null if none output
     * @throws Exception In case of error in service
     */
    protected abstract Object create(MessageContext context, Object dataService) throws Exception;

    /**
     * Perform update operation.
     *
     * @param context The message context
     * @param dataService The input service data
     * @return The output service data or null if none output
     * @throws Exception In case of error in service
     */
    protected abstract Object update(MessageContext context, Object dataService) throws Exception;

    /**
     * Perform update operation.
     *
     * @param context The message context
     * @param dataService The input service data
     * @return The output service data or null if none output
     * @throws Exception In case of error in service
     */
    protected abstract Object delete(MessageContext context, Object dataService) throws Exception;


    /**
     * Convert the service data to a message data from request.
     *
     * @param context The message context
     * @param dataService The output service data
     * @throws Exception In case of conversion error
     */
    protected abstract void convertToResponse(MessageContext context, Object dataService) throws Exception;

    /**
     * Manage the request validation.
     *
     * @param context The message context
     * @return True if the request is valid
     * @throws Exception In case of validation error
     */
    private boolean doValidate(final MessageContext context) throws Exception {
        boolean valid = this.validate(context);
        if (!valid) {
            context.getResponse().setStatus(Response.Status.BAD_REQUEST);
        }
        return valid;
    }

    /**
     * Convert general exception to HTTP status "INTERNAL_SERVER_ERROR" (500).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final Exception exception) {
        LOGGER.error("Internal Server Error", exception);
        context.getResponse().setStatus(Response.Status.INTERNAL_SERVER_ERROR);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "NOT FOUND" (404).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final ResourceNotFoundException exception) {
        LOGGER.debug("Resource not found : {}", context.getRequest().getId());
        context.getResponse().setStatus(Response.Status.NOT_FOUND);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "BAD REQUEST" (400).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final InvalidRequestException exception) {
        LOGGER.debug(exception.getMessage(), exception);
        context.getResponse().setStatus(Response.Status.BAD_REQUEST);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "BAD REQUEST" (400).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final InvalidConversionException exception) {
        LOGGER.debug(exception.getMessage(), exception);
        context.getResponse().setStatus(Response.Status.BAD_REQUEST);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "CONFLICT" (409).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final ResourceConflictException exception) {
        LOGGER.debug(exception.getMessage(), exception);
        context.getResponse().setStatus(Response.Status.CONFLICT);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "SERVICE UNAVAILABLE" (503).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final ServiceUnavailableException exception) {
        LOGGER.debug(exception.getMessage(), exception);
        context.getResponse().setStatus(Response.Status.SERVICE_UNAVAILABLE);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "FORBIDDEN" (403).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final SecurityException exception) {
        LOGGER.debug(exception.getMessage(), exception);
        context.getResponse().setStatus(Response.Status.FORBIDDEN);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "NOT IMPLEMENTED" (501).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final UnsupportedOperationException exception) {
        LOGGER.debug(exception.getMessage(), exception);
        context.getResponse().setStatus(501);
        context.getResponse().setErrorMessage(exception.getMessage());
    }

    /**
     * Convert exception to HTTP status "INTERNAL_SERVER_ERROR" (500).
     *
     * @param context The message context
     * @param exception The exception to convert
     */
    private void convertToResponse(final MessageContext context, final CloudProviderException exception) {
        LOGGER.error(exception.getMessage(), exception);
        context.getResponse().setStatus(Response.Status.INTERNAL_SERVER_ERROR);
        context.getResponse().setErrorMessage(exception.getMessage());
    }
}
