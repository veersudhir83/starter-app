package io.sudheer.springboot.starterapp;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StarterAppApplicationTests {

	@Test
	public void contextLoads() {
		byte[] expected = "trial".getBytes();
	    byte[] actual = "trial".getBytes();
	    assertArrayEquals("failure - byte arrays not same", expected, actual);
	}

}
