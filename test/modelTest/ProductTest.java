package modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Model.Product;

public class ProductTest {
	private Product product;

	@Before
	public void setUp() throws Exception {
		this.product = new Product("DT01", "Iphone", 20, 500000, null, null);
	}

	@After
	public void tearDown() throws Exception {
		this.product = null;
	}

	@Test
	public void testProduct() {
		this.product = new Product();
	}

	@Test
	public void testGetHinh() {
		assertEquals(this.product.getHinh(), null);
	}

	@Test
	public void testSetHinh() {
		this.product.setHinh("Iphone.png");
		assertEquals("Iphone.png", this.product.getHinh());
	}

	@Test
	public void testGetMaDT() {
		assertEquals(this.product.getMaDT(), "DT01");
	}

	@Test
	public void testSetMaDT() {
		this.product.setMaDT("DT012");
		assertEquals("DT012", this.product.getMaDT());
	}

	@Test
	public void testGetTenDT() {
		assertEquals(this.product.getTenDT(), "Iphone");
	}

	@Test
	public void testSetTenDT() {
		this.product.setTenDT("SamSung");
		assertEquals("SamSung", this.product.getTenDT());
	}

	@Test
	public void testGetSoLuong() {
		assertEquals(this.product.getSoLuong(), 20);
	}

	@Test
	public void testSetSoLuong() {
		this.product.setSoLuong(55);
		assertEquals(55, this.product.getSoLuong());
	}

	@Test
	public void testGetGiaTien() {
		assertTrue(this.product.getGiaTien() == 500000);
	}

	@Test
	public void testSetGiaTien() {
		this.product.setGiaTien(50651);
		assertTrue(this.product.getGiaTien()== 50651);
	}

	@Ignore
	@Test
	public void testGetNgayNhap() {
	}

	@Ignore
	@Test
	public void testSetNgayNhap() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetGhiChu() {
		assertEquals(this.product.getGhiChu(), null);
	}

	@Test
	public void testSetGhiChu() {
		this.product.setGhiChu("Best Seller");
		assertEquals("Best Seller", this.product.getGhiChu());
	}

}
