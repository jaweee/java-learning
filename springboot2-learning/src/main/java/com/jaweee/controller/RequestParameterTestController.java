package com.jaweee.controller;

import com.jaweee.po.Product;
import javafx.beans.binding.ObjectExpression;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: TODO
 * @author: jiawei
 * @date: 2022/5/29 15:07
 * @github: https://github.com/jaweee
 * @version: 1.0
 */
@Controller
@RequestMapping("/parameter")
public class RequestParameterTestController {

    // PathVariable 测试
    @ResponseBody
    @GetMapping("/pathvariable/{id}/{username}")
    public Map<String, Object> testPathVariable(@PathVariable("id") Integer id,
                                                @PathVariable("username") String name,
                                                @PathVariable Map<String, String> kv){
        Map<String, Object> map = new HashMap<>();

        map.put("id", id);
        map.put("username", name);
        map.put("kv", kv);
        return map;
    }

    // RequestParam 测试
    @ResponseBody
    @GetMapping("/requestparam")
    public Map<String, Object> testRequestParam(@RequestParam("name") String name,
                                                @RequestParam("age") Integer age,
                                                @RequestParam("families") List<String> families,
                                                @RequestParam Map<String, Object> kv){
        Map<String, Object> map = new HashMap<>();

        map.put("name", name);
        map.put("age", age);
        map.put("families", families);
        map.put("kv", kv);
        return map;
    }

    // RequestHeader   测试
    @ResponseBody
    @GetMapping ("/requestheader")
    public Map<String, Object> testRequestHeader(@RequestHeader("User-agent") String userAgent,
                                                 @RequestHeader Map<String, Object> kv){
        Map<String, Object> map = new HashMap<>();

        map.put("userAgent", userAgent);
        map.put("kv", kv);
        return map;
    }

    // CookieValue
    @ResponseBody
    @GetMapping("/cookievalue")
    public Map<String, Object> testCookieValue(@CookieValue("_ga") String ga,
                                               @CookieValue("_ga") Cookie cookie){

        Map<String, Object> map = new HashMap<>();

        map.put("_ga", ga);
        map.put("_gacookie", cookie);
        return map;
    }

    // RequestBody
    @ResponseBody
    @PostMapping("/requestbody")
    public Map<String, Object> testRequestBody(@RequestBody Product product){

        Map<String, Object> map = new HashMap<>();

        map.put("product", product);
        return map;
    }

    // @RequestAttribute
    @GetMapping("/requestattribute")
    public void goToPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg", "成功....");
        request.setAttribute("code", 200);
        request.getRequestDispatcher("/parameter/attribute").forward(request, response);
//        下面这个路径就不对，不是到资源的路径名，到资源的路径名是localhost:8088/parameter/attribute
//        @param path: a String specifying the pathname to the resource.
//        request.getRequestDispatcher("/attribute").forward(request, response);
    }

    @ResponseBody
    @GetMapping("/attribute")
    public Map<String, Object> testRequestAttribute(@RequestAttribute("msg") String msg,
                                         @RequestAttribute("code") Integer code,
                                         HttpServletRequest request){
        Map<String, Object> map = new HashMap<>();
        map.put("msg", msg);
        map.put("code", code);
        map.put("msgreq", request.getAttribute("msg"));
        map.put("codereg", request.getAttribute("code"));
        return map;
    }

    // 矩阵变量（默认关闭了这个功能）的方式请求
    // 使用UrlPathHelper关闭url移除分号后内容的功能
    // 必须使用@PathVariable注解规定路径变量
    @ResponseBody
    @GetMapping("/{path}")
    public Map<String, Object> testMatrixVariable(@MatrixVariable("name") String name,
                                                  @MatrixVariable("hobbies") List<String> hobbies,
                                                  @PathVariable("path") String path){
        if("matrixvariable" != path){
            Map<String, Object> map = new HashMap<>();
            map.put("oops", "404！opps");
            return map;
        }
        Map<String, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("path", path);
        map.put("hobbies", hobbies);
        return map;
    }

    // 多个路径变量，使用pathVar，没有@ResponseBody会产生404错误，页面没有json串
    @ResponseBody
    @GetMapping("/multimatrixvariable/{person1}/{person2}")
    public Map<String, Object> testMultiMatrixVariable(@MatrixVariable (value = "name", pathVar = "person1") String name1,
                                                       @MatrixVariable (value = "name", pathVar = "person2") String name2,
                                                       @PathVariable("person1") String person1,
                                                       @PathVariable("person2") String person2){
        Map<String, Object> map = new HashMap<>();
        map.put("name1", name1);
        map.put("name2", name2);
        return map;
    }
}
