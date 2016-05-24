/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionapp;

import java.io.Writer;
import java.io.IOException;

/**
 *
 * @author dajones
 */
public class EncryptingWriter extends Writer {

    public EncryptingWriter(Writer writer) {
        this.writer = writer;
    }

    private Writer writer;

    //Basically want off = 0, and len = length of cbuf
    //Abstract method write, we want it to call Casear Ciphe
    public void write(char[] cbuf, int off, int len)
            throws IOException {
        cbuf = caesEncrypt(cbuf, off, len);
        writer.write(cbuf, off, len);
    }

    //Specific encryption from English to Casear Ciphe
    public char[] caesEncrypt(char[] cbuf, int off, int len) {
        int caesar = 3;
        char c;
        for (int i = off; i < len; i++) {
            if (Character.isLetter(cbuf[i])) {
                c = (char) ((int) cbuf[i] + caesar);

                if (!Character.isLetter(c)) {
                    c -= 26;
                }
                cbuf[i] = c;
            }
        }
        return cbuf;
    }

    public char[] alg(char[] cbuf, int off, int len, int a) {
        char c;
        for (int i = off; i < len; i++) {
            if (Character.isLetter(cbuf[i])) {
                c = (char) ((int) cbuf[i] + a);

                if (!Character.isLetter(c)) {
                    c -= 26;
                }
                cbuf[i] = c;
            }
        }
        return cbuf;
    }

    public void algWrite(char[] cbuf, int off, int len, int a)
            throws IOException {
        cbuf = alg(cbuf, off, len, a);
        writer.write(cbuf, off, len);
    }

    public void close() throws IOException {
        writer.close();
    }

    public void flush() throws IOException {
        writer.flush();
    }
}
