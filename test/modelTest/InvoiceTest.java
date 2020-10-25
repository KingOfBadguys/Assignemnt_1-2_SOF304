package modelTest;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import Model.Invoice;

public class InvoiceTest {
	private Invoice invoice;
	@Before
	public void setUp() throws Exception {
		this.invoice = new Invoice("HD989","KH01","NV05");
	}

	@After
	public void tearDown() throws Exception {
		this.invoice = null;
	}

	@Test
	public void testInvoice() {
		this.invoice = new Invoice();
	}

	@Test
	public void testGetMaHD() {
		assertEquals(this.invoice.getMaHD(), "HD989");
	}

	@Test
	public void testSetMaHD() {
		this.invoice.setMaHD("HD2951");
		assertEquals("HD2951", this.invoice.getMaHD());
	}

	@Test
	public void testGetMaKH() {
		assertEquals(this.invoice.getMaKH(), "KH01");
	}

	@Test
	public void testSetMaKH() {
		this.invoice.setMaKH("KH279");
		assertEquals("KH279", this.invoice.getMaKH());
	}

	@Test
	public void testGetMaNV() {
		assertEquals(this.invoice.getMaNV(), "NV05");
	}

	@Test
	public void testSetMaNV() {
		this.invoice.setMaNV("NV008");
		assertEquals("NV008", this.invoice.getMaNV());
	}

	@Ignore
	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
