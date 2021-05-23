package main.java.com.hubery.rsamanage.encrypt;

/*import com.csii.pe.encrypt.a;
import com.csii.pe.encrypt.encryptFactroy;*/
import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.interfaces.RSAPublicKey;

public class EncryptFactory extends encryptFactroy{

	private synchronized RSAPublicKey getEncPubKey() {
		String modulus = EncRSAPublicKeyModulus;
		String pubExponent = "10001";
		//return a.buildRSAPublicKey(modulus, pubExponent);
		return null;
	}

	public String getEncPubValue(String password){
		RSAPublicKey EncPubKey = getEncPubKey();
		try {
			return RsaUtil.rsaEncrypt(EncPubKey, password);
		} catch (Exception e) {
			throw new SecurityException("encrypt password error.", e);
		}
	}

	private String EncRSAPublicKeyModulus;

	public void setEncRSAPublicKeyModulus(String encRSAPublicKeyModulus) {
		EncRSAPublicKeyModulus = encRSAPublicKeyModulus;
	}

	@SuppressWarnings("restriction")
	public String toRSAPublicKeyBlobString() throws IOException {
		RSAPublicKey pk = getEncPubKey();
		byte[] bytes = toRSAPublicKeyBlob(pk);
		BASE64Encoder b64enc = new BASE64Encoder();
		return b64enc.encode(bytes);
	}

	public static byte[] toRSAPublicKeyBlob(RSAPublicKey pk) throws IOException {
		ByteArrayOutputStream bout = new ByteArrayOutputStream();

		byte[] header = new byte[] { 0x06, 0x02, 0x0, 0x0, 0x0, (byte) 0xa4, 0x0, 0x0, 'R', 'S', 'A', '1' };
		bout.write(header);
		// modules length
		{
			// in little endian
			int bitLength = pk.getModulus().bitLength();
			byte[] bitBytes = new byte[4];
			for (int i = 0; i < 4; i++) {
				bitBytes[i] = (byte) ((bitLength >> i * 8) & 0x0ff);
			}
			bout.write(bitBytes);
		}
		// exp
		{
			// in little endian
			int exp = pk.getPublicExponent().intValue();
			byte[] bitBytes = new byte[4];
			for (int i = 0; i < 4; i++) {
				bitBytes[i] = (byte) ((exp >> i * 8) & 0x0ff);
			}
			bout.write(bitBytes);
		}

		// in little endian
		byte[] modules = pk.getModulus().toByteArray();
		int size = (pk.getModulus().bitLength() + 7) / 8;
		int offset = modules.length - 1;
		// for microsoft using Little Endian, need reverse
		while (size > 0) {
			bout.write(modules[offset--]);
			size--;
		}

		return bout.toByteArray();
	}


}
