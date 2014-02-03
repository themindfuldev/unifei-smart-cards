package smartsystem;

import java.rmi.Remote;


import javacard.framework.JCSystem;
import javacard.framework.service.CardRemoteObject;

public class VCardImpl extends CardRemoteObject implements Remote, IVCard
{
	// Atributos
	private byte[] title, foreName, middleName, surName, suffix, photoURL,
			birthDate, postOfficeAddress, buildingName, street, locality, region,
			postalCode, country, tel1, tel2, email1, email2, url;

	// addressType = {DOM;INTL;POSTAL;PARCEL;HOME;WORK}
	// telType = {PREF?;WORK;HOME;VOICE;FAZ;MSG;CELL;PAGER;BBS;MODEM;CAR;ISDN;VIDEO}
	private boolean[] addressType, tel1Type, tel2Type;

	public VCardImpl()
	{
		super();
	}

	public VCardImpl(byte[] title, byte[] foreName, byte[] middleName,
			byte[] surName, byte[] suffix, byte[] photoURL, byte[] birthDate,
			byte[] postOfficeAddress, byte[] buildingName, byte[] street,
			byte[] locality, byte[] region, byte[] postalCode, byte[] country,
			byte[] tel1, byte[] tel2, byte[] email1, byte[] email2, byte[] url,
			boolean[] addressType, boolean[] tel1Type, boolean[] tel2Type)
	{
		super();
		this.title = title;
		this.foreName = foreName;
		this.middleName = middleName;
		this.surName = surName;
		this.suffix = suffix;
		this.photoURL = photoURL;
		this.birthDate = birthDate;
		this.postOfficeAddress = postOfficeAddress;
		this.buildingName = buildingName;
		this.street = street;
		this.locality = locality;
		this.region = region;
		this.postalCode = postalCode;
		this.country = country;
		this.tel1 = tel1;
		this.tel2 = tel2;
		this.email1 = email1;
		this.email2 = email2;
		this.url = url;
		this.addressType = addressType;
		this.tel1Type = tel1Type;
		this.tel2Type = tel2Type;
	}

	/**
	 * @see modelo.IVCard#getAddressType()
	 */
	public boolean[] getAddressType()
	{
		return addressType;
	}

	/**
	 * @see modelo.IVCard#setAddressType(boolean[])
	 */
	public void setAddressType(boolean[] addressType)
	{
		if (addressType != null)
		{
			addressType = null;
			JCSystem.requestObjectDeletion();
		}
		this.addressType = addressType;
	}

	/**
	 * @see modelo.IVCard#getBirthDate()
	 */
	public byte[] getBirthDate()
	{
		return birthDate;
	}

	/**
	 * @see modelo.IVCard#setBirthDate(byte[])
	 */
	public void setBirthDate(byte[] birthDate)
	{
		if (birthDate != null)
		{
			birthDate = null;
			JCSystem.requestObjectDeletion();
		}
		this.birthDate = birthDate;
	}

	/**
	 * @see modelo.IVCard#getBuildingName()
	 */
	public byte[] getBuildingName()
	{
		return buildingName;
	}

	/**
	 * @see modelo.IVCard#setBuildingName(byte[])
	 */
	public void setBuildingName(byte[] buildingName)
	{
		if (buildingName != null)
		{
			buildingName = null;
			JCSystem.requestObjectDeletion();
		}
		this.buildingName = buildingName;
	}

	/**
	 * @see modelo.IVCard#getCountry()
	 */
	public byte[] getCountry()
	{
		return country;
	}

	/**
	 * @see modelo.IVCard#setCountry(byte[])
	 */
	public void setCountry(byte[] country)
	{
		if (country != null)
		{
			country = null;
			JCSystem.requestObjectDeletion();
		}
		this.country = country;
	}

	/**
	 * @see modelo.IVCard#getEmail1()
	 */
	public byte[] getEmail1()
	{
		return email1;
	}

	/**
	 * @see modelo.IVCard#setEmail1(byte[])
	 */
	public void setEmail1(byte[] email1)
	{
		if (email1 != null)
		{
			email1 = null;
			JCSystem.requestObjectDeletion();
		}
		this.email1 = email1;
	}

	/**
	 * @see modelo.IVCard#getEmail2()
	 */
	public byte[] getEmail2()
	{
		return email2;
	}

	/**
	 * @see modelo.IVCard#setEmail2(byte[])
	 */
	public void setEmail2(byte[] email2)
	{
		if (email2 != null)
		{
			email2 = null;
			JCSystem.requestObjectDeletion();
		}
		this.email2 = email2;
	}

	/**
	 * @see modelo.IVCard#getForeName()
	 */
	public byte[] getForeName()
	{
		return foreName;
	}

	/**
	 * @see modelo.IVCard#setForeName(byte[])
	 */
	public void setForeName(byte[] foreName)
	{
		if (foreName != null)
		{
			foreName = null;
			JCSystem.requestObjectDeletion();
		}
		this.foreName = foreName;
	}

	/**
	 * @see modelo.IVCard#getLocality()
	 */
	public byte[] getLocality()
	{
		return locality;
	}

	/**
	 * @see modelo.IVCard#setLocality(byte[])
	 */
	public void setLocality(byte[] locality)
	{
		if (locality != null)
		{
			locality = null;
			JCSystem.requestObjectDeletion();
		}
		this.locality = locality;
	}

	/**
	 * @see modelo.IVCard#getMiddleName()
	 */
	public byte[] getMiddleName()
	{
		return middleName;
	}

	/**
	 * @see modelo.IVCard#setMiddleName(byte[])
	 */
	public void setMiddleName(byte[] middleName)
	{
		if (middleName != null)
		{
			middleName = null;
			JCSystem.requestObjectDeletion();
		}
		this.middleName = middleName;
	}

	/**
	 * @see modelo.IVCard#getPhotoURL()
	 */
	public byte[] getPhotoURL()
	{
		return photoURL;
	}

	/**
	 * @see modelo.IVCard#setPhotoURL(byte[])
	 */
	public void setPhotoURL(byte[] photoURL)
	{
		if (photoURL != null)
		{
			photoURL = null;
			JCSystem.requestObjectDeletion();
		}
		this.photoURL = photoURL;
	}

	/**
	 * @see modelo.IVCard#getPostalCode()
	 */
	public byte[] getPostalCode()
	{
		return postalCode;
	}

	/**
	 * @see modelo.IVCard#setPostalCode(byte[])
	 */
	public void setPostalCode(byte[] postalCode)
	{
		if (postalCode != null)
		{
			postalCode = null;
			JCSystem.requestObjectDeletion();
		}
		this.postalCode = postalCode;
	}

	/**
	 * @see modelo.IVCard#getPostOfficeAddress()
	 */
	public byte[] getPostOfficeAddress()
	{
		return postOfficeAddress;
	}

	/**
	 * @see modelo.IVCard#setPostOfficeAddress(byte[])
	 */
	public void setPostOfficeAddress(byte[] postOfficeAddress)
	{
		if (postOfficeAddress != null)
		{
			postOfficeAddress = null;
			JCSystem.requestObjectDeletion();
		}
		this.postOfficeAddress = postOfficeAddress;
	}

	/**
	 * @see modelo.IVCard#getRegion()
	 */
	public byte[] getRegion()
	{
		return region;
	}

	/**
	 * @see modelo.IVCard#setRegion(byte[])
	 */
	public void setRegion(byte[] region)
	{
		if (region != null)
		{
			region = null;
			JCSystem.requestObjectDeletion();
		}
		this.region = region;
	}

	/**
	 * @see modelo.IVCard#getStreet()
	 */
	public byte[] getStreet()
	{
		return street;
	}

	/**
	 * @see modelo.IVCard#setStreet(byte[])
	 */
	public void setStreet(byte[] street)
	{
		if (street != null)
		{
			street = null;
			JCSystem.requestObjectDeletion();
		}
		this.street = street;
	}

	/**
	 * @see modelo.IVCard#getSuffix()
	 */
	public byte[] getSuffix()
	{
		return suffix;
	}

	/**
	 * @see modelo.IVCard#setSuffix(byte[])
	 */
	public void setSuffix(byte[] suffix)
	{
		if (suffix != null)
		{
			suffix = null;
			JCSystem.requestObjectDeletion();
		}
		this.suffix = suffix;
	}

	/**
	 * @see modelo.IVCard#getSurName()
	 */
	public byte[] getSurName()
	{
		return surName;
	}

	/**
	 * @see modelo.IVCard#setSurName(byte[])
	 */
	public void setSurName(byte[] surName)
	{
		if (surName != null)
		{
			surName = null;
			JCSystem.requestObjectDeletion();
		}
		this.surName = surName;
	}

	/**
	 * @see modelo.IVCard#getTel1()
	 */
	public byte[] getTel1()
	{
		return tel1;
	}

	/**
	 * @see modelo.IVCard#setTel1(byte[])
	 */
	public void setTel1(byte[] tel1)
	{
		if (tel1 != null)
		{
			tel1 = null;
			JCSystem.requestObjectDeletion();
		}
		this.tel1 = tel1;
	}

	/**
	 * @see modelo.IVCard#getTel1Type()
	 */
	public boolean[] getTel1Type()
	{
		return tel1Type;
	}

	/**
	 * @see modelo.IVCard#setTel1Type(boolean[])
	 */
	public void setTel1Type(boolean[] tel1Type)
	{
		if (tel1Type != null)
		{
			tel1Type = null;
			JCSystem.requestObjectDeletion();
		}
		this.tel1Type = tel1Type;
	}

	/**
	 * @see modelo.IVCard#getTel2()
	 */
	public byte[] getTel2()
	{
		return tel2;
	}

	/**
	 * @see modelo.IVCard#setTel2(byte[])
	 */
	public void setTel2(byte[] tel2)
	{
		if (tel2 != null)
		{
			tel2 = null;
			JCSystem.requestObjectDeletion();
		}
		this.tel2 = tel2;
	}

	/**
	 * @see modelo.IVCard#getTel2Type()
	 */
	public boolean[] getTel2Type()
	{
		return tel2Type;
	}

	/**
	 * @see modelo.IVCard#setTel2Type(boolean[])
	 */
	public void setTel2Type(boolean[] tel2Type)
	{
		if (tel2Type != null)
		{
			tel2Type = null;
			JCSystem.requestObjectDeletion();
		}
		this.tel2Type = tel2Type;
	}

	/**
	 * @see modelo.IVCard#getTitle()
	 */
	public byte[] getTitle()
	{
		return title;
	}

	/**
	 * @see modelo.IVCard#setTitle(byte[])
	 */
	public void setTitle(byte[] title)
	{
		if (title != null)
		{
			title = null;
			JCSystem.requestObjectDeletion();
		}
		this.title = title;
	}

	/**
	 * @see modelo.IVCard#getUrl()
	 */
	public byte[] getUrl()
	{
		return url;
	}

	/**
	 * @see modelo.IVCard#setUrl(byte[])
	 */
	public void setUrl(byte[] url)
	{
		if (url != null)
		{
			url = null;
			JCSystem.requestObjectDeletion();
		}
		this.url = url;
	}

	public void limpar()
	{
		this.title = null;
		this.foreName = null;
		this.middleName = null;
		this.surName = null;
		this.suffix = null;
		this.photoURL = null;
		this.birthDate = null;
		this.postOfficeAddress = null;
		this.buildingName = null;
		this.street = null;
		this.locality = null;
		this.region = null;
		this.postalCode = null;
		this.country = null;
		this.tel1 = null;
		this.tel2 = null;
		this.email1 = null;
		this.email2 = null;
		this.url = null;
		this.addressType = null;
		this.tel1Type = null;
		this.tel2Type = null;
		
		JCSystem.requestObjectDeletion();
	}

}
