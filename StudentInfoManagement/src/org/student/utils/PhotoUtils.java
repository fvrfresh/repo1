package org.student.utils;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;

public class PhotoUtils
{
	public static void addPhoto(PreparedStatement ps, int index, String photoPath)
	{
		InputStream is = null;
		try
		{
			is = new FileInputStream(new File(photoPath));
			ps.setBinaryStream(index, is);
			ps.executeUpdate();
			System.out.println(ps);
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(SQLException sqle)
		{
			sqle.printStackTrace();
		}
		finally
		{
			try
			{
				if (is != null)
					is.close();
			} catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}	
	}
	public static void getPhoto(ResultSet rs, String columnLabel, String name)
	{
		try
		{
			rs.next();
			InputStream is = rs.getBinaryStream(columnLabel);
//			byte[] bytes = new byte[102400];
//			int len = -1;
//			len = is.read(bytes);
			File f = new File(name + ".jpg");
//			ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
			BufferedImage bi = ImageIO.read(is);
			System.out.println("bufferedimage" + bi);
			ImageIO.write(bi, "jpg", f);
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
