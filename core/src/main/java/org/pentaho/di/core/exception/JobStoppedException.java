/*! ******************************************************************************
 *
 * Pentaho Data Integration
 *
 * Copyright (C) 2002-2017 by Hitachi Vantara : http://www.pentaho.com
 *
 *******************************************************************************
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 ******************************************************************************/

package org.pentaho.di.core.exception;

/**
 * This exception is used when handling stopped jobs during blocking operations.
 *
 * @author Nick Hudak
 * @since 2-13-2014
 */
public class JobStoppedException extends KettleJobException {
    public static final long serialVersionUID = 3307875569693837831L;

    /**
     * Constructs a new throwable with null as its detail message.
     */
    public JobStoppedException() {
        super();
    }

    /**
     * Constructs a new throwable with the specified detail message.
     *
     * @param message - the detail message. The detail message is saved for later retrieval by the getMessage() method.
     */
    public JobStoppedException(String message) {
        super(message);
    }

    /**
     * Constructs a new throwable with the specified cause and a detail message of (cause==null ? null : cause.toString())
     * (which typically contains the class and detail message of cause).
     *
     * @param cause the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and
     *              indicates that the cause is nonexistent or unknown.)
     */
    public JobStoppedException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new throwable with the specified detail message and cause.
     *
     * @param message the detail message (which is saved for later retrieval by the getMessage() method).
     * @param cause   the cause (which is saved for later retrieval by the getCause() method). (A null value is permitted, and
     *                indicates that the cause is nonexistent or unknown.)
     */
    public JobStoppedException(String message, Throwable cause) {
        super(message, cause);
    }
}
