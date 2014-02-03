package smartsystem;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Interface para a manipulação de dados de um vCard.
 * 
 * @author Tiago
 */
public interface IVCard extends Remote
{
	public boolean[] getAddressType() throws RemoteException;

	public void setAddressType(boolean[] addressType) throws RemoteException;

	public byte[] getBirthDate() throws RemoteException;

	public void setBirthDate(byte[] birthDate) throws RemoteException;

	public byte[] getBuildingName() throws RemoteException;

	public void setBuildingName(byte[] buildingName) throws RemoteException;

	public byte[] getCountry() throws RemoteException;

	public void setCountry(byte[] country) throws RemoteException;

	public byte[] getEmail1() throws RemoteException;

	public void setEmail1(byte[] email1) throws RemoteException;

	public byte[] getEmail2() throws RemoteException;

	public void setEmail2(byte[] email2) throws RemoteException;

	public byte[] getForeName() throws RemoteException;

	public void setForeName(byte[] foreName) throws RemoteException;

	public byte[] getLocality() throws RemoteException;

	public void setLocality(byte[] locality) throws RemoteException;

	public byte[] getMiddleName() throws RemoteException;

	public void setMiddleName(byte[] middleName) throws RemoteException;

	public byte[] getPhotoURL() throws RemoteException;

	public void setPhotoURL(byte[] photoURL) throws RemoteException;

	public byte[] getPostalCode() throws RemoteException;

	public void setPostalCode(byte[] postalCode) throws RemoteException;

	public byte[] getPostOfficeAddress() throws RemoteException;

	public void setPostOfficeAddress(byte[] postOfficeAddress)
			throws RemoteException;

	public byte[] getRegion() throws RemoteException;

	public void setRegion(byte[] region) throws RemoteException;

	public byte[] getStreet() throws RemoteException;

	public void setStreet(byte[] street) throws RemoteException;

	public byte[] getSuffix() throws RemoteException;

	public void setSuffix(byte[] suffix) throws RemoteException;

	public byte[] getSurName() throws RemoteException;

	public void setSurName(byte[] surName) throws RemoteException;

	public byte[] getTel1() throws RemoteException;

	public void setTel1(byte[] tel1) throws RemoteException;

	public boolean[] getTel1Type() throws RemoteException;

	public void setTel1Type(boolean[] tel1Type) throws RemoteException;

	public byte[] getTel2() throws RemoteException;

	public void setTel2(byte[] tel2) throws RemoteException;

	public boolean[] getTel2Type() throws RemoteException;

	public void setTel2Type(boolean[] tel2Type) throws RemoteException;

	public byte[] getTitle() throws RemoteException;

	public void setTitle(byte[] title) throws RemoteException;

	public byte[] getUrl() throws RemoteException;

	public void setUrl(byte[] url) throws RemoteException;

}