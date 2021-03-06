/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.aprendiendola.toolbar.jarsearch;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import org.openide.awt.HtmlBrowser.URLDisplayer;
import org.openide.awt.Mnemonics;
import org.openide.util.Exceptions;
import org.openide.util.NbBundle;

/**
 * Class that allow us to search in several sites for a Jar.
 *
 * @author ruslan.lopez
 */
public class JarSearchPanel extends javax.swing.JPanel {

    /**
     * Hols a map between search sites and URL's.
     */
    private final transient Map<String, String> sitesAndURLs
            = new HashMap<String, String>();
    /**
     * Hols a map between search sites and it graphic resources.
     */
    private final transient Map<String, String> sitesAndImages
            = new HashMap<String, String>();
    /**
     * Field for serializing.
     */
    private static final long serialVersionUID = 1L;
    /**
     * base path for image resources.
     */
    private static final String BASE_PATH
            = "/web/aprendiendola/toolbar/jarsearch/";

    /**
     * Creates new form Java2sPanel.
     */
    public JarSearchPanel() {
        super();
        addSearchSite("Java2s",
                "http://cse.google.com/cse?cx="
                + "partner-pub-1130008796007602:iri8be-v211"
                + "&siteurl=www.java2s.com&q=",
                BASE_PATH + "java2s.gif");
        addSearchSite("findJar",
                "http://www.findjar.com/index.x?query=",
                BASE_PATH + "jarsearch.gif");
        addSearchSite("sapjarfinder",
                "http://sapjarfinder.com/?q=", BASE_PATH + "sapjarfinder.gif");
        addSearchSite("Google Search",
                "https://www.google.com.mx/search?safe=off&noj=&q=jar+",
                "google.gif");
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        final JLabel lblSearch = new JLabel();
        searchText = new JTextField();
        sitesCombo = new JComboBox(sitesAndImages.keySet().toArray());
        sitesCombo.setRenderer(new MyComboRendere());
        ;

        setMinimumSize(new Dimension(150, 20));
        setLayout(new BorderLayout());

        Mnemonics.setLocalizedText(lblSearch, NbBundle.getMessage(JarSearchPanel.class, "JarSearchPanel.lblSearch.text")); // NOI18N
        add(lblSearch, BorderLayout.LINE_START);

        searchText.setText(NbBundle.getMessage(JarSearchPanel.class, "JarSearchPanel.searchText.text")); // NOI18N
        searchText.setToolTipText(NbBundle.getBundle(JarSearchPanel.class).getString("JarSearchPanel.searchText.toolTipText")); // NOI18N
        searchText.setMinimumSize(new Dimension(4, 2));
        searchText.setPreferredSize(new Dimension(100, 20));
        searchText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        add(searchText, BorderLayout.CENTER);

        sitesCombo.setMinimumSize(new Dimension(40, 20));
        add(sitesCombo, BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Detects action events on the text field and call the search
     * functionality.
     *
     * @param evt the event
     * @see #search()
     */
    private void searchTextActionPerformed(ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        search();
    }//GEN-LAST:event_searchTextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    /** Variable that holds the search terms. */
    private transient JTextField searchText;
    /** Combo containing search site names. */
    private transient JComboBox<String> sitesCombo;
    // End of variables declaration//GEN-END:variables

    /**
     * Performs the search in the specified search site.
     */
    private void search() {
        try {
            final String textToSearch = URLEncoder.encode(
                    this.searchText.getText(),
                    "UTF-8");
            final String url = sitesAndURLs.get(
                    (String) sitesCombo.getSelectedItem());
            URLDisplayer.getDefault().showURL(new URL(url + textToSearch));
        } catch (UnsupportedEncodingException eee) {
            Exceptions.printStackTrace(eee); //nothing much to do
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    /**
     * Adds a new search site.
     *
     * @param siteName name of th site
     * @param siteURL url of the site
     * @param siteIcon path of the icon to be displayed
     */
    private void addSearchSite(final String siteName, final String siteURL,
            final String siteIcon) {
        sitesAndURLs.put(siteName, siteURL);
        sitesAndImages.put(siteName, siteIcon);
    }

    /**
     * Handles the rendering of List elements.
     */
    class MyComboRendere implements ListCellRenderer<String> {

        @Override
        public Component getListCellRendererComponent(
                final JList<? extends String> list,
                final String value, final int index,
                final boolean isSelected,
                final boolean cellHasFocus) {
            final JLabel label = new JLabel();
            label.setOpaque(true);
            final String nombreSitio = value;
            label.setText(nombreSitio);
            label.setIcon(new ImageIcon(
                    getClass().getResource(sitesAndImages.get(nombreSitio)))
            );
            if (isSelected) {
                label.setBackground(Color.LIGHT_GRAY);
            }
            return label;
        }

    }
}
