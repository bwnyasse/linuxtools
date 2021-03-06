/*******************************************************************************
 * Copyright (c) 2016 Red Hat.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Red Hat - Initial Contribution
 *******************************************************************************/

package org.eclipse.linuxtools.docker.core;

/**
 * 
 */
public class DockerProcessException extends DockerException {

	/**
	 * Constructor
	 * 
	 * @param message
	 *            the error message
	 */
	public DockerProcessException(String message) {
		super(message);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 7940420692807693369L;

}
