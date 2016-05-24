/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package encryptionapp;

import java.io.IOException;
import java.io.StringReader;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author dajones
 */
public class DecryptingReaderTest {

    public DecryptingReaderTest() {
    }

    @Test
    public void readTest() throws IOException {
        String t1 = "Rqh pruqlqj";
        String t2 = "Pdbeh vrphgdb";
        String t3 = "Lw'v d pludfoh.";

        StringReader reader1 = new StringReader(t1);
        DecryptingReader r1 = new DecryptingReader(reader1);
        r1.read(t1.toCharArray(), 0, t1.length());
        String decryption = reader1.toString();
        assertEquals(decryption, "One morning");

        StringReader reader2 = new StringReader(t2);
        DecryptingReader r2 = new DecryptingReader(reader2);
        r2.read(t2.toCharArray(), 0, t2.length());
        decryption = reader2.toString();
        assertEquals(decryption, "Maybe someday");

        StringReader reader3 = new StringReader(t3);
        DecryptingReader r3 = new DecryptingReader(reader3);
        r3.read(t3.toCharArray(), 0, t3.length());
        decryption = reader3.toString();
        assertEquals(decryption, "It's a miracle.");
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    /**
     * Test of read method, of class DecryptingReader.
     */
    @Test
    public void testRead() throws Exception {
        System.out.println("read");
        char[] cbuf = null;
        int off = 0;
        int len = 0;
        DecryptingReader instance = null;
        instance.read(cbuf, off, len);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caesDecrypt method, of class DecryptingReader.
     */
    @Test
    public void testCaesDecrypt() {
        System.out.println("caesDecrypt");
        char[] cbuf = {'H'};
        int off = 0;
        int len = 0;
        DecryptingReader instance = null;
        char[] expResult = {'E'};
        char[] result = instance.caesDecrypt(cbuf, off, len);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of close method, of class DecryptingReader.
     */
    @Test
    public void testClose() throws Exception {
        System.out.println("close");
        DecryptingReader instance = null;
        instance.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
