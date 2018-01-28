package filters.test;

import filters.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test the parser.
 */
public class TestParser {
    @Test
    public void testBasic() throws SyntaxError {
        Filter f = new Parser("trump").parse();
        assertTrue(f instanceof BasicFilter);
        assertTrue(((BasicFilter)f).getWord().equals("trump"));
    }

    @Test
    public void testOrParser() throws SyntaxError{
        Filter f = new Parser("red or yellow").parse();
        assertTrue(f.toString().equals("(red or yellow)"));
    }

    @Test
    public void testAndParser() throws SyntaxError{
        Filter f = new Parser("red and yellow").parse();
        assertTrue(f.toString().equals("(red and yellow)"));
    }

    @Test
    public void testHairy() throws SyntaxError {
        Filter x = new Parser("trump and (evil or blue) and red or green and not not purple").parse();
        assertTrue(x.toString().equals("(((trump and (evil or blue)) and red) or (green and not not purple))"));
    }
}
