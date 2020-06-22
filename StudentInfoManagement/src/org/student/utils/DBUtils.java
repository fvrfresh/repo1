package org.student.utils;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public abstract class DBUtils<T>
{
	private Class<T> clazz = null;
	{
		Type ty = this.getClass().getGenericSuperclass();
		ParameterizedType pt = (ParameterizedType)ty;
		Type[] typeArguments = pt.getActualTypeArguments();
		clazz = (Class<T>)typeArguments[0];
	}
	//通用增删改方法
	public int update(Connection conn, String sql, Object... params)
	{
		PreparedStatement pstmt = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			if (null != params)
			{
				for (int i = 0; i < params.length; i++)
				{
					pstmt.setObject(i + 1, params[i]);
				}
			}
			System.out.println(pstmt);
			int count = pstmt.executeUpdate();
			return count;
		} 
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return -1;
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
			return -1;
		}
		finally
		{
			JDBCUtils.closeResources(pstmt, null);
		}
	}
	//通用查询多条信息的方法
	public List<T> query(Connection conn, String sql, Object... params)
	{
		T t = null;
		List<T> ts = new LinkedList<T>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			if(null != params)
			{
				for (int i = 0; i < params.length; i++)
				{
					pstmt.setObject(i + 1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next())
			{
				t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++)
				{
					Object columnVal = rs.getObject(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnVal);
				}
				ts.add(t);
			}
			return ts.isEmpty() ? null : ts;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCUtils.closeResources(pstmt, rs);
		}
	}
	//通用查询一条信息的方法
	public T queryOne(Connection conn, String sql, String id)
	{
		T t = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, id);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			if(rs.next())
			{
				t = clazz.newInstance();
				for (int i = 0; i < columnCount; i++)
				{
					Object columnVal = rs.getObject(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Field field = clazz.getDeclaredField(columnLabel);
					field.setAccessible(true);
					field.set(t, columnVal);
				}
			}
			return null != t ? t : null;
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCUtils.closeResources(pstmt, rs);
		}
	}
	//特殊查询通用方法
	public Map<String, Object> count(Connection conn, String sql)
	{
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Map<String, Object> results = null;
		try
		{
			results = new HashMap<>();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCount = rsmd.getColumnCount();
			while(rs.next())
			{
				for (int i = 0; i < columnCount; i++)
				{
					Object columnVal = rs.getObject(i + 1);
					String columnLabel = rsmd.getColumnLabel(i + 1);
					results.put(columnLabel, columnVal);
				}
			}
			return results;
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
			return null;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			JDBCUtils.closeResources(pstmt, rs);
		}	
	}
	
}
