package com.rambert.assignment.model;

public class Student implements GenericModel
{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String lastName;
	private String firstName;

	@Override
	public Long getId()
	{
		return id;
	}

	@Override
	public void setId(Long id)
	{
		this.id = id;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	@Override
	public void copyAttributes(GenericModel model)
	{
		Student studentModel = (Student) model;
		this.setFirstName(studentModel.getFirstName());
		this.setLastName(studentModel.getLastName());
	}

}
