/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionapp;

import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;

/**
 *
 * @author dajones
 */
public class EncryptionApp {

    public static void main(String[] args) throws Exception {
        
        int ALGORITHM = 2;
        String t = "It's a miracle.";
        String q = "Lw'v d pludfoh.";
        
        ArrayList<Character> cbuf = new ArrayList<Character>();
        ArrayList<Character> dbuf = new ArrayList<Character>();
        ArrayList<Character> qbuf = new ArrayList<Character>();
        ArrayList<Character> pbuf = new ArrayList<Character>();

        System.out.println("English:" + "" + t);

        StringWriter writer = new StringWriter();
        EncryptingWriter w1 = new EncryptingWriter(writer);
        w1.write(t.toCharArray(), 0, t.length());
        String encryption = writer.toString();
        w1.close();

        for (int i = 0; i < encryption.length(); i++) {
            char c = encryption.charAt(i);
            cbuf.add(c);
        }

        StringBuilder builder = new StringBuilder(cbuf.size());
        for (Character ch : cbuf) {
            builder.append(ch);
        }

        System.out.println("Caesar:" + "" + builder);

        StringWriter w = new StringWriter();
        EncryptingWriter w2 = new EncryptingWriter(w);
        w2.algWrite(t.toCharArray(), 0, t.length(),ALGORITHM);
        String encryption1 = w.toString();
        w2.close();

        for (int i = 0; i < encryption1.length(); i++) {
            char c = encryption1.charAt(i);
            dbuf.add(c);
        }

        StringBuilder dbuilder = new StringBuilder(dbuf.size());
        for (Character ch : dbuf) {
            dbuilder.append(ch);
        }

        System.out.println("Skip by 2:" + "" + dbuilder);
        System.out.println();
        
        System.out.println("Caesar:" + "" + q);
        StringReader reader = new StringReader(q);
        DecryptingReader r = new DecryptingReader(reader);
//        r.read(q.toCharArray(), 0, q.length());
        char[] cq = r.get(q.toCharArray(), 0, q.length());
//        String decryption = r.toString();
        r.close();
        
        for (int i = 0; i < cq.length; i++) {
            char c = cq[i];
            qbuf.add(c);
        }
        
        StringBuilder qbuilder = new StringBuilder(qbuf.size());
        for (Character ch : qbuf) {
            qbuilder.append(ch);
        }

        System.out.println("English:" + "" + qbuilder);
        StringReader reader1 = new StringReader(q);
        DecryptingReader r1 = new DecryptingReader(reader1);
//        r.read(q.toCharArray(), 0, q.length());
        char[] cq1 = r1.get(q.toCharArray(), 0, q.length(), ALGORITHM);
//        String decryption = r.toString();
        r.close();
        
        for (int i = 0; i < cq1.length; i++) {
            char c = cq1[i];
            pbuf.add(c);
        }
        
        StringBuilder pbuilder = new StringBuilder(pbuf.size());
        for (Character ch : pbuf) {
            pbuilder.append(ch);
        }
        
        System.out.println("Retract by 2:" + "" + pbuilder);
        
    }
}
