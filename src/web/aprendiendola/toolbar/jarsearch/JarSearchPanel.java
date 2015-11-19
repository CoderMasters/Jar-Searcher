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
import java.util.Hashtable;
import java.util.Vector;
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

    Hashtable<String, String> searchSitesAndURLs = new Hashtable<String, String>();
    Hashtable<String, String> searchSitesAndImages = new Hashtable<String, String>();
    private static final long serialVersionUID = 1L;
    final String basePath = "/web/aprendiendola/toolbar/jarsearch/";

    /**
     * Creates new form Java2sPanel
     */
    public JarSearchPanel() {
        addSearchSite("Java2s", "http://cse.google.com/cse?cx=partner-pub-1130008796007602:iri8be-v211&siteurl=www.java2s.com&q=", basePath + "java2s.gif");
        addSearchSite("findJar", "http://www.findjar.com/index.x?query=", basePath + "jarsearch.gif");
        addSearchSite("sapjarfinder", "http://sapjarfinder.com/?q=", basePath + "sapjarfinder.gif");
        addSearchSite("Google Search", "https://www.google.com.mx/search?safe=off&noj=&q=jar+", "google.gif");
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

        lblSearch = new JLabel();
        searchText = new JTextField();
        jComboBox1 = new JComboBox(new Vector(searchSitesAndImages.keySet()));
        jComboBox1.setRenderer(new MyComboRendere());

        setLayout(new BorderLayout());

        Mnemonics.setLocalizedText(lblSearch, NbBundle.getMessage(JarSearchPanel.class, "JarSearchPanel.lblSearch.text")); // NOI18N
        add(lblSearch, BorderLayout.LINE_START);

        searchText.setColumns(20);
        searchText.setText(NbBundle.getMessage(JarSearchPanel.class, "JarSearchPanel.searchText.text")); // NOI18N
        searchText.setToolTipText(NbBundle.getMessage(JarSearchPanel.class, "JarSearchPanel.searchText.toolTipText")); // NOI18N
        searchText.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchTextActionPerformed(evt);
            }
        });
        add(searchText, BorderLayout.CENTER);

        jComboBox1.setMinimumSize(new Dimension(40, 20));
        add(jComboBox1, BorderLayout.LINE_END);
    }// </editor-fold>//GEN-END:initComponents

    private void searchTextActionPerformed(ActionEvent evt) {//GEN-FIRST:event_searchTextActionPerformed
        search();
    }//GEN-LAST:event_searchTextActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JComboBox jComboBox1;
    private JLabel lblSearch;
    private JTextField searchText;
    // End of variables declaration//GEN-END:variables

    private void search() {
        try {
            String textToSearch = URLEncoder.encode(this.searchText.getText(), "UTF-8");
            String url = searchSitesAndURLs.get(jComboBox1.getSelectedItem());
            URLDisplayer.getDefault().showURL(new URL(url + textToSearch));
        } catch (UnsupportedEncodingException eee) {
            Exceptions.printStackTrace(eee);//nothing much to do
        } catch (MalformedURLException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    private void addSearchSite(String siteName, String siteURL, String siteIcon) {
        searchSitesAndURLs.put(siteName, siteURL);
        searchSitesAndImages.put(siteName, siteIcon);
    }

    class MyComboRendere implements ListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value,
                int index, boolean isSelected, boolean cellHasFocus) {

            JLabel label = new JLabel();
            label.setOpaque(true);
            String nombreSitio = value.toString();
            label.setText(nombreSitio);
            label.setIcon(new ImageIcon(getClass().getResource(searchSitesAndImages.get(value))));
            if (isSelected) {
                label.setBackground(Color.LIGHT_GRAY);
            }
            return label;
        }

    }
}
