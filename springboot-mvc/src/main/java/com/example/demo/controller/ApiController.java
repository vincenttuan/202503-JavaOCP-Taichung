package com.example.demo.controller;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.SpringbootMvcApplication;
import com.example.demo.model.BMI;
import com.example.demo.model.Book;
import com.example.demo.model.Student;
import com.example.demo.model.Sugar;
import com.example.demo.model.Water;
import com.example.demo.response.ApiResponse;

@RestController
@RequestMapping("/api")
public class ApiController {

    // 執行路徑: /api/hello
	@GetMapping("/hello")
	public String hello() {
		return "Hello Springboot";
	}
	
	// 執行路徑: /api/hi
	@GetMapping("/hi")
	public String hi() {
		return "嗨~ Springboot";
	}
	
	// 執行路徑: /api/bmi?h=170&w=60
	@GetMapping("/bmi")
	public String bmi(@RequestParam(name = "h") double h, @RequestParam double w) {
		double bmi = w / Math.pow(h/100, 2);
		return String.format("身高: %.1f 體重: %.1f BMI: %.2f", h, w, bmi);
	}
	
	// size=S or M or L or XL or XXL
	// sweet=1..10
	// S(20元) or M(25元) or L(30元) or XL(40元) or XXL(50元)
	// 執行路徑: /api/beverage?size=S&sweet=1
	@GetMapping("/beverage")
	public String beverage(@RequestParam(required = false, defaultValue = "XL") String size, 
						   @RequestParam(required = false, defaultValue = "10") Integer sweet) {
		Map<String, Integer> pricesMap = Map.of("S", 20, "M", 25, "L", 30, "XL", 40, "XXL", 50);
		return String.format("飲料 %s 杯 甜度 %d 分 價格 %d 元", size, sweet, pricesMap.get(size));
	}
	
	/**
	 * Lab 練習 I
	 * 路徑: /api/bmi2?h=170&w=60
	 * 網址: http://localhost:8080/api/bmi2?h=170&w=60
	 * 執行結果: 
	 * {
	 *   "message": "BMI 計算成功",
	 *   "data": {
	 *     "height": 170.0,
	 *     "weight": 60.0,
	 *     "bmi": 20.76
	 *   }
	 * }
	 * */
	@GetMapping(value = "/bmi2", produces = "application/json;charset=utf-8")
	public ApiResponse<BMI> bmi2(@RequestParam(required = false) Double h, 
								 @RequestParam(required = false) Double w) {
		if(h == null || w == null) {
			return new ApiResponse<>(false, null, "請提供身高與體重");
		}
		double bmiValue = w / Math.pow(h/100, 2);
		BMI bmi = new BMI(h, w, bmiValue);
		return new ApiResponse<>(true, bmi, "BMI 計算成功");
	}
	
	/**
	 * Lab 練習 II - 飲料含糖量計算
	 * 路徑: /api/sugar?volume=500&sugar=12
	 * volume = 飲料容量, 單位(ml)
	 * sugar = 每 100ml 含糖量, 單位(克)
	 * 執行結果: 
	 *  {
			"success": true,
			"data": {
				"volume": 500,
				"sugar": 12,
				"totalSugar": 60
			},
			"message": "含糖量計算成功"
		}
	   提示:建立 Sugar 物件	
	 * */
	@GetMapping(value = "/sugar", produces = "application/json;charset=utf-8")
	public ApiResponse<Sugar> sugar(@RequestParam(required = false) Integer volume,
									@RequestParam(required = false) Integer sugar) {
		if(volume == null || sugar == null) {
			return new ApiResponse<>(false, null, "請提供飲料容量與每 100ml 含糖量");
		}
		Integer totalSugar = volume / 100 * sugar;
		Sugar data = new Sugar(volume, sugar, totalSugar);
		return new ApiResponse<>(true, data, "含糖量計算成功");
	}
	
	/**
	 * Lab 練習 III - 成人每日水分需求計算 API
	 * 說明: 輸入體重, 運動時間(分鐘/天) 計算出建議每日飲水量
	 * 計算邏輯:
	 * 基礎水量: 體重 x 0.035(升)
	 * 運動候補水: 運動時間(分鐘/天) x 0.012(升)
	 * 建議每日飲水量: 基礎水量 + 運動候補水
	 * 飲水等級:
	 * <2L - 普通 
	 * 2L~3L - 良好
	 * >3L - 注意 
	 * 
	 * 路徑: /api/water?weight=60&time=30
	 */
	@GetMapping(value = "/water", produces = "application/json;charset=utf-8")
	public ApiResponse<Water> water(@RequestParam(required = false) Integer weight,
									@RequestParam(required = false) Integer time) {
		if(weight == null || time == null) {
			return new ApiResponse<>(false, null, "請提供體重與運動時間");
		}
		
		// 基礎水量: 體重 x 0.035(升)
		double baseWater = weight * 0.035;
		// 運動候補水: 運動時間(分鐘/天) x 0.012(升)
		double exerciseWater = time * 0.012;
		// 建議每日飲水量
		double recommand = baseWater + exerciseWater;
		double roundWater = Math.round(recommand * 100.0) / 100.0;
		
		String advice;
		if(roundWater < 2.0) advice = "普通";
		else if (roundWater <= 3.0) advice = "良好";
		else advice = "需注意";
		
		Water data = new Water(weight, time, recommand, advice);
		
		return new ApiResponse<>(true, data, "每日水分需求計算成功");
	}
	
	/**
	 * 請求參數: /student?id=1
	 * 請求參數: /student?id=3
	 * 
	 * 路徑參數
	 * 路徑: /student/1
	 * 路徑: /student/3
	 * 
	 * */
	@GetMapping(value = "/student/{id}", produces = "application/json;charset=utf-8")
	public ApiResponse<Student> student(@PathVariable Integer id) {
		Map<Integer, Student> map = Map.of(1, new Student(1, "John", 20),
										   2, new Student(2, "Mary", 21),
										   3, new Student(3, "Helen", 22));
		Student student = map.get(id);
		if(student == null) {
			return new ApiResponse<>(false, null, "查無學生資料");
		}
		return new ApiResponse<>(true, student, "取得學生資料成功");
	}
	
	@GetMapping(value = "/student", produces = "application/json;charset=utf-8")
	public ApiResponse<Map<Integer, Student>> findAllStudent() {
		Map<Integer, Student> map = Map.of(1, new Student(1, "John", 20),
										   2, new Student(2, "Mary", 21),
										   3, new Student(3, "Helen", 22));
		return new ApiResponse<>(true, map, "取得所有學生資料成功");
	}
	
	/**
	 * 同名多筆資料
	 * 路徑: /ages?age=19&age=21&age=30
	 * 請計算出平均年齡
	 * */
	@GetMapping(value = "/ages", produces = "application/json;charset=utf-8")
	public ApiResponse<Map<String, Double>> getAvgOfAge(@RequestParam(name = "age", required = false) List<Integer> ages) {
		if(ages == null || ages.size() == 0) {
			return new ApiResponse<>(false, null, "請輸入年齡資料");
		}
		double avg = ages.stream().mapToInt(Integer::intValue).average().getAsDouble();
		return new ApiResponse<>(true, Map.of("平均年齡", avg), "取得平均年齡成功");
	}
	
	/*
	 * Lab 練習: 得到多筆 score 資料
	 * 路徑: "/exam?score=80&score=100&score=50&score=70&score=30"
	 * 網址: http://localhost:8080/api/exam?score=80&score=100&score=50&score=70&score=30
	 * 請自行設計一個方法，此方法可以
	 * 印出: 最高分=?、最低分=?、平均=?、總分=?、及格分數列出=?、不及格分數列出=?
	 */
	@GetMapping(value = "/exam", produces = "application/json;charset=utf-8")
	public ApiResponse<Object> getExamInfo(@RequestParam(name = "score", required = false) List<Integer> scores) {
		if(scores == null || scores.size() == 0) {
			return new ApiResponse<>(false, null, "請輸入成績資料");
		}
		// 統計資料
		IntSummaryStatistics stat = scores.stream().mapToInt(Integer::intValue).summaryStatistics();
		// 利用 Collectors.partitioningBy
		// key=true 及格 | key=false 不及格
		Map<Boolean, List<Integer>> resultMap = scores.stream()
				.collect(Collectors.partitioningBy(score -> score >= 60));
		Object data = Map.of(
				"最高分", stat.getMax(),
				"最低分", stat.getMin(),
				"平均", stat.getAverage(),
				"總分", stat.getSum(),
				"及格", resultMap.get(true),
				"不及格", resultMap.get(false)
		);
		return new ApiResponse<>(true, data, "成績計算結果");
	}
	
	/**
	 * 
	 * CRUD 現代設計風格(Rest):
	 * GET    /books   查詢所有書籍
	 * GET    /book/1  查詢單筆書籍
	 * POST   /book    新增書籍
	 * PUT    /book/1  修改單筆書籍
	 * DELETE /book/1  刪除單筆書籍
	 * 
	 * 路徑: /book/1 得到 id = 1 的書
	 * 路徑: /book/3 得到 id = 3 的書
	 * 網址: http://localhost:8080/api/book/1
	 * 網址: http://localhost:8080/api/book/3
	 * 
	 * @PathVariable(name = "id") Integer id
	 * 等價於
	 * @PathVariable(value = "id") Integer id
	 * 也等價於
	 * @PathVariable("id") Integer id
	 * ps: 就只是符合不同開發者的需要 !
	 * 
	 * */
	
	// 書庫
	List<Book> books = new CopyOnWriteArrayList<>();
	
	{
		books.add(new Book(1, "機器貓小叮噹", 12.5, 20, false));
		books.add(new Book(2, "老夫子", 10.5, 30, false));
		books.add(new Book(3, "好小子", 8.5, 40, true));
		books.add(new Book(4, "尼羅河的女兒", 14.5, 50, true));
		books.add(new Book(5, "天子傳奇", 25.5, 25, true));
		books.add(new Book(6, "洪興十三妹", 30.0, 15, true));
	}
	
	// 單筆查詢
	@GetMapping(value = "/book/{id}", produces = "application/json;charset=utf-8")
	public ApiResponse<Book> getBookById(@PathVariable Integer id) {
		// 根據 id 搜尋 book
		Optional<Book> optBook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
		// 判斷是否有找到
		if(optBook.isEmpty()) {
			return new ApiResponse<>(false, null, "查無此書");
		}
		// 取得此書
		Book book = optBook.get();
		return new ApiResponse<>(true, book, "查詢成功");
	}
	
	// 多筆查詢
	@GetMapping(value = "/books", produces = "application/json;charset=utf-8")
	public ApiResponse<List<Book>> findAllBooks() {
		if(books.isEmpty()) {
			return new ApiResponse<>(false, null, "查無任何書籍");
		}
		return new ApiResponse<>(true, books, "查詢成功");
	}
	
	// 分頁查詢
	@GetMapping(value = "/books/page", produces = "application/json;charset=utf-8")
	public ApiResponse<List<Book>> findBooksByPage(@RequestParam(defaultValue = "1") int page, 
												   @RequestParam(defaultValue = "3") int size) {
		if(page < 1 || size < 1) {
			return new ApiResponse<>(false, null, "page 與 size 必須 > 0");
		}
		
		int start = (page - 1) * size;
		int end = Math.min(start + size, books.size());
		
		List<Book> subBooks = books.subList(start, end); // 該頁的書籍集合
		
		if(subBooks.size() == 0) {
			return new ApiResponse<>(false, null, "此頁無資料");
		}
		
		return new ApiResponse<>(true, subBooks, "分頁查詢成功");
	}
	
	// 新增書籍
	@PostMapping(value = "/book", produces = "application/json;charset=utf-8")
	public ApiResponse<Book> addBook(@RequestBody Book book) {
		books.add(book);
		return new ApiResponse<>(true, book, "新增成功");
	}
	
	// 批次新增書籍
	@PostMapping(value = "/book/batch", produces = "application/json;charset=utf-8")
	public ApiResponse<Object> addBatchBooks(@RequestBody List<Book> batchBooks) {
		if(batchBooks == null || batchBooks.isEmpty()) {
			return new ApiResponse<>(false, null, "請至少要新增一本書");
		}
		// 批次新增
		books.addAll(batchBooks);
		
		return new ApiResponse<>(true, "資料筆數:" + batchBooks.size(), "批次新增成功");
		
	} 
	
	
	// 修改書籍(完整)
	@PutMapping(value = "/book/{id}", produces = "application/json;charset=utf-8")
	public ApiResponse<Book> updateBook(@PathVariable Integer id,  @RequestBody Book updateBook) {
		// 根據 id 搜尋 book
		Optional<Book> optBook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
		// 判斷是否有找到
		if(optBook.isEmpty()) {
			return new ApiResponse<>(false, null, "查無此書");
		}
		// 取得原始 book 資料
		Book book = optBook.get();
		// 逐筆欄位更新 (id 不需更新)
		book.setName(updateBook.getName());
		book.setPrice(updateBook.getPrice());
		book.setAmount(updateBook.getAmount());
		book.setPub(updateBook.getPub());
		
		return new ApiResponse<>(true, book, "修改完成");
	}
	
	// 修改書籍(部分, 技巧:使用 Map 來接收資料, 逐欄判斷需更改項目)
	@PatchMapping(value = "/book/{id}", produces = "application/json;charset=utf-8")
	public ApiResponse<Book> patchBook(@PathVariable Integer id,  @RequestBody Map<String, Object> updates) {
		// 根據 id 搜尋 book
		Optional<Book> optBook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
		// 判斷是否有找到
		if(optBook.isEmpty()) {
			return new ApiResponse<>(false, null, "查無此書");
		}
		// 取得原始 book 資料
		Book book = optBook.get();
		// 利用 foreach 更新欄位
		updates.forEach((key, value) -> {
			switch (key) {
				case "name":
					book.setName(value.toString());
					break;
				case "price":
					book.setPrice(Double.valueOf(value.toString()));
					break;
				case "amount":
					book.setAmount(Integer.valueOf(value.toString()));
					break;
				case "pub":
					book.setPub(Boolean.valueOf(value.toString()));
					break;
			}
		});
		
		return new ApiResponse<>(true, book, "patch 修改完成");
	}
	
	// 刪除書籍
	@DeleteMapping(value = "/book/{id}", produces = "application/json;charset=utf-8")
	public ApiResponse<Object> deleteBook(@PathVariable Integer id) {
		// 根據 id 搜尋 book
		Optional<Book> optBook = books.stream().filter(book -> book.getId().equals(id)).findFirst();
		// 判斷是否有找到
		if(optBook.isEmpty()) {
			return new ApiResponse<>(false, null, "查無此書");
		}
		// 取得原始 book 資料
		Book book = optBook.get();
		// 刪除
		books.remove(book);
		return new ApiResponse<>(true, "", "刪除成功");
	} 
	
	
	
	
}
