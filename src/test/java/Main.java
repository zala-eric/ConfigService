public class Main {
	public static void main(String[] args) {
		String content = "test11111";
		String password = "12345678";
		// 加密
		System.out.println("加密前：" + content);
		byte[] encryptResult = Encryption.encrypt(content, password);
		// 解密
		byte[] decryptResult = Decryption.decrypt(encryptResult, password);
		System.out.println("解密后：" + new String(decryptResult));
	}
}