
package com.g2inc.scap.editor.gui.wizards.filesaveas;

import java.util.regex.Pattern;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import org.apache.log4j.Logger;

import com.g2inc.scap.editor.gui.wizards.Wizard;
import com.g2inc.scap.editor.gui.wizards.WizardPage;
import com.g2inc.scap.editor.gui.wizards.cpe.NewCPEDictionaryWizardPage;
import com.g2inc.scap.editor.gui.wizards.oval.document.CreateOvalFilenameChoicePage;
import com.g2inc.scap.editor.gui.wizards.xccdf.CreateXCCDFFilenameChoicePage;
import com.g2inc.scap.library.domain.SCAPDocumentTypeEnum;

public class PickFilenamePage extends WizardPage implements ChangeListener
{
    private static final long serialVersionUID = 1L;
    private static Logger log = Logger.getLogger(PickFilenamePage.class);
	
    private FileSaveAsWizard parentWiz = null;
    private SCAPDocumentTypeEnum docType = null;

    private void initFilePicker()
    {
        Pattern p = null;
        String pString = null;

        switch(docType)
        {
            case CPE_20:
            case CPE_21:
            case CPE_22:
                filenamePicker.setOverviewText(NewCPEDictionaryWizardPage.OVERVIEW_STRING);
                filenamePicker.setFilenameCaption(NewCPEDictionaryWizardPage.FILENAME_CAPTION_STRING);
                filenamePicker.addDefaultExtension("-cpe-dictionary.xml");
                pString = NewCPEDictionaryWizardPage.PATTERN_STRING;
                break;
            case OVAL_53:
            case OVAL_54:
            case OVAL_55:
            case OVAL_56:
            case OVAL_57:
            case OVAL_58:
            case OVAL_59:
            case OVAL_510:
                filenamePicker.setOverviewText(CreateOvalFilenameChoicePage.OVERVIEW_STRING);
                filenamePicker.setFilenameCaption(CreateOvalFilenameChoicePage.FILENAME_CAPTION_STRING);
                filenamePicker.addDefaultExtension("-oval.xml");
                filenamePicker.addDefaultExtension("-cpe-oval.xml");
                filenamePicker.addDefaultExtension("-patches.xml");
                pString = CreateOvalFilenameChoicePage.PATTERN_STRING;
                break;
            case XCCDF_114:
            case XCCDF_12:
                filenamePicker.setOverviewText(CreateXCCDFFilenameChoicePage.OVERVIEW_STRING);
                filenamePicker.setFilenameCaption(CreateXCCDFFilenameChoicePage.FILENAME_CAPTION_STRING);
                filenamePicker.addDefaultExtension("-xccdf.xml");
                pString = CreateXCCDFFilenameChoicePage.PATTERN_STRING;
                break;
        }
        try
        {
            p = Pattern.compile(pString);
            filenamePicker.setFilenamePattern(p);
        }
        catch(Exception e)
        {
            log.error("Error compiling pattern " + pString, e);
        }

        filenamePicker.setApproveButtonText("Save");
        filenamePicker.setApproveButtonTooltipText("Save");

        filenamePicker.setBrowseButtonText("Browse");
        filenamePicker.setBrowseButtonTooltipText("Browse for file");

        filenamePicker.addChangeListener(this);
    }

    private void initComponents2()
    {
        initFilePicker();
    }

    /** Creates new form ChoseVariableTypeWizardPage */
    public PickFilenamePage(FileSaveAsWizard wiz, SCAPDocumentTypeEnum docType)
    {
        initComponents();
        parentWiz = wiz;
        this.docType = docType;
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

        filenamePicker = new com.g2inc.scap.editor.gui.windows.common.FilenamePicker();

        setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(filenamePicker, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.g2inc.scap.editor.gui.windows.common.FilenamePicker filenamePicker;
    // End of variables declaration//GEN-END:variables

    @Override
    public Object getData()
    {
        return getFilename();
    }

    @Override
    public void setData(Object data)
    {
    }
    
    @Override
    public void setWizard(Wizard wizard)
    {
        parentWiz = (FileSaveAsWizard) wizard;
    }

    @Override
    public String getPageTitle()
    {
        return "Filename To Save As";
    }

    @Override
    public void performFinish()
    {
    }

    public String getFilename()
    {
        return filenamePicker.getFilenameText();
    }

    public void setFilenamePattern(Pattern pattern)
    {
        filenamePicker.setFilenamePattern(pattern);
    }

    public void setFilenamePatterns(Pattern[] patterns)
    {
        filenamePicker.setFilenamePatterns(patterns);
    }

    @Override
    public void stateChanged(ChangeEvent e)
    {
        Object src = e.getSource();

        if(src == filenamePicker)
        {
            if(filenamePicker.isValidFilename())
            {
                setSatisfied(true);
                parentWiz.enableNextButton();
            }
            else
            {
                setSatisfied(false);
                parentWiz.disableNextButton();
            }
        }
    }
}