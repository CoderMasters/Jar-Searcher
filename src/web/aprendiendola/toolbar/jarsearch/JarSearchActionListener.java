/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.aprendiendola.toolbar.jarsearch;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.AbstractAction;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;
import org.openide.util.actions.Presenter;

@ActionID(
        category = "File",
        id = "com.java2s.toolbar.JarFinderActionListener"
)
@ActionRegistration(
        iconBase = "com/java2s/toolbar/java2s.gif",
        displayName = "#CTL_JarFinderActionListener"
)
@ActionReference(path = "Toolbars/Search", position = Integer.MAX_VALUE)
@Messages("CTL_JarFinderActionListener=JarFinder")
public final class JarSearchActionListener extends AbstractAction implements ActionListener, Presenter.Toolbar {

    @Override
    public void actionPerformed(ActionEvent e) {
        //delegated to toolbar
    }

    @Override
    public Component getToolbarPresenter() {
        return new JarSearchPanel();
    }
}
