package modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Model.User;
public class UserTest {
	private User user;

	@Before
	public void setUp() throws Exception {
		this.user = new User("NV01", "Cao Bang", true, "abc");
	}

	@After
	public void tearDown() throws Exception {
		this.user = null;
	}

	//==========================♠♠Pass test

	@Test
	public void testUser() {
		this.user = new User();
	}

	@Test
	public void testGetMaNV() {
		assertEquals(this.user.getMaNV(), "NV01");
	}

	@Test
	public void testSetMaNV() {
		this.user.setMaNV("Nv01");
		String maNV = this.user.getMaNV();
		assertEquals("Nv01", maNV);
	}

	@Test
	public void testGetTenNV() {
		assertEquals(this.user.getTenNV(), "Cao Bang");
	}

	@Test
	public void testSetTenNV() {
		this.user.setTenNV("Cao Ba Quat");
		assertEquals("Cao Ba Quat", this.user.getTenNV());
	}

	@Test
	public void testIsChucVu() {
		assertEquals(this.user.isChucVu(), true);
	}

	@Test
	public void testSetChucVu() {
		this.user.setChucVu(false);
		assertTrue(this.user.isChucVu() == false);
	}

	@Test
	public void testGetMatKhau() {
		assertEquals(this.user.getMatKhau(), "abc");
	}

	@Test
	public void testSetMatKhau() {
		this.user.setMatKhau("123abc");
		assertTrue(this.user.getMatKhau() == "123abc");
	}
	
}
