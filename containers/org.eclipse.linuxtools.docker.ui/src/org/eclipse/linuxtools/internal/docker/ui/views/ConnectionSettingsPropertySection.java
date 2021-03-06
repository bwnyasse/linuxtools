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

package org.eclipse.linuxtools.internal.docker.ui.views;

import org.eclipse.core.runtime.Assert;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.ITreeSelection;
import org.eclipse.linuxtools.docker.core.IDockerConnection;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.views.properties.tabbed.TabbedPropertySheetPage;

/**
 * @author jjohnstn
 *
 */
public class ConnectionSettingsPropertySection extends BasePropertySection {

	@Override
	public void createControls(Composite parent, TabbedPropertySheetPage propertySheetPage) {
		super.createControls(parent, propertySheetPage);
		getTreeViewer()
				.setContentProvider(new ConnectionSettingsContentProvider());
	}

	@Override
	public void setInput(final IWorkbenchPart part, final ISelection selection) {
		super.setInput(part, selection);
		Assert.isTrue(selection instanceof ITreeSelection);
		Object input = ((ITreeSelection) selection).getFirstElement();
		Assert.isTrue(input instanceof IDockerConnection);
		IDockerConnection connection = (IDockerConnection) input;
		if (getTreeViewer() != null) {
			getTreeViewer().setInput(connection);
			getTreeViewer().expandAll();
		}
	}

}
