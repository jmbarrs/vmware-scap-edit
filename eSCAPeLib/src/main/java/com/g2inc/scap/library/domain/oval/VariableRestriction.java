package com.g2inc.scap.library.domain.oval;
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

/**
 * Represents a variable restriction in an oval variable.
 */
public class VariableRestriction extends OvalVariableChild {
	
	public VariableRestriction(OvalDefinitionsDocument parentDocument)
	{
		super(parentDocument);
	}
	
	/**
	 * Get the value.
	 * 
	 * @return String
	 */
	public String getValue() {
		return element.getValue();
	}
	
	/**
	 * Set the value.
	 * 
	 * @param value
	 */
	public void setValue(String value) {
		element.setText(value);
	}
	
	/**
	 * Get the operation.
	 * 
	 * @return String
	 */
	public String getOperation() {
        String ret = "equals";
		String operation = element.getAttributeValue("operation");
        if(operation != null && operation.length() > 0) {
            ret = operation;
        }
        return ret;
	}
	
	/**
	 * Set the operation.
	 * 
	 * @param operation
	 */
	public void setOperation(String operation) {
		element.setAttribute("operation", operation);
	}

    @Override
    public String toString() {
       return "restriction: oper=" + getOperation() + ", value=" + getValue();
    }

    @Override
    public boolean equals(Object o)
    {
    	boolean ret = false;
    	
    	if(o == null)
    	{
    		return ret;
    	}
    	
    	if(!(o instanceof VariableRestriction))
    	{
    		return ret;
    	}
    	
    	VariableRestriction other = (VariableRestriction)o;

    	if(getElementName() != null)
    	{
    		if(!getElementName().equals(other.getElementName()))
    		{
    			return ret;
    		}
    	}
    	
    	if(getOperation() != null)    		
    	{
    		if(!getOperation().equals(other.getOperation()))
    		{
    			return ret;
    		}
    	}

    	if(getValue() != null)    		
    	{
    		if(!getValue().equals(other.getValue()))
    		{
    			return ret;
    		}
    	}

    	ret = true;
    	return ret;
    }
    
    /**
     * This method determines if this object is a duplicate of another object.
     * 
     * @param other
     * @return boolean
     */
	@Override
	public boolean isDuplicateOf(Object other)
	{
    	// Call the ancestor isDuplicateOf method.
    	if (!(super.isDuplicateOf(other)))
    	{
		return false;
    	}
		
		// If the other object is not an instance of this class,
		// then return false.
		if (!(other instanceof VariableRestriction))
		{
			return false;
		}
		
		// Cast the other object to this class.
		VariableRestriction other2 = (VariableRestriction) other;
		
		// If the other object's operation attribute does not match,
		// then return false.
    	if (!(areStringsEqualOrBothNull(other2.getOperation(), this.getOperation())))
    	{
    		return false;
    	}
    	
		// If the other object's value does not match,
		// then return false.
    	if (!(areStringsEqualOrBothNull(other2.getValue(), this.getValue())))
    	{
    		return false;
    	}

		// Return true if we get to this point.
		return true;
	}
}
