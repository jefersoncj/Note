/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.note.metodos;

import javax.swing.text.AttributeSet;  
import javax.swing.text.BadLocationException;  
import javax.swing.text.PlainDocument;  
  
public class FixedLengthDocument extends PlainDocument {  
    private int maxLength;  
  
    public FixedLengthDocument(int maxlen) {  
        super();  
          
        if (maxlen <= 0)  
            throw new IllegalArgumentException("You must specify a maximum length!");  
          
        maxLength = maxlen;  
    }  
  
    /**
     *
     * @param offset
     * @param str
     * @param attr
     * @throws BadLocationException
     */
    @Override  
    public void insertString(int offset, String str, AttributeSet attr)   
    throws BadLocationException {  
        if (str == null || getLength() == maxLength)  
            return;  
  
        int totalLen = (getLength() + str.length());  
        if (totalLen <= maxLength) {  
            super.insertString(offset, str.toUpperCase(), attr);  
           // super.insertString(offset, , attr); 
            return;  
        }  
          
        String newStr = str.substring(0, (maxLength - getLength()));  
        super.insertString(offset, newStr, attr);  
    }  
}