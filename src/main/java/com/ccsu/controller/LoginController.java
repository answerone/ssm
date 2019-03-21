package com.ccsu.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ccsu.commons.Constants;
import com.ccsu.utils.ImageCodeUtil;

@Controller
public class LoginController {
	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	/*
	 * @Autowired private UserService userService;
	 */
	
	@RequestMapping("/prepareLogin")
	public String prepareLogin() {
		return "prepare_login";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) {
		String number = request.getParameter("number");
		String password = request.getParameter("password");
		String imageCode = request.getParameter("imageCode");
		String sessionCode = (String) request.getSession().getAttribute("imageCode");
		if(imageCode == null || "".equals(imageCode) || !imageCode.equals(sessionCode)) {
			request.setAttribute("code", Constants.RESPONSE_CODE_FAIL);
			request.setAttribute("msg", "验证码错误");
		}
		return "regiester";
	}
	
	@RequestMapping("/getImageCode")
	public void getImageCode(HttpServletRequest request,HttpServletResponse response) {
		 // 调用工具类生成的验证码和验证码图片
        Map<String, Object> codeMap = ImageCodeUtil.generateCodeAndPic();

        // 将四位数字的验证码保存到Session中。
        HttpSession session = request.getSession();
        session.setAttribute("imageCode", codeMap.get("code").toString());

        // 禁止图像缓存。
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", -1);

        response.setContentType("image/jpeg");

        // 将图像输出到Servlet输出流中。
        OutputStream  sos = null;
        try {
            sos = response.getOutputStream();
            ImageIO.write((RenderedImage) codeMap.get("codePic"), "jpeg", sos);
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
        	if(sos != null)
				try {
					sos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        }

	}
}
