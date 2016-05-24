/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionapp;

import java.io.IOException;
import java.io.StringWriter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dajones
 */
public class EncryptingWriterTest {

    public EncryptingWriterTest() {
    }

    @Test
    public void writeTest() throws IOException{
        String t1 = "One morning";
        String t2 = "Maybe someday";
        String t3 = "It's a miracle.";
        
        StringWriter writer1 = new StringWriter();
        EncryptingWriter w1 = new EncryptingWriter(writer1);
        w1.write(t1.toCharArray(), 0 , t1.length());
        String encryption = writer1.toString();
        assertEquals(encryption, "Rqh pruqlqj");
        
        StringWriter writer2 = new StringWriter();
        EncryptingWriter w2 = new EncryptingWriter(writer2);
        w2.write(t2.toCharArray(), 0 , t2.length());
        encryption = writer2.toString();
        assertEquals(encryption, "Pdbeh vrphgdb");
        
        StringWriter writer3 = new StringWriter();
        EncryptingWriter w3 = new EncryptingWriter(writer3);
        w3.write(t3.toCharArray(), 0 , t3.length());
        encryption = writer3.toString();
        assertEquals(encryption, "Lw'v d pludfoh.");
    }

    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of close method, of class EncryptingWriter.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        EncryptingWriter instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of write method, of class EncryptingWriter.
     */
    @Test
    public void testWrite() throws Exception {
        System.out.println("write");
        char[] cbuf = null;
        int off = 0;
        int len = 0;
        EncryptingWriter instance = null;
        instance.write(cbuf, off, len);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caesEncrypt method, of class EncryptingWriter.
     */
    @Test
    public void testCaesEncrypt() {
        System.out.println("caesEncrypt");
        char[] cbuf = {'E'};
        int off = 0;
        int len = 0;
        EncryptingWriter instance = null;
        char[] expResult = {'H'};
        char[] result = instance.caesEncrypt(cbuf, off, len);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of flush method, of class EncryptingWriter.
     */
    @Test
    public void testFlush() throws Exception {
        System.out.println("flush");
        EncryptingWriter instance = null;
        instance.flush();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
