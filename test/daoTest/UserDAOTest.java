package daoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.mockito.Mockito;

import DAO_Controller.UserDAO;
import Helper.JdbcHelper;
import Model.User;
import Model.User2;

public class UserDAOTest {
	private UserDAO userDAO;
	private User user;
	private User2 user2;
	JdbcHelper mock;

	@Rule
	public ErrorCollector collector = new ErrorCollector();

	@Before
	public void setUp() {
		Mockito.mock(JdbcHelper.class);
		this.userDAO = new UserDAO(mock);
		this.user = new User();
		this.user2 = new User2();
	}

	@SuppressWarnings("static-access")
	@Test(expected = Exception.class)
	public void testInsertNull() {
		String sql = "insert";
		this.userDAO.insert(this.user);
		Mockito.doNothing().when(this.mock).executeUpdate(sql, this.user.getMaNV(),this.user.getMatKhau(),this.user.getTenNV(),this.user.isChucVu());
//		this.user.getMaNV(),this.user.getTenNV(),this.user.getMatKhau()
//		,this.user.getMaNV()
	}

	@Test
	public void testInsertValid() {
		try {
			this.user.setMaNV("HT989");
			this.user.setTenNV("King Tien");
			this.user.setMatKhau("admin");
			this.user.setChucVu(true);

			this.userDAO.insert(this.user);
			assertNull(this.user);

		} catch (Throwable e) {
			collector.addError(e);
		}
	}

	@Test
	public void testUpdateNull() {
		collector.addError(new Throwable("Should not be empty"));
		try {
			this.userDAO.update(this.user);
		} catch (Throwable e) {
			collector.addError(e);
		}
	}

	@Test
	public void testUpdateValid() {
		this.user.setMaNV("HT98");
		this.user.setTenNV("King Tien");
		this.user.setMatKhau("admin");
		this.user.setChucVu(true);
		this.userDAO.update(this.user);
		assertNull(this.user);
	}

	@Test(expected = Exception.class)
	public void testUpdateMKNull() {
		this.userDAO.updateMK(this.user2);
	}

	@Test
	public void testUpdateMKValid() {
		this.user2.setMaNV("HT98");
		this.user2.setMatKhau("admin2");
		this.userDAO.updateMK(this.user2);
		assertEquals(user2.getMaNV(), "HT98");
		assertEquals(user2.getMatKhau(), "admin2");
	}

	@Test
	public void testDeleteNull() {
		collector.addError(new Throwable("maNV have to be available"));
		String maNV = "";
		this.userDAO.delete(maNV);
	}

	@Test
	public void testDeleteValid() {
		this.userDAO.delete(this.user.getMaNV());
	}

	@Test
	public void testFindByIDNotExist() {
		String maNV = "nothing";
		@SuppressWarnings("unchecked")
		List<User> user = (List<User>) this.userDAO.findByID(maNV);
		assertNull(user);
	}

	@Test
	public void testFindByIDExist() {
		String maNV = "HT98";
		this.user = this.userDAO.findByID(maNV);
		assertNotNull(user);
	}

	@SuppressWarnings("deprecation")
	@Test
	public void testSelect() {
		User user = new User();
		List<User> expResult = new ArrayList<>();
		expResult.add(user);
//        Mockito.doReturn(expResult).when(userDAO.select()).add();
		List<User> result = userDAO.select();
		assertThat(result, CoreMatchers.is(expResult));
	}

	@Test
	public void testReadFromResultSet() {
		fail("Not yet implemented");
	}

}
