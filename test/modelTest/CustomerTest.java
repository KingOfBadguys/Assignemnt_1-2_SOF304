package modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Model.Customer;

public class CustomerTest {
	private Customer customer;

	@Before
	public void setUp() throws Exception {
		this.customer = new Customer("KH001", "Cao Thi Lung Linh", "Ha Noi", "linhct99@gmail.com", "0909564156", false);
	}

	@After
	public void tearDown() throws Exception {
		this.customer = null;
	}

	@Test
	public void testCustomer() {
		this.customer = new Customer();
	}

	@Test
	public void testGetMaKH() {
		assertTrue(customer.getMaKH() == "KH001");
	}

	@Test
	public void testSetMaKH() {
		this.customer.setMaKH("KH99");
		assertEquals(this.customer.getMaKH(), "KH99");
	}

	@Test
	public void testGetTenKH() {
		assertEquals(customer.getTenKH(), "Cao Thi Lung Linh");
	}

	@Test
	public void testSetTenKH() {
		this.customer.setTenKH("Vip");
		assertEquals(this.customer.getTenKH(), "Vip");
	}

	@Test
	public void testGetDiaChi() {
		assertEquals(customer.getDiaChi(), "Ha Noi");
	}

	@Test
	public void testSetDiaChi() {
		this.customer.setDiaChi("Nghe An");
		assertEquals(this.customer.getDiaChi(), "Nghe An");
	}

	@Test
	public void testGetEmail() {
		assertEquals(customer.getEmail(), "linhct99@gmail.com");
	}

	@Test
	public void testSetEmail() {
		this.customer.setEmail("lingltc9989@gmail.com");
		assertEquals(this.customer.getEmail(), "lingltc9989@gmail.com");
	}

	@Test
	public void testGetSDT() {
		assertEquals(customer.getSDT(), "0909564156");
	}

	@Test
	public void testSetSDT() {
		this.customer.setSDT("0912365488");
		assertEquals(this.customer.getSDT(), "0912365488");
	}

	@Test
	public void testIsGioiTinh() {
		assertTrue(customer.isGioiTinh() == false);
	}

	@Test
	public void testSetGioiTinh() {
		this.customer.setGioiTinh(true);
		assertEquals(this.customer.isGioiTinh(), true);
	}

}
