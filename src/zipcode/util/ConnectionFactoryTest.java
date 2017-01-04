package zipcode.util;

import static org.junit.Assert.*;

import java.sql.Connection;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

public class ConnectionFactoryTest {
private static Connection instance;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		instance = ZipcodeUtil.getInstance();
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		Jdbc.close(instance);
	}

	@Test
	public void testConnection() {
		Assert.assertNotNull(instance);
	}

}
