//package com.sample.controller;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.multipart.MultipartFile;
//
//import com.entity.User;
//
///**
// * @author:DanLongChen
// * @versioin:2018年11月19日上午10:22:13
// **/
//@Controller
//@RequestMapping("/test") // RequestMapping可以映射到类或者方法
//public class HelloWorldController {
//	@RequestMapping("/index.html")
//	public String say(Model model) {
//		model.addAttribute("word", "hello world");
//		return "/index.btl"; // 返回的是视图，并且传入了Attribute参数设定
//	}
//
//	@RequestMapping(path = "/admin", method = RequestMethod.GET) // 这里返回的是json字符串
//	@ResponseBody
//	public String sayJson() {
//		System.out.println("sayJson");
//		return "hello world!";
//	}
//
//	@RequestMapping(path = "/all.json", method = RequestMethod.GET) // 可以制定path和method，如果是对象，那么会使用jackson序列化为json字符串再输出
//	@ResponseBody
//	public List<Object> allUser() {
//		return new ArrayList<Object>();
//	}
//
//	@RequestMapping(value = "/user/{id}.json", method = RequestMethod.GET) // value用于设置路径，id用于传递参数,也可以用类似于ant的匹配"/usr/all/*.json"匹配任意字符
//	// /**/user.json
//	// 统配任意路径(/user.json、/path1/user.json等)、?用于匹配一个字符，有多个匹配的时候会选用更加具体的匹配来处理请求，使用${}来获取系统的配置或者环境变量
//	/*
//	 * method属性用于映射对应HTTP的请求方法
//	 *
//	 * GET：用来获取URL的对应的内容 POST：用来向服务器提交信息 HEAD：同GET，只是用于获取URL的元信息（过期时间等等）
//	 * PUT：语义上类似于更新操作（多次PUT不会导致数据的变化） DELETE：删除对应的资源 PATCH：类似于PUT，表示信息的局部更新
//	 * 为了简化操作，提供了：@GetMapping，@PostMapping，@PutMapping，@DeleteMapping，@PatchMapping
//	 */
//	@ResponseBody
//	public User getUserById(@PathVariable("id") Long id) {// 可以简化 @PathVariable Long id
//		return new User();
//	}
//
//	@GetMapping(value = "/consumes/test.json", consumes = "application/json")
//	@ResponseBody
//	public User forJson() {
//		System.out.println("fine");
//		return new User();
//	}
//
//	@PostMapping("/getUser")
//	@ResponseBody
//	public String getUser(@RequestBody User user) {
//		System.out.println(user.name);
//		return "ok";
//	}
//
//	@GetMapping(value = "/update/{id}/{target}.json", params = "action=update")
//	@ResponseBody
//	public void update(@PathVariable int id, @PathVariable int target) {
//		System.out.println("update compelite");
//	}
//
//	@PostMapping("/file")
//	@ResponseBody
//	public String getFile(String name, MultipartFile file) throws IOException {
//		if (file == null || file.isEmpty() || file.getSize() == 0) {
//			return "false";
//		} else {
//			String fileName = file.getOriginalFilename();// 获取上传文件的名称,getBytes(获取输入文件的二进制流),transferTo(File
//			// dest)保存上传文件到目标文件系统
//			// InputStream stream = file.getInputStream();// 获取输入流
//			return "true";
//		}
//	}
//
//	@ModelAttribute
//	public void addIdToModel(@PathVariable long id, Model model) {
//		model.addAttribute("id", id);
//	}
//
//	@RequestMapping(value = "/{id}/get.json", method = RequestMethod.GET)
//	@ResponseBody
//	public String findId(Model model) {
//		if (model.containsAttribute("id")) {
//			return "true";
//		} else {
//			return "false";
//		}
//	}
//
//	@RequestMapping(path = "{id}/validated", method = RequestMethod.GET)
//	@ResponseBody
//	public void addUser(@Validated({ User.Add.class }) User user, BindingResult result) {
//		if (result.hasErrors()) {// getAllErrors()得到所有的错误信息
//			System.out.println("验证不通过");
//		}
//		return;
//	}
//}
