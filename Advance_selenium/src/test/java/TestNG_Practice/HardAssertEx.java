package TestNG_Practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

	@Test
	public void m1() {
		System.out.println("step1");
		System.out.println("step2");
		Assert.assertEquals("B", "B"); //------>Assertion fail
		System.out.println("step3");
		System.out.println("step4");
	}
	@Test
	public void m2() {
		String expData ="Vishnu";
		String actData = "Vishnu";
		Assert.assertEquals(actData, expData);
	}
	@Test
	public void m3() {
		String expData ="Vishnu";
		String actData = "Vishnu";
		Assert.assertEquals(expData, actData, "Assert FAIL");
		System.out.println("Assert PASS");
	}
	@Test
	public void m4() {
		int ExpData=10;
		int actData=20;
		Assert.assertEquals(ExpData,actData,"Assert Fail");
		System.out.println("Assert Pass");
	}
	@Test
	public void m5() {
		int ExpData = 10;
		int actData = 20;
		Assert.assertNotEquals(actData, ExpData,"ASSERT EQUAL");
		System.out.println("ASSERT NOT EQUAL");
	}
	@Test
	public void m6() {
		int ExpData = 10;
		int actData = 10;
		Assert.assertNotEquals(actData, ExpData,"ASSERT EQUAL");
		System.out.println("ASSERT NOT EQUAL");
	}
	@Test
	public void m7() {
		String ExpData="vishnu";
		String actData="vishnu";
		Assert.assertTrue(actData.equals(ExpData),"ASSERT FAIL");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m8() {
		String ExpData="vishnu";
		String actData="vishnU";
		Assert.assertTrue(actData.equals(ExpData),"ASSERT FAIL");
		System.out.println("Assert Pass");
	}
	@Test
	public void m9() {
		String ExpData="vishnu";
		String actData="vishnU";
		Assert.assertFalse(actData.equals(ExpData),"ASSERT FALSE");
		System.out.println("Assert True");
	}
	@Test
	public void m10() {
		String ExpData="vishnu";
		String actData="vishnu";
		Assert.assertFalse(actData.equals(ExpData),"ASSERT FALSE");
		System.out.println("Assert True");
	}
	@Test
	public void m11() {
		String a ="aruna";
		Assert.assertNull(a,"Assert Fail");
		System.out.println("Assert Pass");
	}
	@Test
	public void m12() {
		String a=null;
		Assert.assertNull(a,"Assert Fail");
		System.out.println("Assert Pass");
	}
	@Test
	public void m13() {
		String a=null;
		Assert.assertNotNull(a,"Assert Fail");
		System.out.println("Assert Pass");
	}
	@Test
	public void m14() {
		String a="vishnu";
		Assert.assertNotNull(a,"Assert Fail");
		System.out.println("Assert Pass");
	}
	@Test
	public void m15() {
		int exp =10;
		int act =20;
		Assert.assertSame(exp, act,"Assert fail");
		System.out.println("ASSERT PASS");
	}
	@Test
	public void m16() {
		int exp =10;
		int act =10;
		Assert.assertSame(exp, act,"Assert fail");
		System.out.println("ASSERT PASS");
	}
	@Test
	public void m17() {
		int exp =10;
		int act =10;
		Assert.assertNotSame(exp, act,"Assert fail");
		System.out.println("ASSERT PASS");
	}
	@Test
	public void m18() {
		int exp =10;
		int act =20;
		Assert.assertNotSame(exp, act,"Assert fail");
		System.out.println("ASSERT PASS");
	}
	/*@Test
	public void m19() {
		Assert.fail("I'm failing the script");
	}*/
	
}

