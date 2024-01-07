package mbti;

import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class MBTIPersonalityTestTest {

    @Test
    public void testValidateResponse() {
        // Test valid response
        assertEquals('A', MBTIPersonalityTest.validateResponse('A'));

        // Test valid response (lowercase)
        assertEquals('B', MBTIPersonalityTest.validateResponse('b'));

        // Test invalid response
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> MBTIPersonalityTest.validateResponse('C'));
        assertEquals("Invalid response. Please enter either 'A' or 'B'.", exception.getMessage());
    }

    @Test
    public void testGetUserResponse() {
        // Test valid responses
        String inputA = "A\n";
        InputStream inA = new ByteArrayInputStream(inputA.getBytes());
        System.setIn(inA);
        assertEquals('A', MBTIPersonalityTest.getUserResponse(new Scanner(System.in)));

        String inputB = "b\n";
        InputStream inB = new ByteArrayInputStream(inputB.getBytes());
        System.setIn(inB);
        assertEquals('B', MBTIPersonalityTest.getUserResponse(new Scanner(System.in)));

        // Test invalid response
        String inputInvalid = "C\n";
        InputStream inInvalid = new ByteArrayInputStream(inputInvalid.getBytes());
        System.setIn(inInvalid);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> MBTIPersonalityTest.getUserResponse(new Scanner(System.in)));
        assertEquals("Invalid response. Please enter either 'A' or 'B'.", exception.getMessage());
    }

    // Add more tests for other methods as needed
}
