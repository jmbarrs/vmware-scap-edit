package com.g2inc.scap.editor.gui.dialogs.editors.oval.datatype.version;
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

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.text.Element;

import com.g2inc.scap.editor.gui.dialogs.editors.EditorDialog;
import com.g2inc.scap.editor.gui.dialogs.editors.IEditorPage;

public class VersionDatatypeEditor extends javax.swing.JPanel implements IEditorPage
{

    private EditorDialog parentEditor = null;
    private DocumentListener versionTextDocumentListener = null;

    private void initTextFields()
    {
        versionTextDocumentListener = new DocumentListener()
        {

            private void common(DocumentEvent de)
            {
                String text = versionTextField.getText();

                if (text.length() > 0)
                {
                    Pattern [] patterns = null;

                    if(patterns == null)
                    {
                        String [] patternStrings = new String []
                        {
                            "^\\d+[^\\d]\\d+[^\\d]\\d+[^\\d]\\d+$",
                            "^\\d+[^\\d]\\d+[^\\d]\\d+$",
                            "^\\d+[^\\d]\\d+$",
                            "^\\d+$"
                        };

                        patterns = new Pattern[patternStrings.length];

                        for(int x = 0; x < patternStrings.length; x++)
                        {
                            try
                            {
                                patterns[x] = Pattern.compile(patternStrings[x]);
                            }
                            catch(Exception e)
                            {
                                e.printStackTrace();
                            }
                        }
                    }

                    boolean ok = false;

                    for(int x = 0; x < patterns.length; x++)
                    {
                        Pattern p = patterns[x];

                        if(p != null)
                        {
                            Matcher m = p.matcher(text);

                            if(m.matches())
                            {
                                ok = true;
                                break;
                            }
                        }
                    }

                    if(ok)
                    {
                        statusLabel.setText("Version OK");
                        parentEditor.enableOkButton();
                    }
                    else
                    {
                        statusLabel.setText("Version format incorrect");
                        parentEditor.disableOkButton();
                    }
                }
                else
                {
                    statusLabel.setText("ERROR: version can't be zero-length");
                    parentEditor.disableOkButton();
                }
            }

            public void insertUpdate(DocumentEvent de)
            {
                common(de);
            }

            public void removeUpdate(DocumentEvent de)
            {
                common(de);
            }

            public void changedUpdate(DocumentEvent de)
            {
                common(de);
            }
        };

        versionTextField.getDocument().addDocumentListener(versionTextDocumentListener);

    }

    private void initComponents2()
    {
        initTextFields();
    }

    /** Creates new form RegexDatatypeEditor */
    public VersionDatatypeEditor()
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

        patternPanel = new javax.swing.JPanel();
        versionCaption = new javax.swing.JLabel();
        versionTextField = new javax.swing.JTextField();
        statusCaption = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();

        setLayout(new java.awt.GridBagLayout());

        patternPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Version", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 11), java.awt.SystemColor.windowText)); // NOI18N
        patternPanel.setLayout(new java.awt.GridBagLayout());

        versionCaption.setText("Version");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 5);
        patternPanel.add(versionCaption, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.9;
        patternPanel.add(versionTextField, gridBagConstraints);

        statusCaption.setText("Status");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(3, 10, 0, 5);
        patternPanel.add(statusCaption, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 0.9;
        gridBagConstraints.weighty = 0.1;
        gridBagConstraints.insets = new java.awt.Insets(4, 0, 0, 0);
        patternPanel.add(statusLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        add(patternPanel, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel patternPanel;
    private javax.swing.JLabel statusCaption;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel versionCaption;
    private javax.swing.JTextField versionTextField;
    // End of variables declaration//GEN-END:variables

    public String getData()
    {
        return versionTextField.getText();
    }

    public void setEditorDialog(EditorDialog editorDialog)
    {
        parentEditor = editorDialog;
    }

    public void setData(Object data)
    {
        if (data == null)
        {
            versionTextField.setText("");
        } else
        {
            versionTextField.setText((String) data);
        }

        versionTextField.requestFocus();

        versionTextDocumentListener.changedUpdate(new DocumentEvent()
        {
            public int getOffset()
            {
                return 0;
            }

            public int getLength()
            {
                return 0;
            }

            public Document getDocument()
            {
                return versionTextField.getDocument();
            }

            public EventType getType()
            {
                return null;
            }

            public ElementChange getChange(Element arg0)
            {
                return null;
            }
        });
    }
}
