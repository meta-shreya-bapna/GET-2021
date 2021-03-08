import static org.junit.Assert.*;

import org.junit.Test;


public class lcmHcfTest {

	@Test
	public void lcmTest() {
		LCMandHCF l=new LCMandHCF();
		assertEquals(175,l.lcm(25,35,35,35));
		assertEquals(20, l.lcm(20,4,20,20));
		assertEquals(130, l.lcm(10,13,13,13));
		assertEquals(80, l.lcm(80,40,80,80));
		assertEquals(152, l.lcm(152,4,152,152));
	}
	
	
	@Test
	public void hcfTest() {
		LCMandHCF h=new LCMandHCF();
		assertEquals(4, h.hcf(20,4));
		assertEquals(1, h.hcf(10,13));
		assertEquals( 5, h.hcf(25,35));
		assertEquals(40, h.hcf(80,40));
		assertEquals(4, h.hcf(152,4));
	}

}
