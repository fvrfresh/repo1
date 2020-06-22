package org.student.entity;

public class Student
{
	private int number;
	private String stu_nu;
	private String name;
	private String gender;
	private Integer age;
	private String school;
	private String major;
	private String grade;
	private String contact;
	private String photo;
	
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
	public String getStu_nu()
	{
		return stu_nu;
	}
	public void setStu_nu(String stu_nu)
	{
		this.stu_nu = stu_nu;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getGender()
	{
		return gender;
	}
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	public Integer getAge()
	{
		return age;
	}
	public void setAge(Integer age)
	{
		this.age = age;
	}
	public String getSchool()
	{
		return school;
	}
	public void setSchool(String school)
	{
		this.school = school;
	}
	public String getMajor()
	{
		return major;
	}
	public void setMajor(String major)
	{
		this.major = major;
	}
	public String getGrade()
	{
		return grade;
	}
	public void setGrade(String grade)
	{
		this.grade = grade;
	}
	public String getContact()
	{
		return contact;
	}
	public void setContact(String contact)
	{
		this.contact = contact;
	}
	public String getPhoto()
	{
		return photo;
	}
	public void setPhoto(String photo)
	{
		this.photo = photo;
	}
	@Override
	public String toString()
	{
		return "Student [number=" + number + ", stu_nu=" + stu_nu + ", name=" + name + ", gender=" + gender + ", age=" + age
				+ ", school=" + school + ", major=" + major + ", grade=" + grade + ", contact=" + contact + ", photo="
				+ photo + "]";
	}
	
	
}
