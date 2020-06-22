package org.student.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * @Description 数据库操纵类
 * @author zhang
 * @version 1.0
 * @date 2019-12-10
 */
public class JDBCUtils
{	
	/**
	 * @Description 通过数据库连接池获取连接的静态方法
	 * @author zhang
	 * @date 2020-3-18
	 * @return Connection
	 * @throws Exception
	 */
	private static DataSource ds;
	private static Properties properties;
	static {
		try
		{
			InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("/druid.properties");
			properties = new Properties();
			properties.load(is);
			ds = DruidDataSourceFactory.createDataSource(properties);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection()
	{
		try
		{
			Connection conn = ds.getConnection();
			return conn;
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	public static void closeResources(Statement s, ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		try
		{
			if (s != null)
			{
				s.close();
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
	}
	public static void closeResources(Connection conn, Statement s, ResultSet rs)
	{
		try
		{
			if (rs != null)
			{
				rs.close();
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		try
		{
			if (s != null)
			{
				s.close();
			}
		}
		catch (SQLException sqle)
		{
			sqle.printStackTrace();
		}
		try
		{
			if (null != conn)
			{
				conn.close();
			}
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}