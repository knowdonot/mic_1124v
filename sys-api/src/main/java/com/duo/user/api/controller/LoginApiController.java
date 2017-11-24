package com.duo.user.api.controller;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Date;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.duo.common.po.User;
import com.duo.common.util.DateUtils;
import com.duo.common.util.IdGen;
import com.duo.user.api.service.IUserApiService;

import sun.misc.BASE64Encoder;
/**
 * 提供用户信息数据
 * 
 * @Class Name UserController
 * @author yourname
 * @Create In 2017年7月11日
 */
@RestController
@RequestMapping("/loginapi")
public class LoginApiController {

	
	@Autowired
	private IUserApiService userApiService;
	
	@RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    public User queryUserSys(String username,String password){
		System.out.println("login...........username:"+username+"..........password:"+password);
		User user = userApiService.login(username, password);
		
		return user;
    }

	
	
	public static byte[] encrypt(byte[] src, byte[] key) throws Exception {
	    // DES算法要求有一个可信任的随机数源
	    SecureRandom sr = new SecureRandom();

	    // 从原始密匙数据创建DESKeySpec对象
	    DESKeySpec dks = new DESKeySpec(key);

	    // 创建一个密匙工厂，然后用它把DESKeySpec转换成一个SecretKey对象
	    SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
	    SecretKey securekey = keyFactory.generateSecret(dks);

	    // Cipher对象实际完成加密操作
	    Cipher cipher = Cipher.getInstance("DES");

	    // 用密匙初始化Cipher对象
	    cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

	    // 执行加密操作
	    return cipher.doFinal(src);
	}
	
	
	
	public static String encryptBASE64(byte[] key) throws Exception {  
	    return (new BASE64Encoder()).encodeBuffer(key);  
	}  
	
	public static byte[] encryptMD5(byte[] data) throws Exception {  
		  
        MessageDigest md5 = MessageDigest.getInstance("MD5");  
        md5.update(data);  
        return md5.digest();  
  
    }  
	


}
