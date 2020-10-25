package daoTest;

import Helper.JdbcHelper;
import Model.Invoice;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.PreparedStatement;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceDAOTest {

    @Mock
    private JdbcHelper mock;

    private Invoice invoice;

    @Before
    public void setUp() throws Exception {
        String sql = "Insert";
        Object args = new Object();
//        Mockito.when(this.mock).thenReturn();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void insert() {
    }

    @Test
    public void update() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByID() {
    }

    @Test
    public void readFromResultSet() {
    }
}