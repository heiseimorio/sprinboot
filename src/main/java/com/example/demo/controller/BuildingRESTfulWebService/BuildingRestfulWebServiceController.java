// package com.example.demo.controller.BuildingRESTfulWebService;

// import java.util.concurrent.atomic.AtomicLong;

// import com.example.demo.BuildingRestfulWebService.BuildingRestfulWebService;

// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.RestController;

// // import org.springframework.web.bind.annotation.GetMapping;

// // SpringBootガイドのBuilding a RESTful Web Serviceのコントローラー
// @RestController
// public class BuildingRestfulWebServiceController {

//   private static final String template = "Hello, %s!";
//   private final AtomicLong counter = new AtomicLong();

//   // @GetMapping("/greeting") // Handling Form Submissionガイドでもgreetingを使用しているためコメントアウト
//   public BuildingRestfulWebService greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
//     return new BuildingRestfulWebService(counter.incrementAndGet(), String.format(template, name));
//   }

// }