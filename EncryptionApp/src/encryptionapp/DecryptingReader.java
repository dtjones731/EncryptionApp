/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionapp;

import java.io.IOException;
import java.io.Reader;

/**
 *
 * @author dajones
 */
public class DecryptingReader {

    public DecryptingReader(Reader reader) {
        this.reader = reader;
    }

    private Reader reader;

    //Basically want off = 0, and len = length of cbuf
    //Abstract method read, we want it to know Casear Ciphe
    public void read(char[] cbuf, int off, int len)
            throws IOException {
        cbuf = caesDecrypt(cbuf, off, len);
        reader.read(cbuf, off, len);
    }
    
    //Specific decryption from Casear Ciphe to English
    public char[] caesDecrypt(char[] cbuf, int off, int len) {
        int caesar = 3;
        char c;
        for (int i = off; i < len; i++) {
            if (Character.isLetter(cbuf[i])) {
                c = (char) ((int) cbuf[i] - caesar);

                if (!Character.isLetter(c)) {
                    c += 26;
                }
                cbuf[i] = c;
            }
        } 
        return cbuf;
    }
    
    public char[] get(char[] cbuf, int off, int len){
        cbuf = caesDecrypt(cbuf, off, len);
        return cbuf;
    }
    
    public char[] get(char[] cbuf, int off, int len, int a){
        cbuf = alg(cbuf, off, len, a);
        return cbuf;
    }
    
    public char[] alg(char[] cbuf, int off, int len, int a){
        char c;
        for (int i = off; i < len; i++) {
            if (Character.isLetter(cbuf[i])) {
                c = (char) ((int) cbuf[i] - a);

                if (!Character.isLetter(c)) {
                    c += 26;
                }
                cbuf[i] = c;
            }
        } 
        return cbuf;
    }
            
    public void algRead(char[] cbuf, int off, int len, int a) 
            throws IOException{
        cbuf = alg(cbuf, off, len, a);
        reader.read(cbuf, off, len);
    }

    public void close() throws IOException {
        reader.close();
    }
    
}

