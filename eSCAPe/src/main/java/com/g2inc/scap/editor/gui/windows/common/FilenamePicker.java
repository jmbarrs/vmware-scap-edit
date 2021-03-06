package com.g2inc.scap.editor.gui.windows.common;
/* ESCAPE Software Copyright 2010 G2, Inc. - All rights reserved.
*
* ESCAPE is open source software distributed under GNU General Public License Version 3.  ESCAPE is not in the public domain 
* and G2, Inc. holds its copyright.  Redistribution and use in source and binary forms, with or without modification, are
* permitted provided that the following conditions are met:

* 1. Redistributions of ESCAPE source code must retain the above copyright notice, this list of conditions and the following disclaimer. 
* 2. Redistributions in binary form must reproduce the above copyright notice, this list of conditions and the following disclaimer in the documentation and/or other materials provided with the ESCAPE Software distribution. 
* 3. Neither the name of G2, Inc. nor the names of any contributors may be used to endorse or promote products derived from this software without specific prior written permission. 

* THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS ``AS IS'' AND ANY EXPRESS OR IMPLIED WARRANTIES,
* INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
* IN NO EVENT SHALL G2, INC., THE AUTHORS OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY,
* OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA,
* OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
* OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
* POSSIBILITY OF SUCH DAMAGE.

* You should have received a copy of the GNU General Public License Version 3 along with this program. 
* If not, see http://www.gnu.org/licenses/ for a copy.
*/

import com.g2inc.scap.editor.gui.util.EditorUtil;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JFileChooser;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.g2inc.scap.editor.gui.windows.EditorConfiguration;
import org.apache.log4j.Logger;

public class FilenamePicker extends ChangeNotifierPanel implements ChangeListener, ActionListener
{
    private static Logger LOG = Logger.getLogger(FilenamePicker.class);
    private ArrayList<String> defaultExtensions = new ArrayList<String>();

    private String approveButtonText = null;
    private String approveButtonTooltipText = null;
    private boolean filenameValid = false;

   @Override
    public void actionPerformed(ActionEvent ae)
   {
       Object src = ae.getSource();

       if(src == chooseFilenameButton)
       {
            final JFileChooser fc = new JFileChooser();
            fc.setDialogType(JFileChooser.SAVE_DIALOG);

            if(approveButtonText != null)
                fc.setApproveButtonText(approveButtonText);

            if(approveButtonTooltipText != null)
                fc.setApproveButtonToolTipText(approveButtonTooltipText);

            EditorConfiguration guiProps = EditorConfiguration.getInstance();
            File lastOpenedFrom = guiProps.getLastOpenedFromFile();

            // Set current directory
            fc.setCurrentDirectory(lastOpenedFrom);

            int ret = fc.showSaveDialog(getParent());

            if(ret == JFileChooser.APPROVE_OPTION)
            {
                File f = fc.getSelectedFile();

                File parent = f.getAbsoluteFile().getParentFile();
                guiProps.setLastOpenedFrom(parent.getAbsolutePath());
                guiProps.save();

                String absFileName = formatFilename(f.getAbsolutePath());
                f = new File(absFileName);

                filenameField.setValue(f.getAbsolutePath());
                                    guiProps.setLastOpenedFromFile(f.getParentFile());
                                    guiProps.save();
            }
       }
   }

    private void initButtonListeners()
    {
        chooseFilenameButton.addActionListener(this);
    }

    private void initFilenameField()
    {
        filenameField.addChangeListener(this);
    }

    private void initComponents2()
    {
        initFilenameField();
        initButtonListeners();
    }

    /** Creates new form FilenamePicker */
    public FilenamePicker()
    {
        initComponents();
        initComponents2();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        captionPanel = new javax.swing.JPanel();
        overviewLabel = new javax.swing.JLabel();
        otherControlsPanel = new javax.swing.JPanel();
        filenameCaption = new javax.swing.JLabel();
        filenameField = new com.g2inc.scap.editor.gui.dialogs.editors.oval.datatype.string.PatternedStringField();
        chooseFilenameButton = new javax.swing.JButton();
        statusPanel = new javax.swing.JPanel();
        statusCaption = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        captionPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Overview"));
        captionPanel.setLayout(new java.awt.GridBagLayout());

        overviewLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        overviewLabel.setText("Choose the filename.");
        overviewLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 6, 0, 6);
        captionPanel.add(overviewLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        add(captionPanel, gridBagConstraints);

        otherControlsPanel.setLayout(new java.awt.GridBagLayout());

        filenameCaption.setText("Filename");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(5, 6, 0, 0);
        otherControlsPanel.add(filenameCaption, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 0, 0);
        otherControlsPanel.add(filenameField, gridBagConstraints);

        chooseFilenameButton.setText("Browse");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        otherControlsPanel.add(chooseFilenameButton, gridBagConstraints);

        statusPanel.setLayout(new java.awt.GridBagLayout());

        statusCaption.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusCaption.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        statusPanel.add(statusCaption, gridBagConstraints);

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        statusLabel.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        statusLabel.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        statusLabel.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 6, 2);
        statusPanel.add(statusLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.3;
        gridBagConstraints.insets = new java.awt.Insets(2, 6, 0, 5);
        otherControlsPanel.add(statusPanel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(otherControlsPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel captionPanel;
    private javax.swing.JButton chooseFilenameButton;
    private javax.swing.JLabel filenameCaption;
    private com.g2inc.scap.editor.gui.dialogs.editors.oval.datatype.string.PatternedStringField filenameField;
    private javax.swing.JPanel otherControlsPanel;
    private javax.swing.JLabel overviewLabel;
    private javax.swing.JLabel statusCaption;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JPanel statusPanel;
    // End of variables declaration//GEN-END:variables

    public String getStatusText()
    {
        return statusLabel.getText();
    }

    public String getFilenameText()
    {
        return formatFilename(filenameField.getValue());
    }
    
    private String formatFilename(String filename)
    {
        // If filename already ends with one of the default extensions,
        // then just return the filename.
        for(int x = 0; x < this.defaultExtensions.size(); x++)
        {
            if (filename.toLowerCase().endsWith(this.defaultExtensions.get(x).toLowerCase()))
            {
                return filename;
            }
        }
        
        // Extract the string before the "." from each default extension
        // and determine if the filename ends with that. If it does, then
        // remove that string from the end of filename and append
        // the default extension to it. This handles situations
        // where the user inputs "fdcc-winxp-oval" and it needs
        // to be "fdcc-winxp-oval.xml".
        for(int x = 0; x < this.defaultExtensions.size(); x++)
        {
            String stringBeforePeriod = null;
            if (this.defaultExtensions.get(x).lastIndexOf(".") != -1)
            {
                stringBeforePeriod = this.defaultExtensions.get(x).substring(0, this.defaultExtensions.get(x).lastIndexOf("."));
                if (stringBeforePeriod.length() == 0)
                {
                    stringBeforePeriod = null;
                }
            }
            if ((stringBeforePeriod != null) && (filename.toLowerCase().endsWith(stringBeforePeriod.toLowerCase())))
            {
                filename = filename.substring(0, filename.toLowerCase().lastIndexOf(stringBeforePeriod.toLowerCase()));
                filename = filename.concat(this.defaultExtensions.get(x).toLowerCase());
                return filename;
            }
        }
        
        // Extract the string starting at "." from each default extension
        // and determine if the filename ends with that. If it does, then
        // remove that string from the end of filename and append
        // the default extension to it. This handles situations
        // where the user inputs "fdcc-winxp.xml" and it needs
        // to be "fdcc-winxp-oval.xml".
        for(int x = 0; x < this.defaultExtensions.size(); x++)
        {
            String stringStartingWithPeriod = null;
            if (this.defaultExtensions.get(x).lastIndexOf(".") != -1)
            {
            	stringStartingWithPeriod = this.defaultExtensions.get(x).substring(this.defaultExtensions.get(x).lastIndexOf("."));
                if (stringStartingWithPeriod.length() <= 1)
                {
                    stringStartingWithPeriod = null;
                }
            }
            if ((stringStartingWithPeriod != null) && (filename.toLowerCase().endsWith(stringStartingWithPeriod.toLowerCase())))
            {
                filename = filename.substring(0, filename.toLowerCase().lastIndexOf(stringStartingWithPeriod.toLowerCase()));
                filename = filename.concat(this.defaultExtensions.get(x).toLowerCase());
                return filename;
            }
        }

        // If none of the above cases match, then add the first
        // default extension to the filename.
        if (this.defaultExtensions.size() > 0)
        {
            return filename.concat(this.defaultExtensions.get(0).toLowerCase());
        }
 
        // If we get to this point, then just return the original filename.
        return filename;
    }

    public void setFilenameCaption(String captionText)
    {
        filenameCaption.setText(captionText);
    }

    public void setBrowseButtonText(String browseButtonText)
    {
        chooseFilenameButton.setText(browseButtonText);
    }

    public void setBrowseButtonTooltipText(String tooltipText)
    {
        chooseFilenameButton.setToolTipText(tooltipText);
    }
    
    public void setFilenamePattern(Pattern fnPattern)
    {
        filenameField.setPattern(fnPattern);
    }

    public void setFilenamePatterns(Pattern[] patterns)
    {
        filenameField.setPatterns(patterns);
    }

    public void setOverviewText(String overviewText)
    {
        overviewLabel.setText(overviewText);
    }
    
    public boolean isValidFilename()
    {
       return filenameValid;
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        Object src = e.getSource();

        if(src != filenameField)
        {
        	return;
        }
        
        // Verify that the file name matches any patterns.
    	if(!filenameField.isValidInput())
    	{
            statusLabel.setText("<HTML>&nbsp;ERROR - The file name isn't valid.</HTML>");
            filenameField.setStringValueTextFieldColor(filenameField.getErrorTextColor());
            filenameValid = false;
            notifyRegisteredListeners();
            return;
    	}
        
    	// Verify that the file name does not end in a separator.
    	if (filenameField.getValue().endsWith("/") || filenameField.getValue().endsWith("\\") || filenameField.getValue().endsWith(":"))
    	{
            statusLabel.setText("<HTML>&nbsp;ERROR - The file name cannot end in a separator.</HTML>");
            filenameField.setStringValueTextFieldColor(filenameField.getErrorTextColor());
            filenameValid = false;
            notifyRegisteredListeners();
            return;
    	}
    	
    	// Verify that the file's parent directory exists.
        File f = new File(filenameField.getValue()).getAbsoluteFile();
        File parent = f.getParentFile();
        if(parent == null)
        {
            statusLabel.setText("<HTML>&nbsp;ERROR - The file's parent directory could not be determined.</HTML>");
            filenameField.setStringValueTextFieldColor(filenameField.getErrorTextColor());
            filenameValid = false;
            notifyRegisteredListeners();
            return;
        }
        if(!parent.exists())
        {
            statusLabel.setText("<HTML>&nbsp;ERROR - The file's parent directory does not exist: " + parent.getAbsolutePath() + ".</HTML>");
            filenameField.setStringValueTextFieldColor(filenameField.getErrorTextColor());
            filenameValid = false;
            notifyRegisteredListeners();
            return;
        }
        
        // Verify that the filename does not equal any default extension
        // by itself. The filename should have the extension, but not equal it.
        for(int x = 0; x < this.defaultExtensions.size(); x++)
        {
        	if (f.getName().toLowerCase().equals(this.defaultExtensions.get(x).toLowerCase()))
        	{
                statusLabel.setText("<HTML>&nbsp;ERROR - The file name must consist of more than just the extension '" + this.defaultExtensions.get(x) + "'.</HTML>");
                filenameField.setStringValueTextFieldColor(filenameField.getErrorTextColor());
                filenameValid = false;
                notifyRegisteredListeners();
                return;
        	}
        }
        
    	// Verify that the filename does not start with a "-".
        // This probably needs to be handled by a pattern.
    	if (f.getName().startsWith("-"))
    	{
            statusLabel.setText("<HTML>&nbsp;ERROR - The file name must not start with '-'.</HTML>");
            filenameField.setStringValueTextFieldColor(filenameField.getErrorTextColor());
            filenameValid = false;
            notifyRegisteredListeners();
            return;
    	}
        
        // Verify that the file is writable.
        boolean writable = false;
        try
        {
            boolean created = f.createNewFile();
            writable = f.setWritable(true, true);
            if(created)
                f.delete();
        }
        catch(Exception ex)
        {
        }
        if(!writable)
        {
            String message = "<HTML>&nbsp;ERROR - The file can't be created. Check that the file name does not "
                + "contain any of the following characters: \\ / : * ? \" < > |. Check that the file's parent directory exists and is writable: "
                + f.getAbsolutePath()
                + ".</HTML>";
            statusLabel.setText(message);
            filenameField.setStringValueTextFieldColor(filenameField.getErrorTextColor());
            filenameValid = false;
            notifyRegisteredListeners();
            return;
        }
        
        // If we get to this point, then the file name is valid.
        statusLabel.setText("<HTML>The file name is valid.</HTML>");
        filenameField.setStringValueTextFieldColor(filenameField.getNormalTextColor());
        filenameValid = true;
        notifyRegisteredListeners();
    }

    public String getApproveButtonText()
    {
        return approveButtonText;
    }

    public void setApproveButtonText(String approveButtonText)
    {
        this.approveButtonText = approveButtonText;
    }

    public String getApproveButtonTooltipText()
    {
        return approveButtonTooltipText;
    }

    public void setApproveButtonTooltipText(String approveButtonTooltipText)
    {
        this.approveButtonTooltipText = approveButtonTooltipText;
    }

    public void setShowOverviewText(boolean showText)
    {
        captionPanel.setVisible(showText);
    }

    public void addDefaultExtension(String defaultExtension)
    {
        this.defaultExtensions.add(defaultExtension);
    }

    public void clearDefaultExtensions()
    {
        this.defaultExtensions.clear();
    }
}
