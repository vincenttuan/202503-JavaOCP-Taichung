package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.response.ApiResponse;

@RestController
@RequestMapping("/gold")
@CrossOrigin(origins = "*") 
public class GoldController {

    private final List<Map<Integer, UUID>> goldMap = new CopyOnWriteArrayList<>();
    private final Random random = new Random();
    private final AtomicInteger ans = new AtomicInteger();

    public GoldController() {
        for (int i = 0; i < 100; i++) {
            goldMap.add(Map.of(random.nextInt(100) + 1, UUID.randomUUID()));
        }
        ans.set(random.nextInt(9) + 1); // 1~9
    }

    @GetMapping("/get")
    public ApiResponse<Map<Integer, UUID>> get(@RequestParam int guess) {
        if (guess == ans.get()) {
            if (!goldMap.isEmpty()) {
                Map<Integer, UUID> gold = goldMap.remove(0);
                ans.set(random.nextInt(9) + 1); // update answer after correct guess
                return new ApiResponse<>(true, gold, "恭喜你得到金幣, 金幣剩下: " + goldMap.size() + " 枚");
            } else {
                return new ApiResponse<>(false, null, "金幣已領完，請稍後再試");
            }
        } else {
            return new ApiResponse<>(false, null, "很抱歉沒拿到金幣, 再接再厲 加油~, 金幣剩下: " + goldMap.size() + " 枚");
        }
    }
}
