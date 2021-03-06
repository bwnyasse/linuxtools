/*******************************************************************************
 * Copyright (c) 2007, 2016 Alphonse Van Assche.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Alphonse Van Assche - initial API and implementation
 *******************************************************************************/

package org.eclipse.linuxtools.rpm.ui.editor.tests;

import static org.junit.Assert.fail;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.eclipse.linuxtools.internal.rpm.ui.editor.Activator;
import org.eclipse.linuxtools.internal.rpm.ui.editor.RpmPackageProposalsList;
import org.eclipse.linuxtools.internal.rpm.ui.editor.preferences.PreferenceConstants;
import org.junit.Before;
import org.junit.Test;

public class RpmPackageProposalsListTest {

    private RpmPackageProposalsList packageProposalsList;

    @Before
    public void setUp() throws IOException {
        Activator.getDefault().getPreferenceStore().setValue(
                PreferenceConstants.P_RPM_LIST_FILEPATH, "/tmp/pkglist");
        Files.write(Paths.get("/tmp/pkglist"), "setup\ntest\nrpm\n".getBytes());
        packageProposalsList = new RpmPackageProposalsList();
    }

    @Test
    public final void testGetProposals() {
        List<String[]> proposals = packageProposalsList.getProposals("setup");
        if (!(proposals.size() == 1)) {
            fail("getProposals failed, setup package was retrieve as proposals!");
        }
    }

    @Test
    public final void testGetValue() {
        if (Files.exists(Paths.get("/bin/rpm"))) {
            if (!packageProposalsList.getValue("rpm").startsWith(
                    "<b>Name: </b>rpm")) {
                fail("getValue failed, rpm package info doesn't start with '<b>Name:<b> rpm'");
            }
        }
    }

    @Test
    public final void testGetValue2() {
        if (packageProposalsList.getValue("test").indexOf("test") == -1) {
            fail("getValue failed, test package info doesn't contain 'test'");
        }
    }

    @Test
    public final void testGetRpmInfo() {
        if (Files.exists(Paths.get("/bin/rpm"))) {
            if (!packageProposalsList.getRpmInfo("rpm").startsWith(
                    "<b>Name: </b>rpm")) {
                fail("getRpmInfo failed, rpm package info doesn't start with '<b>Name:<b> rpm'");
            }
        }
    }

    @Test
    public final void testGetRpmInfo2() {
        if (packageProposalsList.getValue("test").indexOf("test") == -1) {
            fail("getRpmInfo failed, test package info doesn't contain 'test'");
        }
    }

}
