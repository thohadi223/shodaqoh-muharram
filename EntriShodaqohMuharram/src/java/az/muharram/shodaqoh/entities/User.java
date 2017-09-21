package az.muharram.shodaqoh.entities;

import java.security.NoSuchAlgorithmException;

public class User {
	private String username;
	private String password;
	private int privilege;
	
	public User() {}
	public User(String username) {
		this.username = username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	
	public int getPrivilege() {
		return privilege;
	}
	public void setPrivilege(int privilege) {
		this.privilege = privilege;
	}
	
	public String getEncryptedPassword(){
		return encrypt(this.password);
	}
	
	public static String encrypt(String password){
		try {
			java.security.MessageDigest d = null;
			d = java.security.MessageDigest.getInstance("SHA-1");
			d.reset();
			d.update(password.getBytes());
			byte[] digest = new byte[40];
			digest = d.digest();
			//return digest;
			return convertToHex(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}
	private static String convertToHex(byte[] data) { 
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < data.length; i++) { 
            int halfbyte = (data[i] >>> 4) & 0x0F;
            int two_halfs = 0;
            do { 
                if ((0 <= halfbyte) && (halfbyte <= 9)) 
                    buf.append((char) ('0' + halfbyte));
                else 
                    buf.append((char) ('a' + (halfbyte - 10)));
                halfbyte = data[i] & 0x0F;
            } while(two_halfs++ < 1);
        } 
        return buf.toString();
    }
}
